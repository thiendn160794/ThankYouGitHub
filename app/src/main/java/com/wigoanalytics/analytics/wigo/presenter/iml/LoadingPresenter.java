package com.wigoanalytics.analytics.wigo.presenter.iml;

import com.wigoanalytics.analytics.wigo.model.local.sharePref.SharedPreferenceRepository;
import com.wigoanalytics.analytics.wigo.presenter.ILoadingPresenter;
import com.wigoanalytics.analytics.wigo.view.ILoadingView;

/**
 * Created by thiendn on 19/07/2017.
 */

public class LoadingPresenter implements ILoadingPresenter {
    ILoadingView mLoadingView;

    public LoadingPresenter(ILoadingView loadingView){
        mLoadingView = loadingView;
    }

    @Override
    public void checkUserLoginBefore() {
        String authenKey = SharedPreferenceRepository.getAuthenticationKey(mLoadingView.getContext());
        if (authenKey.equals("")){
            mLoadingView.startLoginActivity();
        }else {
            mLoadingView.startHomeActivity();
        }
    }

    @Override
    public void onDetach() {
        mLoadingView = null;
    }
}
