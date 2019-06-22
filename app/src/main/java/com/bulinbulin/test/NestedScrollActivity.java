package com.bulinbulin.test;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bulinbulin.test.adapter.RvAdapter;
import com.tobiasrohloff.view.NestedScrollWebView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 官方嵌套滑动，webview+recycler评论，有回弹问题
 * CoordinatorLayout + AppBarLayout + RecyclerView
 *
 * app:layout_scrollFlags="scroll|snap"
 * app:layout_behavior="@string/appbar_scrolling_view_behavior"
 *
 * @author 12482
 * @date 2019/6/4 16:29
 */
public class NestedScrollActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.webview)
    NestedScrollWebView mWebView;
    private ArrayList<String> dateList;
    private RvAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nestedscroll);
        ButterKnife.bind(this);

        initWebView();
        mWebView.loadUrl("http://baidu.com");
        initRvData();
        initRv();
    }

    private void initWebView() {
        // 设置背景色
        mWebView.setBackgroundColor(0);
        mWebView.requestFocus(View.FOCUS_DOWN);
        mWebView.resumeTimers(); // pptv页面带有pauseTimers ，所以这里resumeTimers
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            mWebView.getSettings().setTextZoom(100);
        }

        // 创建WebViewClient对象
        WebViewClient wvc = new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url,
                                      Bitmap favicon) {
//                showLoading();
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // 查找这个关闭的标签在不在 如果在就关闭webview
                // 关闭Loading
//                stopLoading();


                super.onPageFinished(view, url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
        };

        // 设置WebViewClient对象
        mWebView.setWebViewClient(wvc);

        // 创建WebViewChromeClient
        WebChromeClient wvcc = new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progress) {
                super.onProgressChanged(view, progress);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message,
                                     final JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message,
                                       final JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message,
                                      String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue,
                        result);
            }

        };
        // 设置setWebChromeClient对象
        mWebView.setWebChromeClient(wvcc);
        // 设置滚动样式
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // 设置可以支持缩放
        mWebView.getSettings().setSupportZoom(false);
        // // 设置默认缩放方式尺寸是far
        // mWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        // 设置出现缩放工具
        mWebView.getSettings().setBuiltInZoomControls(false);
        // 设置可以自动加载图片
        mWebView.getSettings().setLoadsImagesAutomatically(true);
        // // 提高渲染的优先级
        // mWebView.getSettings().setRenderPriority(RenderPriority.HIGH);
        // 开启js
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.setVerticalScrollBarEnabled(false);

        mWebView.setHorizontalScrollBarEnabled(false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebView.getSettings().setMixedContentMode(
                    WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
    }

    private void initRv() {
        rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        adapter = new RvAdapter(dateList);
        rv.setAdapter(adapter);

    }

    private void initRvData() {
        dateList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            dateList.add(i + "");
        }
    }
}
