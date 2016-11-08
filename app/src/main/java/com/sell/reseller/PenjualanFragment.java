package com.sell.reseller;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sell.reseller.adapter.AdapterPager;
import com.sell.reseller.adapter.PagerAdapterPenjualan;

/**
 * Created by Gerbage on 8/29/2016.
 */
public class PenjualanFragment extends Fragment {
    public PenjualanFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_penjualan,container,false);

        TabLayout tabLayout = (TabLayout)rootView.findViewById(R.id.tab_layout_penjuala);
        tabLayout.addTab(tabLayout.newTab().setText("Order baru"));
        tabLayout.addTab(tabLayout.newTab().setText("Pengiriman"));
        tabLayout.addTab(tabLayout.newTab().setText("Status"));
        tabLayout.addTab(tabLayout.newTab().setText("Transaksi"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)rootView.findViewById(R.id.pager_penjualan);
        PagerAdapterPenjualan adapterPager = new PagerAdapterPenjualan(getActivity().getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapterPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
