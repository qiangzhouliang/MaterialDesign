package com.example.qzl.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.qzl.materialdesign.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{

    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        TabLayout tab = (TabLayout) findViewById(R.id.tab);

        //要注意顺序，要不然点击事件不响应
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//设置actionbar为toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示导航图标图标

        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, 0, 0);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();//同步状态

        List<String> list = getDataList();
        pager.setAdapter(new MyAdapter(getSupportFragmentManager(),list));
        //和tab绑定
        tab.setupWithViewPager(pager);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        //按钮
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @NonNull
    private List<String> getDataList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(String.format(Locale.CHINA,"第%02d页",i));
        }
        return list;
    }

    /**
     * 点击事件的接口
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_4:
                finish();
                break;
        }
        //关闭侧边栏
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        //显示一个对话框
        Snackbar.make(v,"Snackbar",Snackbar.LENGTH_LONG)
                .setAction("撤销", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this, "撤销了", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,CoordinatorActivity.class));
                    }
                }).show();
    }
}
