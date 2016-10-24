package com.huangdaran.mvpdemo.mvpdemo.presenter;

import android.os.Handler;

import com.huangdaran.mvpdemo.mvpdemo.model.UserBean;
import com.huangdaran.mvpdemo.mvpdemo.view.ILoginView;

/**
 * Created by Administrator on 2016/10/24.
 */

public class LoginPresenter implements ILoginPresenter {
    private UserBean userBean;
    private ILoginView view;
    private Handler handler;
    public LoginPresenter(ILoginView view ){
        this.view = view;
    }
    @Override
    public void login(String name, String pwd) {
        if("".equals(name)){
            view.onShowToast("请输入用户名");
            return;
        }
        if("".equals(pwd)){
            view.onShowToast("请输入密码");
            return;
        }
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.onLoginResult(200,"登录成功");
            }
        },2000);
    }

    @Override
    public void clear() {
        view.clear();
    }

    @Override
    public void clearPwdText() {
        view.clearPwdText();
    }
}
