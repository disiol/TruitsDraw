package com.truitsdraw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;

import java.util.Random;

import static com.truitsdraw.constants.Constants.MYLOG_TEG;

public class MainActivity extends AppCompatActivity {

    private final int higt = 5;
    private final int wigt =6;
    private int cellsCount = 30;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout = findViewById(R.id.GridLayout);
        schowBord(gridLayout);


    }

    private void schowBord(GridLayout gridLayout) {
        while (cellsCount > 0) {
            ImageView imageView = eadToGridLayout(gridLayout, 0, cellsCount);
            imageView.requestLayout();
            setSize(imageView);
            imageView.setOnClickListener(v -> {
//                Log.e(MYLOG_TEG, imageView.getTag().toString());
                //receiveClick(imageView);
                Log.e(MYLOG_TEG, " imageView.getId() =  " + imageView.getId());

                //TODO
            });
            cellsCount--;
        }



    }

    private ImageView eadToGridLayout(GridLayout gridLayout, int imageResource, int id) {
        ImageView imageView = new ImageView(this);
       // imageView.setImageResource(imageResource);
        imageView.setId(id);
        imageView.setBackground(ContextCompat.getDrawable(this, R.drawable.blak_boder));
        imageView.setClickable(true);
        setContentDescriptionAndTag(imageView);
        gridLayout.addView(imageView);
        return imageView;
    }

    private void setContentDescriptionAndTag(ImageView imageView) {
      //  imageView.setContentDescription(noFlag);
        Random rnd = new Random();
    }

    private void setSize(ImageView imageView) {
        Display display = getWindowManager().getDefaultDisplay();
        imageView.getLayoutParams().height = (display.getWidth() * 18) / 100;
        imageView.getLayoutParams().width = (display.getWidth() * 18) / 100;
    }
}
