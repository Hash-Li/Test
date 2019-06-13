package com.bulinbulin.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bulinbulin.test.adapter.RvAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;
    private ArrayList<String> dataList;
    private RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRvData();
        initRv();
    }

    private void initRv() {
        adapter = new RvAdapter(dataList);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(adapter);
    }

    private void initRvData() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add(i + "");
        }
    }


    @OnClick({R.id.bt_1, R.id.bt_2, R.id.bt_3, R.id.bt_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_1:
                break;
            case R.id.bt_2:
                break;
            case R.id.bt_3:
                break;
            case R.id.bt_4:
                break;
        }
        Intent intent = new Intent(this, BActivity.class);
        startActivity(intent);
    }
}
