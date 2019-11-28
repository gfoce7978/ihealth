package com.example.healthapp.ui.Diabetic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healthapp.Adapter.SectionPagerAdapter;
import com.example.healthapp.R;
import com.example.healthapp.ui.CameraFragment;
import com.google.android.material.tabs.TabLayout;

public class Diabetic extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.diabetic_fragment, container, false);

        viewPager = root.findViewById(R.id.viewPager);
        tabLayout = root.findViewById(R.id.tabLayout);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d("tab click checker","aliakajsdf");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.d("tab click checker","aliakajsdf");

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.d("tab click checker","aliakajsdf");


            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {

        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getChildFragmentManager());

        sectionPagerAdapter.addFragment(new Diabetic_Form(), "Form");
        sectionPagerAdapter.addFragment(new CameraFragment(), "Camera");

        viewPager.setAdapter(sectionPagerAdapter);
    }



}
