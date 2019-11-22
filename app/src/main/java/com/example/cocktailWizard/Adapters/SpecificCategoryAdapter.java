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

// Adapter code mostly adapter from NYT Tutorial Application as well as minor adjustments made https://www.youtube.com/watch?v=E6vE8fqQPTE

public class SpecificCategoryAdapter extends RecyclerView.Adapter<SpecificCategoryAdapter.SpecificCategoryViewHolder> {
    private List<Drinks.Drink> sDrinks;

    public void setData(List<Drinks.Drink> sDrinks){
        this.sDrinks = sDrinks;
    }

    @NonNull
    @Override
    public SpecificCategoryAdapter.SpecificCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_view, parent, false);
        SpecificCategoryViewHolder sCategoryViewHolder = new SpecificCategoryViewHolder(view);
        return sCategoryViewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull SpecificCategoryAdapter.SpecificCategoryViewHolder holder, int position) {
        final Drinks.Drink drinkPos = sDrinks.get(position);
        holder.category.setText(drinkPos.getStrDrink());
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
        return sDrinks.size();
    }

    public static class SpecificCategoryViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView category;
        public ImageView image;

        public SpecificCategoryViewHolder(View v){
            super (v);
            view = v;
            category = v.findViewById(R.id.searchCat);
            image = v.findViewById(R.id.imageView);
        }

    }
}
