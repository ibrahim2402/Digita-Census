package com.rihat.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonParser;
import com.rihat.retrofitapp.models.Comment;
import com.rihat.retrofitapp.models.Person;
import com.rihat.retrofitapp.models.Post;
import com.rihat.retrofitapp.models.ResponseData;
import com.rihat.retrofitapp.reastInterface.JsonPlaceHolder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText useremail;
    private EditText userPass;
    private Button login;

    private String userName;
    private String password;

    private JsonPlaceHolder jsonPlaceHolder;
    private String baseURL = "'https://api.covid19api.com/'";
    private String baseURL1 = "https://jsonplaceholder.typicode.com/";
    private String BaseURLIBRA = "https://census-api-hnxpvzwhbq-uc.a.run.app/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        useremail = findViewById(R.id.login_email_text);
        userPass = findViewById(R.id.login_password_text);
        login = findViewById(R.id.loginButton);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURLIBRA)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = useremail.getText().toString();
                password = userPass.getText().toString();
                // TODO get request to login url.
                /**
                 * IF RESPONSSE WITH USER DTA
                 * GO TO another activity and display it there.
                 * else give a chance try again
                 */

            }
        });

        //getPosts();
        //getComments();
        getPersonalDtaa();
        //createPost();
    }

    private void getPosts() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("userId", "1");
        parameters.put("_sort", "id");
        parameters.put("_order", "desc");

        //Call<List<Post>> call = jsonPlaceHolder.getPosts(new Integer[]{2,3,4},null,null);
        Call<List<Post>> call = jsonPlaceHolder.getPosts("posts");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Body: " + post.getText() + "\n\n";
                    //textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
               // textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getComments() {
        Call<List<Comment>> call = jsonPlaceHolder.getComments("posts/3/comments");
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Comment> comments = response.body();
                for (Comment comment : comments) {
                    String content = "";
                    content += "ID: " + comment.getId() + "\n";
                    content += "Post ID: " + comment.getPostId() + "\n";
                    content += "Name: " + comment.getName() + "\n";
                    content += "Email: " + comment.getEmail() + "\n";
                    content += "Body: " + comment.getText() + "\n\n";
                    //textViewResult.append(content);

                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                //textViewResult.setText(t.getMessage());
            }
        });
    }

    /**
     * To get personal data
     */
    private void getPersonalDtaa() {
        Call<Map<String, Person>> call = jsonPlaceHolder.getpersonalData(1);
        call.enqueue(new Callback<Map<String, Person>>() {
            @Override
            public void onResponse(Call<Map<String, Person>> call, Response<Map<String, Person>> response) {
                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }

                Map<String, Person> po = response.body();
                Person p = po.get("person");

                String content = "";
                content += "ID: " + p.getId() + "\n";
                content += "Name: " + p.getFullname() + "\n";
                content += "Address: " + p.getAddress() + "\n";
                content += "age: " + p.getAge() + "\n";
                content += "gender: " + p.getGender() + "\n";
                content += "ssn: " + p.getSsn() + "\n\n";
                //textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<Map<String, Person>> call, Throwable t) {
                //textViewResult.setText(t.getMessage());
            }
        });
    }


    private void createPost() {
        Post post = new Post(23, "New Title", "New Text");
        Call<Post> call = jsonPlaceHolder.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    //textViewResult.setText("Code: " + response.code());
                    return;
                }

                Post postresponse = response.body();
                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postresponse.getId() + "\n";
                content += "User ID: " + postresponse.getUserId() + "\n";
                content += "Title: " + postresponse.getTitle() + "\n";
                content += "Body: " + postresponse.getText() + "\n\n";
                //textViewResult.setText(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}
