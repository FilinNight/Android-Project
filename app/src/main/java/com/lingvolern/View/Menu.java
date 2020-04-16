package com.lingvolern.View;        //Ну, очень корявенько вышло, но это меню приложения

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.lingvolern.Presenter.Controller;
import com.lingvolern.R;
import java.util.ArrayList;



public class Menu extends AppCompatActivity implements View.OnClickListener {

    private Button btn_traning;
    private Button btn_vocabulary;
    private Button btn_transcript;
    private Button btn_basics;
    private ImageButton ibtn_help;
    private TextView txt_UserName;
    private TextView txt_NumberLearnedWords;
    Controller controller;

    ArrayList<String> listSetting;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        controller = new Controller(this);

        listSetting = new ArrayList<String>();
        listSetting.add("Удалить пользователя");
        listSetting.add("Настройки");

        txt_UserName = (TextView) findViewById(R.id.txt_userName);
        txt_UserName.setText(controller.getUserName());

        txt_NumberLearnedWords = (TextView) findViewById(R.id.txtNumberLearnedWords);
        txt_NumberLearnedWords.setText( String.valueOf(controller.countLearnedWords()));

        ibtn_help = (ImageButton) findViewById(R.id.imageButton_Help);
        ibtn_help.setOnClickListener(this);

        btn_basics = (Button) findViewById(R.id.btnBasics);
        btn_basics.setOnClickListener(this);

        btn_traning = (Button) findViewById(R.id.btnStart);
        btn_traning.setOnClickListener(this);

        btn_vocabulary = (Button) findViewById(R.id.btnVocabulary);
        btn_vocabulary.setOnClickListener(this);

        btn_transcript = (Button) findViewById(R.id.btnTranscript);
        btn_transcript.setOnClickListener(this);

        spinner = (Spinner) findViewById(R.id.spiner_settings);

    }


    @Override
    protected void onResume()
    {
        super.onResume();
        txt_NumberLearnedWords.setText(String.valueOf(controller.countLearnedWords()));

    }

    @Override                                               //в целом тут вся логика Spinner и кнопки "Удалить пользователя"
    public void onStart() {
        super.onStart();

        final int listsize = listSetting.size() - 1;
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listSetting) {
            @Override
            public int getCount() {
                return(listsize); // Truncate the list
            }
        };

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner.setSelection(listsize);

        OnItemSelectedListener itemSelectedListener = new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                if(position == 0)
                {
                    spinner.setSelection(listsize);
                    showDialog(Menu.this);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        spinner.setOnItemSelectedListener(itemSelectedListener);

    }



    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnStart :
                Intent intentStart = new Intent(this, Level.class);
                startActivity(intentStart);
                break;

            case R.id.btnBasics :
                Intent intentBasics = new Intent(this, Basics.class);
                startActivity(intentBasics);
                break;

            case R.id.btnVocabulary :
                Intent intentVocabulary = new Intent(this, Vocabulary.class);
                startActivity(intentVocabulary);
                break;

            case R.id.btnTranscript :
                Intent intentTranscript = new Intent(this, Transcript.class);
                startActivity(intentTranscript);
                break;


            case R.id.imageButton_Help :
                Intent intentHelp = new Intent(this, Help.class);
                startActivity(intentHelp);
                break;

            default:
                break;
        }
    }


    public void showDialog(Context context) {


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle("Подтвердите действие");
        builder.setMessage("Вы действительно хотите удалить пользователя и всю информацию о нем?");

        builder.setPositiveButton("Да",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        delUser();
                    }
                });

        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }               //Диалоговое окно

    public void delUser()
    {
        Toast.makeText(Menu.this,"Пользователь удален", Toast.LENGTH_SHORT).show();
        controller.deleteUser();
        this.finish();
        Intent intentLogin = new Intent(this, Login.class);
        startActivity(intentLogin);
    }

}

