package com.truitsdraw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
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
            Button button = eadtogridlayout(gridLayout, cellsCount);
            button.requestLayout();
            setSize(button);

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
                setContentDescriptionAndTag(button, 3);

            } else if (cellsCount == 0) {
                setContentDescriptionAndTag(button, 1);
            } else if (cellsCount == 1) {
                setContentDescriptionAndTag(button, 2);
            } else if (cellsCount == 5) {
                setContentDescriptionAndTag(button, 5);
            } else if (cellsCount == 6) {
                setContentDescriptionAndTag(button, 4);
            } else if (cellsCount == 11) {
                setContentDescriptionAndTag(button, 7);
            } else if (cellsCount == 10) {
                setContentDescriptionAndTag(button, 6);
            } else if (cellsCount == 15) {
                setContentDescriptionAndTag(button, 8);
            } else if (cellsCount == 16) {
                setContentDescriptionAndTag(button, 9);
            } else if (cellsCount == 17) {
                setContentDescriptionAndTag(button, 10);
            } else if (cellsCount == 20) {
                setContentDescriptionAndTag(button, 11);
            } else if (cellsCount == 21) {
                setContentDescriptionAndTag(button, 12);
            } else if (cellsCount == 22) {
                setContentDescriptionAndTag(button, 13);
            } else if (cellsCount == 23) {
                setContentDescriptionAndTag(button, 14);
            } else if (cellsCount == 24) {
                setContentDescriptionAndTag(button, 15);
            } else if (cellsCount == 26) {
                setContentDescriptionAndTag(button, 16);
            } else if (cellsCount == 27) {
                setContentDescriptionAndTag(button, 17);
            } else if (cellsCount == 28) {
                setContentDescriptionAndTag(button, 18);
            } else if (cellsCount == 29) {
                setContentDescriptionAndTag(button, 19);
            } else {
                button.setText(String.valueOf(cellsCount));
                button.setTextColor(getResources().getColor(R.color.colorAccent));
            }

            button.setOnClickListener(v -> {
                //receiveClick(button);
                Log.e(MYLOG_TEG, " button.getId() =  " + button.getId());

                if (button.getTag() != null) {
                    int tag = (int) button.getTag();
                    showPises(button, tag);
                }

                //TODO
            });
            cellsCount++;
        }


    }

    private void showPises(Button imageView, int tag) {
        Log.e(MYLOG_TEG, " imageView.getTag() =  " + imageView.getTag());

        if (selrktedPise == tag) {
            imageView.setClickable(false);
            imageView.setBackgroundResource(imageArey[tag - 1]);
            imageView.setText("");

            if (tag == 3) {
                this.witeSelCaunt = this.witeSelCaunt--;
            } else if (witeSelCaunt == 0) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 1) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 2) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 5) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 4) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 7) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 6) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 8) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 9) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 10) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 11) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 12) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 13) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 14) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 15) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 16) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 17) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 18) {
                buttonTmp.setVisibility(View.GONE);
            } else if (tag == 19) {
                buttonTmp.setVisibility(View.GONE);
            }
            Log.e(MYLOG_TEG, " witeSelCaunt =  " + this.witeSelCaunt);


        }
    }

    private Button eadtogridlayout(GridLayout gridLayout, int id) {
        Button button = new Button(this);
        // button.setImageResource(imageResource);
        button.setBackgroundColor(getResources().getColor(R.color.onColor));
        button.setClickable(true);
        gridLayout.addView(button);
        return button;
    }

    private Button eadtoBatonlayout(LinearLayout linearLayout, int imageResource, int id) {
        Button button = new Button(this);
        //button.setImageResource(imageResource);
        button.setId(id);
        button.setText(String.valueOf(id));
        button.setTextColor(getResources().getColor(R.color.colorAccent));
        button.setBackground(ContextCompat.getDrawable(this, imageResource));
        button.setClickable(true);
        button.getBackground();
        params = new LinearLayout.LayoutParams(0, 0);
        params.rightMargin = 10;
        linearLayout.addView(button, params);
        return button;
    }

    private void setContentDescriptionAndTag(Button button, int teg) {
        button.setTag(teg);
        button.setText(String.valueOf(teg));
        button.setTextColor(getResources().getColor(R.color.colorAccent));

    }

    private void setSize(Button imageView) {
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
