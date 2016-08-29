package com.example.qzl.materialdesign.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qzl.materialdesign.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    public BlankFragment() {
    }

    /**
     * 获取fragment的实例
     * @param text
     * @return
     */
    public static BlankFragment newInstance(String text) {
        Bundle args = new Bundle();
        args.putString("text",text);
        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 加载fragment布局
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    /**
     * 调运此方法时，fragment布局加载已完成
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.pager_text);
        String string = getArguments().getString("text");
        textView.setText(string);
    }
}
