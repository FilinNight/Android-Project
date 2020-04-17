package com.lingvolern.View;        //Основной класс для изучения английских слов.

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.lingvolern.Presenter.Controller;
import com.lingvolern.Presenter.User;
import com.lingvolern.Presenter.Word;
import com.lingvolern.R;

public class Traning extends AppCompatActivity implements View.OnClickListener {


    ImageButton ibtn_menu;
    ImageButton ibtn_input;
    Button btn_show;
    EditText etxt_EntryField;
    TextView txt_EnWord;
    TextView txt_Transcript;
    TextView txt_ProcentProgress;
    Controller controller;

    Bundle arguments;
    Word word;
    User user;
    int level;
    int progress;
    boolean checkShow = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traning);
        controller = new Controller(this);

        user = controller.getUser();
        arguments = getIntent().getExtras();
        level = arguments.getInt("level");

        ibtn_menu = (ImageButton) findViewById(R.id.ibtn_Menu);
        ibtn_menu.setOnClickListener(this);

        ibtn_input = (ImageButton) findViewById(R.id.ibtn_Input);
        ibtn_input.setOnClickListener(this);

        btn_show = (Button) findViewById(R.id.btn_Show);
        btn_show.setOnClickListener(this);

        etxt_EntryField = (EditText) findViewById(R.id.EditTextEntryField);
        txt_EnWord = (TextView) findViewById(R.id.textEnWord);
        txt_Transcript = (TextView) findViewById(R.id.textTranscript);
        txt_ProcentProgress = (TextView) findViewById(R.id.txtProcentProgress);

        progress = controller.progress(level);
        txt_ProcentProgress.setText(String.valueOf(progress));
        word = controller.randomWord(level);
        txt_EnWord.setText(word.getEnWord());
        txt_Transcript.setText(word.getTranscription());

        System.out.println(word.toString());


    }

    @Override
    public void onClick(View v)
    {

        switch (v.getId()) {


            case R.id.ibtn_Menu:
                this.finish();
                break;

            case R.id.ibtn_Input:

                if(progress >= 75 && level == user.getLevel())
                {
                    int lvl = user.getLevel();
                    lvl++;
                    controller.setUserLevel(lvl);
                    controller.addWordsByLevel(lvl);
                }

                etxt_EntryField.setHint("");

                String enterWord = etxt_EntryField.getText().toString();
                enterWord = enterWord.toLowerCase();
                enterWord = enterWord.trim();

                String currentWord = word.getRuWord();
                currentWord = currentWord.toLowerCase();
                currentWord = currentWord.trim();

                if(!enterWord.equals(""))
                {
                    if(!checkShow)
                    {
                        if(currentWord.equals(enterWord))
                        {
                            controller.wordProcessing(word, 1);

                            etxt_EntryField.setText("");
                            word = null;
                            word = controller.randomWord(level);
                            txt_EnWord.setText(word.getEnWord());
                            txt_Transcript.setText(word.getTranscription());
                            progress = controller.progress(level);
                            txt_ProcentProgress.setText(String.valueOf(progress));
                        }
                        else
                        {
                            controller.wordProcessing(word, 0);

                            etxt_EntryField.setText("");
                            etxt_EntryField.setHint(word.getRuWord());
                            progress = controller.progress(level);
                            txt_ProcentProgress.setText(String.valueOf(progress));
                        }
                    }
                    else
                    {
                        if(currentWord.equals(enterWord))
                        {
                            word = null;
                            word = controller.randomWord(level);
                            txt_EnWord.setText(word.getEnWord());
                            txt_Transcript.setText(word.getTranscription());
                            etxt_EntryField.setText("");
                            checkShow = false;

                        }
                        else
                        {
                            etxt_EntryField.setText("");
                            etxt_EntryField.setHint(word.getRuWord());
                        }
                    }

                    System.out.println(word.toString());

                }
                else
                {
                    etxt_EntryField.setText("");
                    etxt_EntryField.setHint(word.getRuWord());
                }

                break;

            case R.id.btn_Show:

                etxt_EntryField.setText("");
                etxt_EntryField.setHint(word.getRuWord());
                checkShow = true;

                break;


            default:
                break;
        }

    }
}
