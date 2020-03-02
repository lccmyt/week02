package com.bawei.licongcong.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.licongcong.base.App;

import java.io.UnsupportedEncodingException;

/**
 * @ProjectName: Licongcong20200302
 * @Package: com.bawei.licongcong.utils
 * @ClassName: VolleyUtils
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/3/2 13:08
 */
public class VolleyUtils {

    private final RequestQueue requestQueue;

    public VolleyUtils() {
        requestQueue = Volley.newRequestQueue(App.getAppContext());
    }
    private static class SingleInstance{
        private static final VolleyUtils INSTANCE = new VolleyUtils();
    }
    public static VolleyUtils getInstance(){
        return SingleInstance.INSTANCE;
    }
    public Boolean isWorkInfo(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() != null){
            return true;
        }
        return false;
    }
    public interface CallBack{
        void onSuccess(String json);
        void onFailure(String msg);
    }
    public void doGet(String url, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callBack.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onFailure(error.getMessage());
            }
        }){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String s;
                try {
                    s = new String(response.data, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    s = new String(response.data);
                }
                return Response.success(s, HttpHeaderParser.parseCacheHeaders(response));
            }
        };
        requestQueue.add(stringRequest);
    }
}
