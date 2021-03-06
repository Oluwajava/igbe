package com.snews.pison.snews.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.snews.pison.snews.R;

import org.michaelevans.colorart.library.ColorArt;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Olusegun Olaosebikan on 10/11/2016.
 */
public class SelectionAdapter extends RecyclerView.Adapter<SelectionAdapter.ConnectViewHolder> {
    public static ArrayList<String> favourites = new ArrayList<>();
    ArrayList<SelectionItem> selectionItems = new ArrayList<SelectionItem>();
    public static ArrayList<Boolean> tracker = new ArrayList<>();
    public static Context ctx;

    public SelectionAdapter(ArrayList<SelectionItem> selectionItems, Context ctx){
        this.selectionItems = selectionItems;
        this.ctx = ctx;
        initializeTracker();

    }

    private void initializeTracker() {
        for(int i = 0; i < selectionItems.size(); i++){
            tracker.add(false);
        }
    }
    @Override
    public ConnectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pick_favorite_card, parent, false);
        ConnectViewHolder connectViewHolder = new ConnectViewHolder(view);

        return connectViewHolder;
    }

    @Override
    public void onViewRecycled(ConnectViewHolder holder) {
        super.onViewRecycled(holder);



    }



    @Override
    public void onBindViewHolder(ConnectViewHolder holder, int position) {
        SelectionItem con = selectionItems.get(position);
        holder.person_image.setImageResource(con.getImage_id());
        holder.source_name.setText(con.getName());
        holder.bgLayout.setBackgroundResource(con.getBackground_id());
        holder.bgLayout.getBackground().setAlpha(40);

        holder.selectNewsSource.setTag(position);
        holder.selectNewsSource.setChecked(tracker.get(position));
    }


    @Override
    public int getItemCount() {
        return selectionItems.size();
    }

    public static class ConnectViewHolder extends RecyclerView.ViewHolder{
        public static int position;
        RelativeLayout relView;
        CardView cardView;
        ImageView person_image;
        TextView source_name;
        FrameLayout bgLayout;
        CheckBox selectNewsSource;


        public ConnectViewHolder(View view){
            super(view);
            setIsRecyclable(false);
            person_image = (ImageView)view.findViewById(R.id.content_image);
            relView = (RelativeLayout)view.findViewById(R.id.relView);
            cardView = (CardView)view.findViewById(R.id.card_view);
            bgLayout = (FrameLayout)view.findViewById(R.id.bg_layout);
            source_name = (TextView)view.findViewById(R.id.source_name);
            selectNewsSource = (CheckBox) view.findViewById(R.id.checkbox);

            selectNewsSource.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    int position = getAdapterPosition();

                    if(selectNewsSource.getTag()!=null){
                        tracker.set((int)selectNewsSource.getTag(), b);
                    }
                    if(favourites.indexOf(new String(""+position)) != -1){
                        Log.d("Test", "Item "+position+" removed");

                        favourites.remove(favourites.indexOf(new String(""+position)));
                    }else{
                        /*
                            This section gets the background color of the particular image used in
                            the card and use it to set a border round the card
                         */

                        Log.d("Test", "Item "+position+" added");

                        favourites.add("" + position);

                        NewsContent.setFavouritesSources(favourites);
                    }
                }
            });
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    position = getAdapterPosition();
//
//                    /*
//                        When a favourite news channel is selected it checks if it is already in ArrayList(favourite)
//                        if it's der it removes it removes it from ArrayList(favourite)
//                        if it's not der it adds it to ArrayList(Favourite)
//
//                     */
//                    if(favourites.indexOf(new String(""+position)) != -1){
//                        Log.d("Test", "Background reset");
//                        relView.setBackgroundColor(Color.WHITE);
//                        favourites.remove(favourites.indexOf(new String(""+position)));
//                    }else{
//                        /*
//                            This section gets the background color of the particular image used in
//                            the card and use it to set a border round the card
//                         */
//
//                        Bitmap bitmap = BitmapFactory.decodeResource(ctx.getResources(), NewsContent.getImageId(position));
//                        ColorArt colorArt = new ColorArt(bitmap);
//
//                        Log.d("Test", "Background set");
//                        relView.setBackgroundColor(colorArt.getBackgroundColor());
//                        favourites.add("" + position);
//
//                        NewsContent.setFavouritesSources(favourites);
//                    }
//
//
//
//
//                }
//            });
        }
    }
}
