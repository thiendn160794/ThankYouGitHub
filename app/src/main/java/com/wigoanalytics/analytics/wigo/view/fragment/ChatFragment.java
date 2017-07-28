package com.wigoanalytics.analytics.wigo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.wigoanalytics.analytics.wigo.R;
import com.wigoanalytics.analytics.wigo.view.activity.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;

/**
 * Created by thiendn on 25/07/2017.
 */

public class ChatFragment extends Fragment {

    HomeActivity mActivityCallback;
    @BindView(R.id.toolbar_home)
    Toolbar toolbar;
    @BindView(R.id.frame_layout_chat)
    FrameLayout frameLayout;
    @BindView(R.id.divider_bellow_toolbar)
    View divider;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityCallback = (HomeActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        ButterKnife.bind(this, view);
        FragmentTransaction ft = mActivityCallback.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout_chat, new ListContactFragment());
        ft.commit();
        return view;
    }

    public void showMainChatToolBar(){
        toolbar.setVisibility(View.VISIBLE);
        divider.setVisibility(View.VISIBLE);
        mActivityCallback.setSupportActionBar(toolbar);
    }
}
