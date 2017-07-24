package com.wigoanalytics.analytics.wigo.presenter.iml;

import com.wigoanalytics.analytics.wigo.model.dto.ResponseGetNewPassword;
import com.wigoanalytics.analytics.wigo.model.remote.ApiUtils;
import com.wigoanalytics.analytics.wigo.presenter.IGetNewPasswordPresenter;
import com.wigoanalytics.analytics.wigo.utils.StringUtils;
import com.wigoanalytics.analytics.wigo.view.IGetNewPasswordView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by thiendn on 19/07/2017.
 */

public class GetNewPasswordPresenter implements IGetNewPasswordPresenter {
    IGetNewPasswordView mGetNewPasswordView;

    public GetNewPasswordPresenter(IGetNewPasswordView mGetNewPasswordView) {
        this.mGetNewPasswordView = mGetNewPasswordView;
    }

    @Override
    public void onDetach() {
        mGetNewPasswordView = null;
    }

    @Override
    public void getNewPassword(String email) {
        mGetNewPasswordView.showProgressBar();
        if (!StringUtils.isEmailValid(email)){
            mGetNewPasswordView.onFailCheckValidEmailFormat();
            mGetNewPasswordView.hideProgressBar();
            return;
        }
        ApiUtils.getApiService().getNewPassword(email).enqueue(new Callback<ResponseGetNewPassword>() {
            @Override
            public void onResponse(Call<ResponseGetNewPassword> call, Response<ResponseGetNewPassword> response) {
                ResponseGetNewPassword responseGetNewPassword = response.body();
                mGetNewPasswordView.hideProgressBar();
                if (responseGetNewPassword.getIsSuccess() == 1){
                    mGetNewPasswordView.onSuccessSendMail();
                }else {
                    mGetNewPasswordView.onFailCheckExistInServer();
                }
            }

            @Override
            public void onFailure(Call<ResponseGetNewPassword> call, Throwable t) {
                mGetNewPasswordView.hideProgressBar();
                mGetNewPasswordView.onFailConnectToServer();
            }
        });
    }
}
