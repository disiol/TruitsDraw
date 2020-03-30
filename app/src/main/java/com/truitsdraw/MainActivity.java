package com.truitsdraw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.gridlayout.widget.GridLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
    private LinearLayout.LayoutParams params;
    private int selrktedPise;
    private int witeSelCaunt = 12;
    private Button buttonTmp;

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
            Button button = eadtoBatonlayout(linearLayout, imageArey[batonsCaunter - 1], batonsCaunter);
            button.requestLayout();
            setSizeButons(button);
            button.setOnClickListener(v -> {
//                Log.e(MYLOG_TEG, button.getTag().toString());
                //receiveClick(button);
                Log.e(MYLOG_TEG, " button.getId() =  " + button.getId());
                selrktedPise = button.getId();
                buttonTmp = findViewById(button.getId());

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

            if (cellsCount == 2
                    || cellsCount == 3
                    || cellsCount == 4
                    || cellsCount == 7
                    || cellsCount == 8
                    || cellsCount == 9
                    || cellsCount == 12
                    || cellsCount == 13
                    || cellsCount == 14
                    || cellsCount == 18
                    || cellsCount == 19
                    || cellsCount == 25) {
                setContentDescriptionAndTag(imageView, 3);
            }

            if (cellsCount == 0) {
                setContentDescriptionAndTag(imageView, 1);
            }

            imageView.setOnClickListener(v -> {
                Log.d(MYLOG_TEG, imageView.getTag().toString());
                //receiveClick(imageView);
                Log.e(MYLOG_TEG, " imageView.getId() =  " + imageView.getId());
                Log.e(MYLOG_TEG, " imageView.getDrawable() =  " + imageView.getDrawable());

                int tag = (int) imageView.getTag();
                if (selrktedPise == tag) {
                    imageView.setClickable(false);
                    imageView.setImageDrawable(ContextCompat.getDrawable(this, imageArey[tag - 1]));
                    this.witeSelCaunt --;
                    Log.e(MYLOG_TEG, " witeSelCaunt =  " + this.witeSelCaunt );

                    if (this.witeSelCaunt == 0) {
                        this.buttonTmp.setVisibility(View.GONE);
                    }

                }

                //TODO
            });
            cellsCount++;
        }


    }

    private ImageView eadtogridlayout(GridLayout gridLayout, int imageResource, int id) {
        ImageView imageView = new ImageView(this);
        // imageView.setImageResource(imageResource);
        imageView.setId(id + 20);
        imageView.setBackground(ContextCompat.getDrawable(this, R.drawable.blak_boder));
        imageView.setClickable(true);
        gridLayout.addView(imageView);
        return imageView;
    }

    private Button eadtoBatonlayout(LinearLayout linearLayout, int imageResource, int id) {
        Button button = new Button(this);
        //button.setImageResource(imageResource);
        button.setId(id);
        button.setText(String.valueOf(id));
        button.setTextColor(getResources().getColor(R.color.colorAccent));
        button.setBackground(ContextCompat.getDrawable(this, imageResource));
        button.setClickable(true);
        params = new LinearLayout.LayoutParams(0, 0);
        params.rightMargin = 10;
        linearLayout.addView(button, params);
        return button;
    }

    private void setContentDescriptionAndTag(ImageView imageView, int noFlag) {
        imageView.setTag(noFlag);
        Random rnd = new Random();
    }

    private void setSize(ImageView imageView) {
        Display display = getWindowManager().getDefaultDisplay();
        imageView.getLayoutParams().height = (display.getWidth() * 18) / 95;
        imageView.getLayoutParams().width = (display.getWidth() * 18) / 95;
    }

    private void setSizeButons(Button button) {
        Display display = getWindowManager().getDefaultDisplay();
        button.getLayoutParams().height = (display.getWidth() * 18) / 100;
        button.getLayoutParams().width = (display.getWidth() * 18) / 100;
    }
}
