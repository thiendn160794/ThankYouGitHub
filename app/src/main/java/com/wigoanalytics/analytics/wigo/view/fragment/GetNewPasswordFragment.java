package com.wigoanalytics.analytics.wigo.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wigoanalytics.analytics.wigo.R;
import com.wigoanalytics.analytics.wigo.presenter.IGetNewPasswordPresenter;
import com.wigoanalytics.analytics.wigo.presenter.iml.GetNewPasswordPresenter;
import com.wigoanalytics.analytics.wigo.utils.ToastUtils;
import com.wigoanalytics.analytics.wigo.view.IGetNewPasswordView;
import com.wigoanalytics.analytics.wigo.view.activity.ForgotPasswordActivity;
import com.wigoanalytics.analytics.wigo.view.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by thiendn on 19/07/2017.
 */

public class GetNewPasswordFragment extends Fragment implements IGetNewPasswordView, View.OnClickListener {

    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.btn_send_new_password)
    Button btnSendNewPassword;
    @BindView(R.id.tv_cancle)
    TextView tvCancle;
    @BindView(R.id.tv_forgot_password_description)
    TextView tvForgetPasswordDescription;
    @BindView(R.id.pb_loading_send_mail)
    ProgressBar pbLoadingSendMail;

    ForgotPasswordActivity mActivityCallback;
    IGetNewPasswordPresenter mGetNewPasswordPresenter;

    private String ENTER_YOUR_EMAIL_HERE, NO_USER_WAS_FOUND;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityCallback = (ForgotPasswordActivity) getActivity();
        mGetNewPasswordPresenter = new GetNewPasswordPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_get_new_password, container, false);
        ButterKnife.bind(this, view);
        btnSendNewPassword.setOnClickListener(this);
        tvCancle.setOnClickListener(this);

        NO_USER_WAS_FOUND = getContext().getResources().getString(R.string.no_user_was_found);
        ENTER_YOUR_EMAIL_HERE = getContext().getResources().getString(R.string.forgot_password_description);

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (tvForgetPasswordDescription.getText().toString().equals(NO_USER_WAS_FOUND)){
                    tvForgetPasswordDescription.setText(ENTER_YOUR_EMAIL_HERE);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //dont care
            }

            @Override
            public void afterTextChanged(Editable s) {
                //dont care
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send_new_password:
                mGetNewPasswordPresenter.getNewPassword(etEmail.getText().toString());
                break;
            case R.id.tv_cancle:
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                callIntent.setClass(getActivity(),LoginActivity.class);
                startActivity(callIntent);
                break;
        }
    }

    @Override
    public void onFailCheckValidEmailFormat() {
        ToastUtils.showShortToast(getContext(), "Email format is not valid!");
    }

    @Override
    public void onFailCheckExistInServer() {
        ToastUtils.showShortToast(getContext(), "Email is not existed on server!");
        tvForgetPasswordDescription.setText(NO_USER_WAS_FOUND);
    }

    @Override
    public void onFailConnectToServer() {
        ToastUtils.showShortToast(getContext(), "Can not connect to server!");
    }

    @Override
    public void onSuccessSendMail() {
        ToastUtils.showShortToast(getContext(), "Successfully!");
        mActivityCallback.replaceSendMailSuccessFragment();
    }

    @Override
    public void showProgressBar() {
        pbLoadingSendMail.setVisibility(View.VISIBLE);
        etEmail.setEnabled(false);
        btnSendNewPassword.setEnabled(false);
        tvCancle.setEnabled(false);
    }

    @Override
    public void hideProgressBar() {
        pbLoadingSendMail.setVisibility(View.GONE);
        etEmail.setEnabled(true);
        btnSendNewPassword.setEnabled(true);
        tvCancle.setEnabled(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mGetNewPasswordPresenter.onDetach();
    }
}
