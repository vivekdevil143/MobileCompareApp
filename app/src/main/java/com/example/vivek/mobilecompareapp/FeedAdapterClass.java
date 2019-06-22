package com.example.vivek.mobilecompareapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedAdapterClass extends RecyclerView.Adapter<FeedAdapterClass.ViewHolder> {
    ArrayList<FeedModelClass> modelclasses;
    Context context;
    public FeedAdapterClass(Context context, ArrayList<FeedModelClass>modelclasses1){
        this.context=context;
       this.modelclasses=modelclasses1;
    }
    @NonNull
    @Override
    public FeedAdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_cardview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     FeedModelClass feedModelClass=modelclasses.get(position);

        Picasso.get().load(feedModelClass.image).fit().centerInside().into(holder.ImageView);
    }

    @Override
    public int getItemCount() {
        return modelclasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public android.widget.ImageView ImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            ImageView=itemView.findViewById(R.id.image_view);
        }
    }
}
