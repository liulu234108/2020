package com.study.view.own;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.study.R;
import com.study.model.bean.MineBean;

import java.util.ArrayList;
import java.util.List;

public class Mine_Recyadapter extends RecyclerView.Adapter<Mine_Recyadapter.MyViewHolder> {
   private List<MineBean> datas=new ArrayList<>();
   private Context basecontext;

    public Mine_Recyadapter(Context basecontext) {
        this.basecontext = basecontext;
    }

    public List<MineBean> getDatas() {
        return datas;
    }

    public void setDatas(List<MineBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(basecontext).inflate(R.layout.item_mineadapter, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(basecontext).load(datas.get(position).getImg()).into(holder.img);
        holder.text.setText(datas.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.mine_imga);
            text = itemView.findViewById(R.id.mine_texta);
        }
    }
}
