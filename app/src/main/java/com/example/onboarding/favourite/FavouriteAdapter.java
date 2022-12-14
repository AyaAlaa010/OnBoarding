package com.example.onboarding.favourite;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onboarding.R;
import com.example.onboarding.databinding.ItemFavouriteBinding;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavouritsHolder> {
    List<FavouriteModel> favouriteModelList;
    public FavouriteAdapter(List<FavouriteModel> favouriteModelList) {
        this.favouriteModelList=favouriteModelList;
    }

    @NonNull
    @Override
    public FavouritsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavouritsHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_favourite,parent
                ,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavouritsHolder holder, int position) {
        FavouriteModel model=favouriteModelList.get(position);
//        holder.itemBinding.setCategoriesModel(category);
//        int categoryId=category.getId();
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                categoriesInterface.getContentOfCategory(category,categoryId);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return favouriteModelList.size();
    }

    class FavouritsHolder extends RecyclerView.ViewHolder{
        ItemFavouriteBinding itemBinding;

        public FavouritsHolder(@NonNull ItemFavouriteBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding=itemBinding;
        }
    }


}