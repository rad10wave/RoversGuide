package com.example.roversguide2;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    List<Model> my_list;
    Context context;
    private String[] stitles;
    private String[] scontents;
    private String[] shead;
    private String[] ccontent;

    public CustomAdapter(List<Model> my_list, Context context,String titles[],String content[], String sHead[], String cContent[]) {
        this.my_list = my_list;
        this.context = context;
        this.stitles=titles;
        this.shead=sHead;
        this.scontents=content;
        this.ccontent=cContent;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        Model model=my_list.get(i);
        String name=stitles[i];
        holder.state.setText(model.getState_name());

        holder.image.setImageDrawable(context.getResources().getDrawable(model.getImage()));


    }

    @Override
    public int getItemCount() {
        return my_list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView state;
        RelativeLayout relative;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView);
            state=itemView.findViewById(R.id.stateName);
            relative=itemView.findViewById(R.id.relative);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                Intent i=new Intent(v.getContext(),DetailsActivity.class);
                i.putExtra("titleOfState",stitles[getAdapterPosition()]);
                i.putExtra("contentOfState",scontents[getAdapterPosition()]);
                i.putExtra("cityHead",shead[getAdapterPosition()]);
                i.putExtra("cityContent",ccontent[getAdapterPosition()]);
                v.getContext().startActivity(i);
                }
            });


        }
    }
    public void setSearchOperation(List<Model> newList){
        my_list=new ArrayList<>();
        my_list.addAll(newList);
        notifyDataSetChanged();;
    }
}
