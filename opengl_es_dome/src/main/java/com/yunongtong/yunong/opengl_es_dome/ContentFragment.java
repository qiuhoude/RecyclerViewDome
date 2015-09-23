package com.yunongtong.yunong.opengl_es_dome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/7/7.
 */
public class ContentFragment extends Fragment {

    private final static String KEY_TITLE ="key_title";

    private String mTitle;

    public static ContentFragment newInstance(String title){
        ContentFragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.theme_content_layout, container, false);
        TextView tv = (TextView) view.findViewById(R.id.key_title);
        String title = (String) getArguments().get(KEY_TITLE);
        if (!TextUtils.isEmpty(title))
        {
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(40);
            tv.setText(title);
        }

        return view;
    }
}
