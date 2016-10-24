package com.huangdaran.mvpdemo.mvpdemo.view;

/**
 * Created by Administrator on 2016/10/24.
 */

public interface ILoginView {
    void clear();
    void clearPwdText();
    void onLoginResult(int resultCode,String msg);
    void onShowToast(String msg);
}
