package com.lingvolern.Presenter.Interface;

import com.lingvolern.Presenter.User;
import com.lingvolern.Presenter.Word;

import java.util.ArrayList;


public interface IController
{
    Word randomWord(int level);
    void addWordsByLevel(int level);
    void addUser(String name);
    void wordProcessing(Word word, int key);
    User getUser();
    String getUserName();
    ArrayList<Word> setListLearnedWords();
    int getUserLevel();
    void setUserLevel(int level);
    int progress(int level);
    Word changeRating(Word word);
    ArrayList<Word> getWordsByLevel(int level);
    ArrayList<Word> getAllWords();
    boolean wordComparison(String ruWord, Word word);
    void changeWord(Word word);
    int countWords();
    int countLearnedWords();
    boolean checkUser();
    void deleteUser();

}
