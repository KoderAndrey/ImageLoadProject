package com.example.imageloadproject.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imageloadproject.databinding.ItemImageBinding;
import com.example.imageloadproject.domain.model.ImageModel;

import org.jetbrains.annotations.NotNull;

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
        ItemImageBinding binding = ItemImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ImageViewHolder(binding);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        ItemImageBinding mBinding;

        ImageViewHolder(ItemImageBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(ImageModel model) {
            mBinding.setImageModel(model);
            Glide.with(mBinding.getRoot()).load(model.getUrl()).into(mBinding.image);
        }
    }
}