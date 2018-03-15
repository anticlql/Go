package com.example.go.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.go.R;

import Fragments.MyInfoFragment;
import Fragments.MessageFragment;
import Fragments.SortFragment;
import Fragments.DiscoveryFragment;

public class NavActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bottomNavigationBar;

    private DiscoveryFragment mDiscoveryFragment;
    private SortFragment mSortFragment;
    private MessageFragment mMessageFragment;
    private MyInfoFragment mMyInfoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_layout);

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.find, "发现").setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.sort, "分类").setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.info, "信息").setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.me3, "我的").setActiveColor(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();


    }

    /**
     * 设置默认的Fragment
     */
    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mDiscoveryFragment = DiscoveryFragment.newInstance();
        transaction.replace(R.id.tb, mDiscoveryFragment);
        transaction.commit();
    }


    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (mDiscoveryFragment == null) {
                    mDiscoveryFragment = DiscoveryFragment.newInstance();
                }
                transaction.replace(R.id.tb, mDiscoveryFragment);
                break;
            case 1:
                if (mSortFragment == null) {
                    mSortFragment = SortFragment.newInstance();
                }
                transaction.replace(R.id.tb, mSortFragment);
                break;
            case 2:
                if (mMessageFragment == null) {
                    mMessageFragment = MessageFragment.newInstance();
                }
                transaction.replace(R.id.tb, mMessageFragment);
                break;
            case 3:
                if (mMyInfoFragment == null) {
                    mMyInfoFragment = MyInfoFragment.newInstance();
                }
                transaction.replace(R.id.tb, mMyInfoFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
