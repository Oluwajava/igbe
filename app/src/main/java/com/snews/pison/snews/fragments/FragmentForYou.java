package com.snews.pison.snews.fragments;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.snews.pison.snews.R;
import com.snews.pison.snews.utils.FontFactory;


public class FragmentForYou extends Fragment {
    TextView main_title, main_content, main_source, main_time, sub_title_1, sub_source_1, sub_time_1,
            sub_title_2, sub_source_2, sub_time_2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_for_you, container, false);

        main_title = (TextView)rootView.findViewById(R.id.main_title);
        main_content = (TextView)rootView.findViewById(R.id.main_content);
        main_source = (TextView)rootView.findViewById(R.id.main_source);
        main_time = (TextView)rootView.findViewById(R.id.main_time);
        sub_title_1 = (TextView)rootView.findViewById(R.id.sub_title_1);
        sub_source_1 = (TextView)rootView.findViewById(R.id.sub_source_1);
        sub_time_1 = (TextView)rootView.findViewById(R.id.sub_time_1);
        sub_title_2 = (TextView)rootView.findViewById(R.id.sub_title_2);
        sub_source_2 = (TextView)rootView.findViewById(R.id.sub_source_2);
        sub_time_2 = (TextView)rootView.findViewById(R.id.sub_time_2);

        AssetManager am = getActivity().getApplicationContext().getAssets();

        TextView[] all = {main_title, main_content, main_source, main_time, sub_title_1, sub_source_1, sub_time_1,
                sub_title_2, sub_source_2, sub_time_2};

        ImageView img = (ImageView) rootView.findViewById(R.id.main_image);


        for(TextView text: all){
            text.setTypeface(FontFactory.getTypeFace(am, "regular"));
        }

        return rootView;
    }


}
