package com.wigoanalytics.analytics.wigo.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wigoanalytics.analytics.wigo.R;
import com.wigoanalytics.analytics.wigo.presenter.ILoginPresenter;
import com.wigoanalytics.analytics.wigo.presenter.iml.LoginPresenter;
import com.wigoanalytics.analytics.wigo.utils.ToastUtils;
import com.wigoanalytics.analytics.wigo.view.ILoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by thiendn on 18/07/2017.
 */

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener{
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_forgot_password)
    TextView tvForgotPassword;
    @BindView(R.id.pb_loading_login)
    ProgressBar pbLoadingLogin;

    ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);

        mLoginPresenter = new LoginPresenter(this);
    }

    @Override //for using chrisjenx/Calligraphy opensource set up custom fonts in xml.
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                mLoginPresenter.doLogin(etUsername.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.tv_forgot_password:
                startForgotPasswordActivity();
                break;
        }

    }

    @Override
    public void onLoginSuccess() {
        ToastUtils.showShortToast(this, "Login Success!");
        hideLoadingDialog();
        startHomeActivity();
    }

    @Override
    public void onLoginFailure() {
        ToastUtils.showShortToast(this, "Login Fail!");
        hideLoadingDialog();
    }

    @Override
    public void onConnectToServerFail() {
        Toast.makeText(this, "Fail to connect to server!", Toast.LENGTH_SHORT).show();
        hideLoadingDialog();
    }

    @Override
    public void showNotValidUsernamePassword() {
        ToastUtils.showShortToast(this, "Username or Password can not be blank!");
        hideLoadingDialog();
    }

    @Override
    public void showLoadingDialog() {
        pbLoadingLogin.setVisibility(View.VISIBLE);
        etUsername.setEnabled(false);
        etPassword.setEnabled(false);
        btnLogin.setEnabled(false);
        tvForgotPassword.setEnabled(false);
    }

    @Override
    public void hideLoadingDialog() {
        pbLoadingLogin.setVisibility(View.GONE);
        etUsername.setEnabled(true);
        etPassword.setEnabled(true);
        btnLogin.setEnabled(true);
        tvForgotPassword.setEnabled(true);
    }

    @Override
    public void startHomeActivity() {
        startActivity(new Intent(this, HomeActivity.class));
        this.finish();
    }

    @Override
    public void startForgotPasswordActivity() {
        startActivity(new Intent(this, ForgotPasswordActivity.class));
    }

    @Override
    public Context getContext() {
        return this;
    }
}
