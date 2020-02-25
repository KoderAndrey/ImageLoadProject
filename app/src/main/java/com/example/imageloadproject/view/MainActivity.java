package com.example.imageloadproject.view;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.ViewModelProvider;

import com.example.imageloadproject.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends DaggerAppCompatActivity {

    private ImageLoadViewModel mViewModel;

    @Inject
    protected ViewModelProvider.Factory mViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(ImageLoadViewModel.class);
        mViewModel.getImage("cat")
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}
