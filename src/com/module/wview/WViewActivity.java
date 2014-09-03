package com.module.wview;

import android.app.Activity;
import android.os.Bundle;
import com.module.wview.MSGView.CWView;
import com.module.wview.MSGView.ViewParameters;

public class WViewActivity extends Activity implements ViewParameters {

    private CWView mWebView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mWebView = (CWView) findViewById(R.id.activity_main_web_view);
        mWebView.init(getApplicationContext());

//        mWebView.loadUrl("file:///android_asset/jira1.html");
//        mWebView.loadUrl("http://beta.html5test.com/");

        mWebView.setText(testText2);

    }

}
