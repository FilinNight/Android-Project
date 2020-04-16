package com.lingvolern.Model.Interface;

import com.lingvolern.Presenter.Word;

import java.util.ArrayList;

public interface IWorkDataBase
{
    void addWord(Word word);
    void addUser(String name);
    void changeWord(Word word);
    void deleteWord(Word word);
    void deleteAll();
    Word getUserWord(int id);
    String getUserName();
    int getUserLevel();
    void setUserLevel(int level, String name);
    ArrayList<Word> getAllPublicWords();
    ArrayList<Word> getAllUserWords();
    ArrayList<Word> getUserWordsLevel(int Level);
    ArrayList<Word> getPublicWordsLevel(int Level);
    int getCountUserName();
    int getCountPublicWords();
    int getCountUserWords();
    int getCountWordsLearned();

}
