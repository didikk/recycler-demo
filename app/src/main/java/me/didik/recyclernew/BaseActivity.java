package me.didik.recyclernew;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by didik on 03/03/16.
 * Base class for any activity
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected ActionBar mActionBar;
    protected Context mContext;
    private boolean isToolbarEnabled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    @Override
    public void setContentView(int layoutResID) {
        LinearLayout fullView = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);

        super.setContentView(fullView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (isToolbarEnabled){
            setSupportActionBar(toolbar);
            mActionBar = getSupportActionBar();
        }else toolbar.setVisibility(View.GONE);
    }

    /**
     * Custom setContentView
     * Call this method if you want to disable the toolbar
     * Toolbar is enable by default
     *
     * @param layoutResID Your layout Id
     * @param useToolbar set false to disable toolbar
     */
    public void setContentView(int layoutResID, boolean useToolbar){
        isToolbarEnabled = useToolbar;
        setContentView(layoutResID);
    }
}
