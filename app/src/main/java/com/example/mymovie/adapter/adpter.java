package com.example.mymovie.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class adpter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> strings = new ArrayList<>();

    public adpter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return strings.size();
    }
    public CharSequence getPageTitle(int position){
return strings.get(position);
    }

    public void Addfragment(Fragment fragment,String title){

        fragmentList.add(fragment);
        strings.add(title);
    }
}
