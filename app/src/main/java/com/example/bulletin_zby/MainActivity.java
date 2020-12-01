package com.example.bulletin_zby;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText usernameField;  //用户名
    EditText passwordField;  //密码
    Button loginButton;  //登录按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameField = (EditText) findViewById(R.id.login_field_username);
        passwordField = (EditText) findViewById(R.id.login_field_password);
        loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(this);
    }

    public void onClick(View v) {
                String loginAddress="https://vcapi.lvdaqian.cn/login";
                String loginAccount = usernameField.getText().toString();
                String loginPassword = passwordField.getText().toString();
                loginWithOkHttp(loginAddress,loginAccount,loginPassword);
        }

    //实现登录
    public void loginWithOkHttp(String address,String account,String password){
        HttpUtil.loginWithOkHttp(address,account,password, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //在这里对异常情况进行处理
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //得到服务器返回的具体内容
                final String responseData = response.body().string();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("以下显示token的结果 ",responseData);
                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,homePage.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).start();
            }
        });
    }

    //退出时将用户输入的内容重置
        protected void onResume() {
        super.onResume();
        usernameField.setText("");
        passwordField.setText("");
    }
}

