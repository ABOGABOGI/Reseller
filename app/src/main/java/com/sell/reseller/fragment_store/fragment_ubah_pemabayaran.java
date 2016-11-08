package com.sell.reseller.fragment_store;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sell.reseller.R;

/**
 * Created by Gerbage on 8/31/2016.
 */
public class fragment_ubah_pemabayaran extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_store_ubahpembayaran, container, false);
    }
}
