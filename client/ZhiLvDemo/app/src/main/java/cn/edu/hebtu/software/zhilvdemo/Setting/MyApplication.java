package cn.edu.hebtu.software.zhilvdemo.Setting;

import android.app.Application;

/**
 * @ProjectName:    ZhiLv
 * @Description:    
 * @Author:         张璐婷
 * @CreateDate:     2020/12/29  20:10
 * @Version:        1.0
 */
public class MyApplication extends Application {
    private String topic;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
