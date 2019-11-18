package com.example.cocktailWizard.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cocktailWizard.Activities.DetailActivityRecycler;
import com.example.cocktailWizard.Model.Drinks;
import com.example.cocktailWizard.R;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private List<Drinks.Drink> sDrinks;

    public void setData(List<Drinks.Drink> sDrinks){
        this.sDrinks = sDrinks;
    }

    @NonNull
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_view, parent, false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchViewHolder holder, int position) {
        final Drinks.Drink drinkPos = sDrinks.get(position);
        holder.textView.setText(drinkPos.getStrDrink());
        String imageUrl = drinkPos.getStrDrinkThumb();
        Glide.with(holder.image.getContext()).load(imageUrl).into(holder.image);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivityRecycler.class);
                intent.putExtra("cID", drinkPos.getIdDrink());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        if (sDrinks == null) {
            return 0;
        }
        else {
            return sDrinks.size();
        }

    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView textView;
        public ImageView image;

        public SearchViewHolder(@NonNull View v){
            super(v);
            view = v;
            textView = v.findViewById(R.id.searchCat);
            image = v.findViewById(R.id.imageView);
        }
    }
}
