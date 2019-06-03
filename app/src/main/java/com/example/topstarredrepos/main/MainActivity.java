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
    @Inject Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDaggerComponent();
        initComponents();
        configureReposList();
    }

    public void initComponents(){
        reposList = (RecyclerView)findViewById(R.id.repos_list);
        repos = new ArrayList<Repo>();
        adapter = new RepoAdapter(this,repos);
        presenter.getRepos();

    }

    public void configureReposList(){
        reposList.setLayoutManager(new LinearLayoutManager(this));
        //Set the Repos Adapter for the list
        reposList.setAdapter(adapter);
    }

    public void initDaggerComponent(){
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .contextModule(new ContextModule(this))
                .build()
                .inject(this);
    }


    @Override
    public void updateRepos(List<Repo> reposList) {
        adapter.addRepos(reposList);
    }
}
