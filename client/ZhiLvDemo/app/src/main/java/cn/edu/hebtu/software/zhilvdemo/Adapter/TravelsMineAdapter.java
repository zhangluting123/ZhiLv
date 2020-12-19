package cn.edu.hebtu.software.zhilvdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.edu.hebtu.software.zhilvdemo.R;

/**
 * @ProjectName:    ZhiLv
 * @Description:    我的游记适配器
 * @Author:         张璐婷
 * @CreateDate:     2020/12/14$ 15:57$
 * @Version:        1.0
 */
public class TravelsMineAdapter extends RecyclerView.Adapter<TravelsMineAdapter.ViewHolder> {
    private Context context;
    private int itemLayout;
    private List<String> mDatas = new ArrayList<String>();

    public TravelsMineAdapter(Context context, int itemLayout, List<String> mDatas) {
        this.context = context;
        this.itemLayout = itemLayout;
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public TravelsMineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(itemLayout, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelsMineAdapter.ViewHolder holder, int position) {
        holder.item_tv.setText(mDatas.get(position));

    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView item_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_tv = itemView.findViewById(R.id.id_info);
        }
    }

}





