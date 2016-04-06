package com.example.nataliia.finalproject_deshkonataliia;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private int[] mImageSet;
    private int[] mCaptionSet;
    private View.OnClickListener[] onClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.recycler_image_view);
            mTextView = (TextView) v.findViewById(R.id.recycler_text_view);
        }
    }

    public RecyclerViewAdapter(int[] imageSet, int[] captionSet, View.OnClickListener[] onClickListener) {
        mImageSet = imageSet;
        mCaptionSet = captionSet;
        this.onClickListener = onClickListener;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
        inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImageView.setImageResource(mImageSet[position]);
        holder.mImageView.setOnClickListener(onClickListener[position]);
        holder.mTextView.setText(mCaptionSet[position]);
        holder.mTextView.setOnClickListener(onClickListener[position]);
    }

    @Override
    public int getItemCount() {
        return mImageSet.length;
    }
}
