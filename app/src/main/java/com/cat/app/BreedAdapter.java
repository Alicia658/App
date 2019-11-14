package com.cat.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.CatHolder>{
    List<Breed> breedList;
    private Context context;
    public BreedAdapter(Context context, List<Breed> breedList) {
        this.context = context;
        this.breedList = breedList;
    }



    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.item_breed,parent,false);
        return new CatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder holder, int position) {
        final Breed breed = breedList.get(position);
        holder.tvBreed.setText(breed.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BreedActivity.class);
                intent.putExtra("id",breed.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return breedList.size();
    }
    class CatHolder extends RecyclerView.ViewHolder{
        TextView tvBreed;
        public CatHolder(@NonNull View itemView) {
            super(itemView);
            tvBreed = itemView.findViewById(R.id.tv_breed);

        }
    }
}
