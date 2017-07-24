package com.wigoanalytics.analytics.wigo.view;

/**
 * Created by thiendn on 19/07/2017.
 */

public interface IGetNewPasswordView extends IBaseView{
    void onFailCheckValidEmailFormat();
    void onFailCheckExistInServer();
    void onFailConnectToServer();
    void onSuccessSendMail();
    void showProgressBar();
    void hideProgressBar();
}
