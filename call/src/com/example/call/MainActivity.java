package com.example.call;

/**
 * 进一步简化一下测试代码
 * 在封装一层
 */
import intent.TestIntentOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import senddatebetweenactivity.OneActivity;
import activity.StudyActivityLifeOne;
import adapter.AdapterSimpleAdapter;
import adapter.ListArrayAdapter;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import app.login.ui.LoginLogin;
import app.login.ui.WeiXinLogin;
import event.ButtonOnClickEvent;
import event.LaunchMadeSingTop;
import event.LearnActivityLaunchMade;
import event.LearnSaveStateActivity;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		List<Map<String, Object>> data = this.getData(); // 调用方法得到资源文件
		setListAdapter(new SimpleAdapter(this, data,
				android.R.layout.simple_list_item_1, // 实列化适配器
				new String[] { "title" }, new int[] { android.R.id.text1 }));
		
		setSelection(data.size()-1);  //设置进入时光标处于最底部
	}

	protected List<Map<String, Object>> getData() { // 封装添加资源方法
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>(); // 用来保存数据源
		addItem(data, "布局管理器学习", LayoutMainActivity.class); // 调用方法，添加第一个元素
		addItem(data, "微信登录界面", WeiXinLogin.class);
		addItem(data, "事件处理", ButtonOnClickEvent.class);
		addItem(data, "控件学习", WiagetMainActivity.class);
		addItem(data, "Activity生命周期学习", StudyActivityLifeOne.class);
		addItem(data, "SaveState状态保存", LearnSaveStateActivity.class);
		addItem(data, "Activity的启动模式之标准模式->单实例", LearnActivityLaunchMade.class);
		addItem(data, "Activity的启动模式之单顶模式->单任务", LaunchMadeSingTop.class);
		addItem(data, "LoginLogin", LoginLogin.class);
		addItem(data, "Activity之间的参数传递", OneActivity.class);
		addItem(data, "Intent学习", TestIntentOne.class);
		addItem(data, "ArrayAdapter学习", ListArrayAdapter.class);
		addItem(data, "SimpleAdapter学习", AdapterSimpleAdapter.class);
		return data;
	}

	protected void addItem(List<Map<String, Object>> data, String name,
			Class<?> c) { // 封装Intent
		addItem(data, name, new Intent(this, c));
	}

	protected void addItem(List<Map<String, Object>> data, String name,
			Intent intent) { // 向数据源中添加内容的方法
		Map<String, Object> temp = new HashMap<String, Object>(); // 实列化集合对象
		temp.put("title", name); // 向集合中添加元素
		temp.put("intent", intent);
		data.add(temp); // 向数据源中添加元素
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>) l
				.getItemAtPosition(position);
		Intent intent = (Intent) map.get("intent");
		startActivity(intent);
	}
}
