package com.example.uibestpractice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.uibestpractice.adapter.MsgAdapter;
import com.example.uibestpractice.entity.Msg;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	private ListView msgListView;
	private EditText inputText;
	private Button send;

	private MsgAdapter adapter;

	private List<Msg> msgList = new ArrayList<Msg>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initMsgs(); // 初始化消息数据
		adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);

		inputText = (EditText) findViewById(R.id.input_text);
		send = (Button) findViewById(R.id.send);
		msgListView = (ListView) findViewById(R.id.msg_list_view);
		msgListView.setAdapter(adapter);
		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				String content = inputText.getText().toString();
				if (content != null && !"".equals(content)) {
					Msg msg = new Msg(content, Msg.TYPE_SENT);
					msgList.add(msg);
					adapter.notifyDataSetChanged(); // 当有新消息时刷新ListView
					msgListView.setSelection(msgList.size()); // 将ListView定位到最后一行
					inputText.setText(""); // 清空输入框中的内容
				}
			}
		});
	}

	private void initMsgs() {

		Msg msg1 = new Msg("你好，家伙！", Msg.TYPE_RECEIVED);
		msgList.add(msg1);
		Msg msg2 = new Msg("你好，你是谁？", Msg.TYPE_SENT);
		msgList.add(msg2);
		Msg msg3 = new Msg("我是汤姆，很高兴认识你。", Msg.TYPE_RECEIVED);
		msgList.add(msg3);
		Msg msg4 = new Msg("我是杰克，也很高兴认识你。", Msg.TYPE_SENT);
		msgList.add(msg4);
	}
}
