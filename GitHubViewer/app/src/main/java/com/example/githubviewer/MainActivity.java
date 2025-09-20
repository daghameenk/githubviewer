package com.example.githubviewer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView userNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameTextView = findViewById(R.id.textViewUserName);

        // Create a Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of the API service
        GitHubApiService service = retrofit.create(GitHubApiService.class);

        // Make the API call
        Call<GitHubUser> call = service.getUser("octocat");
        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                if (response.isSuccessful()) {
                    GitHubUser user = response.body();
                    if (user != null) {
                        String userInfo = "Name: " + user.getName() + "\nLogin: " + user.getLogin() + "\nFollowers: " + user.getFollowers();
                        userNameTextView.setText(userInfo);
                    }
                } else {
                    userNameTextView.setText("API call failed: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {
                userNameTextView.setText("Error: " + t.getMessage());
            }
        });
    }
}