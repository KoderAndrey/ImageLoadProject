package com.example.imageloadproject.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.imageloadproject.R;
import com.example.imageloadproject.databinding.ActivityMainBinding;
import com.example.imageloadproject.util.AlertUtil;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    private ImageLoadViewModel mViewModel;

    @Inject
    protected ViewModelProvider.Factory mViewModelFactory;

    private ImageRecyclerAdapter mAdapter;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(ImageLoadViewModel.class);
        mBinding.setViewModel(mViewModel);
        setObservers();
        mViewModel.getListModelImage();
    }

    private void setObservers() {
        mViewModel.getImageModelsEvent().observe(this, imageModels -> {
            mAdapter = new ImageRecyclerAdapter(imageModels);
            mBinding.recyclerView.setAdapter(mAdapter);
        });
        mViewModel.getError().observe(this, throwable -> {
            AlertUtil.showErrorDialog(this, throwable.getMessage());
        });
    }
}
