package com.w3e.nixonok.androidbasicsassignment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Nixonok on 2/15/2018.
 */

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder> {

    private List<Item> list;
    private Context context;

    public RecyclerViewAdaptor(List<Item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdaptor.ViewHolder holder, final int position) {
        final Item myList = list.get(position);

        holder.imageView.setImageResource(myList.getImage());
        holder.textViewHead.setText(myList.getTitle());
        holder.textViewDesc.setText(myList.getDescription());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPosition(position);

                Intent intent = new Intent( v.getContext() , Main2Activity.class);
                intent.putExtra("name", myList.getTitle());
                intent.putExtra("position", myList.getDescription());
                v.getContext().startActivity(intent);
            }

            private void showPosition(int position) {

                Toast.makeText(context,  myList.getTitle() +"\n" + myList.getDescription(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public int getItemCount() {

        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);


            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
        }
    }
}