package ro.assist.interns.kickstartandroid.models;

/**
 * Created by sebi on 07.08.2015.
 * Question model to match the one from api. The members must have the same names as the one
 * from the backend api models
 */
public class Question {
    String question_text;
    String pub_date;

    public Question(String text, String pubDate) {
        this.question_text = text;
        this.pub_date = pubDate;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }
}
