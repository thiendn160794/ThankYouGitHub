package com.wigoanalytics.analytics.wigo.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


import com.wigoanalytics.analytics.wigo.R;
import com.wigoanalytics.analytics.wigo.view.fragment.GetNewPasswordFragment;
import com.wigoanalytics.analytics.wigo.view.fragment.SendMailSuccessFragment;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by thiendn on 19/07/2017.
 */

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        replaceGetNewPasswordFragment(new GetNewPasswordFragment());
    }

    @Override //for using chrisjenx/Calligraphy opensource set up custom fonts in xml.
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void replaceGetNewPasswordFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout_holder, fragment);
        ft.commit();
    }

    public void replaceSendMailSuccessFragment(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout_holder, new SendMailSuccessFragment());
        ft.commit();
    }

    public void startLoginActivity(){
        startActivity(new Intent(this, LoginActivity.class));
        this.finish();
    }
}
