package com.guy.class22b_and_7;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity activity;
    private ArrayList<Item> items = new ArrayList<>();

    public ItemAdapter(Activity activity, ArrayList<Item> items){
        this.activity = activity;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("pttt", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_trip, parent, false);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Log.d("pttt", "onBindViewHolder= " + position);
        final ItemHolder holder = (ItemHolder) viewHolder;
        Item item = items.get(position);

        holder.index.setText("" + position);
        holder.name.setText(item.getName());

        if (item.isSelected()) {
            holder.name.setTextColor(Color.RED);
        } else {
            holder.name.setTextColor(Color.DKGRAY);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    class ItemHolder extends RecyclerView.ViewHolder {

        private MaterialTextView index;
        private MaterialTextView name;

        public ItemHolder(View itemView) {
            super(itemView);
            index = itemView.findViewById(R.id.index);
            name = itemView.findViewById(R.id.name);
        }

    }
}