package com.snews.pison.snews;

import android.graphics.Color;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.snews.pison.snews.fragments.FragmentFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class MenuFragment extends AppCompatActivity implements View.OnClickListener {
    ArrayList<TextView> textArrayList;
    ArrayList<ImageButton> buttonArrayList;
    ImageButton btnForYou, btnFavourite, btnExplore, btnSearch, btnSaved;
    TextView forYouText, favouritesText, exploreText, searchText, savedText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_fragment);

        //Load the first fragment for you
        loadFragment("For You");

        //initialises the imagebutton and textview used
        widgetInitialization();

    }

    private void widgetInitialization() {

        // button initialization
        btnForYou = (ImageButton) findViewById(R.id.forYou);
        btnFavourite = (ImageButton) findViewById(R.id.favourites);
        btnExplore = (ImageButton) findViewById(R.id.explore);
        btnSearch = (ImageButton) findViewById(R.id.search);
        btnSaved = (ImageButton) findViewById(R.id.saved);

        // textview initialization
        forYouText = (TextView) findViewById(R.id.forYouText);
        favouritesText = (TextView) findViewById(R.id.favouritesText);
        exploreText = (TextView) findViewById(R.id.exploreText);
        searchText = (TextView) findViewById(R.id.searchText);
        savedText = (TextView) findViewById(R.id.savedText);

        // initialializing button for click listener
        btnForYou.setOnClickListener(this);
        btnFavourite.setOnClickListener(this);
        btnExplore.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnSaved.setOnClickListener(this);

        // initialializing button and text for array list
        buttonArrayList = new ArrayList<>();
        textArrayList = new ArrayList<>();

        ImageButton[] btn = {btnForYou, btnFavourite, btnExplore, btnSearch, btnSaved};
        TextView[] txt = {forYouText, favouritesText, exploreText, searchText, savedText};

        // adding button from array to ArrayLIst
        for(ImageButton buttonAdd: btn){
            buttonArrayList.add(buttonAdd);
        }

        // adding textview from array to ArrayList
        for(TextView textAdd: txt){
            textArrayList.add(textAdd);
        }

    }

    private void loadFragment(String type) {
        Fragment fragment = FragmentFactory.getFragment(type);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forYou:
                reallocateColors(btnForYou, forYouText);
                loadFragment("For You");
                break;
            case R.id.favourites:
                reallocateColors(btnFavourite, favouritesText);
                loadFragment("Favourites");
                break;
            case R.id.explore:
                reallocateColors(btnExplore, exploreText);
                loadFragment("Explore");
                break;
            case R.id.search:
                reallocateColors(btnSearch, searchText);
                loadFragment("Search");
                break;
            case R.id.saved:
                reallocateColors(btnSaved, savedText);
                loadFragment("Saved");
                break;
        }
    }

    private void reallocateColors(ImageButton btnClicked, TextView textClicked) {

        // setting colour of button to default colour
        for(ImageButton btn: buttonArrayList){
            btn.setColorFilter(Color.rgb(127, 127, 127));
        }

        // setting colour of textview to default
        for(TextView txt: textArrayList) {
            txt.setTextColor(Color.rgb(127,127,127));
        }

        // setting colour to selected colour
        btnClicked.setColorFilter(Color.rgb(0, 122, 255));
        textClicked.setTextColor(Color.rgb(0, 122, 255));

    }
}
