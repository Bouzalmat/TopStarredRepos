package com.example.topstarredrepos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.topstarredrepos.main.models.Repo;
import com.example.topstarredrepos.utils.RepoAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RepoAdapter adapter;
    RecyclerView reposList;
    ArrayList<Repo> repos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repos = new ArrayList<Repo>();
        repos = generateData();
        adapter = new RepoAdapter(this,repos);
        reposList = (RecyclerView)findViewById(R.id.repos_list);
        reposList.setLayoutManager(new LinearLayoutManager(this));
        reposList.setAdapter(adapter);




    }





    public ArrayList<Repo> generateData (){
        ArrayList<Repo> data = new ArrayList<Repo>();
        Repo repo;
        for(int i = 0; i<100; i++){
            repo = new Repo("titre"+i,"arcana","decription" +i,"200");
            data.add(repo);
        }

        return data;
    }
}
