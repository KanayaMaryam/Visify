package com.google.sample.cloudvision;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ScoreBoard extends AppCompatActivity  {

    private TextView score1;
    private TextView score2;
    private ImageView image1;
    private ImageView image2;
    private ImageView trophy;
    private ImageView trophy2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboard_activity);


        score1 = findViewById(R.id.p1score);
        score2 = findViewById(R.id.p2score);

        image1 = findViewById(R.id.p1image);
        image2 = findViewById(R.id.p2image);
        trophy = findViewById(R.id.trophyImage);
        trophy2 = findViewById(R.id.trophyImage2);

        //setActionBar(View.INVISIBLE);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }

        setImage(MainActivity.getBtmp1(), MainActivity.getBtmp2());
        setScore(MainActivity.getScore1(), MainActivity.getScore2());
    }

    public void setImage(Bitmap bitmap1, Bitmap bitmap2){
        image1.setVisibility(View.VISIBLE);
        image2.setVisibility(View.VISIBLE);


        image1.setImageBitmap(Bitmap.createScaledBitmap(bitmap1, 400, 600, false));
        image2.setImageBitmap(Bitmap.createScaledBitmap(bitmap2, 400, 600, false));
    }

    public void setScore(double p1, double p2) {
        int s1 = (int)(p1 * 100);
        int s2 = (int)(p2 * 100);
        score1.setText(s1 + "%");
        score2.setText(s2 + "%");

        trophy.setVisibility(View.INVISIBLE);
        trophy2.setVisibility(View.INVISIBLE);
        if (p1 > p2) {
            trophy.setVisibility(View.VISIBLE);
        } else if (p2 > p1) {
            trophy2.setVisibility(View.VISIBLE);
        }

    }
}
