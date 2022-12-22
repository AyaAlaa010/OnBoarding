package com.example.onboarding.search.Flight;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FlightItemBinding;
import com.example.onboarding.databinding.ItemFavouriteBinding;
import com.example.onboarding.favourite.FavouriteBookingsAndSavedAdapter;
import com.example.onboarding.favourite.FavouriteModel;

import java.util.List;

public class FlightsAdapter extends RecyclerView.Adapter<FlightsAdapter.FlightsHolder> {
    List<FlightModel> flightsModelList;
     private ItemFlightImp itemFlightImp;

    public FlightsAdapter(List<FlightModel> flightsModelList, ItemFlightImp itemFlightImp) {
        this.flightsModelList=flightsModelList;
         this.itemFlightImp= itemFlightImp;
    }

    @NonNull
    @Override
    public FlightsAdapter.FlightsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new FlightsAdapter.FlightsHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.flight_item,parent
                ,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlightsHolder holder, int position) {
        FlightModel model=flightsModelList.get(position);
//        holder.itemBinding.setCategoriesModel(category);
//        int categoryId=category.getId();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemFlightImp.navigateToConfirmFragment();
            }
        });
    }

    @Override
    public int getItemCount() {
        return flightsModelList.size();
    }

    class FlightsHolder extends RecyclerView.ViewHolder{
        FlightItemBinding itemBinding;

        public FlightsHolder(@NonNull FlightItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding=itemBinding;
        }
    }


}