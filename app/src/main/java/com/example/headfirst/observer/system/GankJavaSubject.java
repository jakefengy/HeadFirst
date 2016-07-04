package com.example.headfirst.observer.system;

import com.example.headfirst.observer.bean.Gank;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * 通过java.util.Observable 和 java.util.Observer 实现观察者模式。。
 */
public class GankJavaSubject extends Observable {

    private List<Gank> ganks = new ArrayList<>();

    // 为了测试notifyObservers(Object data)而临时创建的数据
    private Gank tempGank;

    public GankJavaSubject() {
        tempGank = new Gank();
        tempGank.setSubAndroid("Gank Android From Subject");
        tempGank.setSubIos("Gank iOS From Subject");
    }

    // 添加操作
    public void addGank(Gank gank) {
        ganks.add(gank);

        // 标记数据已经改变，否则不会推送消息。原因可看java.util.Observable.notifyObservers(Object data)源码
        setChanged();

        // 通知所有订阅者，内容已经改变了。通过向Subject拉去数据的方式更新内容
        notifyObservers();

        // 通知所有订阅者，内容已经改变了。通过向Subject推送数据的方式更新内容
        notifyObservers(tempGank);

    }

    // 提供获取订阅信息的方法。   方便起见，只返回最新一条。
    public String getGankAndroid() {
        if (ganks.isEmpty()) {
            return "";
        }
        return ganks.get(ganks.size() - 1).getSubAndroid();
    }

    public String getGankIos() {
        if (ganks.isEmpty()) {
            return "";
        }
        return ganks.get(ganks.size() - 1).getSubIos();
    }


}
