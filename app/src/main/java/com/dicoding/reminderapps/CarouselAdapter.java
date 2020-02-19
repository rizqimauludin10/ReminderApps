package com.dicoding.reminderapps;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.dicoding.reminderapps.model.CarouselModel;

import java.util.ArrayList;

public class CarouselAdapter extends PagerAdapter {
    private ArrayList<CarouselModel> carouselImages;
    private LayoutInflater layoutInflater;
    private Context context;

    public CarouselAdapter(Context context, ArrayList<CarouselModel> carouselImages){
        this.context = context;
        this.carouselImages = carouselImages;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.carousel, container, false );
        assert view != null;
        final ImageView imageView = view.findViewById(R.id.banner);

        imageView.setImageResource(carouselImages.get(position).getImage());
        container.addView(view, 0);

        return view;
    }

    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {

    }

    @Nullable
    @Override
    public Parcelable saveState() {
        return null;
    }
}
