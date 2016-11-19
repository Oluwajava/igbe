package com.snews.pison.snews.utils;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.Locale;

/**
 * Created by Olusegun Olaosebikan on 11/1/2016.
 */

public class FontFactory {

    public static Typeface getTypeFace(AssetManager am, String type) {
        if(type.equalsIgnoreCase("bold")) {
            return Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "ssbold.ttf"));
        } else if(type.equalsIgnoreCase("thin")) {
            return Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "ssthin.ttf"));
        } else if(type.equalsIgnoreCase("regular")) {
            return Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "ssregular.ttf"));
        } else if(type.equalsIgnoreCase("ultralight")) {
            return Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "ssultralight.ttf"));
        } else if(type.equalsIgnoreCase("timeburnerbold")) {
            return Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "timeburnerbold.ttf"));
        } else if(type.equalsIgnoreCase("timeburnernormal")) {
            return Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "timeburnernormal.ttf"));
        }

        return Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "ssregular.ttf"));
    }
}
