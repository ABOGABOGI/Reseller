package com.sell.reseller.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sell.reseller.fragment_store.fragment_konfirmasi;
import com.sell.reseller.fragment_store.fragment_status;
import com.sell.reseller.fragment_store.fragment_transaksi;
import com.sell.reseller.fragment_store.fragment_ubah_pemabayaran;

/**
 * Created by Gerbage on 8/31/2016.
 */
public class AdapterPager extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public AdapterPager(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                fragment_konfirmasi fragmentKonfirmasi = new fragment_konfirmasi();
                return fragmentKonfirmasi;
            case 1:
                fragment_status fragmentStatus = new fragment_status();
                return fragmentStatus;
            case 2:
                fragment_ubah_pemabayaran fragmentUbahPemabayaran = new fragment_ubah_pemabayaran();
                return fragmentUbahPemabayaran;
            case 3:
                fragment_transaksi fragmentTransaksi = new fragment_transaksi();
                return fragmentTransaksi;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
