package com.huangdaran.mvpdemo.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.huangdaran.mvpdemo.mvpdemo.presenter.LoginPresenter;
import com.huangdaran.mvpdemo.mvpdemo.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView,View.OnClickListener{
    private EditText edt_pwd,edt_username;
    private Button btn_login,btn_cancel;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_pwd = (EditText)findViewById(R.id.edt_pwd);
        edt_username = (EditText)findViewById(R.id.edt_username);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        presenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_cancel:
                presenter.clearPwdText();
                break;
            case R.id.btn_login:
                String name = edt_username.getText().toString();
                String pwd = edt_pwd.getText().toString();
                presenter.login(name,pwd);
                break;
        }
    }

    @Override
    public void clearPwdText() {
        edt_pwd.setText("");
        edt_username.setText("");
    }

    @Override
    public void clear() {
        edt_pwd.setText("");
    }

    @Override
    public void onLoginResult(int resultCode, String msg) {
        if(resultCode == 200){
            onShowToast(msg);
        }
    }

    @Override
    public void onShowToast(String msg) {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }
}
