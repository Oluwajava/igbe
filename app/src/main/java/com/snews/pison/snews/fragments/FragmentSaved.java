package com.snews.pison.snews.fragments;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.snews.pison.snews.R;
import com.snews.pison.snews.utils.News;
import com.snews.pison.snews.utils.SavedNewsAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;


public class FragmentSaved extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<News> list = new ArrayList<>();
    Button btnContinue;
    String[] title = {"Saints fall short in red zone in first game without Jimmy Graham", "Saints fall short in red zone in first game without Jimmy Graham",
            "Saints fall short in red zone in first game without Jimmy Graham", "Saints fall short in red zone in first game without Jimmy Graham",
            "Saints fall short in red zone in first game without Jimmy Graham", "Saints fall short in red zone in first game without Jimmy Graham",
            "Saints fall short in red zone in first game without Jimmy Graham", "Saints fall short in red zone in first game without Jimmy Graham"};
    String[] content = {"An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,",
            "An enthusiast recent graduate with B.sc in political science (public administration) and international relations. Excellent research,"};
    String[] source = {"ESPN", "ESPN", "ESPN", "ESPN", "ESPN", "ESPN", "ESPN", "ESPN"};
    String[] time = {"2h", "2h", "2h", "2h", "2h", "2h", "2h", "2h"};
    String[] thumbnail_id = {"https://metrouk2.files.wordpress.com/2016/10/617269818.jpg",
            "http://static.guim.co.uk/sys-images/Football/Pix/pictures/2015/4/16/1429206099512/Eden-Hazard-009.jpg",
            "https://blog-blogmediainc.netdna-ssl.com/upload/SportsBlogcom/2355290/0393288001463260456_filepicker.jpg",
            "http://a.fssta.com/content/dam/fsdigital/fscom/soccer/images/2016/08/23/lionel-messi.vadapt.980.high.63.png",
            "http://e1.365dm.com/15/11/16-9/20/jose-mourinho-chelsea-manager_3380880.jpg?20151124201615",
            "http://cdn.images.express.co.uk/img/dynamic/67/590x/Antonio-Conte-639015.jpg",
            "http://goo.gl/gEgYUd",
            "http://goo.gl/gEgYUd"};

    /** Required empty constructor */
    public FragmentSaved() {}

    public static FragmentSaved newInstance() {
        return new FragmentSaved();
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
        View rootView = inflater.inflate(R.layout.fragment_saved, container, false);
        int count = 0;

        //loops through the array and add it to an ArrayList
        for(String image: thumbnail_id){
            News news = new News.Builder(image, title[count])
                                .content(content[count])
                                .source(source[count])
                                .sourceId(image)
                                .time(time[count])
                                .build();

            count++;
            list.add(news);
        }

        initializeToolbar(rootView);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new SavedNewsAdapter(list, getActivity());
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private void initializeToolbar(View rootView) {

        // Setup the toolbar
        Toolbar toolbar = ButterKnife.findById(rootView, R.id.toolbar);
        TextView toolBarTitle = ButterKnife.findById(toolbar, R.id.toolbar_title);
        toolBarTitle.setText(R.string.saved_tab);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

    }



}
