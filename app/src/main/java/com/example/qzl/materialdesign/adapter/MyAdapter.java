package com.example.qzl.materialdesign.adapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.qzl.materialdesign.fragment.BlankFragment;
import java.util.List;

/**
 * Created by Qzl on 2016-08-29.
 */
public class MyAdapter extends FragmentPagerAdapter{

    private List<String> mList;

    public MyAdapter(FragmentManager fm,List<String> list) {
        super(fm);
        this.mList = list;
    }

    /**
     * fragment 对象
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return BlankFragment.newInstance(mList.get(position));
    }

    /**
     * ragment 的个数
     * @return
     */
    @Override
    public int getCount() {
        return mList.size();
    }

    /**
     * 标签元素
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }
}
