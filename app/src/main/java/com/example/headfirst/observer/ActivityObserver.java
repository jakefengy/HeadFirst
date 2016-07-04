package com.example.headfirst.observer;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.example.headfirst.R;
import com.example.headfirst.databinding.ActivityObserverBinding;
import com.example.headfirst.observer.bean.Gank;
import com.example.headfirst.observer.custom.AndroidObserver;
import com.example.headfirst.observer.custom.GankSubject;
import com.example.headfirst.observer.custom.IosObserver;
import com.example.headfirst.observer.system.AndroidJavaObserver;
import com.example.headfirst.observer.system.GankJavaSubject;
import com.example.headfirst.observer.system.IosJavaObserver;
import com.example.headfirst.utils.SomeUtils;

import java.util.Observable;

public class ActivityObserver extends AppCompatActivity {

    // 不太愿意写find id
    private ActivityObserverBinding binding;

    // 模式切换 暂时采用简陋的boolean
    private boolean isSystem = false;

    // 自定义观察者模式…
    // 主题
    private GankSubject subject;

    // 订阅者
    private AndroidObserver androidObserver;
    private IosObserver iosObserver;

    // 使用系统观察者模式…
    private GankJavaSubject javaSubject;
    private AndroidJavaObserver androidJavaObserver;
    private IosJavaObserver iosJavaObserver;

    // 换行符..
    private final static String Line = "\r\n";

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, ActivityObserver.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_observer);
        initView();
        initData();
    }

    public void initData() {
        subject = new GankSubject();

        androidObserver = new AndroidObserver() {
            @Override
            public void update() {
                binding.setDataA(SomeUtils.getNotNullString(binding.getDataA()) + Line + subject.getGankAndroid());
            }
        };

        iosObserver = new IosObserver() {
            @Override
            public void update() {
                binding.setDataB(SomeUtils.getNotNullString(binding.getDataB()) + Line + subject.getGankIos());
            }
        };

        subject.subscribe(androidObserver);
        subject.subscribe(iosObserver);

        javaSubject = new GankJavaSubject();

        androidJavaObserver = new AndroidJavaObserver() {
            @Override
            public void update(Observable observable, Object data) {
                binding.setDataA(SomeUtils.getNotNullString(binding.getDataA()) + Line + javaSubject.getGankAndroid());
            }
        };

        iosJavaObserver = new IosJavaObserver() {
            @Override
            public void update(Observable observable, Object data) {
                binding.setDataB(SomeUtils.getNotNullString(binding.getDataB()) + Line + javaSubject.getGankIos());
            }
        };

        javaSubject.addObserver(androidJavaObserver);
        javaSubject.addObserver(iosJavaObserver);

    }

    public void initView() {
        binding.rgWay.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                isSystem = checkedId == binding.rbSystem.getId();
                binding.setDataA("");
                binding.setDataB("");
            }
        });

        binding.rbSelf.setChecked(true);
    }

    public void changeData(View view) {

        Gank gank = new Gank();

        if (isSystem) {
            gank.setSubAndroid("Android System " + SomeUtils.getRandomString());
            gank.setSubIos("iOS System " + SomeUtils.getRandomString());
            javaSubject.addGank(gank);
        } else {
            gank.setSubAndroid("Android Custom " + SomeUtils.getRandomString());
            gank.setSubIos("iOS Custom " + SomeUtils.getRandomString());
            subject.addGank(gank);
        }
    }

}
