package com.bawei.licongcong.model;

import com.bawei.licongcong.contract.IHomePageContract;
import com.bawei.licongcong.utils.VolleyUtils;

/**
 * @ProjectName: Licongcong20200302
 * @Package: com.bawei.licongcong.model
 * @ClassName: Model
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/3/2 13:22
 */
public class Model implements IHomePageContract.IModel {
    @Override
    public void onGetListSuccess(String url, final onGetListCallBack callBack) {
        VolleyUtils.getInstance().doGet(url, new VolleyUtils.CallBack() {
            @Override
            public void onSuccess(String json) {
                callBack.onSuccess(json);
            }

            @Override
            public void onFailure(String msg) {
                callBack.onFailure(msg);
            }
        });
    }
}
