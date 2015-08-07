package ro.assist.interns.kickstartandroid.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import ro.assist.interns.kickstartandroid.R;
import ro.assist.interns.kickstartandroid.models.Question;

/**
 * Created by sebi on 07.08.2015.
 * Custom ArrayAdapter to use in a ListView for displaying the Question Objects
 */
public class QuestionListAdapter extends ArrayAdapter<Question> {

    private final Context mContext;
    private final Question[] questions;
    private final int rowlayout;

    public QuestionListAdapter(Context context, int resource, Question[] objects) {
        super(context, resource, objects);
        mContext = context;
        questions = objects;
        rowlayout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(rowlayout, parent, false);
        TextView questionText = (TextView) rowView.findViewById(R.id.questionText);
        TextView pubDate = (TextView) rowView.findViewById(R.id.pubDate);

        questionText.setText(questions[position].getQuestion_text());
        pubDate.setText(questions[position].getPub_date());
        return rowView;
    }
}
