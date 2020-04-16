package com.lingvolern.View;        //Авторизация

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.lingvolern.Presenter.Controller;
import com.lingvolern.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText etext_Name;
    ImageButton ibtn_inputName;
    ImageButton ibtn_help;
    Controller controller;





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        controller = new Controller(this);

        etext_Name = (EditText) findViewById(R.id.EtxtEnterName);
        ibtn_inputName = (ImageButton) findViewById(R.id.ibtn_InputName);
        ibtn_inputName.setOnClickListener(this);
        ibtn_help = (ImageButton) findViewById(R.id.ibtn_HelpLog);
        ibtn_help.setOnClickListener(this);

        if(controller.checkUser())
        {
            this.finish();
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
        }


    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {

            case R.id.ibtn_InputName:

                String name =  etext_Name.getText().toString();

                if(name != "")
                {
                    controller.addUser(name);
                    controller.addWordsByLevel(1);
                    this.finish();
                    Intent intent = new Intent(this, Menu.class);
                    startActivity(intent);
                }

                break;


            case R.id.ibtn_HelpLog:

                Toast toast = Toast.makeText(this, "Для запуска приложения введите имя пользователя", Toast.LENGTH_LONG);
                toast.show();

                break;


            default:
                break;

        }
    }
}
