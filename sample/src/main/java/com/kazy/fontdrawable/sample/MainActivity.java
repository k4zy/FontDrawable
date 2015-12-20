package com.kazy.fontdrawable.sample;

import com.kazy.fontdrawable.FontDrawable;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final String CUSTOM_FONT_PATH = "fontawesome-webfont.ttf";

    static final char SPACE_SHUTTLE_CODE = '\uf197';

    static final char BICYCLE_CODE = '\uf206';

    @ColorInt
    static final int MATERIAL_BLUE = 0xff00a8f7;

    @ColorInt
    static final int MATERIAL_GREEN = 0xff009688;

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

        ImageView bitmapImageView = (ImageView) findViewById(R.id.bitmap_image_view);
        Bitmap bicycle = new FontDrawable.Builder(this, BICYCLE_CODE, CUSTOM_FONT_PATH)
                .setSizeDp(100)
                .setColor(MATERIAL_GREEN)
                .build()
                .toBitmap();
        bitmapImageView.setImageBitmap(bicycle);
    }
}
