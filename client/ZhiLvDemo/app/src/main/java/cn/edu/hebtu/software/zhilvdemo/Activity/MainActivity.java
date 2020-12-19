package cn.edu.hebtu.software.zhilvdemo.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;
import cn.edu.hebtu.software.zhilvdemo.Fragment.AddTravelsFragment;
import cn.edu.hebtu.software.zhilvdemo.Fragment.DestinationFragment;
import cn.edu.hebtu.software.zhilvdemo.Fragment.HomeFragment;
import cn.edu.hebtu.software.zhilvdemo.Fragment.MessageFragment;
import cn.edu.hebtu.software.zhilvdemo.Fragment.MineFragment;
import cn.edu.hebtu.software.zhilvdemo.R;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:    ZhiLv
 * @Description:    主界面
 * @Author:         张璐婷
 * @CreateDate:     2020/12/13 18:12
 * @Version:        1.0
 */
public class MainActivity extends AppCompatActivity {
    private long exitTime;
    private final Map<String, ImageView> imageViewMap = new HashMap<>();
    private final Map<String, TextView> textViewMap = new HashMap<>();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTabHost fragmentTabHost = findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this,
                getSupportFragmentManager(),//FragmentManager对象用来管理多个Fragment
                android.R.id.tabcontent);//真正显示内容页面的容器的id

        //主页
        TabHost.TabSpec home = fragmentTabHost.newTabSpec("home")
                .setIndicator(getTabSpecView("home",R.mipmap.home1,"主页"));
        fragmentTabHost.addTab(home, HomeFragment.class, null);
        //目的地
        TabHost.TabSpec destination = fragmentTabHost.newTabSpec("destination")
                .setIndicator(getTabSpecView("destination",R.mipmap.destination1,"目的地"));
        fragmentTabHost.addTab(destination, DestinationFragment.class, null);
        //添加
        TabHost.TabSpec addTravels = fragmentTabHost.newTabSpec("addTravels")
                .setIndicator(getAddView("addTravels",R.mipmap.add_travels));
        fragmentTabHost.addTab(addTravels, AddTravelsFragment.class,null);
        //消息
        TabHost.TabSpec message = fragmentTabHost.newTabSpec("message")
                .setIndicator(getTabSpecView("message",R.mipmap.message1,"消息"));
        fragmentTabHost.addTab(message, MessageFragment.class, null);

        //我的
        TabHost.TabSpec mine = fragmentTabHost.newTabSpec("mine")
                .setIndicator(getTabSpecView("mine",R.mipmap.mine1,"我的"));
        fragmentTabHost.addTab(mine, MineFragment.class, null);
        //默认选中第一项
//        int tab = 0;
        fragmentTabHost.setCurrentTab(0);
        imageViewMap.get("home").setImageResource(R.mipmap.home2);
        textViewMap.get("home").setTextColor(getResources().getColor(R.color.MyThemeColor));
//        switch (tab){
//            case 0:
//                imageViewMap.get("home").setImageResource(R.mipmap.home2);
//                textViewMap.get("home").setTextColor(getResources().getColor(R.color.MyThemeColor));
//                break;
//            case 1:
//                imageViewMap.get("destination").setImageResource(R.mipmap.destination2);
//                textViewMap.get("destination").setTextColor(getResources().getColor(R.color.MyThemeColor));
//                break;
//            case 3:
//                imageViewMap.get("message").setImageResource(R.mipmap.message2);
//                textViewMap.get("message").setTextColor(getResources().getColor(R.color.MyThemeColor));
//                break;
//            case 4:
//                imageViewMap.get("mine").setImageResource(R.mipmap.mine2);
//                textViewMap.get("mine").setTextColor(getResources().getColor(R.color.MyThemeColor));
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + tab);
//        }


        //切换选项卡的事件监听器
        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                switch (tabId){
                    case "home":
                        imageViewMap.get("home").setImageResource(R.mipmap.home2);
                        imageViewMap.get("destination").setImageResource(R.mipmap.destination1);
                        imageViewMap.get("message").setImageResource(R.mipmap.message1);
                        imageViewMap.get("mine").setImageResource(R.mipmap.mine1);
                        textViewMap.get("home").setTextColor(getResources().getColor(R.color.MyThemeColor));
                        textViewMap.get("destination").setTextColor(Color.BLACK);
                        textViewMap.get("message").setTextColor(Color.BLACK);
                        textViewMap.get("mine").setTextColor(Color.BLACK);
                        break;
                    case "destination":
                        imageViewMap.get("home").setImageResource(R.mipmap.home1);
                        imageViewMap.get("destination").setImageResource(R.mipmap.destination2);
                        imageViewMap.get("message").setImageResource(R.mipmap.message1);
                        imageViewMap.get("mine").setImageResource(R.mipmap.mine1);
                        textViewMap.get("home").setTextColor(Color.BLACK);
                        textViewMap.get("destination").setTextColor(getResources().getColor(R.color.MyThemeColor));
                        textViewMap.get("message").setTextColor(Color.BLACK);
                        textViewMap.get("mine").setTextColor(Color.BLACK);
                        break;
                    case "message":
                        imageViewMap.get("home").setImageResource(R.mipmap.home1);
                        imageViewMap.get("destination").setImageResource(R.mipmap.destination1);
                        imageViewMap.get("message").setImageResource(R.mipmap.message2);
                        imageViewMap.get("mine").setImageResource(R.mipmap.mine1);
                        textViewMap.get("home").setTextColor(Color.BLACK);
                        textViewMap.get("destination").setTextColor(Color.BLACK);
                        textViewMap.get("message").setTextColor(getResources().getColor(R.color.MyThemeColor));
                        textViewMap.get("mine").setTextColor(Color.BLACK);
                        break;
                    case "mine":
                        imageViewMap.get("home").setImageResource(R.mipmap.home1);
                        imageViewMap.get("destination").setImageResource(R.mipmap.destination1);
                        imageViewMap.get("message").setImageResource(R.mipmap.message1);
                        imageViewMap.get("mine").setImageResource(R.mipmap.mine2);
                        textViewMap.get("home").setTextColor(Color.BLACK);
                        textViewMap.get("destination").setTextColor(Color.BLACK);
                        textViewMap.get("message").setTextColor(Color.BLACK);
                        textViewMap.get("mine").setTextColor(getResources().getColor(R.color.MyThemeColor));
                        break;
                }
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private View getTabSpecView(String tag, int imageResId, String title) {
        LayoutInflater layoutInflater = getLayoutInflater();
        @SuppressLint("InflateParams") 
        View view = layoutInflater.inflate(R.layout.tabspec_layout,null);

        //获取控件对象
        ImageView imageView = view.findViewById(R.id.iv_icon);
        imageView.setImageResource(imageResId);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(40, 40);
        imageView.setLayoutParams(lp);

        TextView textView = view.findViewById(R.id.tv_icon);
        textView.setText(title);

        imageViewMap.put(tag,imageView);
        textViewMap.put(tag,textView);
        return view;
    }

    private View getAddView(String tag, int imageResId){
        LayoutInflater layoutInflater = getLayoutInflater();
        @SuppressLint("InflateParams")
        View view = layoutInflater.inflate(R.layout.tabspec_layout,null);
        //获取控件对象
        ImageView imageView = view.findViewById(R.id.iv_icon);
        imageView.setImageResource(imageResId);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(80, 80);
        imageView.setLayoutParams(lp);

        imageViewMap.put(tag,imageView);
        return view;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断用户是否点击了返回键
        if(keyCode == KeyEvent.KEYCODE_BACK ){
            //获取当前时间毫秒数
            if(System.currentTimeMillis()-exitTime>2000){
                Toast.makeText(this,"再次点击退出程序",Toast.LENGTH_LONG).show();
                exitTime=System.currentTimeMillis();
            }else{
                this.finish();
            }
        }
        return true;
    }
}