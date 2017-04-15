package com.snews.pison.snews;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.snews.pison.snews.fragments.FragmentExplore;
import com.snews.pison.snews.fragments.FragmentFavourite;
import com.snews.pison.snews.fragments.FragmentForYou;
import com.snews.pison.snews.fragments.FragmentSaved;
import com.snews.pison.snews.fragments.FragmentSearch;
import com.snews.pison.snews.utils.FragmentSwitcher;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MenuActivity extends AppCompatActivity {

    private static final String FOR_YOU    =  "For You";
    private static final String FAVORITES  =  "Favorites";
    private static final String EXPLORE    =  "Explore";
    private static final String SEARCH     =  "Search";
    private static final String SAVED      =  "Saved";

    private FragmentSwitcher mFragSwitcher;

    @BindView(R.id.bottom_bar) BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_fragment);

        // Bind ButterKnife to this activity
        ButterKnife.bind(this);

        // Setup UI widgets and event handlers
        widgetInitialization();

        ImageView logo_view = (ImageView) findViewById(R.id.logo_view);

        AnimationDrawable animationDrawable = (AnimationDrawable) logo_view.getBackground();
        animationDrawable.start();
    }

    private void widgetInitialization() {

        // Initialize fragment switcher
        mFragSwitcher = FragmentSwitcher.getNewInstance(this, R.id.fragment_container);
        mFragSwitcher.addFragment(FOR_YOU, FragmentForYou.newInstance());
        mFragSwitcher.addFragment(FAVORITES, FragmentFavourite.newInstance());
        mFragSwitcher.addFragment(EXPLORE, FragmentExplore.newInstance());
        mFragSwitcher.addFragment(SEARCH, FragmentSearch.newInstance());
        mFragSwitcher.addFragment(SAVED, FragmentSaved.newInstance());

        // Show the FragmentForYou first
        mFragSwitcher.showAsFirst(FOR_YOU);

        // Setup event listener
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch(tabId) {
                    case R.id.for_you:
                        mFragSwitcher.switchFragment(FOR_YOU);
                        break;
                    case R.id.favorites:
                        mFragSwitcher.switchFragment(FAVORITES);
                        break;
                    case R.id.explore:
                        mFragSwitcher.switchFragment(EXPLORE);
                        break;
                    case R.id.search:
                        mFragSwitcher.switchFragment(SEARCH);
                        break;
                    case R.id.saved:
                        mFragSwitcher.switchFragment(SAVED);
                        break;
                }
            }
        });
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
