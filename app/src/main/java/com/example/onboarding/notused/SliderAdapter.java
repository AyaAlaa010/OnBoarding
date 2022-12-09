package com.example.onboarding.notused;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.onboarding.MainActivity;
import com.example.onboarding.R;

import java.util.ArrayList;
//not used
//public class SliderAdapter extends PagerAdapter {
//
//    // creating variables for layout
//    // inflater, context and array list.
//    LayoutInflater layoutInflater;
//    Context context;
//    ArrayList<SliderModal> sliderModalArrayList;
//
//    // creating constructor.
//    public SliderAdapter(Context context, ArrayList<SliderModal> sliderModalArrayList) {
//        this.context = context;
//        this.sliderModalArrayList = sliderModalArrayList;
//    }
//
//    @Override
//    public int getCount() {
//        // inside get count method returning
//        // the size of our array list.
//        return sliderModalArrayList.size();
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        // inside isViewFrombject method we are
//        // returning our Relative layout object.
//        return view == (ConstraintLayout) object;
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//
//        // in this method we will initialize all our layout
//        // items and inflate our layout file as well.
//        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//
//        // below line is use to inflate the
//        // layout file which we created.
//        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);
//
//        // initializing our views.
//        TextView skipTv = view.findViewById(R.id.tv_skip);
//
//        TextView titleTV = view.findViewById(R.id.tv_small_title);
//        TextView headingTV = view.findViewById(R.id.tv_large_title);
//        ConstraintLayout sliderRL = view.findViewById(R.id.idRLSlider);
//
//        // setting data to our views.
//        SliderModal modal = sliderModalArrayList.get(position);
//
//
//        titleTV.setText(modal.getTitle());
//        headingTV.setText(modal.getHeading());
//        ////////////////////////////
////        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
////        params.setMargins(10,10,10,10);
////        titleTV.setLayoutParams(params);
////////////////////////////////////////////
//        if (position == 1) {
//            titleTV.setTextSize(42);
//            headingTV.setTextSize(24);
//        }
//
//
//        // Picasso.get().load(modal.getImgUrl()).into(imageView);
//
//        // below line is to set background
//        // drawable to our each item
//        sliderRL.setBackground(context.getResources().getDrawable(modal.getBackgroundDrawable()));
//
//
//        // after setting the data to our views we
//        // are adding the view to our container.
//        container.addView(view);
//        skipTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, MainActivity.class);
//                context.startActivity(intent);
//
//            }
//        });
//        // at last we are
//        // returning the view.
//        return view;
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        // this is a destroy view method
//        // which is use to remove a view.
//        container.removeView((ConstraintLayout) object);
//    }
//}
