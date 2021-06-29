package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

        private ArrayList<ExampleItem> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        /**
         * constructor of example view holder that we created first on be for implement the method
         * and after that we passed <ExampleAdapter.ExampleViewHolder> to the parent class and
         * then we implement the required methods.
         **/
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageview);
            mTextView1 = itemView.findViewById(R.id.textview1);
            mTextView2 = itemView.findViewById(R.id.textview2);
        }
    }

    /**
     * we create ExampleAdapter constructor
     * @param exampleList
     */
    public ExampleAdapter (ArrayList <ExampleItem> exampleList){
        exampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
         * here we create the data for viewHolder and pass layout that contain recycle view
         * after that create new object of ExampleViewHolder class named evh >> and return it .
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item , parent , false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return null!= mExampleList?mExampleList.size():0;
    }
}
