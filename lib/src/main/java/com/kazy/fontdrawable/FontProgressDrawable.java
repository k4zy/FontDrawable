package com.kazy.fontdrawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.ColorInt;
import android.view.Gravity;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.applyDimension;

public class FontProgressDrawable extends LayerDrawable {

    private FontProgressDrawable(Drawable[] layers) {
        super(layers);
        final int[] requiredIds = {android.R.id.background, android.R.id.secondaryProgress, android.R.id.progress};
        for (int i = 0; i < requiredIds.length; i++) {
            setId(i, requiredIds[i]);
        }
    }

    public static class Builder {

        final static int ICON_SIZE = 48;

        final private Context context;

        final private char fontCode;

        final private Paint paint;

        final private int size;

        private int padding = 0;

        private int progressColor = Color.YELLOW;

        private int backgroundColor = Color.LTGRAY;

        private int secondaryProgressColor = Color.GRAY;

        public Builder(Context context, char fontCode, String customFontPath) {
            this(context, fontCode, Typeface.createFromAsset(context.getAssets(), customFontPath));
        }

        public Builder(Context context, char fontCode, Typeface typeface) {
            this(context, fontCode, new CustomFontPaint(typeface));
        }

        public Builder(Context context, char fontCode, CustomFontPaint paint) {
            this.context = context;
            this.fontCode = fontCode;
            this.paint = new Paint(paint);
            this.size = convertDpToPx(context, ICON_SIZE);
        }

        public Builder setPaddingPx(int padding) {
            this.padding = padding;
            return this;
        }

        public Builder setPaddingDp(int dp) {
            int padding = convertDpToPx(context, dp);
            setPaddingPx(padding);
            return this;
        }

        public Builder setProgressColor(@ColorInt int color) {
            this.progressColor = color;
            return this;
        }

        public Builder setBackGroundColor(@ColorInt int color) {
            this.backgroundColor = color;
            return this;
        }

        public Builder setSecondaryProgressColor(@ColorInt int color) {
            this.secondaryProgressColor = color;
            return this;
        }

        public FontProgressDrawable build() {
            Bitmap progressBitmap = createBitmap(progressColor);
            Bitmap secondaryProgressBitmap = createBitmap(secondaryProgressColor);
            Bitmap backgroundBitmap = createBitmap(backgroundColor);
            return new FontProgressDrawable(createDrawables(new Bitmap[]{backgroundBitmap, secondaryProgressBitmap, progressBitmap}));
        }

        private Bitmap createBitmap(@ColorInt int color) {
            Paint progressPaint = new Paint(paint);
            progressPaint.setColor(color);
            return new FontDrawable(fontCode, progressPaint, size, padding).toBitmap();
        }

        private Drawable[] createDrawables(Bitmap[] bitmaps) {
            Drawable[] pieces = new Drawable[bitmaps.length];
            for (int i = 0; i < bitmaps.length; i++) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmaps[i]);
                bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
                if (i == 0) {
                    pieces[i] = bitmapDrawable;
                } else {
                    pieces[i] = new ClipDrawable(bitmapDrawable, Gravity.LEFT, ClipDrawable.HORIZONTAL);
                }
            }
            return pieces;
        }

        private static int convertDpToPx(Context context, float dp) {
            return (int) applyDimension(COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
        }

    }
}
