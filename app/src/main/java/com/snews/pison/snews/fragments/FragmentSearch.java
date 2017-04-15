package com.snews.pison.snews.fragments;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.snews.pison.snews.R;
import com.snews.pison.snews.utils.News;
import com.snews.pison.snews.utils.SearchResultsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * User can search for article using certain keywords
 */
public class FragmentSearch extends AbstractFragment {

    private List<News> newsList = newsList = new ArrayList<>();;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private SearchResultsAdapter mSearchResultsAdapter;
    private LinearLayout mRecentsContainer;
    private ListView mRecentSearchesListView;
    public static FragmentSearch newInstance() {
        return new FragmentSearch();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        initializeToolbar(rootView);

        mRecyclerView = ButterKnife.findById(rootView, R.id.search_results);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mSearchResultsAdapter = new SearchResultsAdapter(newsList);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mSearchResultsAdapter);
        mRecyclerView.setVisibility(View.GONE);

        initAdapter();

        String[] searchesArray = {
                "Benghazi wars", "Nigerian president", "Obama presidency",
                "UN deployment", "Chinese army", "Ebola outbreak"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.listview_item,
                R.id.search_item_textview,
                searchesArray);
        mRecentSearchesListView = ButterKnife.findById(rootView, R.id.recent_searches);
        mRecentSearchesListView.setDivider(null);
        mRecentSearchesListView.setAdapter(adapter);
        mRecentsContainer = ButterKnife.findById(rootView, R.id.recents_container);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.options_menu, menu);

        Activity activity = getActivity();
        // Link the searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) activity.getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(
                    activity.getComponentName()));

        EditText searchEditText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setHint("what are you looking for?");
        searchEditText.setTextColor(Color.BLACK);
        searchEditText.setHintTextColor(Color.GRAY);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                int recentsVisible = mRecentsContainer.getVisibility();
                if (recentsVisible == View.VISIBLE) {
                    // Hide the recent search list
                    mRecentsContainer.setVisibility(View.GONE);
                    mRecyclerView.setVisibility(View.VISIBLE);
                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getView().getWindowToken(), 0);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                int recentsVisible = mRecentsContainer.getVisibility();
                if (recentsVisible == View.GONE) {
                    mRecentsContainer.setVisibility(View.VISIBLE);
                    mRecyclerView.setVisibility(View.GONE);
                }
                return false;
            }
        });
    }

    private void initAdapter() {
        newsList.add(new News.Builder("", "Nigeria discovers oil in Enugu")
                .content("Lorem ipsum vegra bara simu ipsum cara tara tarada " +
                        "parada isump mellar demis deram ispum param param loreil " +
                        "carat ispusm marak ispum mara maraton isput")
                .build());
        newsList.add(new News.Builder("", "Benghazi war heats up")
                .content("Lorem ipsum vegra bara simu ipsum cara tara tarada " +
                        "parada isump mellar demis deram ispum param param loreil " +
                        "carat ispusm marak ispum mara maraton isput")
                .build());
        newsList.add(new News.Builder("", "Putin goes all Game of Thrones on the USA")
                .content("Lorem ipsum vegra bara simu ipsum cara tara tarada " +
                        "parada isump mellar demis deram ispum param param loreil " +
                        "carat ispusm marak ispum mara maraton isput")
                .build());
        newsList.add(new News.Builder("", "Hillary Clinton jumps off the Eiffle")
                .content("Lorem ipsum vegra bara simu ipsum cara tara tarada " +
                        "parada isump mellar demis deram ispum param param loreil " +
                        "carat ispusm marak ispum mara maraton isput")
                .build());
        newsList.add(new News.Builder("", "Donald Trump claims Chinese origins")
                .content("Lorem ipsum vegra bara simu ipsum cara tara tarada " +
                        "parada isump mellar demis deram ispum param param loreil " +
                        "carat ispusm marak ispum mara maraton isput")
                .build());
        newsList.add(new News.Builder("", "Barack looks dope on some Caftan shi")
                .content("Lorem ipsum vegra bara simu ipsum cara tara tarada " +
                        "parada isump mellar demis deram ispum param param loreil " +
                        "carat ispusm marak ispum mara maraton isput")
                .build());
        mSearchResultsAdapter.notifyDataSetChanged();
    }


    private void initializeToolbar(View view) {
        super.initilizeToolbars(view, R.string.search_tab, 0, false);

    }
}
