FontDrawable
============

Convert Icon-font(e.g. font-awsome) to Drawable or Bitmap for Android.

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
    compile 'com.github.kazy1991:FontDrawable:0.9.0'
  }
```
##### Step 3. Add icon-font file to `main/assets`

##### Step 4.  Sample code with [font-awsome](https://fortawesome.github.io/Font-Awesome/).

```java
public class MainActivity extends AppCompatActivity {

    static final String CUSTOM_FONT_PATH = "fontawesome-webfont.ttf";

    static final char SPACE_SHUTTLE_CODE = '\uf197';

    @ColorInt static final int MATERIAL_BLUE = 0xff00a8f7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        FontDrawable spaceShuttle = new FontDrawable.Builder(this, SPACE_SHUTTLE_CODE, CUSTOM_FONT_PATH)
                .setSizeDp(100)
                .setColor(MATERIAL_BLUE)
                .build();
        imageView.setImageDrawable(spaceShuttle);
    }
}
```

<img src="https://i.gyazo.com/9a772b2859d15db9b8c3c8243ea38e04.png" width=40% />

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


