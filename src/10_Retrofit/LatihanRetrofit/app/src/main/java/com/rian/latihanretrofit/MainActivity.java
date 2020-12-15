package com.rian.latihanretrofit;

import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import com.rian.latihanretrofit.databinding.ActivityMainBinding;
import com.rian.latihanretrofit.models.Repo;
import com.rian.latihanretrofit.services.GithubService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private GithubService service;
    private AlertDialog.Builder errorDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(GithubService.class);
    }

    public void cariUser(View view) {
        String username = binding.userEdit.getText().toString();
        binding.loadingBar.setVisibility(View.VISIBLE);

        Call<List<Repo>> repos = service.listRepos(username);

        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                Repo repo = response.body().get(0);
                binding.setRepo(repo);
                binding.loadingBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                errorDialog = new AlertDialog.Builder(MainActivity.this);
                errorDialog.setTitle("Gagal").setMessage(t.getMessage());

                errorDialog.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = errorDialog.create();
                alertDialog.show();
            }
        });

    }
}