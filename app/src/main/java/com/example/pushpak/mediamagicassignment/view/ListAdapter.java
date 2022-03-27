package com.example.pushpak.mediamagicassignment.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.pushpak.mediamagicassignment.R;
import com.example.pushpak.mediamagicassignment.databinding.AdapterListItemBinding;
import com.example.pushpak.mediamagicassignment.model.ModelClass;

import java.util.List;

/**
 * Created by Pushpak on 3/27/2022.
 */

class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder> {

    private Context context;
    private List<ModelClass> list;

    public ListAdapter(Context context, List<ModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = ((MainActivity) context).getLayoutInflater().inflate(R.layout.adapter_list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getLogo()).error(R.drawwable.error).override(100, 50).into(holder.imgView);
        holder.tvTitle.setText(list.get(position).getStationName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{

        private AppCompatImageView imgView;
        private AppCompatTextView tvTitle;

        public ItemViewHolder(View view) {
            super(view);
            init(view);
        }

        void init(View view){
            imgView = (AppCompatImageView) view.findViewById(R.id.imgView);
            tvTitle = (AppCompatTextView) view.findViewById(R.id.tvtTitle);
        }

    }

}
