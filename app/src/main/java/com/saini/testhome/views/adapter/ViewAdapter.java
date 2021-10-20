package com.saini.testhome.views.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.saini.testhome.R;

public class ViewAdapter extends PagerAdapter {
    Context mContext;

    public ViewAdapter(Context context) {
        this.mContext = context;
    }

    int[] mDrawables = new int[]{
            R.drawable.intro_image_one,
            R.drawable.intro_image_two,
            R.drawable.intro_image_three,
            R.drawable.intro_image_four};

    @Override
    public int getCount() {
        return mDrawables.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_inttro_item, null);
        ImageView imageView = view.findViewById(R.id.imageViewMain);
        imageView.setImageResource(mDrawables[position]);
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
