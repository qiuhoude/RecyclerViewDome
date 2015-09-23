package com.event_bus.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.event_bus.fragment.Event.ItemListEvent;
import com.event_bus.bean.Item;

import de.greenrobot.event.EventBus;

public class ItemListFragment extends ListFragment {

    private AbsListView mListView;

    private ListAdapter mAdapter;


    public ItemListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //订阅事件
        EventBus.getDefault().register(this);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //因为继承的是listfragment所以自己有个视图，不用覆盖onCreateView方法来加载视图
        super.onViewCreated(view, savedInstanceState);
        //开启线程加载列表
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000); // 模拟延时
                    // 发布事件，在后台线程发的事件
                    EventBus.getDefault().post(new ItemListEvent(Item.ITEMS));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /*如果方法名以onEvent开头，则代表要订阅一个事件，MainThread意思，这个方法最终要在UI线程执行；当事件发布的时候，这个方法就会被执行*/
    public void onEventMainThread(ItemListEvent event) {
        setListAdapter(new ArrayAdapter<Item>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, android.R.id.text1, event.getItems()));
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //发送事件，在ItemDetailFragment中会有订阅事件方法来接受这次的发布事件
        EventBus.getDefault().post(getListView().getItemAtPosition(position));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //注销
        EventBus.getDefault().unregister(this);
    }
}
