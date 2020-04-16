package com.lingvolern.View;        //Выбор уровня пользователем

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.lingvolern.Presenter.Controller;
import com.lingvolern.Presenter.User;
import com.lingvolern.R;

public class Level extends AppCompatActivity implements View.OnClickListener {

    ImageButton ibtn_menu;
    Button btn_level_1;
    Button btn_level_2;
    Button btn_level_3;
    Button btn_level_4;
    Button btn_level_5;
    Button btn_level_6;
    Button btn_level_7;
    Button btn_level_8;
    Button btn_level_9;
    Button btn_level_10;
    Button btn_level_11;
    Button btn_level_12;
    Button btn_level_13;
    Button btn_level_14;
    Button btn_level_15;
    Button btn_level_16;
    Button btn_level_17;
    Button btn_level_18;
    Button btn_level_19;
    Button btn_level_20;
    Button btn_level_21;
    Button btn_level_22;
    Button btn_level_23;
    Button btn_level_24;


    Controller controller;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        controller = new Controller(this);
        user = controller.getUser();

        ibtn_menu = (ImageButton) findViewById(R.id.ibtn_Menu);
        ibtn_menu.setOnClickListener(this);

        btn_level_1 = (Button) findViewById(R.id.btn_level_1);
        btn_level_1.setOnClickListener(this);

        btn_level_2 = (Button) findViewById(R.id.btn_level_2);
        btn_level_2.setOnClickListener(this);

        btn_level_3 = (Button) findViewById(R.id.btn_level_3);
        btn_level_3.setOnClickListener(this);

        btn_level_4 = (Button) findViewById(R.id.btn_level_4);
        btn_level_4.setOnClickListener(this);

        btn_level_5 = (Button) findViewById(R.id.btn_level_5);
        btn_level_5.setOnClickListener(this);

        btn_level_6 = (Button) findViewById(R.id.btn_level_6);
        btn_level_6.setOnClickListener(this);

        btn_level_7 = (Button) findViewById(R.id.btn_level_7);
        btn_level_7.setOnClickListener(this);

        btn_level_8 = (Button) findViewById(R.id.btn_level_8);
        btn_level_8.setOnClickListener(this);

        btn_level_9 = (Button) findViewById(R.id.btn_level_9);
        btn_level_9.setOnClickListener(this);

        btn_level_10 = (Button) findViewById(R.id.btn_level_10);
        btn_level_10.setOnClickListener(this);

        btn_level_11 = (Button) findViewById(R.id.btn_level_11);
        btn_level_11.setOnClickListener(this);

        btn_level_12 = (Button) findViewById(R.id.btn_level_12);
        btn_level_12.setOnClickListener(this);

        btn_level_13 = (Button) findViewById(R.id.btn_level_13);
        btn_level_13.setOnClickListener(this);

        btn_level_14 = (Button) findViewById(R.id.btn_level_14);
        btn_level_14.setOnClickListener(this);

        btn_level_15 = (Button) findViewById(R.id.btn_level_15);
        btn_level_15.setOnClickListener(this);

        btn_level_16 = (Button) findViewById(R.id.btn_level_16);
        btn_level_16.setOnClickListener(this);

        btn_level_17 = (Button) findViewById(R.id.btn_level_17);
        btn_level_17.setOnClickListener(this);

        btn_level_18 = (Button) findViewById(R.id.btn_level_18);
        btn_level_18.setOnClickListener(this);

        btn_level_19 = (Button) findViewById(R.id.btn_level_19);
        btn_level_19.setOnClickListener(this);

        btn_level_20 = (Button) findViewById(R.id.btn_level_20);
        btn_level_20.setOnClickListener(this);

        btn_level_21 = (Button) findViewById(R.id.btn_level_21);
        btn_level_21.setOnClickListener(this);

        btn_level_22 = (Button) findViewById(R.id.btn_level_22);
        btn_level_22.setOnClickListener(this);

        btn_level_23 = (Button) findViewById(R.id.btn_level_23);
        btn_level_23.setOnClickListener(this);

        btn_level_24 = (Button) findViewById(R.id.btn_level_24);
        btn_level_24.setOnClickListener(this);




        if (user.getLevel() == 1)
        {
            btn_level_1.setEnabled(true);
        }
        else if (user.getLevel() == 2)
        {
            btn_level_2.setEnabled(true);
        }
        else if (user.getLevel() == 3)
        {
            btn_level_3.setEnabled(true);
        }
        else if (user.getLevel() == 4)
        {
            btn_level_4.setEnabled(true);
        }
        else if (user.getLevel() == 5)
        {
            btn_level_5.setEnabled(true);
        }
        else if (user.getLevel() == 6)
        {
            btn_level_6.setEnabled(true);
        }
        else if (user.getLevel() == 7)
        {
            btn_level_7.setEnabled(true);
        }
        else if (user.getLevel() == 8)
        {
            btn_level_8.setEnabled(true);
        }
        else if (user.getLevel() == 9)
        {
            btn_level_9.setEnabled(true);
        }
        else if (user.getLevel() == 10)
        {
            btn_level_10.setEnabled(true);
        }
        else if (user.getLevel() == 11)
        {
            btn_level_11.setEnabled(true);
        }
        else if (user.getLevel() == 12)
        {
            btn_level_12.setEnabled(true);
        }
        else if (user.getLevel() == 13)
        {
            btn_level_13.setEnabled(true);
        }
        else if (user.getLevel() == 14)
        {
            btn_level_14.setEnabled(true);
        }
        else if (user.getLevel() == 15)
        {
            btn_level_15.setEnabled(true);
        }
        else if (user.getLevel() == 16)
        {
            btn_level_16.setEnabled(true);
        }
        else if (user.getLevel() == 17)
        {
            btn_level_17.setEnabled(true);
        }
        else if (user.getLevel() == 18)
        {
            btn_level_18.setEnabled(true);
        }
        else if (user.getLevel() == 19)
        {
            btn_level_19.setEnabled(true);
        }
        else if (user.getLevel() == 20)
        {
            btn_level_20.setEnabled(true);
        }
        else if (user.getLevel() == 21)
        {
            btn_level_21.setEnabled(true);
        }
        else if (user.getLevel() == 22)
        {
            btn_level_22.setEnabled(true);
        }
        else if (user.getLevel() == 23)
        {
            btn_level_23.setEnabled(true);
        }
        else if (user.getLevel() == 24)
        {
            btn_level_24.setEnabled(true);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.ibtn_Menu:
                this.finish();
                break;

            case R.id.btn_level_1:


                this.finish();
                Intent intent_1 = new Intent(this, Traning.class);
                intent_1.putExtra("level", 1);
                startActivity(intent_1);
                break;

            case R.id.btn_level_2:

                this.finish();
                Intent intent_2 = new Intent(this, Traning.class);
                intent_2.putExtra("level", 2);
                startActivity(intent_2);
                break;

            case R.id.btn_level_3:

                this.finish();
                Intent intent_3 = new Intent(this, Traning.class);
                intent_3.putExtra("level", 3);
                startActivity(intent_3);
                break;

            case R.id.btn_level_4:

                this.finish();
                Intent intent_4 = new Intent(this, Traning.class);
                intent_4.putExtra("level", 4);
                startActivity(intent_4);
                break;

            case R.id.btn_level_5:

                this.finish();
                Intent intent_5 = new Intent(this, Traning.class);
                intent_5.putExtra("level", 5);
                startActivity(intent_5);
                break;

            case R.id.btn_level_6:

                this.finish();
                Intent intent_6 = new Intent(this, Traning.class);
                intent_6.putExtra("level", 6);
                startActivity(intent_6);
                break;

            case R.id.btn_level_7:

                this.finish();
                Intent intent_7 = new Intent(this, Traning.class);
                intent_7.putExtra("level", 7);
                startActivity(intent_7);
                break;

            case R.id.btn_level_8:

                this.finish();
                Intent intent_8 = new Intent(this, Traning.class);
                intent_8.putExtra("level", 8);
                startActivity(intent_8);
                break;

            case R.id.btn_level_9:

                this.finish();
                Intent intent_9 = new Intent(this, Traning.class);
                intent_9.putExtra("level", 9);
                startActivity(intent_9);
                break;

            case R.id.btn_level_10:

                this.finish();
                Intent intent_10 = new Intent(this, Traning.class);
                intent_10.putExtra("level", 10);
                startActivity(intent_10);
                break;

            case R.id.btn_level_11:

                this.finish();
                Intent intent_11 = new Intent(this, Traning.class);
                intent_11.putExtra("level", 11);
                startActivity(intent_11);
                break;

            case R.id.btn_level_12:

                this.finish();
                Intent intent_12 = new Intent(this, Traning.class);
                intent_12.putExtra("level", 12);
                startActivity(intent_12);
                break;

            case R.id.btn_level_13:

                this.finish();
                Intent intent_13 = new Intent(this, Traning.class);
                intent_13.putExtra("level", 13);
                startActivity(intent_13);
                break;

            case R.id.btn_level_14:

                this.finish();
                Intent intent_14 = new Intent(this, Traning.class);
                intent_14.putExtra("level", 14);
                startActivity(intent_14);
                break;

            case R.id.btn_level_15:

                this.finish();
                Intent intent_15 = new Intent(this, Traning.class);
                intent_15.putExtra("level", 15);
                startActivity(intent_15);
                break;

            case R.id.btn_level_16:

                this.finish();
                Intent intent_16 = new Intent(this, Traning.class);
                intent_16.putExtra("level", 16);
                startActivity(intent_16);
                break;

            case R.id.btn_level_17:

                this.finish();
                Intent intent_17 = new Intent(this, Traning.class);
                intent_17.putExtra("level", 17);
                startActivity(intent_17);
                break;

            case R.id.btn_level_18:

                this.finish();
                Intent intent_18 = new Intent(this, Traning.class);
                intent_18.putExtra("level", 18);
                startActivity(intent_18);
                break;

            case R.id.btn_level_19:

                this.finish();
                Intent intent_19 = new Intent(this, Traning.class);
                intent_19.putExtra("level", 19);
                startActivity(intent_19);
                break;

            case R.id.btn_level_20:

                this.finish();
                Intent intent_20 = new Intent(this, Traning.class);
                intent_20.putExtra("level", 20);
                startActivity(intent_20);
                break;

            case R.id.btn_level_21:

                this.finish();
                Intent intent_21 = new Intent(this, Traning.class);
                intent_21.putExtra("level", 21);
                startActivity(intent_21);
                break;

            case R.id.btn_level_22:

                this.finish();
                Intent intent_22 = new Intent(this, Traning.class);
                intent_22.putExtra("level", 22);
                startActivity(intent_22);
                break;

            case R.id.btn_level_23:

                this.finish();
                Intent intent_23 = new Intent(this, Traning.class);
                intent_23.putExtra("level", 23);
                startActivity(intent_23);
                break;

            case R.id.btn_level_24:

                this.finish();
                Intent intent_24 = new Intent(this, Traning.class);
                intent_24.putExtra("level", 24);
                startActivity(intent_24);
                break;


            default:
                break;
        }


    }
}
