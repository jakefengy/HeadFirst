package com.example.headfirst.observer.custom;

import com.example.headfirst.observer.bean.Gank;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class GankSubject implements ISubject {

    // 观察者们（订阅者们）
    private List<IObserver> observerList = new ArrayList<>();

    // 数据集合
    private List<Gank> gankList = new ArrayList<>();

    @Override
    public void subscribe(IObserver observer) {
        if (observer != null) {
            observerList.add(observer);
        }
    }

    @Override
    public void unSubscribe(IObserver observer) {
        if (observer != null && observerList.indexOf(observer) >= 0) {
            observerList.remove(observer);
        }
    }

    @Override
    public void update() {
        for (IObserver observer : observerList) {
            observer.update();
        }
    }

    // 添加操作
    public void addGank(Gank gank) {
        gankList.add(gank);

        update();
    }

    // 提供获取订阅信息的方法。   方便起见，只返回最新一条。
    public String getGankAndroid() {
        if (gankList.isEmpty()) {
            return "";
        }
        return gankList.get(gankList.size() - 1).getSubAndroid();
    }

    public String getGankIos() {
        if (gankList.isEmpty()) {
            return "";
        }
        return gankList.get(gankList.size() - 1).getSubIos();
    }

}
