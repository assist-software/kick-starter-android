package ro.assist.interns.kickstartandroid;

import java.util.List;

import retrofit.http.GET;
import ro.assist.interns.kickstartandroid.models.Question;

/**
 * Created by sebi on 07.08.2015.
 */


public interface PollsApi {
    @GET("/api/questions/")
    List<Question> listQuestions();
}
