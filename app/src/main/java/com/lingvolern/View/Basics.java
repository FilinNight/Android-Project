package com.lingvolern.View;        //Класс содержащий в себе Button Артикли, Местоимения, Предлоги, Таблицы времен, и основные предложения

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.lingvolern.R;
import com.lingvolern.View.basics.Articles;
import com.lingvolern.View.basics.BasicsSuggestions;
import com.lingvolern.View.basics.Prepositions;
import com.lingvolern.View.basics.Pronoun;
import com.lingvolern.View.basics.TableTimes;

public class Basics extends AppCompatActivity implements View.OnClickListener {

    ImageButton ibtn_menu;
    Button btn_articles;
    Button btn_pronouns;
    Button btn_prepositions;
    Button btn_tableTimes;
    Button btn_basicsSuggestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics);

        ibtn_menu = (ImageButton) findViewById(R.id.ibtn_Menu);
        ibtn_menu.setOnClickListener(this);

        btn_articles = (Button) findViewById(R.id.btnArticles);
        btn_articles.setOnClickListener(this);

        btn_pronouns = (Button) findViewById(R.id.btnPronouns);
        btn_pronouns.setOnClickListener(this);

        btn_prepositions = (Button) findViewById(R.id.btnPrepositions);
        btn_prepositions.setOnClickListener(this);

        btn_tableTimes = (Button) findViewById(R.id.btnTableTimes);
        btn_tableTimes.setOnClickListener(this);

        btn_basicsSuggestion = (Button) findViewById(R.id.btnBasicsSuggestions);
        btn_basicsSuggestion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ibtn_Menu:
                this.finish();
                break;

            case R.id.btnArticles:
                this.finish();
                Intent intentArticles = new Intent(this, Articles.class);
                startActivity(intentArticles);
                break;

            case R.id.btnPronouns:
                this.finish();
                Intent intentPronouns = new Intent(this, Pronoun.class);
                startActivity(intentPronouns);
                break;

            case R.id.btnPrepositions:
                this.finish();
                Intent intentPrepositionss = new Intent(this, Prepositions.class);
                startActivity(intentPrepositionss);
                break;

            case R.id.btnTableTimes:
                this.finish();
                Intent intentTableTimes = new Intent(this, TableTimes.class);
                startActivity(intentTableTimes);
                break;

            case R.id.btnBasicsSuggestions:
                this.finish();
                Intent intentBasicsSuggestions = new Intent(this, BasicsSuggestions.class);
                startActivity(intentBasicsSuggestions);
                break;


            default:
                break;


        }

    }
}
