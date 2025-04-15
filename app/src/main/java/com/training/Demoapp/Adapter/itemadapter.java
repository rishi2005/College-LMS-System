
package com.training.Demoapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.training.Demoapp.R;
import com.training.Demoapp.datamodel.Item;

import java.util.List;

public class itemadapter extends RecyclerView.Adapter<itemadapter.ViewHolder> {
    private List<Item> itemList;

    public itemadapter(List<Item> itemList){ this.itemList = itemList;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position){
        Item item= itemList.get(position);
        holder.textViewItem.setText(item.getText());
    }

    @Override
    public int getItemCount(){return itemList.size();}






    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewItem;

        public ViewHolder(View itemview){
            super(itemview);
            textViewItem = itemview.findViewById(R.id.txt_item);
        }
    }
}
