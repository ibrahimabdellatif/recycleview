package com.example.recycleview;

import android.provider.ContactsContract;
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
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void OnItemClick(int position);
        void OnDeleteClick(int position);
    }

    //this method will called in main method
    public void setOnClickListener(OnItemClickListener listener) {
        mListener = listener;

    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public ImageView mDelete;
        /**
         * constructor of example view holder that we created first on be for implement the method
         * and after that we passed <ExampleAdapter.ExampleViewHolder> to the parent class and
         * then we implement the required methods.
         **/
        public ExampleViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageview);
            mTextView1 = itemView.findViewById(R.id.textview1);
            mTextView2 = itemView.findViewById(R.id.textview2);
            mDelete = itemView.findViewById(R.id.image_delete);

            /**
             * so when click on itemView it will change the status of item
             */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // because the class is static we can't access interface directly here so we pass it to constructor
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
            mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.OnDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    /**
     * we create ExampleAdapter constructor
     *
     * @param exampleList
     */
    public ExampleAdapter(ArrayList<ExampleItem> exampleList) {
        // the error it was here
        this.mExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
         * here we create the data for viewHolder and pass layout that contain recycle view
         * after that create new object of ExampleViewHolder class named evh >> and return it .
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
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
        return mExampleList.size();
    }
}
