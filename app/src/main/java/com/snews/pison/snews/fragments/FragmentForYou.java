package com.snews.pison.snews.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.snews.pison.snews.R;
import com.snews.pison.snews.utils.Constants;
import com.snews.pison.snews.utils.ForYouAdapter;
import com.snews.pison.snews.utils.News;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;


public class FragmentForYou extends Fragment implements Constants{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<News> list = new ArrayList<>();
    Button btnContinue;


    /** Required empty constructor */
    public FragmentForYou() {}

    public static FragmentForYou newInstance() {
        return new FragmentForYou();
    }

    @Override
    public void onPause() {
        super.onPause();
        list.clear();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_for_you, container, false);

        int count = 0;

        //calls method to initialize toolbar
        initializeToolbar(rootView);

        //loops through the array and add it to an ArrayList
        for(String image: THUMBNAIL_ID){
            News news = new News.Builder(THUMBNAIL_ID[count], TITLE[count])
                    .content(CONTENT[count])
                    .source(SOURCE[count])
                    .time(TIME[count])
                    .sourceId(SOURCE_ID[count])
                    .build();

            count++;
            list.add(news);
        }

        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setSpanSizeLookup( new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch( position ) {
                    case 0:
                        return 3;
                    default:
                        return 1;
                }
            }

        });

//        StaggeredGridLayoutManager manager =
//                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new ForYouAdapter(list, getActivity());
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private void initializeToolbar(View rootView) {

        // Setup the toolbar
        Toolbar toolbar = ButterKnife.findById(rootView, R.id.toolbar);
        TextView toolBarTitle = ButterKnife.findById(toolbar, R.id.toolbar_title);
        toolBarTitle.setText(Html.fromHtml(getToolbarText()));
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private String getToolbarText() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        Calendar cal = Calendar.getInstance();
        String date = "<b>"+dateFormat.format(now)+" "+cal.get(Calendar.DAY_OF_MONTH)+",</b> "+cal.get(Calendar.YEAR);
        return date.toUpperCase();
    }
}
