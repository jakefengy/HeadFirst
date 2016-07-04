package com.example.headfirst.observer.role;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class GankSubject implements ISubject {

    private List<IObserver> iObserverList = new ArrayList<>();

    private List<String> gankMeiZi = new ArrayList<>();

    @Override
    public void subscribe(IObserver observer) {
        if (observer != null) {
            iObserverList.add(observer);
        }
    }

    @Override
    public void unSubscribe(IObserver observer) {
        if (observer != null && iObserverList.indexOf(observer) >= 0) {
            iObserverList.remove(observer);
        }
    }

    @Override
    public void update() {
        for (IObserver observer : iObserverList) {
            observer.update();
        }
    }

    // 数据操作
    public void addMeiZi(String meiZi) {
        gankMeiZi.add(meiZi);

        update();
    }

    // 提供获取妹子信息的方法。
    public List<String> getGankMeiZi() {
        return gankMeiZi;
    }

    // 提供获取观察者数量的方法。
    public int getObserverCount() {
        return iObserverList.size();
    }
}
