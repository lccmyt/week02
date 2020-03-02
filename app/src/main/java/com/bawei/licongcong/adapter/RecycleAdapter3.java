package com.bawei.licongcong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.licongcong.R;
import com.bawei.licongcong.activity.MainActivity;
import com.bawei.licongcong.bean.Bean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @ProjectName: Licongcong20200302
 * @Package: com.bawei.licongcong.adapter
 * @ClassName: RecycleAdapter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/3/2 14:12
 */
public class RecycleAdapter3 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final Context context;
    private final List<Bean.DataBean.GridDataBean> gridData;

    public RecycleAdapter3(Context context, List<Bean.DataBean.GridDataBean> gridData) {

        this.context = context;
        this.gridData = gridData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(View.inflate(context, R.layout.item3, null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Glide.with(context).load(gridData.get(position).getImageurl()).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher)
                .priority(Priority.LOW).into(((ViewHolder) holder).iv);
        ((ViewHolder)holder).tv1.setText(gridData.get(position).getTitle());
        ((ViewHolder)holder).tv2.setText(gridData.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return gridData.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1;
        TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv_titile);
            tv2 = itemView.findViewById(R.id.tv_price);
        }
    }
}
