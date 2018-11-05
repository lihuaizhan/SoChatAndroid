package com.neishenmo.sochat.sochatandroid.view.homepage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.neishenmo.sochat.sochatandroid.view.message.MessageFragment;
import com.neishenmo.sochat.sochatandroid.view.personage.PersonageFragment;
import com.neishenmo.sochat.sochatandroid.view.relation.RelationFragment;

import java.util.List;


public class HomePageAdapter extends FragmentPagerAdapter {
    private List<String> list;

    public HomePageAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomePageFragment();
        } else if (position == 1) {
            return new MessageFragment();
        } else if (position == 2) {
            return new RelationFragment();
        } else {
            return new PersonageFragment();
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }


}
