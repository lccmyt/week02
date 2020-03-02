package com.bawei.licongcong.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bawei.licongcong.R;
import com.bawei.licongcong.adapter.RecycleAdapter;
import com.bawei.licongcong.adapter.RecycleAdapter2;
import com.bawei.licongcong.adapter.RecycleAdapter3;
import com.bawei.licongcong.base.BaseActivity;
import com.bawei.licongcong.base.BasePresenter;
import com.bawei.licongcong.bean.Bean;
import com.bawei.licongcong.contract.IHomePageContract;
import com.bawei.licongcong.presenter.Presenter;
import com.bawei.licongcong.utils.VolleyUtils;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity implements IHomePageContract.IView {

    private LinearLayout linearLayout;
    private RecyclerView rc;
    private RecyclerView rc2;
    private RecyclerView rc3;
    private RelativeLayout relativeLayout;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter(this);
    }

    @Override
    protected void initView() {
        linearLayout = findViewById(R.id.ll1);
        relativeLayout = findViewById(R.id.rl);
        rc = findViewById(R.id.rc);
        rc2 = findViewById(R.id.rc2);
        rc3 = findViewById(R.id.rc3);
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initData() {
        Boolean workInfo = VolleyUtils.getInstance().isWorkInfo(this);
        Log.i("xxx", "" + workInfo);
        if (workInfo) {
            BasePresenter presenter = getPresenter();
            if (presenter != null && presenter instanceof Presenter) {
                ((Presenter) presenter).onGetListSuccess("http://blog.zhaoliang5156.cn/api/shop/jingdong.json");
                relativeLayout.setVisibility(4);
            }
        }else {
            Toast.makeText(this, "无网络", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSuccess(String json) {
        Bean.DataBean data = new Gson().fromJson(json, Bean.class).getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2,RecyclerView.HORIZONTAL,false);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this, 2,RecyclerView.VERTICAL,false);
       // StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,RecyclerView.HORIZONTAL);

        rc.setLayoutManager(linearLayoutManager);
        rc2.setLayoutManager(gridLayoutManager);
        rc3.setLayoutManager(gridLayoutManager1);
        List<Bean.DataBean.HorizontalListDataBean> horizontalListData = data.getHorizontalListData();
        List<Bean.DataBean.GridDataBean> gridData = data.getGridData();
        final List<Bean.DataBean.VerticalListDataBean> verticalListData = data.getVerticalListData();
        RecycleAdapter recycleAdapter = new RecycleAdapter(this,horizontalListData);
        rc.setAdapter(recycleAdapter);
        RecycleAdapter2 recycleAdapter2 = new RecycleAdapter2(this,verticalListData);
        rc2.setAdapter(recycleAdapter2);
        RecycleAdapter3 recycleAdapter3 = new RecycleAdapter3(this,gridData);
        rc3.setAdapter(recycleAdapter3);

        recycleAdapter2.clickListener(new RecycleAdapter2.setOnItmClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, verticalListData.get(position).getPrice(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onFailure(String msg) {

    }
}
