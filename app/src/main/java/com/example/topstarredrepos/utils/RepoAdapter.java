package com.example.topstarredrepos.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.topstarredrepos.R;
import com.example.topstarredrepos.main.models.Repo;

import java.util.List;

/**
 * Created by BouzalmatAbderrahman on 6/1/2019
 */
public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder>{

    private List<Repo> repos;
    private Context context;

    public  RepoAdapter(Context context, List<Repo> repo) {
        this.repos = repo;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_content, parent, false);

        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Repo repo = repos.get(position);

        holder.title.setText(repo.getTitle());
        holder.description.setText(repo.getDescription());
        holder.username.setText(repo.getUsername());
        holder.rating.setText(repo.getRating());


    }


    @Override
    public int getItemCount() {
        return repos.size();
    }

    public void addRepos(List<Repo> reposList){
        this.repos.addAll(reposList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title, description, username, rating;
        public ImageView avatar;

        ViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);
            username = (TextView) view.findViewById(R.id.username);
            rating = (TextView) view.findViewById(R.id.rating);
            avatar = (ImageView) view.findViewById(R.id.avatar);

        }
    }
}

