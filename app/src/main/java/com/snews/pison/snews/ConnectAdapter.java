package com.snews.pison.snews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.michaelevans.colorart.library.ColorArt;

import java.util.ArrayList;

/**
 * Created by Olusegun Olaosebikan on 10/11/2016.
 */
public class ConnectAdapter extends RecyclerView.Adapter<ConnectAdapter.ConnectViewHolder> {
    public static ArrayList<String> favourites = new ArrayList<>();
    ArrayList<Connect> connects = new ArrayList<Connect>();
    public static Context ctx;

    public ConnectAdapter(ArrayList<Connect> connects, Context ctx){
        this.connects = connects;
        this.ctx = ctx;
    }

    @Override
    public ConnectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selection_view_layout, parent, false);
        ConnectViewHolder connectViewHolder = new ConnectViewHolder(view);

        return connectViewHolder;
    }

    @Override
    public void onBindViewHolder(ConnectViewHolder holder, int position) {
        Connect con = connects.get(position);
        holder.person_image.setImageResource(con.getImage_id());
    }

    @Override
    public int getItemCount() {
        return connects.size();
    }

    public static class ConnectViewHolder extends RecyclerView.ViewHolder{
        public static int position;
        RelativeLayout relView;
        CardView cardView;
        ImageView person_image;
        public ConnectViewHolder(View view){
            super(view);
            person_image = (ImageView)view.findViewById(R.id.content_image);
            relView = (RelativeLayout)view.findViewById(R.id.relView);
            cardView = (CardView)view.findViewById(R.id.card_view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    position = getAdapterPosition();

                    /*
                        When a favourite news channel is selected it checks if it is already in ArrayList(favourite)
                        if it's der it removes it removes it from ArrayList(favourite)
                        if it's not der it adds it to ArrayList(Favourite)

                     */
                    if(favourites.indexOf(new String(""+position)) != -1){

                        cardView.setBackgroundColor(Color.WHITE);
                        favourites.remove(favourites.indexOf(new String(""+position)));
                    }else{
                        /*
                            This section gets the background color of the particular image used in
                            the card and use it to set a border round the card
                         */

                        Bitmap bitmap = BitmapFactory.decodeResource(ctx.getResources(), NewsContent.getImageId(position));
                        ColorArt colorArt = new ColorArt(bitmap);

                        cardView.setBackgroundColor(colorArt.getBackgroundColor());
                        favourites.add("" + position);

                        NewsContent.setFavouritesSources(favourites);
                    }




                }
            });

        }
    }
}