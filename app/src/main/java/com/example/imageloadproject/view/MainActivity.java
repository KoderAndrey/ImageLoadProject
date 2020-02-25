package com.example.imageloadproject.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imageloadproject.R;
import com.example.imageloadproject.domain.model.ImageModel;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.RealmChangeListener;
import io.realm.RealmList;
import io.realm.RealmResults;

public class MainActivity extends DaggerAppCompatActivity {

    private ImageLoadViewModel mViewModel;

    @Inject
    protected ViewModelProvider.Factory mViewModelFactory;

    private ImageRecyclerAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(ImageLoadViewModel.class);
        setObservers();
        mViewModel.getListModelImage();
        findViewById(R.id.search_button).setOnClickListener(v -> mViewModel
                .getImage(((EditText) findViewById(R.id.search_field))
                        .getText().toString()));
        mRecyclerView = findViewById(R.id.recycler_view);
    }

    private void setObservers(){
        mViewModel.getImageModelsEvent().observe(this, imageModels -> {
            mAdapter = new ImageRecyclerAdapter(imageModels);
            mRecyclerView.setAdapter(mAdapter);
            Log.i("test_test", "list " + imageModels);
        });
    }
}
