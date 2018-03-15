package Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.go.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import Model.MyActivity;
import utils.Constant;

import static com.example.go.R.drawable.bac2;

/**
 * Created by 刘青林 on 2017/12/11.
 */

public class LocationRecyclerViewAdapter extends RecyclerView.Adapter<LocationRecyclerViewAdapter.ViewHolder> {

    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");

    private List<MyActivity> activityList;
    private Context mContext;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView activityTitle;
        ImageView imageView;
        TextView activityTime;
        TextView activityLocation;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            activityTitle = (TextView) itemView.findViewById(R.id.location_item_title);
            imageView = (ImageView) itemView.findViewById(R.id.activity_img);
            activityTime = (TextView) itemView.findViewById(R.id.activity_last_time);
            activityLocation = (TextView) itemView.findViewById(R.id.activity_loc);
        }
    }

    public LocationRecyclerViewAdapter(List<MyActivity> list){
        this.activityList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(parent.getContext(),"点击图片进入活动详情",Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyActivity myActivity = activityList.get(position);
        //设置活动标题
        holder.activityTitle.setText("活动："+myActivity.getName());
        //设置活动时间
        holder.activityTime.setText("活动时间："+df.format(myActivity.getTimeStart())+"--"
                +df.format(myActivity.getTimeStart().getTime() + 3*24*60*60*1000));
        //设置活动图片
        Glide.with(mContext).load(Constant.RECYCLER_IMG[position]).into(holder.imageView);
        //设置活动地点
        holder.activityLocation.setText("活动地点："+myActivity.getPositon());
    }

    @Override
    public int getItemCount() {
        return activityList.size();
    }
}
