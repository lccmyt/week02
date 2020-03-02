package com.bawei.licongcong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
public class RecycleAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final Context context;
    private final List<Bean.DataBean.VerticalListDataBean> verticalListData;

    public RecycleAdapter2(Context context, List<Bean.DataBean.VerticalListDataBean> verticalListData) {

        this.context = context;
        this.verticalListData = verticalListData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(View.inflate(context, R.layout.item2, null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Glide.with(context).load(verticalListData.get(position).getImageurl()).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher)
                .priority(Priority.IMMEDIATE).into(((ViewHolder) holder).iv);
        ((ViewHolder)holder).tv1.setText(verticalListData.get(position).getTitle());
        ((ViewHolder)holder).tv2.setText(verticalListData.get(position).getPrice());
        ((ViewHolder)holder).ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetOnItemClickList.onClick(position);
            }
        });
    }

    setOnItmClickListener mSetOnItemClickList;
    public void clickListener(setOnItmClickListener setOnItmClickListener){
        mSetOnItemClickList = setOnItmClickListener;
    }
    public interface setOnItmClickListener{
        void onClick(int position);
    }

    @Override
    public int getItemCount() {
        return verticalListData.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        LinearLayout ll;
        TextView tv1;
        TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv_titile);
            tv2 = itemView.findViewById(R.id.tv_price);
            ll = itemView.findViewById(R.id.ll2);
        }
    }
}
