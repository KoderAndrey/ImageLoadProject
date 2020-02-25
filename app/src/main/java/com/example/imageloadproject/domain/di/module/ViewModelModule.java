package com.example.imageloadproject.domain.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.imageloadproject.domain.ViewModelFactory;
import com.example.imageloadproject.domain.ViewModelKey;
import com.example.imageloadproject.view.ImageLoadViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ImageLoadViewModel.class)
    abstract ViewModel bindAuthViewModel(ImageLoadViewModel viewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
