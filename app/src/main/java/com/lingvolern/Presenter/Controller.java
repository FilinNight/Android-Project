package com.lingvolern.Presenter;

import android.content.Context;
import com.lingvolern.Model.WorkDataBase;
import com.lingvolern.Presenter.Interface.IController;
import java.util.ArrayList;
import java.util.Random;

public class Controller implements IController
{

    WorkDataBase workDataBase;
    Context context;

    public Controller(Context context)
    {
        workDataBase = new WorkDataBase(context);
        this.context = context;

    }


    @Override
    public void wordProcessing(Word word, int key)     //взависимости от ответа пользователя изменяет и перезаписывает слово в TableUserWords
    {
        //key = 0 (неправильный ответ), key = 1 (правильный ответ)

        if(key == 0)
        {
            if(word.getNew() == 1)
            {
                word = this.changeRating(word);
                word.setNew(0);
                this.changeWord(word);
            }
            else
            {
                if(word.getWrongAttempty() >= 5)
                {
                    word.setWrongAttempty(5);
                    word = this.changeRating(word);
                    this.changeWord(word);
                }
                else
                {
                    int wrongAttempty = word.getWrongAttempty() + 1;
                    word.setWrongAttempty(wrongAttempty);
                    word = this.changeRating(word);
                    this.changeWord(word);
                }
            }
        }
        else if (key == 1)
        {
            if(word.getNew() == 1)
            {
                word.setNew(0);
                word.setCorrectAttempty(4);
                word = this.changeRating(word);
                this.changeWord(word);

            }
            else
            {
                int correctAttempty = word.getCorrectAttempty() + 1;
                word.setCorrectAttempty(correctAttempty);
                word = this.changeRating(word);
                this.changeWord(word);

            }
        }
        else
        {
            System.out.println("(wordProcessing) чет пошло не так.");
        }


    }

    @Override
    public Word randomWord(int level)   // вызывает рандомное (умный рандом) слово из списка UserWord  (на всякий случай перед применением бабахнуть проверку на null, иначе улечу дальше чем вижу.)
    {
        ArrayList<Word> listWords = this.getWordsByLevel(level);
        ArrayList<Word> listWordsRating1 = new ArrayList<Word>();
        ArrayList<Word> listWordsRating2 = new ArrayList<Word>();
        ArrayList<Word> listWordsRating3 = new ArrayList<Word>();
        ArrayList<Word> listWordsRating4 = new ArrayList<Word>();
        ArrayList<Word> listWordsRating5 = new ArrayList<Word>();


        for(Word wd : listWords)
        {
            if(wd.getRating() == 1 || wd.getRating() == 0)
            {
                listWordsRating1.add(wd);
            }
            else if(wd.getRating() == 2)
            {
                listWordsRating2.add(wd);
            }
            else if(wd.getRating() == 3)
            {
                listWordsRating3.add(wd);
            }
            else if(wd.getRating() == 4)
            {
                listWordsRating4.add(wd);
            }
            else if(wd.getRating() == 5)
            {
                listWordsRating5.add(wd);
            }
            else
            {
                System.out.println("Сортировка по рейтингу дала сбой.");
            }
        }


        System.out.println("ListWords : " + listWords.size());
        System.out.println("ListWordsRating 1 : " + listWordsRating1.size());
        System.out.println("ListWordsRating 2 : " + listWordsRating2.size());
        System.out.println("ListWordsRating 3 : " + listWordsRating3.size());
        System.out.println("ListWordsRating 4 : " + listWordsRating4.size());
        System.out.println("ListWordsRating 5 : " + listWordsRating5.size());

        Random random = new Random();
        int pracentRandom = random.nextInt(100);
        System.out.println(pracentRandom);

        if(pracentRandom <= 20)
        {
            if(listWordsRating1.size() != 0)
            {
                int rand = random.nextInt(listWordsRating1.size());
                return listWordsRating1.get(rand);
            }
            else if (listWordsRating2.size() != 0)
            {
                int rand = random.nextInt(listWordsRating2.size());
                return listWordsRating2.get(rand);
            }
            else if (listWordsRating3.size() != 0)
            {
                int rand = random.nextInt(listWordsRating3.size());
                return listWordsRating3.get(rand);
            }
            else if (listWordsRating4.size() != 0)
            {
                int rand = random.nextInt(listWordsRating4.size());
                return listWordsRating4.get(rand);
            }
            else if (listWordsRating5.size() != 0)
            {
                int rand = random.nextInt(listWordsRating5.size());
                return listWordsRating5.get(rand);
            }

        }
        else if (pracentRandom > 20 && pracentRandom <= 60)
        {
            if (listWordsRating2.size() != 0)
            {
                int rand = random.nextInt(listWordsRating2.size());
                return listWordsRating2.get(rand);
            }
            else if (listWordsRating1.size() != 0)
            {
                int rand = random.nextInt(listWordsRating1.size());
                return listWordsRating1.get(rand);
            }
            else if (listWordsRating3.size() != 0)
            {
                int rand = random.nextInt(listWordsRating3.size());
                return listWordsRating3.get(rand);
            }
            else if (listWordsRating4.size() != 0)
            {
                int rand = random.nextInt(listWordsRating4.size());
                return listWordsRating4.get(rand);
            }
            else if (listWordsRating5.size() != 0)
            {
                int rand = random.nextInt(listWordsRating5.size());
                return listWordsRating5.get(rand);
            }

        }
        else if (pracentRandom > 60 && pracentRandom <= 85)
        {
            if (listWordsRating3.size() != 0)
            {
                int rand = random.nextInt(listWordsRating3.size());
                return listWordsRating3.get(rand);
            }
            else if (listWordsRating2.size() != 0)
            {
                int rand = random.nextInt(listWordsRating2.size());
                return listWordsRating2.get(rand);
            }
            else if (listWordsRating1.size() != 0)
            {
                int rand = random.nextInt(listWordsRating1.size());
                return listWordsRating1.get(rand);
            }
            else if (listWordsRating4.size() != 0)
            {
                int rand = random.nextInt(listWordsRating4.size());
                return listWordsRating4.get(rand);
            }
            else if (listWordsRating5.size() != 0)
            {
                int rand = random.nextInt(listWordsRating5.size());
                return listWordsRating5.get(rand);
            }

        }

        else if (pracentRandom > 85 && pracentRandom <= 95)
        {
            if (listWordsRating4.size() != 0)
            {
                int rand = random.nextInt(listWordsRating4.size());
                return listWordsRating4.get(rand);
            }

            else if (listWordsRating3.size() != 0)
            {
                int rand = random.nextInt(listWordsRating3.size());
                return listWordsRating3.get(rand);
            }
            else if (listWordsRating2.size() != 0)
            {
                int rand = random.nextInt(listWordsRating2.size());
                return listWordsRating2.get(rand);
            }
            else if (listWordsRating1.size() != 0)
            {
                int rand = random.nextInt(listWordsRating1.size());
                return listWordsRating1.get(rand);
            }
            else if (listWordsRating5.size() != 0)
            {
                int rand = random.nextInt(listWordsRating5.size());
                return listWordsRating5.get(rand);
            }

        }

        else if (pracentRandom > 95 && pracentRandom <= 100)
        {
            if (listWordsRating5.size() != 0)
            {
                int rand = random.nextInt(listWordsRating5.size());
                return listWordsRating5.get(rand);
            }
            else if (listWordsRating4.size() != 0)
            {
                int rand = random.nextInt(listWordsRating4.size());
                return listWordsRating4.get(rand);
            }
            else if (listWordsRating3.size() != 0)
            {
                int rand = random.nextInt(listWordsRating3.size());
                return listWordsRating3.get(rand);
            }
            else if (listWordsRating2.size() != 0)
            {
                int rand = random.nextInt(listWordsRating2.size());
                return listWordsRating2.get(rand);
            }
            else if (listWordsRating1.size() != 0)
            {
                int rand = random.nextInt(listWordsRating1.size());
                return listWordsRating1.get(rand);
            }

        }
        else
        {
            System.out.println("Улетел и попал на NULL");
        }
        return null;
    }


    @Override
    public Word changeRating(Word word)     //изменить рейтинг слова
    {
        int correctAttempty = word.getCorrectAttempty();
        int wrongAttempty = word.getWrongAttempty();
        int New = word.getNew();

        int difference = correctAttempty - wrongAttempty;

        if(New == 0)
        {
            if(difference <= -5)
            {
                word.setRating(1);
                return word;
            }
            else if(difference > -5 && difference <= -3)
            {
                word.setRating(2);
                return word;
            }
            else if(difference >= -2 && difference <= 2)
            {
                word.setRating(3);
                return word;
            }
            else if(difference >= 3 && difference <= 4)
            {
                word.setRating(4);
                return word;
            }
            else if(difference >= 5)
            {
                word.setRating(5);
                return word;
            }
            else
            {
                System.out.println("(changeRating) хмм, а должно вроде работать...");
                return word;
            }

        }
        else
        {
            word.setNew(0);
            word.setRating(4);
            return word;
        }
    }


    @Override
    public void addWordsByLevel(int Level)         //Добавить все слова указанного уровня
    {
        ArrayList<Word> listWords = workDataBase.getPublicWordsLevel(Level);

        for(Word wd : listWords)
        {
            workDataBase.addWord(wd);
        }
    }


    @Override
    public int progress(int level)                  //прогресс прохождения уровня
    {
        ArrayList<Word> listWords = this.getWordsByLevel(level);
        int CountRating_1 = 0;
        int CountRating_2 = 0;
        int CountRating_3 = 0;
        int CountRating_4 = 0;
        int CountRating_5 = 0;

        double progress_1 = 0;
        double progress_2 = 0;
        double progress_3 = 0;
        double progress_4 = 0;
        double progress_5 = 0;



        int ItogProgress = 0;
        double allProgress = 0;
        int allSize = listWords.size();

//        for(Word wd : listWords)
//        {
//            System.out.println(wd.toString());
//        }


        for(Word wd : listWords)
        {
            if(wd.getRating() == 1 && wd.getRating() == 0)
            {
                CountRating_1++;
            }
            else if(wd.getRating() == 2)
            {
                CountRating_2++;
            }
            else if(wd.getRating() == 3)
            {
                CountRating_3++;
            }
            else if(wd.getRating() == 4)
            {
                CountRating_4++;
            }
            else if(wd.getRating() == 5)
            {
                CountRating_5++;
            }

        }

        double procentRating_1 = 0;
        double procentRating_2 = 25f / allSize ;
        double procentRating_3 = 50f / allSize ;
        double procentRating_4 = 75f / allSize ;
        double procentRating_5 = 100f / allSize ;


        progress_1 += CountRating_1 * procentRating_1;
        progress_2 += CountRating_2 * procentRating_2;
        progress_3 += CountRating_3 * procentRating_3;
        progress_4 += CountRating_4 * procentRating_4;
        progress_5 += CountRating_5 * procentRating_5;

        allProgress = progress_1 + progress_2 + progress_3 + progress_4 + progress_5;

        ItogProgress = (int) allProgress;

        return ItogProgress;
    }


    @Override
    public void addUser(String name)               //добавить нового пользователя
    {

        workDataBase.addUser(name);
    }


    @Override
    public ArrayList<Word> setListLearnedWords()       //Список выученных слов
    {
        ArrayList<Word> listWordsUser = new ArrayList<Word>();
        ArrayList<Word> listWords = new ArrayList<Word>();

        listWordsUser = workDataBase.getAllUserWords();

        for(Word wd : listWordsUser)
        {
            if(wd.getRating() >= 1)
            {
                listWords.add(wd);
            }
        }


        return listWords;
    }


    @Override
    public  User getUser()
{
    User user = new User();
    user.setLevel(this.getUserLevel());
    user.setName(this.getUserName());
    return user;
}

    @Override
    public  String getUserName()                    //показывает имя текущего пользователя
    {
        return workDataBase.getUserName();
    }


    @Override
    public int getUserLevel()                       //показывает уровень пользователя
    {
        return workDataBase.getUserLevel();
    }


    @Override
    public void setUserLevel(int level)             //изменяет уровень пользователя
    {
        String name = this.getUserName();
        workDataBase.setUserLevel(level, name);
    }

    @Override
    public ArrayList<Word> getWordsByLevel(int Level)      //отдает лист слов указанного уровня из UserWords
    {
        ArrayList<Word> listWords = new ArrayList<Word>();
        listWords = workDataBase.getUserWordsLevel(Level);

        System.out.println("getWordsByLevel : " + listWords.size());

        return listWords;
    }


    @Override
    public ArrayList<Word> getAllWords()                //показывает все слова
    {
        ArrayList<Word> listWords = new ArrayList<Word>();
        listWords = workDataBase.getAllUserWords();

        return listWords;
    }


    @Override
    public boolean wordComparison(String ruWord, Word word)     //сравнивает слово введеного пользователем с текущим
    {
        if(ruWord.equals(word.getEnWord()))
        {
            return true;
        }

        return false;
    }


    @Override
    public void changeWord(Word word)               //изменение слова
    {
        workDataBase.changeWord(word);
    }


    @Override
    public int countWords()                         //число слов из UserWords
    {
        return workDataBase.getCountUserWords();
    }


    @Override
    public int countLearnedWords()                  //число уже выученных слов
    {
        return workDataBase.getCountWordsLearned();
    }

    @Override
    public boolean checkUser()                  //проверяет есть ли User
    {
        int count = workDataBase.getCountUserName();

        if(count == 0)
        {
            System.out.println("User false");
            return false;
        }
        else
        {
            System.out.println("User true");
            return true;
        }
    }


    @Override
    public void deleteUser()                    //удаляет значения таблиц User, UserWords
    {
        workDataBase.deleteAll();
    }


}













