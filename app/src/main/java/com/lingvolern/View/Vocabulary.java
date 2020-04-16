package com.lingvolern.View;        //Словарь пользователя

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.lingvolern.Presenter.Controller;
import com.lingvolern.Presenter.Word;
import com.lingvolern.R;

import java.util.ArrayList;

public class Vocabulary extends AppCompatActivity implements View.OnClickListener {


    ListView lv_words;
    Controller controller;
    ArrayList<Word> listWords;
    SearchView searchView;
    ArrayAdapter<String> adapter;
    ArrayList<String> txtListWords;

    ImageButton ibtn_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        controller = new Controller(this);

        ibtn_menu = (ImageButton) findViewById(R.id.ibtn_Menu);
        ibtn_menu.setOnClickListener(this);

        searchView = findViewById(R.id.searchView);
        lv_words = (ListView) findViewById(R.id.lvAllWords);
    }


    @Override
    protected void onResume()
    {
        super.onResume();

        listWords = controller.setListLearnedWords();
        txtListWords = new ArrayList<String>();
        final String[] EnWord = new String[listWords.size()];

        for(Word wd : listWords)
        {
            int i = 0;
            String txt = wd.getEnWord() + "\t\t\t" + wd.getRuWord() + "\t\t\t" + wd.getTranscription();
            txtListWords.add(txt);
            EnWord[i] = wd.getEnWord();
            i++;
        }


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, txtListWords);
        lv_words.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String text) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {

                adapter.getFilter().filter(text);

                return false;
            }
        });
    }





    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ibtn_Menu:
                this.finish();
                break;

        }

    }
}
