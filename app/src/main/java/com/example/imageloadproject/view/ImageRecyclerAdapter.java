package com.example.imageloadproject.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.imageloadproject.R;
import com.example.imageloadproject.domain.model.ImageModel;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class ImageRecyclerAdapter extends RealmRecyclerViewAdapter<ImageModel, ImageRecyclerAdapter.ImageViewHolder> {


    ImageRecyclerAdapter(OrderedRealmCollection<ImageModel> data) {
        super(data, true);
        setHasStableIds(true);
    }


    @NotNull
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
       holder.bind(getItem(position));
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView urlTextView;
        TextView nameTextView;

        ImageViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            urlTextView = view.findViewById(R.id.url_image);
            nameTextView = view.findViewById(R.id.name_image);
        }

        void bind(ImageModel model){
            urlTextView.setText(model.getUrl());
            nameTextView.setText(model.getName());
        }
    }
}