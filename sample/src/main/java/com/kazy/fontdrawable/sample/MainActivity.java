package com.kazy.fontdrawable.sample;

import com.kazy.fontdrawable.FontDrawable;
import com.kazy.fontdrawable.FontProgressDrawable;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    static final String CUSTOM_FONT_PATH = "fontawesome-webfont.ttf";

    static final char SPACE_SHUTTLE_CODE = '\uf197';

    @ColorInt
    static final int MATERIAL_BLUE = 0xff00a8f7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView drawableImageView = (ImageView) findViewById(R.id.drawable_image_view);
        FontDrawable spaceShuttle = new FontDrawable.Builder(this, SPACE_SHUTTLE_CODE, CUSTOM_FONT_PATH)
                .setSizeDp(100)
                .setColor(MATERIAL_BLUE)
                .build();
        drawableImageView.setImageDrawable(spaceShuttle);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        FontProgressDrawable progressDrawable = new FontProgressDrawable.Builder(this, SPACE_SHUTTLE_CODE, CUSTOM_FONT_PATH)
                .setProgressColor(MATERIAL_BLUE)
                .setBackGroundColor(Color.LTGRAY)
                .setPaddingDp(4)
                .build();
        ratingBar.setProgressDrawable(progressDrawable);
    }

}
