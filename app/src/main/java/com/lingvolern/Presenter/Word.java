package com.lingvolern.Presenter;

public class Word
{
    int id;
    String EnWord;
    String RuWord;
    String Transcription;
    int New;
    int Level;
    int CorrectAttempty;
    int WrongAttempty;
    int Rating;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnWord() {
        return EnWord;
    }

    public void setEnWord(String enWord) {
        EnWord = enWord;
    }

    public String getRuWord() {
        return RuWord;
    }

    public void setRuWord(String ruWord) {
        RuWord = ruWord;
    }

    public String getTranscription() {
        return Transcription;
    }

    public void setTranscription(String transcription) {
        Transcription = transcription;
    }

    public int getNew() {
        return New;
    }

    public void setNew(int aNew) {
        New = aNew;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getCorrectAttempty() {
        return CorrectAttempty;
    }

    public void setCorrectAttempty(int correctAttempty) {
        CorrectAttempty = correctAttempty;
    }

    public int getWrongAttempty() {
        return WrongAttempty;
    }

    public void setWrongAttempty(int wrongAttempty) {
        WrongAttempty = wrongAttempty;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }








    public Word(String EnWord, String RuWord, String Transcription, int New, int Level, int CorrectAttempty, int WrongAttempty, int Rating)
    {
        this.EnWord = EnWord;
        this.RuWord = RuWord;
        this.Transcription = Transcription;
        this.New = New;
        this.Level = Level;
        this.CorrectAttempty = CorrectAttempty;
        this.WrongAttempty = WrongAttempty;
        this.Rating = Rating;
    }

//    public Word(String EnWord, String RuWord, String Transcription)
//    {
//        this.EnWord = EnWord;
//        this.RuWord = RuWord;
//        this.Transcription = Transcription;
//        this.New = 1;
//        this.Level = 1;
//        this.CorrectAttempty = 0;
//        this.WrongAttempty = 0;
//        this.Rating = 1;
//    }



//    public Word()
//    {
//        this.EnWord = "None";
//        this.RuWord = "None";
//        this.Transcription = "None";
//        this.New = 1;
//        this.Level = 1;
//        this.CorrectAttempty = 0;
//        this.WrongAttempty = 0;
//        this.Rating = 1;
//    }


    @Override
    public String toString() {
        return
                "EnWord - " + EnWord +
                ", RuWord - " + RuWord +
                ", Transcription - " + Transcription +
                ", New - " + New +
                ", Level - " + Level +
                ", CorrectAttempty - " + CorrectAttempty +
                ", WrongAttempty - " + WrongAttempty +
                ", Reiting - " + Rating;

    }
}
