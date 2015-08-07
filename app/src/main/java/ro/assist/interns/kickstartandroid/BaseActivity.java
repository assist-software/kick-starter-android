package ro.assist.interns.kickstartandroid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import retrofit.RestAdapter;

/**
 * Created by sebi on 07.08.2015.
 * BaseActivity that all activities must extend in order to have access to the pollsApi service
 */
public class BaseActivity extends ActionBarActivity {

    //edit this one to match the server url
    public static final String serverURL = "http://192.168.100.184:8001/";
    protected PollsApi pollsApi;

    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(serverURL)
                .build();
        pollsApi = restAdapter.create(PollsApi.class);
    }

    protected void showLoadingDialog(String msg) {
        if(progressDialog != null)
            progressDialog.hide();
        progressDialog = ProgressDialog.show(this, "", msg);
    }

    protected void hideLoadingDialog() {
        if(progressDialog != null)
            progressDialog.hide();
        progressDialog = null;
    }

}
