package com.example.flixters.adapter;


import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixters.R;
import com.example.flixters.models.Movie;

import java.util.List;

public class Movieadapter extends RecyclerView.Adapter<Movieadapter.ViewHolder> {

    Context context;
    List<Movie> movies;

    public Movieadapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }



    // usually involves inflating a layout from XML and return to holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "onCreateViewHolder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.items_movie, parent, false);
        return new ViewHolder(movieView);
    }
    // involves populating date into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MovieAdapter", "onBindViewHolder" + position);
        //get the movie at the passed position
        Movie movie = movies.get(position);
        //Bind the movie data into the VH
        holder.bind(movie);

    }
    //return the total count of items in the ist.
    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivPoster = itemView.findViewById(R.id.ivPoster);





        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverView());
            String imageURL;
            //if phone is landscape
            if(context.getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE) {
                // then imageURL = back drop image
                imageURL = movie.getBackdropPath();
            }else {
                //else imageURL=poster image
                imageURL = movie.getPosterPath();

            }


            Glide.with(context).load(imageURL).into(ivPoster);
        }


    }
}
