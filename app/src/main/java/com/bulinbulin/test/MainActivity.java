package com.bulinbulin.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bulinbulin.test.adapter.RvAdapter;
import com.bulinbulin.test.utils.SingleClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 */
public class MainActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    @BindView(R.id.bt_1)
    Button bt1;
    private ArrayList<String> dateList;
    private RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRvData();
        initRv();
        bt1.setOnClickListener(new View.OnClickListener() {
            // 如果需要自定义点击时间间隔，自行传入毫秒值即可
            // @SingleClick(2000)
            @SingleClick
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initRv() {
        System.out.println("");
        rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        adapter = new RvAdapter(dateList);
        adapter.setOnItemClickListener(this);
        adapter.setOnItemChildClickListener(this);
        rv.setAdapter(adapter);
    }

    private void initRvData() {
        dateList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dateList.add(i + "");
        }
    }

    //注解的方法必须传入View，用于获取id判断去重
    //结合butterknif时，使用带参数view的方法
    @SingleClick
    @OnClick({R.id.bt_2, R.id.bt_3, R.id.bt_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_2:
                Intent intent = new Intent(this, BActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_3:
                Intent intent2 = new Intent(this, BActivity.class);
                startActivity(intent2);
                break;
            case R.id.bt_4:
                Intent intent3 = new Intent(this, BActivity.class);
                startActivity(intent3);
                break;
        }
    }

    @SingleClick
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.bt:
                Toast.makeText(this, dateList.get(position), Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, BActivity.class);
                startActivity(intent3);
                break;
        }
    }

    @SingleClick(2000)
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(this, dateList.get(position), Toast.LENGTH_SHORT).show();
        Intent intent3 = new Intent(this, BActivity.class);
        startActivity(intent3);
    }
}
