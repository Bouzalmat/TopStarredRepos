package com.example.topstarredrepos.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.topstarredrepos.R;
import com.example.topstarredrepos.main.interfaces.ModelInterface;
import com.example.topstarredrepos.main.interfaces.ViewInterface;
import com.example.topstarredrepos.main.models.Repo;
import com.example.topstarredrepos.utils.RepoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewInterface {

    RepoAdapter adapter;
    RecyclerView reposList;
    ArrayList<Repo> repos;
    Presenter presenter;
    ViewInterface view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = new ViewInterface() {
            @Override
            public void updateRepos(List<Repo> reposList) {
                adapter.addRepos(reposList);

            }
        };
        repos = new ArrayList<Repo>();
        presenter = new Presenter(repos, view, this);
        adapter = new RepoAdapter(this,repos);
        presenter.getRepos();
        reposList = (RecyclerView)findViewById(R.id.repos_list);
        reposList.setLayoutManager(new LinearLayoutManager(this));
        reposList.setAdapter(adapter);




    }


    @Override
    public void updateRepos(List<Repo> reposList) {
        adapter.addRepos(reposList);
    }
}
