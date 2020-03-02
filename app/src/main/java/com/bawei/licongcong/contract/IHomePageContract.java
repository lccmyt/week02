package com.bawei.licongcong.contract;

import com.bawei.licongcong.base.IBaseView;

/**
 * @ProjectName: Licongcong20200302
 * @Package: com.bawei.licongcong.contract
 * @ClassName: IHomePageContract
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/3/2 13:20
 */
public interface IHomePageContract {
    interface IView extends IBaseView{
        void onSuccess(String json);
        void onFailure(String msg);
    }
    interface IPresenter{
        void onGetListSuccess(String url);
    }
    interface IModel{
        void onGetListSuccess(String url,onGetListCallBack callBack);
        interface onGetListCallBack{
            void onSuccess(String json);
            void onFailure(String msg);
        }
    }
}

