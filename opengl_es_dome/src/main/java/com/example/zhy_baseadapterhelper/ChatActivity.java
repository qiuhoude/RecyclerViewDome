package com.example.zhy_baseadapterhelper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.MultiItemTypeSupport;
import com.joanzapata.android.QuickAdapter;
import com.yunongtong.yunong.opengl_es_dome.R;
import com.zhy.bean.ChatMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ChatActivity extends Activity
{

	private ListView mListView;
	private ArrayList<ChatMessage> mDatas = new ArrayList<ChatMessage>();

	private QuickAdapter<ChatMessage> mAdapter;



	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_adapter);

		mListView = (ListView) findViewById(R.id.id_lv_main);
		
		MultiItemTypeSupport<ChatMessage> multiItemTypeSupport = new MultiItemTypeSupport<ChatMessage>()
		{
			@Override
			public int getLayoutId(int position, ChatMessage msg)
			{
				if (msg.isComMeg())
				{
					return R.layout.main_chat_from_msg;
				}
				return R.layout.main_chat_send_msg;
			}

			@Override
			public int getViewTypeCount()
			{
				return 2;
			}

			@Override
			public int getItemViewType(int postion, ChatMessage msg)
			{
				if (msg.isComMeg())
				{
					return ChatMessage.RECIEVE_MSG;
				}
				return ChatMessage.SEND_MSG;
			}
		};

		initDatas();

		
		mAdapter = new QuickAdapter<ChatMessage>(ChatActivity.this, mDatas,
				multiItemTypeSupport)
		{
			@Override
			protected void convert(BaseAdapterHelper helper, ChatMessage item)
			{
				switch (helper.layoutId)
				{
				case R.layout.main_chat_from_msg:
					helper.setText(R.id.chat_from_content, item.getContent());
					helper.setText(R.id.chat_from_name, item.getName());
					helper.setImageResource(R.id.chat_from_icon, item.getIcon());
					break;
				case R.layout.main_chat_send_msg:
					helper.setText(R.id.chat_send_content, item.getContent());
					helper.setText(R.id.chat_send_name, item.getName());
					helper.setImageResource(R.id.chat_send_icon, item.getIcon());
					break;
				}

			}
		};
//		mAdapter.showIndeterminateProgress(true);
		// 设置适配器
		mListView.setAdapter(mAdapter);

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						mAdapter.add(new ChatMessage(R.drawable.xiaohei, "xiaohei", "hello ",
								new Date().toString(), true	));
						mAdapter.notifyDataSetChanged();
					}
				});
			}
		},5000);


	}

	private void initDatas()
	{
		ChatMessage msg = null;
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
				null, true);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
				null, true);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);

		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
				null, true);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
				null, true);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
				null, true);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
				null, true);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
				null, true);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
				null, true);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
				null, true);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.renma, "renma", "where are you ",
				null, true);
		mDatas.add(msg);
		msg = new ChatMessage(R.drawable.xiaohei, "xiaohei", "where are you ",
				null, false);
		mDatas.add(msg);
	}

}
