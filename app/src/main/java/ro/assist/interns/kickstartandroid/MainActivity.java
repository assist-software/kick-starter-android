package ro.assist.interns.kickstartandroid;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ro.assist.interns.kickstartandroid.models.Question;
import ro.assist.interns.kickstartandroid.ui.QuestionListAdapter;


public class MainActivity extends BaseActivity {

    private ListView questionsListView;
    private QuestionListAdapter arrayAdapter;

    private Question[] questions = new Question[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionsListView = (ListView) findViewById(R.id.questionsListView);
        arrayAdapter = new QuestionListAdapter(this, R.layout.question_list_item, questions);
        questionsListView.setAdapter(arrayAdapter);

        //start AsyncTask to fetch the questions from api
        new GetQuestionsTask(this).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Updates the arrayAdapter (populates the listview with question items received from api
     * @param questions Question objects received from api
     */
    private void displayQuestions(List<Question> questions) {
        this.questions = questions.toArray(new Question[questions.size()]);
        arrayAdapter = new QuestionListAdapter(this, R.layout.question_list_item, this.questions);
        questionsListView.setAdapter(arrayAdapter);
    }

    class GetQuestionsTask extends AsyncTask<Void, Void, List<Question>> {
        Context mContext;

        GetQuestionsTask(Context context) {
            mContext = context;
        }

        @Override
        protected void onPreExecute() {
            ((MainActivity)mContext).showLoadingDialog("Fetching questions");
        }

        @Override
        protected List<Question> doInBackground(Void... params) {
            //Call the api.
            List<Question> questions = pollsApi.listQuestions();
            return questions;
        }

        @Override
        protected void onPostExecute(List<Question> questions) {
            ((MainActivity)mContext).hideLoadingDialog();
            ((MainActivity)mContext).displayQuestions(questions);
        }
    }
}
