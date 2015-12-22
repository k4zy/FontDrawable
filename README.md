FontDrawable
============

Convert Icon-font(e.g. font-awsome) to Drawable or Bitmap for Android.  
Blog(japanese): http://qiita.com/kazy/items/c7d4dd13c49ef1de651d

Update
--------

* ver 0.9.1 Support ProgressDrawable. Please check sample.
* ver 0.9.0 First release.

How to
--------

##### Step 1. Add the JitPack repository to your build file.

```groovy
  repositories {
    maven {
      url "https://jitpack.io"
    }
  }
```

##### Step 2. Add the dependency in the form.

```groovy
  dependencies {
    compile 'com.github.kazy1991:FontDrawable:0.9.1'
  }
```
##### Step 3. Add icon-font file to `main/assets`

##### Step 4.  Sample code with [font-awsome](https://fortawesome.github.io/Font-Awesome/).

```java
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
```

<img src="https://raw.githubusercontent.com/kazy1991/FontDrawable/image/sample_screen_shot.png" width=40% />

License
-------

    Copyright 2015 Kazuki Yoshida

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

