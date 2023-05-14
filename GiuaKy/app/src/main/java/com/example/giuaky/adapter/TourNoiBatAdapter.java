package com.example.giuaky.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.giuaky.R;
import com.example.giuaky.model.Tour;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class TourNoiBatAdapter extends RecyclerView.Adapter<TourNoiBatAdapter.ViewHolder> {
    private Context mContext;
    private List<Tour> mItems;

    public TourNoiBatAdapter(Context context, List<Tour> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tour_noi_bat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tour tour = mItems.get(position);

        Picasso.get().load(tour.getUrlImage()).into(holder.imageView);
//        holder.imageView.setImageResource(tour.getUrlImage());
        String nameTour = tour.getName();
        if(nameTour.length()>16){
            nameTour = nameTour.substring(0,16)+"...";
        }
        holder.titleTextView.setText(nameTour);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = tour.getStartDate();
        if (startDate != null) {
            java.util.Date utilStartDate = new java.util.Date(startDate.getTime());
            String formattedDate = simpleDateFormat.format(utilStartDate);
            holder.dateStart.setText(formattedDate + " --");
        } else {
            holder.dateStart.setText("--");
        }
        holder.totalDate.setText(tour.getTotalDay()+" ngày");


        Locale vietnameseLocale = new Locale("vi", "VN");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(vietnameseLocale);


        Currency vietnameseDong = Currency.getInstance("VND");
        currencyFormat.setCurrency(vietnameseDong);


        holder.txtPrice.setText(currencyFormat.format(tour.getPrice()));
        holder.txtLocation.setText(tour.getTourDestination());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView, dateStart, totalDate, txtPrice, txtLocation;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_tour);
            titleTextView = itemView.findViewById(R.id.item_title);
            dateStart = itemView.findViewById(R.id.dateStart);
            totalDate = itemView.findViewById(R.id.totalDate);
            txtPrice  =itemView.findViewById(R.id.txtPrice);
            txtLocation = itemView.findViewById(R.id.txtLocation);
        }
    }
}
