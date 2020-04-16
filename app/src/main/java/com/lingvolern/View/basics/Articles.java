package com.lingvolern.View.basics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.lingvolern.R;
import com.lingvolern.View.Basics;
import com.lingvolern.View.Menu;

public class Articles extends AppCompatActivity implements View.OnClickListener{

    ImageButton ibtn_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        ibtn_menu = (ImageButton) findViewById(R.id.ibtn_Menu);
        ibtn_menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ibtn_Menu:
                this.finish();
                Intent intent = new Intent(this, Basics.class);
                startActivity(intent);
                break;




        }

    }
}
