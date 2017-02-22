package com.example.mathieu.aninterface;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mathieu on 2017-02-08.
 */

public class HomeRow {

    public int image;
    public String text;

    public HomeRow(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
