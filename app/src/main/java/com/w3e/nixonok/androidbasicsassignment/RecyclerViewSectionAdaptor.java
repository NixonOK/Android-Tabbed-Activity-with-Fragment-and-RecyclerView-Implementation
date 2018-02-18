package com.w3e.nixonok.androidbasicsassignment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nixonok on 2/15/2018.
 */

public class RecyclerViewSectionAdaptor extends RecyclerView.Adapter<RecyclerViewSectionAdaptor.ViewHolder> {

    private ArrayList<Section> sectionArrayList;
    private Context context;

    public RecyclerViewSectionAdaptor(ArrayList<Section> sectionArrayList, Context context) {
        this.sectionArrayList = sectionArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.label, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewSectionAdaptor.ViewHolder holder, final int position) {
        Section myList = sectionArrayList.get(position);

        holder.label.setText(myList.getTitle());
        //recycler view for items
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerViewAdaptor adapter = new RecyclerViewAdaptor(myList.getItem(), context);
        holder.recyclerView.setAdapter(adapter);

    }


    @Override
    public int getItemCount() {

        return sectionArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView recyclerView;
        private TextView label;

        public ViewHolder(View itemView) {
            super(itemView);


            recyclerView = (RecyclerView) itemView.findViewById(R.id.item_recycler_view);
            label = (TextView) itemView.findViewById(R.id.label);
        }
    }
}