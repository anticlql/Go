package Adapter;
/**
 * 2017.12.5 刘青林
 * 轮播图RollViewPager适配器类
 */

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.go.Activity.NavActivity;
import com.example.go.R;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import utils.Constant;

public class MyRollViewPagerAdapter extends StaticPagerAdapter  {

    private int[] imgs = Constant.SLIP_IMG;

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(imgs[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"点击图片",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }


}
