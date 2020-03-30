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
    private final int wigt =6;
    private int cellsCount = 0;
    private GridLayout gridLayout;
    private LinearLayout linearLayout;
    private int batonsCaunter = 17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout = findViewById(R.id.GridLayout);
        linearLayout= findViewById(R.id.butons_LinearLayout);

        schowBord(gridLayout);

        addButons();




    }

    private void addButons() {
        while (batonsCaunter > 0){
            ImageView imageView = eadtogridlayout(linearLayout, 0, cellsCount);
            imageView.requestLayout();
            setSizeButons(imageView);
            imageView.setOnClickListener(v -> {
//                Log.e(MYLOG_TEG, imageView.getTag().toString());
                //receiveClick(imageView);
                Log.e(MYLOG_TEG, " imageView.getId() =  " + imageView.getId());

                //TODO
            });
           batonsCaunter --;
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
 private ImageView eadtogridlayout(LinearLayout gridLayout, int imageResource, int id) {
        ImageView imageView = new ImageView(this);
       // imageView.setImageResource(imageResource);
        imageView.setId(id);
        imageView.setBackground(ContextCompat.getDrawable(this, R.drawable.blak_boder));
        imageView.setClickable(true);
        gridLayout.addView(imageView);
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
