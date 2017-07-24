package com.wigoanalytics.analytics.wigo.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wigoanalytics.analytics.wigo.presenter.ILoadingPresenter;
import com.wigoanalytics.analytics.wigo.presenter.iml.LoadingPresenter;
import com.wigoanalytics.analytics.wigo.view.ILoadingView;

import com.wigoanalytics.analytics.wigo.R;

public class MainActivity extends AppCompatActivity implements ILoadingView {
    ILoadingPresenter mLoadingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoadingPresenter = new LoadingPresenter(this);
        mLoadingPresenter.checkUserLoginBefore();
    }

    @Override
    public void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        this.finish();
    }

    @Override
    public void startHomeActivity() {
        startActivity(new Intent(this, HomeActivity.class));
        this.finish();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
