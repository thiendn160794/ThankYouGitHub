package com.wigoanalytics.analytics.wigo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wigoanalytics.analytics.wigo.R;
import com.wigoanalytics.analytics.wigo.view.activity.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by thiendn on 25/07/2017.
 */

public class SmileFragment extends Fragment {

    HomeActivity mActivityCallback;
    @BindView(R.id.toolbar_home)
    Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityCallback = (HomeActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_smile, container, false);
        ButterKnife.bind(this, view);
        toolbar.setTitle("Smile");
        mActivityCallback.setSupportActionBar(toolbar);
        return view;
    }
}
