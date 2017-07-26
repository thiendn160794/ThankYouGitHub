package com.wigoanalytics.analytics.wigo.view.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.wigoanalytics.analytics.wigo.R;
import com.wigoanalytics.analytics.wigo.view.fragment.AngieFragment;
import com.wigoanalytics.analytics.wigo.view.fragment.ChatFragment;
import com.wigoanalytics.analytics.wigo.view.fragment.SettingFragment;
import com.wigoanalytics.analytics.wigo.view.fragment.SmileFragment;
import com.wigoanalytics.analytics.wigo.view.fragment.TaskFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by thiendn on 19/07/2017.
 */

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.tab_layout_home)
    SmartTabLayout tabLayout;
    @BindView(R.id.vp_home)
    ViewPager vpHome;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setupView();
    }

    @Override //for using chrisjenx/Calligraphy opensource set up custom fonts in xml.
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void setupView(){
        PagerAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), FragmentPagerItems.with(this).
                add("Smile", SmileFragment.class).
                add("Angle", AngieFragment.class).
                add("Chats", ChatFragment.class).
                add("Tasks", TaskFragment.class).
                add("Setting", SettingFragment.class).
                create());
        vpHome.setAdapter(adapter);

        tabLayout.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view = LayoutInflater.from(HomeActivity.this).inflate(R.layout.icon_tab_bar, container, false);
                ImageView ivTabIcon = (ImageView) view.findViewById(R.id.iv_tab_icon);
                ivTabIcon.clearAnimation();
                TextView tvTabIcon = (TextView) view.findViewById(R.id.tv_tab_icon);
                switch (position){
                    case 0:
                        ivTabIcon.setImageDrawable(ContextCompat.getDrawable(HomeActivity.this, R.drawable.icon_smile));
                        tvTabIcon.setText("Smile");
                        break;
                    case 1:
                        ivTabIcon.setImageDrawable(ContextCompat.getDrawable(HomeActivity.this, R.drawable.icon_angie));
                        tvTabIcon.setText("Angie");
                        break;
                    case 2:
                        ivTabIcon.setImageDrawable(ContextCompat.getDrawable(HomeActivity.this, R.drawable.icon_chat));
                        tvTabIcon.setText("Chat");
                        break;
                    case 3:
                        ivTabIcon.setImageDrawable(ContextCompat.getDrawable(HomeActivity.this, R.drawable.icon_task));
                        tvTabIcon.setText("Task");
                        break;
                    case 4:
                        ivTabIcon.setImageDrawable(ContextCompat.getDrawable(HomeActivity.this, R.drawable.icon_setting));
                        tvTabIcon.setText("Setting");
                        break;
                    default:
                        throw new IllegalStateException("Invalid position: " + position);
                }
                ivTabIcon.setBackgroundColor(Color.TRANSPARENT);
                return view;
            }
        });
        tabLayout.setViewPager(vpHome);
    }
}
