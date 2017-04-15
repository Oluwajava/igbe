package com.snews.pison.snews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.snews.pison.snews.fragments.NewsPage;
import com.snews.pison.snews.fragments.SelectionFragment;
import com.snews.pison.snews.utils.SelectionItem;
import com.snews.pison.snews.utils.SelectionAdapter;
import com.snews.pison.snews.utils.GridAutofitLayoutManager;
import com.snews.pison.snews.utils.NewsContent;
import com.snews.pison.snews.utils.TabFragmentPage;
import com.snews.pison.snews.utils.TabbedFragmentPagerAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class Selection extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    private View view;
    private TabbedFragmentPagerAdapter pagerAdapter;
    protected List<TabFragmentPage<? extends Fragment>> tabFragmentPages;
    ImageButton nextButton;
    ArrayList<SelectionItem> list = new ArrayList<SelectionItem>();
    private PrefManager pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_activity);

        pref = new PrefManager(this);

        initilizeToolbars();

        initializeTabs();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref.setSelectionMade(true);
                pref.setFavourites(NewsContent.getFavouritesSources());
                Log.d("Test", "Array: "+ NewsContent.getFavouritesSources().toArray().toString());
                Log.d("Test", "Pref: "+pref.isSelectionMade());
                startActivity(new Intent(Selection.this, MenuActivity.class));
            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
            }
        });

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };




    }

    private void initializeTabs() {
        // Swipe tab initialization
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.pager);



        // Setup swipe view
        viewPager.setAdapter(new Selection.CustomTabAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initilizeToolbars() {

        // Setup the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView toolBarTitle = (TextView)findViewById(R.id.toolbar_title);
        TextView toolBarSubTitle = (TextView) findViewById(R.id.sub_title);
        nextButton = (ImageButton) findViewById(R.id.next);

        nextButton.setVisibility(View.VISIBLE);
        toolBarTitle.setText(R.string.pick_favourites);
        toolBarSubTitle.setText(R.string.tap_one);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private class CustomTabAdapter extends FragmentStatePagerAdapter {

        String[] headers = {"RECOMMENDED", "WORLD", "POLITICS", "SPORT", "ENTERTAINMENT", "NIGRIA", "AFRICA"};
        public CustomTabAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment frag = null;

            switch (position) {
                case 0:
                    frag = new SelectionFragment();
                    break;
                case 1:
                    frag = new NewsPage();
                    break;
                case 2:
                    frag = new NewsPage();
                    break;
                default:
                    frag = new NewsPage();
                    break;
            }
            return frag;
        }

        @Override
        public int getCount() {
            return headers.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return headers[position];
        }

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}