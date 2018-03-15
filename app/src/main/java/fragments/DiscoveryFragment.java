package Fragments;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.example.go.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Adapter.LocationRecyclerViewAdapter;
import Adapter.MyRollViewPagerAdapter;
import Model.MyActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utils.Constant;
import utils.GetActivityListHttp;
import utils.JsonToModel;

public class DiscoveryFragment extends Fragment {

    private FloatingActionButton addFab;
    private RollPagerView mRollViewPager;
    private List<MyActivity> activityList;
    private RecyclerView loactionRecyclerView;

    LocationRecyclerViewAdapter adapter;

    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");


    public static DiscoveryFragment newInstance() {
        DiscoveryFragment fragment = new DiscoveryFragment();
        return fragment;
    }

    public DiscoveryFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discovery, container, false);

        //沉浸式标题栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getActivity().getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        ViewGroup mContentView = (ViewGroup) getActivity().findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 使其不为系统 View 预留空间.
            ViewCompat.setFitsSystemWindows(mChildView, false);
        }

        //图片轮播
        mRollViewPager = (RollPagerView) view.findViewById(R.id.roll_view_pager);
        mRollViewPager.setPlayDelay(3000);//设置播放时间间隔
        mRollViewPager.setAnimationDurtion(500);//设置透明度
        mRollViewPager.setAdapter(new MyRollViewPagerAdapter());//设置适配器
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW,Color.WHITE));//设置为圆点指示器，并指定颜色

        //添加活动按钮FloatingBar
        addFab = (FloatingActionButton) view.findViewById(R.id.add_activity_fab);
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"你点击了按钮",Toast.LENGTH_SHORT).show();
            }
        });

        //Toolbar
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.location_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar bar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        bar.hide();

        CollapsingToolbarLayout collapsingToolbarLayout =(CollapsingToolbarLayout) view.findViewById(R.id.location_coolapsing_toobar);
        collapsingToolbarLayout.setTitle("");
        //RecyclerView
        loactionRecyclerView = (RecyclerView) view.findViewById(R.id.location_recycler_view);
        //初始化数据
        initData();
        //设置适配器绑定数据
        adapter = new LocationRecyclerViewAdapter(activityList);
        //设置布局
        loactionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loactionRecyclerView.setAdapter(adapter);
        return view;
    }

    //初始化数据
    public void initData() {
        //获得网络上的数据
//        activityList = new GetActivityListHttp(Constant.MAIN_PATH).getRes();

//        //本地数据
        activityList = new ArrayList<>();
        MyActivity activity1 = new MyActivity();
        activity1.setName("郑州开发者大会");
        activity1.setTimeStart(new Date());
        activity1.setPositon("郑州市会展中心");
        activityList.add(activity1);
        MyActivity activity2 = new MyActivity();
        activity2.setName("来啊~快活啊");
        activity2.setTimeStart(new Date());
        activity2.setPositon("郑州大学创新创业基地");
        activityList.add(activity2);
        MyActivity activity3 = new MyActivity();
        activity3.setName("博雅论坛");
        activity3.setTimeStart(new Date());
        activity3.setPositon("郑州大学工学院学术报告厅");
        activityList.add(activity3);
        MyActivity activity4 = new MyActivity();
        activity4.setName("公开课");
        activity4.setTimeStart(new Date());
        activity4.setPositon("郑州市金水区文化路97号");
        activityList.add(activity4);
    }

}
