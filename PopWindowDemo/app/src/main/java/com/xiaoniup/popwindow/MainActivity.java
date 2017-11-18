package com.xiaoniup.popwindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private List<String> mList = new ArrayList<>();
    private Button mBtn;
    private Button mBtn2;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initPopupWindow();

        mBtn = (Button) findViewById(R.id.main_click_btn);
        mBtn2 = (Button) findViewById(R.id.main_click_btn2);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                popupWindow.showAsDropDown(mBtn2, 0, 0);
                popupWindow.showAsDropDown(view);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.showAtLocation(view, Gravity.RIGHT | Gravity.BOTTOM, 0, 0);
            }
        });
    }

    private void initData(){
        for (int i=0; i<20; i++){
            mList.add("浪里个浪_" + i);
        }
    }

    private void initPopupWindow(){
        final View popView = LayoutInflater.from(this).inflate(R.layout.layout_popupwindow, null);
        ListView listView = (ListView) popView.findViewById(R.id.popup_window_lv);
        listView.setAdapter(new PopuoWindowAdapter(this, mList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, mList.get(position), Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            }
        });

        //view,宽，高，是否获取焦点
        popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT,200, true);
        //设置背景图片
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
        popupWindow.setOutsideTouchable(false);
        popupWindow.isShowing();
//        popupWindow.showAsDropDown(mBtn, 0, 0);


    }
}
