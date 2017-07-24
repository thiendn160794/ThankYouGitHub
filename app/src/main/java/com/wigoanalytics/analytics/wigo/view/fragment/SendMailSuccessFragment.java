package com.wigoanalytics.analytics.wigo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wigoanalytics.analytics.wigo.R;
import com.wigoanalytics.analytics.wigo.view.activity.ForgotPasswordActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by thiendn on 20/07/2017.
 */

public class SendMailSuccessFragment extends Fragment {
    @BindView(R.id.btn_got_it)
    Button btnGotIt;
    ForgotPasswordActivity mActivityCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityCallback = (ForgotPasswordActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_mail_success, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnGotIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivityCallback.startLoginActivity();
            }
        });
    }
}
