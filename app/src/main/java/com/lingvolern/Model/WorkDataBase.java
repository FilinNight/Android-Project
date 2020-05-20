package com.lingvolern.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.lingvolern.Model.Interface.IWorkDataBase;
import com.lingvolern.Presenter.Word;

import java.io.IOException;
import java.util.ArrayList;



public class WorkDataBase implements IWorkDataBase {


    private DataBaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    public WorkDataBase(Context context) {
        mDBHelper = new DataBaseHelper(context);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }


    }

    @Override
    public void addWord(Word word) {
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        ContentValues values = new ContentValues();
        values.put("EnWord", word.getEnWord());
        values.put("RuWord", word.getRuWord());
        values.put("Transcription", word.getTranscription());
        values.put("New", word.getNew());
        values.put("Level", word.getLevel());
        values.put("CorrectAttempty", word.getCorrectAttempty());
        values.put("WrongAttempty", word.getWrongAttempty());
        values.put("Rating", word.getRating());

        System.out.println("Add word: " + word.toString());
        System.out.println("Put word: " + values.toString());

        mDb.insert("TableUserWords", null, values);
        mDb.close();
    }

    @Override
    public void addUser(String name)
    {
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("Level", 1);


        mDb.insert("TableUser", null, values);
        mDb.close();
    }

    @Override
    public String getUserName()
    {
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
       String name = "";

        Cursor cursor = mDb.rawQuery("SELECT Name FROM TableUser", null);
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            name = cursor.getString(0);

            mDb.close();
            cursor.close();

            return name;
        }

        mDb.close();
        cursor.close();

        return name;
    }

    @Override
    public int getUserLevel()
    {
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        int level;

        Cursor cursor = mDb.rawQuery("SELECT Level FROM TableUser", null);
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            level = cursor.getInt(0);

            mDb.close();
            cursor.close();

            return level;
        }

        mDb.close();
        cursor.close();

        return 0;
    }

    @Override
    public void setUserLevel(int level, String name)
    {
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        ContentValues values = new ContentValues();
        values.put("Level", level);
;

        mDb.update("TableUser", values, "Name" + "=?", new String[]{String.valueOf(name)});
        mDb.close();
    }

    @Override
    public Word getUserWord(int id) {
        //"DELETE FROM Products WHERE id = ?"
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        String ID = String.valueOf(id);
        Word word;

        Cursor cursor = mDb.rawQuery("SELECT _id, EnWord, RuWord, Transcription, Level FROM TableWords WHERE _id = " + ID, null);

        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            word = new Word(cursor.getString(1), cursor.getString(2), cursor.getString(3), 1, cursor.getInt(4), 0, 0, 0);
            cursor.close();

            return word;
        }
        mDb.close();
        cursor.close();

        return null;
    }

    @Override
    public ArrayList<Word> getAllPublicWords() {

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        ArrayList<Word> listWords = new ArrayList<Word>();

        Cursor cursor = mDb.rawQuery("SELECT _id, EnWord, RuWord, Transcription, Level FROM TableWords", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            listWords.add(new Word(cursor.getString(1), cursor.getString(2), cursor.getString(3), 1, cursor.getInt(4), 0, 0, 0));
            cursor.moveToNext();
        }
        cursor.close();
        mDb.close();

        return listWords;
    }

    @Override
    public ArrayList<Word> getAllUserWords() {

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        ArrayList<Word> listWords = new ArrayList<Word>();

        Cursor cursor = mDb.rawQuery("SELECT _id, EnWord, RuWord, Transcription, New, Level, CorrectAttempty, WrongAttempty, Rating FROM TableUserWords", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            listWords.add(new Word(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getInt(5), cursor.getInt(6), cursor.getInt(7), cursor.getInt(8)));
            cursor.moveToNext();
        }
        cursor.close();
        mDb.close();


        return listWords;

    }

    @Override
    public ArrayList<Word> getUserWordsLevel(int Level) {
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        ArrayList<Word> listWords = new ArrayList<Word>();


        Cursor cursor = mDb.rawQuery("SELECT _id, EnWord, RuWord, Transcription, New, Level, CorrectAttempty, WrongAttempty, Rating FROM TableUserWords WHERE Level = " + Level, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            listWords.add(new Word(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getInt(5), cursor.getInt(6), cursor.getInt(7), cursor.getInt(8)));

            cursor.moveToNext();
        }
        cursor.close();
        mDb.close();


        return listWords;
    }

    @Override
    public ArrayList<Word> getPublicWordsLevel(int Level) {
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        ArrayList<Word> listWords = new ArrayList<Word>();


        Cursor cursor = mDb.rawQuery("SELECT _id, EnWord, RuWord, Transcription, Level FROM TableWords WHERE Level = " + Level, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            listWords.add(new Word(cursor.getString(1), cursor.getString(2), cursor.getString(3), 1, cursor.getInt(4), 0, 0, 0));

            cursor.moveToNext();
        }
        cursor.close();
        mDb.close();


        return listWords;
    }

    @Override
    public int getCountPublicWords() {

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }


        String countQuery = "SELECT * FROM TableWords";
        Cursor cursor = mDb.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        mDb.close();
        return count;
    }

    @Override
    public int getCountUserWords() {
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }


        String countQuery = "SELECT * FROM TableUserWords";
        Cursor cursor = mDb.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        mDb.close();
        return count;
    }

    @Override
    public int getCountWordsLearned()
    {

        int count_4 = 0;
        int count_5 = 0;

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }



        String countQuery_4 = "SELECT * FROM TableUserWords WHERE Rating = 4";
        Cursor cursor_4 = mDb.rawQuery(countQuery_4, null);
        count_4 = cursor_4.getCount();
        cursor_4.close();

        String countQuery_5 = "SELECT * FROM TableUserWords WHERE Rating = 5";
        Cursor cursor_5 = mDb.rawQuery(countQuery_5, null);
        count_5 = cursor_5.getCount();
        cursor_5.close();

        mDb.close();

        int count = count_4 + count_5;

        return count;
    }

    @Override
    public int getCountUserName()
    {
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }


        String countQuery = "SELECT * FROM TableUser";
        Cursor cursor = mDb.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        mDb.close();
        return count;
    }

    @Override
    public void changeWord(Word word)
    {
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        ContentValues values = new ContentValues();
        values.put("EnWord", word.getEnWord());
        values.put("RuWord", word.getRuWord());
        values.put("Transcription", word.getTranscription());
        values.put("New", word.getNew());
        values.put("Level", word.getLevel());
        values.put("CorrectAttempty", word.getCorrectAttempty());
        values.put("WrongAttempty", word.getWrongAttempty());
        values.put("Rating", word.getRating());

        mDb.update("TableUserWords", values, "EnWord = ?", new String[]{word.getEnWord()});
        mDb.close();
    }

    @Override
    public void deleteWord(Word word)
    {
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        mDb.delete("TableUserWords" , "EnWord = ?", new String[]{word.getEnWord()});
        mDb.close();


    }

    @Override
    public void deleteAll() {
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        mDb.delete("TableUserWords", null, null);
        mDb.delete("TableUser", null, null);
        mDb.close();
    }

}
