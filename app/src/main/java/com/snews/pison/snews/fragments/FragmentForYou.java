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
import com.snews.pison.snews.utils.ForYouAdapter;
import com.snews.pison.snews.utils.News;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;


public class FragmentForYou extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<News> list = new ArrayList<>();
    Button btnContinue;
    String[] title = {"Lionel Messi wants Ozil at Barcelona",
            "Harzard will be greater than Ronaldo says Conte",
            "C. Ronaldo set to return to Manchester United",
            "Lionel Messi wins Ballon d'Or again",
            "Jose Mourinho under pressure as United draw",
            "Antonio Conte wins EPL manager of the month",
            "Conte says Neymar will be greater than messi if",
            "Lionel Messi wins Ballon d'Or again",
            "Harzard will be greater than Ronaldo says Conte",
            "C. Ronaldo set to return to Manchester United"
            };
    String[] content = {"Lionel Messi as said in an exclusive interview he would love if Ozil join Barcelona...",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,"};
    String[] source = {"ESPN", "Goal", "SkySport", "ESPN", "SkySport", "ESPN", "SkySport", "Goal", "SkySport", "ESPN"};
    String[] time = {"2h", "2h", "2h", "2h", "2h", "2h", "2h", "2h", "2h", "2h"};
    String[] thumbnail_id = { "https://metrouk2.files.wordpress.com/2016/10/617269818.jpg",
                                "http://static.guim.co.uk/sys-images/Football/Pix/pictures/2015/4/16/1429206099512/Eden-Hazard-009.jpg",
                                "https://blog-blogmediainc.netdna-ssl.com/upload/SportsBlogcom/2355290/0393288001463260456_filepicker.jpg",
                                "http://a.fssta.com/content/dam/fsdigital/fscom/soccer/images/2016/08/23/lionel-messi.vadapt.980.high.63.png",
                                "http://e1.365dm.com/15/11/16-9/20/jose-mourinho-chelsea-manager_3380880.jpg?20151124201615",
                                "http://cdn.images.express.co.uk/img/dynamic/67/590x/Antonio-Conte-639015.jpg",
                                "http://images.performgroup.com/di/library/goal_es/37/5e/neymar-barcelona-espanyol-liga-bbva_18wwkuz3kzuj21s7cms5h76qwh.jpg?t=-1853456236",
                                "https://metrouk2.files.wordpress.com/2016/10/617269818.jpg",
                                "http://static.guim.co.uk/sys-images/Football/Pix/pictures/2015/4/16/1429206099512/Eden-Hazard-009.jpg",
                                "https://blog-blogmediainc.netdna-ssl.com/upload/SportsBlogcom/2355290/0393288001463260456_filepicker.jpg"};

    String[] source_id = { "http://logok.org/wp-content/uploads/2015/02/ESPN-logo-wordmark.png",
            "http://logok.org/wp-content/uploads/2015/02/ESPN-logo-wordmark.png",
            "http://logok.org/wp-content/uploads/2015/02/ESPN-logo-wordmark.png",
            "http://logok.org/wp-content/uploads/2015/02/ESPN-logo-wordmark.png",
            "http://logok.org/wp-content/uploads/2015/02/ESPN-logo-wordmark.png",
            "http://logok.org/wp-content/uploads/2015/02/ESPN-logo-wordmark.png",
            "http://logok.org/wp-content/uploads/2015/02/ESPN-logo-wordmark.png",
            "http://logok.org/wp-content/uploads/2015/02/ESPN-logo-wordmark.png",
            "http://logok.org/wp-content/uploads/2015/02/ESPN-logo-wordmark.png",
            "http://logok.org/wp-content/uploads/2015/02/ESPN-logo-wordmark.png",
    };

    /** Required empty constructor */
    public FragmentForYou() {}

    public static FragmentForYou newInstance() {
        return new FragmentForYou();
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
        for(String image: thumbnail_id){
            News news = new News.Builder(image, title[count])
                    .content(content[count])
                    .source(source[count])
                    .time(time[count])
                    .sourceId(source_id[count])
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
        return date;
    }
}
