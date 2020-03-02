package com.bawei.licongcong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<Bean.DataBean.HorizontalListDataBean> horizontalListData;

    public RecycleAdapter(Context context, List<Bean.DataBean.HorizontalListDataBean> horizontalListData) {

        this.context = context;
        this.horizontalListData = horizontalListData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(View.inflate(context, R.layout.item1, null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Glide.with(context).load(horizontalListData.get(position).getImageurl()).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher)
                .priority(Priority.HIGH).into(((ViewHolder) holder).iv);
    }

    @Override
    public int getItemCount() {
        return horizontalListData.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
