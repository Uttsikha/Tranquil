package com.example.tranquil;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class management extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }
    public void Breathe(View view) {
        Intent br=new Intent(this,Breathe.class);
        startActivity(br);

    }

    public void Meditate(View view) {
        Intent me=new Intent(this,Meditate.class);
        startActivity(me);

    }
    public void Mantra(View view) {
        Intent mr=new Intent(this,Mantra.class);
        startActivity(mr);

    }

    public void Yoga(View view) {
        Intent yg=new Intent(this,Yoga.class);
        startActivity(yg);

    }
    public void Exercise(View view) {
        Intent ex=new Intent(this,Exercise.class);
        startActivity(ex);

    }

    public void Music(View view) {
        Intent ms=new Intent(this,Music.class);
        startActivity(ms);

    }

    public void InspiringQuotes(View view) {
        Intent isp=new Intent(this,iq.class);
        startActivity(isp);

    }

}
