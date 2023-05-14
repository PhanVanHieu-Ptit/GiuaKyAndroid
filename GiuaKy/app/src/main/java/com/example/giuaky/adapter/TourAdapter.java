package com.example.giuaky.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.giuaky.R;
import com.example.giuaky.model.Tour;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.ViewHolder> {
    private Context mContext;
    private List<Tour> mItems;

    public TourAdapter() {

    }

    public TourAdapter(Context context, List<Tour> items) {
        mContext = context;
        mItems = items;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public List<Tour> getmItems() {
        return mItems;
    }

    public void setmItems(List<Tour> mItems) {
        this.mItems = mItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tour_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tour tour = mItems.get(position);
        Picasso.get().load(tour.getUrlImage()).into(holder.imageView);
//        holder.imageView.setImageResource(tour.getUrlImage());
        holder.titleTextView.setText(tour.getName());
        holder.locationTextView.setText(tour.getTourDestination());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView, locationTextView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            titleTextView = itemView.findViewById(R.id.item_title);
            locationTextView = itemView.findViewById(R.id.location);
        }
    }
}
