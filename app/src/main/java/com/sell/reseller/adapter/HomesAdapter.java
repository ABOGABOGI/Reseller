package com.sell.reseller.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sell.reseller.R;
import com.sell.reseller.model.Home;

import java.util.List;

/**
 * Created by Gerbage on 8/30/2016.
 */
public class HomesAdapter extends RecyclerView.Adapter<HomesAdapter.ViewHolder> {

    private Context mContext;
    private List<Home>homeList;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title,count;
        public ImageView thumbnail,overFlow;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            count = (TextView)itemView.findViewById(R.id.count);
            thumbnail = (ImageView)itemView.findViewById(R.id.thumbnail);
            overFlow = (ImageView)itemView.findViewById(R.id.overflow);
        }
    }

    public HomesAdapter (Context mContext, List<Home>homesList){
        this.mContext = mContext;
        this.homeList = homesList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HomesAdapter.ViewHolder holder, int position) {
        Home home = homeList.get(position);
        holder.title.setText(home.getName());
        holder.count.setText(home.getNumber()+" Buah");
        //======================================
        Glide.with(mContext).load(home.getThumbnail()).into(holder.thumbnail);

        holder.overFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overFlow);
            }
        });
    }

    private void showPopupMenu(View view){
        PopupMenu popup = new PopupMenu(mContext,view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_home_bottom,popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClcikListener());
        popup.show();
    }

    class MyMenuItemClcikListener implements PopupMenu.OnMenuItemClickListener{

        public MyMenuItemClcikListener(){

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Favorite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Feedback", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
    public int getItemCount() {
        return homeList.size();
    }
}
