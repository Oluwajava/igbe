package com.snews.pison.snews.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.snews.pison.snews.R;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Mayokun on 2/11/2017.
 */

public class AbstractFragment extends Fragment {

    public void initilizeToolbars(View view, int res1, int res2, boolean showSubTitle) {

        // Setup the toolbar
        Toolbar toolbar = ButterKnife.findById(view, R.id.toolbar);
        TextView toolBarTitle = ButterKnife.findById(toolbar, R.id.toolbar_title);
        TextView toolBarSubTitle = ButterKnife.findById(toolbar, R.id.sub_title);

        toolBarTitle.setText(getString(res1));

        if(showSubTitle){
            toolBarSubTitle.setVisibility(View.VISIBLE);
            toolBarSubTitle.setText(getString(res2));
        }else{
            toolBarSubTitle.setVisibility(View.GONE);
        }



        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

    }


}
