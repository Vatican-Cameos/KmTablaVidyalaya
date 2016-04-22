package com.example.pavan.kmtabalavidyalaya.Activities;

/**
 * Created by kai on 22/4/16.
 */
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;


/**
 * Created by Chirag Shenoy on 04-Feb-16.
 */
public abstract class BaseActivity extends AppCompatActivity {


    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);

    }
    protected abstract int getLayoutResource();

    public void setTitleText(int title) {
        if (mToolbar != null) {
            mToolbar.setTitle(title);
        }
    }

    public void setTitleText(String title) {
        if (mToolbar != null) {
            mToolbar.setTitle(title);
        }
    }

    public void setSubTitleText(int subTitleText) {
        if (mToolbar != null) {
            mToolbar.setSubtitle(subTitleText);
        }
    }

    public void setSubTitleText(String subTitleText) {
        if (mToolbar != null) {
            mToolbar.setSubtitle(subTitleText);
        }
    }

    public void enableHomeButtonIcon() {
        if (mToolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }



}