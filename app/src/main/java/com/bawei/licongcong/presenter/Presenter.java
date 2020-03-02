package com.bawei.licongcong.presenter;

import com.bawei.licongcong.base.BasePresenter;
import com.bawei.licongcong.base.IBaseView;
import com.bawei.licongcong.contract.IHomePageContract;
import com.bawei.licongcong.model.Model;

/**
 * @ProjectName: Licongcong20200302
 * @Package: com.bawei.licongcong.presenter
 * @ClassName: Presenter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/3/2 13:23
 */
public class Presenter extends BasePresenter implements IHomePageContract.IPresenter {

    private Model model;

    public Presenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model();
    }

    @Override
    public void onGetListSuccess(String url) {
        model.onGetListSuccess(url, new IHomePageContract.IModel.onGetListCallBack() {
            @Override
            public void onSuccess(String json) {
                IBaseView view = getView();
                if (view instanceof IHomePageContract.IView){
                    ((IHomePageContract.IView)view).onSuccess(json);
                }
            }

            @Override
            public void onFailure(String msg) {
                IBaseView view = getView();
                if (view instanceof IHomePageContract.IView){
                    ((IHomePageContract.IView)view).onFailure(msg);
                }
            }
        });
    }
}
