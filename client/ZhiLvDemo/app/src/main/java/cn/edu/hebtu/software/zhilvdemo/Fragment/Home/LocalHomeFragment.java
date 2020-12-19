package cn.edu.hebtu.software.zhilvdemo.Fragment.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.edu.hebtu.software.zhilvdemo.Adapter.TravelsMineAdapter;
import cn.edu.hebtu.software.zhilvdemo.R;

/**
 * @ProjectName:    ZhiLv
 * @Description:    同城
 * @Author:         张璐婷
 * @CreateDate:     2020/12/18  19:48
 * @Version:        1.0
 */
public class LocalHomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<String> mDatas = new ArrayList<String>();
    private String mTitle = "Defaut Value";
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(null == view){
            view = inflater.inflate(R.layout.fragment_local_home,container,false);
            mRecyclerView = view.findViewById(R.id.hhh);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            for (int i = 0; i < 50; i++)
            {
                mDatas.add(mTitle + " -> " + i);
            }
            TravelsMineAdapter adapter= new TravelsMineAdapter(getActivity(), R.layout.item_video_mine, mDatas);
            mRecyclerView.setAdapter(adapter);
        }

        return view;
    }
}
