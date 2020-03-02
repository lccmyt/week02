package com.bawei.licongcong.base;

import java.lang.ref.WeakReference;

/**
 * @ProjectName: Licongcong20200302
 * @Package: com.bawei.licongcong.base
 * @ClassName: BasePresenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/3/2 13:17
 */
public abstract class BasePresenter<V extends IBaseView> implements IBaseView {

    private WeakReference<V> vWeakReference;

    public BasePresenter(V v){
        vWeakReference = new WeakReference<>(v);
        initModel();
    }

    protected abstract void initModel();

    public V getView(){
        if (vWeakReference != null){
            return vWeakReference.get();
        }
        return null;
    }

    protected void detachView(){
        if (vWeakReference != null){
            vWeakReference.clear();
            vWeakReference = null;
        }
    }
}
