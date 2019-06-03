package com.example.topstarredrepos.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.topstarredrepos.R;
import com.example.topstarredrepos.main.components.DaggerMainComponent;
import com.example.topstarredrepos.main.interfaces.ViewInterface;
import com.example.topstarredrepos.main.models.Repo;
import com.example.topstarredrepos.main.modules.ContextModule;
import com.example.topstarredrepos.main.modules.MainModule;
import com.example.topstarredrepos.utils.RepoAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ViewInterface {

    RepoAdapter adapter;
    RecyclerView reposList;
    ArrayList<Repo> repos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        repos = new ArrayList<Repo>();
        adapter = new RepoAdapter(this,repos);
        
        reposList = (RecyclerView)findViewById(R.id.repos_list);
        reposList.setLayoutManager(new LinearLayoutManager(this));
        reposList.setAdapter(adapter);




    }


    @Override
    public void updateRepos(List<Repo> reposList) {
        adapter.addRepos(reposList);
    }
}
