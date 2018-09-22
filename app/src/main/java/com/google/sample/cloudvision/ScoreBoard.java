package com.google.sample.cloudvision;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboard_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView objecttodraw = findViewById(R.id.object);
        objecttodraw.setText("Hello");

        score1 = findViewById(R.id.p1score);
        score2 = findViewById(R.id.p2score);

        image1 = findViewById(R.id.p1image);
        image2 = findViewById(R.id.p2image);
        trophy = findViewById(R.id.trophyImage);
    }

    public void setImage(Bitmap bitmap1, Bitmap bitmap2){
        image1.setImageBitmap(bitmap1);
        image2.setImageBitmap(bitmap2);
    }

    public void setScore(double p1, double p2) {
        score1.setText(Double.toString(p1));
        score2.setText(Double.toString(p2));

        if (p1 > p2) {
            trophy.setTranslationY(0);
        } else if (p2 > p1) {
            trophy.setTranslationY(300);
        } else {
            trophy.setVisibility(ImageView.INVISIBLE);
        }

    }
}
