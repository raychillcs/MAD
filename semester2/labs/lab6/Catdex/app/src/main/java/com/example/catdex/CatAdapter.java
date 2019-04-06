package com.example.catdex;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView catTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catTextView = itemView.findViewById(R.id.textView);
            catTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    private List<Cat> mCats;

    public CatAdapter(List<Cat> cats, ListItemClickListener catClickListener){
        mCats = cats;
        itemClickListener = catClickListener;
    }

    @NonNull
    @Override
    public CatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View catView = inflater.inflate(R.layout.list_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(catView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatAdapter.ViewHolder viewHolder, int i) {
        Cat cat = mCats.get(i);
        viewHolder.catTextView.setText(cat.getName());
    }

    @Override
    public int getItemCount() {
        return mCats.size();
    }

    public interface ListItemClickListener{
        void onListItemClick(int position);
    }

    ListItemClickListener itemClickListener;
}
