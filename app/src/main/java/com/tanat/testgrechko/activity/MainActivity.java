package com.tanat.testgrechko.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.tanat.testgrechko.R;
import com.tanat.testgrechko.adapter.ExpandableAdapter;
import com.tanat.testgrechko.loader.DataLoader;
import com.tanat.testgrechko.model.Example;
import com.tanat.testgrechko.model.PlaceGroup;
import com.tanat.testgrechko.model.PlaceGroupSchema;
import com.tanat.testgrechko.model.PlaceUnion;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private LinearLayout loadingLayout;
    private LinearLayout errorLayout;
    private Button refreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        loadData();
    }

    private void initView(){
        listView = findViewById(R.id.listView);
        loadingLayout = findViewById(R.id.loadingLayout);
        errorLayout = findViewById(R.id.errorLayout);
        refreshButton = findViewById(R.id.refreshButton);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
            }
        });
    }

    private void loadData(){
        errorLayout.setVisibility(View.GONE);
        loadingLayout.setVisibility(View.VISIBLE);
        Bundle args = new Bundle();
        getSupportLoaderManager().restartLoader(0, args, exampleLoaderCallbacks);
    }

    private LoaderManager.LoaderCallbacks<Example> exampleLoaderCallbacks = new LoaderManager
            .LoaderCallbacks<Example>() {

        @Override
        public Loader<Example> onCreateLoader(int id, Bundle args) {
            return new DataLoader(MainActivity.this, args);
        }

        @Override
        public void onLoadFinished(Loader<Example> loader, Example example) {
            loadingLayout.setVisibility(View.GONE);
            if (example == null) {
                errorLayout.setVisibility(View.VISIBLE);
            } else {
                List<PlaceGroupSchema> list = new ArrayList<>();

                for (PlaceUnion placeUnion : example.getPlaceUnions()) {
                    for (PlaceGroup placeGroup : placeUnion.getPlaceGroups()) {
                        list.addAll(placeGroup.getPlaceGroupSchemas());
                    }
                }

                createList(list);
            }
        }

        @Override
        public void onLoaderReset(@NonNull Loader<Example> loader) {

        }
    };

    private void createList(List groupSchemaList) {
        ExpandableAdapter adapter = new ExpandableAdapter(MainActivity.this, groupSchemaList);
        listView.setAdapter(adapter);
    }
}
