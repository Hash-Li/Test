package com.bulinbulin.test.adapter;

import android.support.annotation.Nullable;

import com.bulinbulin.test.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author 12482
 * @date 2019/6/6 14:13
 */
public class RvAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public RvAdapter(@Nullable List<String> data) {
        super(R.layout.activity_b, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.bt, item);
    }
}
