package com.huangdaran.mvpdemo.mvpdemo.presenter;

/**
 * Created by Administrator on 2016/10/24.
 */

public interface ILoginPresenter {
    void login(String name,String pwd);
    void clear();
    void clearPwdText();

}
