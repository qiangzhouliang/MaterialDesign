package com.example.qzl.materialdesign;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CoordinatorActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        findViewById(R.id.coordinator_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /**
         * Snackbar : 和 CoordinatorLayout 连用的时候，可以实现左右滑动删除
         */
        Snackbar.make(v,"SnackBar in CoordinatorLayout",Snackbar.LENGTH_LONG)
                .setAction("exit", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //退出整个应用
                        ActivityCompat.finishAffinity(CoordinatorActivity.this);
                    }
                }).show();
    }
}
