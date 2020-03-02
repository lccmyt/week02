package com.bawei.licongcong.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @ProjectName: Licongcong20200302
 * @Package: com.bawei.licongcong.base
 * @ClassName: BaseActivity
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/3/2 13:25
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        p = initPresenter();
        initView();
        initData();
    }

    protected abstract int getLayoutResID();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract void initData();

    public P getPresenter(){
        return p;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p != null){
            p.detachView();
            p = null;
        }
    }
}
