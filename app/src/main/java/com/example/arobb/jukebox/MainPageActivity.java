package com.example.arobb.jukebox;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        final Button create = (Button) findViewById(R.id.create_btn);
        final Button enter = (Button) findViewById(R.id.enter_btn);
        if(create != null){
            create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToDJ(create);
                }
            });
        }
        if(enter != null){
            enter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToPleb(enter);
                }
            });
        }
    }

    public void goToDJ(Button btn){
        btn.setEnabled(false);
        btn.setBackgroundColor(Color.LTGRAY);
        Intent toDJ = new Intent(MainPageActivity.this, DJActivity.class);
        startActivity(toDJ);
        btn.setEnabled(true);
        btn.setBackgroundColor(Color.parseColor("#BB9F06"));
    }

    public void goToPleb(Button btn){
        btn.setEnabled(false);
        btn.setBackgroundColor(Color.LTGRAY);
        Intent toPleb = new Intent(MainPageActivity.this, PlebActivity.class);
        startActivity(toPleb);
        btn.setEnabled(true);
        btn.setBackgroundColor(Color.parseColor("#BB9F06"));
    }
}
