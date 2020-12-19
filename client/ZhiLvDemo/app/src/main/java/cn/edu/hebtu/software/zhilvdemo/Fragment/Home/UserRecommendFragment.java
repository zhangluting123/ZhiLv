package cn.edu.hebtu.software.zhilvdemo.Fragment.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.edu.hebtu.software.zhilvdemo.Adapter.MyAttentionListAdapter;
import cn.edu.hebtu.software.zhilvdemo.Adapter.TravelsMineAdapter;
import cn.edu.hebtu.software.zhilvdemo.R;

/**
 * @ProjectName:    ZhiLv
 * @Description:    用户推荐
 * @Author:         张璐婷
 * @CreateDate:     2020/12/18 21:37
 * @Version:        1.0
 */
public class UserRecommendFragment extends Fragment {
    private List<String> mDatas;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(null == view){
            view = inflater.inflate(R.layout.fragment_user_recommend, container, false);
            initData();
            initView();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if(null != parent){
            parent.removeView(view);
        }

        return view;
    }

    private void initData(){
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 50; i++)
        {
            mDatas.add( "userRecommend -> " + i);
        }
    }

    private void initView(){
        RecyclerView rl = view.findViewById(R.id.user_recommend_recycler);

        //纵向列表
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        rl.setLayoutManager(manager);
        //设置适配器
        Log.i("UserRecommendPManager", getParentFragment()+"");
        MyAttentionListAdapter adapter = new MyAttentionListAdapter(getActivity(), R.layout.item_my_fans_list, mDatas);
        adapter.setOnItemClickListener(new MyAttentionListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity().getApplicationContext(), "User-Recommend-" + mDatas.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        rl.setAdapter(adapter);
    }

}