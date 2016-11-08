package com.sell.reseller.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sell.reseller.fragment_penjualan.fragmen_transaksi_penjualan;
import com.sell.reseller.fragment_penjualan.fragment_order;
import com.sell.reseller.fragment_penjualan.fragment_pengiriman;
import com.sell.reseller.fragment_penjualan.fragment_status_penjualan;
import com.sell.reseller.fragment_store.fragment_konfirmasi;
import com.sell.reseller.fragment_store.fragment_status;
import com.sell.reseller.fragment_store.fragment_transaksi;
import com.sell.reseller.fragment_store.fragment_ubah_pemabayaran;

/**
 * Created by Gerbage on 8/31/2016.
 */
public class PagerAdapterPenjualan extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterPenjualan(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                fragment_order fragmentOrder = new fragment_order();
                return fragmentOrder;
            case 1:
                fragment_pengiriman fragmentPengiriman = new fragment_pengiriman();
                return fragmentPengiriman;
            case 2:
                fragment_status_penjualan fragmentStatusPenjualan = new fragment_status_penjualan();
                return fragmentStatusPenjualan;
            case 3:
                fragmen_transaksi_penjualan fragmentTransaksi = new fragmen_transaksi_penjualan();
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
