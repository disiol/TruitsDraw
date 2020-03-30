package com.truitsdraw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

import static com.truitsdraw.constants.Constants.MYLOG_TEG;

public class MainActivity extends AppCompatActivity {

    private final int higt = 5;
    private final int wigt = 6;
    private int cellsCount = 0;
    private GridLayout gridLayout;
    private LinearLayout linearLayout;
    private int batonsCaunter = 19;
    private int[] imageArey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout = findViewById(R.id.GridLayout);
        linearLayout = findViewById(R.id.butons_LinearLayout);

        imageArey = new int[]{R.drawable.image_part_1,
                R.drawable.image_part_2,
                R.drawable.image_part_3,
                R.drawable.image_part_4,
                R.drawable.image_part_5,
                R.drawable.image_part_6,
                R.drawable.image_part_7,
                R.drawable.image_part_8,
                R.drawable.image_part_9,
                R.drawable.image_part_10,
                R.drawable.image_part_11,
                R.drawable.image_part_12,
                R.drawable.image_part_13,
                R.drawable.image_part_14,
                R.drawable.image_part_15,
                R.drawable.image_part_16,
                R.drawable.image_part_17,
                R.drawable.image_part_18,
                R.drawable.image_part_19};

        schowBord(gridLayout);

        addButons();


    }

    private void addButons() {
        while (batonsCaunter > 0) {
            ImageView imageView = eadtogridlayout(linearLayout, imageArey[batonsCaunter -1], cellsCount);
            imageView.requestLayout();
            setSizeButons(imageView);
            imageView.setOnClickListener(v -> {
//                Log.e(MYLOG_TEG, imageView.getTag().toString());
                //receiveClick(imageView);
                Log.e(MYLOG_TEG, " imageView.getId() =  " + imageView.getId());

                //TODO
            });
            batonsCaunter--;
        }

    }

    private void schowBord(GridLayout gridLayout) {
        while (cellsCount < 30) {
            ImageView imageView = eadtogridlayout(gridLayout, 0, cellsCount);
            imageView.requestLayout();
            setSize(imageView);
            imageView.setOnClickListener(v -> {
//                Log.e(MYLOG_TEG, imageView.getTag().toString());
                //receiveClick(imageView);
                Log.e(MYLOG_TEG, " imageView.getId() =  " + imageView.getId());

                //TODO
            });
            cellsCount++;
        }


    }

    private ImageView eadtogridlayout(GridLayout gridLayout, int imageResource, int id) {
        ImageView imageView = new ImageView(this);
        // imageView.setImageResource(imageResource);
        imageView.setId(id);
        imageView.setBackground(ContextCompat.getDrawable(this, R.drawable.blak_boder));
        imageView.setClickable(true);
        gridLayout.addView(imageView);
        return imageView;
    }

    private ImageView eadtogridlayout(LinearLayout linearLayout, int imageResource, int id) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(imageResource);
        imageView.setId(id);
        imageView.setBackground(ContextCompat.getDrawable(this, R.drawable.blak_boder));
        imageView.setClickable(true);
        linearLayout.addView(imageView);
        return imageView;
    }

    private void setContentDescriptionAndTag(ImageView imageView, CharSequence noFlag) {
        imageView.setContentDescription(noFlag);
        Random rnd = new Random();
    }

    private void setSize(ImageView imageView) {
        Display display = getWindowManager().getDefaultDisplay();
        imageView.getLayoutParams().height = (display.getWidth() * 18) / 100;
        imageView.getLayoutParams().width = (display.getWidth() * 18) / 100;
    }

    private void setSizeButons(ImageView imageView) {
        Display display = getWindowManager().getDefaultDisplay();
        imageView.getLayoutParams().height = (display.getWidth() * 18) / 70;
        imageView.getLayoutParams().width = (display.getWidth() * 18) / 70;
    }
}
