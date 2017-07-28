package com.wigoanalytics.analytics.wigo.presenter.iml;

import com.wigoanalytics.analytics.wigo.model.dto.Session;
import com.wigoanalytics.analytics.wigo.model.local.sharePref.SharedPreferenceRepository;
import com.wigoanalytics.analytics.wigo.model.remote.ApiUtils;
import com.wigoanalytics.analytics.wigo.presenter.ILoginPresenter;
import com.wigoanalytics.analytics.wigo.view.ILoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by thiendn on 18/07/2017.
 */

public class LoginPresenter implements ILoginPresenter {
    ILoginView mLoginView;

    public LoginPresenter(ILoginView loginView) {
        this.mLoginView = loginView;
    }

    @Override
    public void doLogin(String username, String password) {
        mLoginView.showLoadingDialog();
                if (username.equals("") || password.equals("")){
                    mLoginView.showNotValidUsernamePassword();
                    return;
                }
                //TODO: @thiendn login with type and divice Id is hashcode.
                ApiUtils.getApiService().login(username, password, "2", "daotran123").enqueue(new Callback<Session>() {
                    @Override
                    public void onResponse(Call<Session> call, Response<Session> response) {
                        if (response.code() == 200){
                            Session session = response.body();
                            SharedPreferenceRepository.storeAuthenticationKey(mLoginView.getContext(), session.getAuthKey());
                            mLoginView.onLoginSuccess();
                        }
                        else {
                            mLoginView.onLoginFailure();
                        }
            }

            @Override
            public void onFailure(Call<Session> call, Throwable t) {
                mLoginView.onConnectToServerFail();
            }
        });
    }

    @Override
    public void onDetach() {
        mLoginView = null;
    }
}
