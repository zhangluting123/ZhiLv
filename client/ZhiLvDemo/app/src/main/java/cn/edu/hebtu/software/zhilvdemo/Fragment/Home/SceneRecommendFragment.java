package cn.edu.hebtu.software.zhilvdemo.Fragment.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.hebtu.software.zhilvdemo.R;

/**
 * @ProjectName:    ZhiLv
 * @Description:    景点推荐
 * @Author:         张璐婷
 * @CreateDate:     2020/12/18 21:32
 * @Version:        1.0
 */
public class SceneRecommendFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scene_recommend, container, false);
        return view;
    }
}