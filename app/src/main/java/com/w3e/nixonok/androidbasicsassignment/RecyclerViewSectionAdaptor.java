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
 * Created by Sudarshan on 2/15/2018.
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


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPosition(position);
            }

            private void showPosition(int position) {
                Toast.makeText(context, "Clicked and Position is " + position, Toast.LENGTH_SHORT).show();

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            private void showPositionx(int position) {
                Toast.makeText(context, "Long Clicked and Position is " + position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public boolean onLongClick(View v) {
                showPositionx(position);
                return true;
            }

        });

//
//        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                //creating a popup menu
////                PopupMenu popup = new PopupMenu(context, holder.buttonViewOption);
////                //inflating menu from xml resource
////                popup.inflate(R.menu.options_menu);
////                //adding click listener
////                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
////                    @Override
////                    public boolean onMenuItemClick(MenuItem item) {
////                        switch (item.getItemId()) {
////                            case R.id.menu1:
////                                //handle menu1 click
////                                Toast.makeText(context, "menu 1", Toast.LENGTH_SHORT).show();
////                                break;
////                            case R.id.menu2:
////
////                                Toast.makeText(context, "menu 2", Toast.LENGTH_SHORT).show();
////                                //handle menu2 click
////                                break;
////                            case R.id.menu3:
////                                //handle menu3 click
////                                break;
////                        }
////                        return false;
////                    }
////                });
////                //displaying the popup
////                popup.show();
//
//            }
//        });
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