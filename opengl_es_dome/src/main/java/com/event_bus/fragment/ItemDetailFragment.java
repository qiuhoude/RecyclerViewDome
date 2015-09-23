package com.event_bus.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.event_bus.bean.Item;
import com.yunongtong.yunong.opengl_es_dome.R;

import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2015/8/18.
 */
public class ItemDetailFragment extends Fragment {

    private TextView tvDetail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册
        EventBus.getDefault().register(this);
    }

    public void onEventMainThread(Item item){
        if (item != null)
            tvDetail.setText(item.getContent());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate( R.layout.fragment_item_detail,container,false);
        tvDetail = (TextView) rootView.findViewById(R.id.item_detail);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //注销
        EventBus.getDefault().unregister(this);
    }
}
