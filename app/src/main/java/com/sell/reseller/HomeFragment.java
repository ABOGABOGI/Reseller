package com.sell.reseller;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sell.reseller.adapter.HomesAdapter;
import com.sell.reseller.model.Home;
import com.sell.reseller.server.JSONParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerbage on 8/26/2016.
 */
public class HomeFragment extends Fragment {

    JSONParser jsonParser = null;
    private RecyclerView recyclerView;
    private HomesAdapter homesAdapter;
    private List<Home>homeList;

    public HomeFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jsonParser = new JSONParser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment,container,false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);



        homeList = new ArrayList<>();
        homesAdapter = new HomesAdapter(getActivity(),homeList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(homesAdapter);
        prepareHome();

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

    private void prepareHome(){
        int []covers = new int[]{
                R.drawable.juicesatu,
                R.drawable.juicedua,
                R.drawable.juicetiga,
                R.drawable.juiceempat,
                R.drawable.juicelima,
                R.drawable.juiceenam,
                R.drawable.juicetuju,
                R.drawable.juicedelepan,
                R.drawable.juicesembilan,
                R.drawable.juicesepuluh,
                R.drawable.juicesebelas,
                R.drawable.juiceduabelas,
                R.drawable.juicetigabelas,
                R.drawable.juiceempatbelas,
                R.drawable.juicelimabelas,
        };

        Home home = new Home("Juice Satu",11,covers[0]);
        homeList.add(home);

        Home home2 = new Home("Juice dua",13,covers[1]);
        homeList.add(home2);

        Home home3 = new Home("Juice Satu",20,covers[2]);
        homeList.add(home3);

        Home home4 = new Home("Juice Satu",6,covers[3]);
        homeList.add(home4);

        Home home5 = new Home("Juice Satu",11,covers[4]);
        homeList.add(home5);

        Home home6 = new Home("Juice Satu",11,covers[5]);
        homeList.add(home6);

        Home home7 = new Home("Juice Satu",6,covers[6]);
        homeList.add(home7);

        Home home8 = new Home("Juice Satu",12,covers[7]);
        homeList.add(home8);

        Home home9 = new Home("Juice Satu",17,covers[8]);
        homeList.add(home9);

        Home home10 = new Home("Juice Satu",19,covers[9]);
        homeList.add(home10);

        Home home11 = new Home("Juice Satu",9,covers[10]);
        homeList.add(home11);

        Home home12 = new Home("Juice Satu",1,covers[11]);
        homeList.add(home12);

        Home home13 = new Home("Juice Satu",22,covers[12]);
        homeList.add(home13);

        Home home14 = new Home("Juice Satu",4,covers[13]);
        homeList.add(home14);

        Home home15 = new Home("Juice Satu",10,covers[14]);
        homeList.add(home15);
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}

