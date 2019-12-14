package com.example.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

public class PastTripListAdapter extends RecyclerView.Adapter<PastTripListAdapter.PastTripListViewHolder> {
    Context context;
    ArrayList<TripData> tripDataArrayList;

    public PastTripListAdapter(Context context, ArrayList<TripData> tripDataArrayList) {
        this.context = context;
        this.tripDataArrayList = tripDataArrayList;
    }

    @NonNull
    @Override
    public PastTripListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View PastTripView= LayoutInflater.from(parent.getContext()).inflate(R.layout.past_trips_list_items,parent,false);
        return new PastTripListViewHolder(PastTripView);
    }

    @Override
    public void onBindViewHolder(@NonNull PastTripListViewHolder holder, int position) {
        holder.txt_boardingStation.setText(tripDataArrayList.get(position).getBoardingStation());
        holder.txt_boardingTime.setText(Date(tripDataArrayList.get(position).getBoardingTime()));
        holder.txt_departureStation.setText(tripDataArrayList.get(position).getDepartureStation());
        holder.txt_departureTime.setText(Date(tripDataArrayList.get(position).getDepartureTime()));
        holder.txt_currencyType.setText(tripDataArrayList.get(position).getCurrencyType());
        holder.txt_tripCost.setText(tripDataArrayList.get(position).getTripCost());
        holder.txt_travelTime.setText(tripDataArrayList.get(position).getTravelTime()+" mins");
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Trip Data!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tripDataArrayList.size();
    }

    public class PastTripListViewHolder extends RecyclerView.ViewHolder{
        TextView txt_departureStation,txt_departureTime,txt_boardingStation,txt_boardingTime,txt_currencyType,txt_tripCost,txt_travelTime;
        LinearLayout parentLayout;
        public PastTripListViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_boardingStation=itemView.findViewById(R.id.boardingStation);
            txt_boardingTime=itemView.findViewById(R.id.boardingTime);
            txt_departureStation=itemView.findViewById(R.id.departureStation);
            txt_departureTime=itemView.findViewById(R.id.departureTime);
            txt_currencyType=itemView.findViewById(R.id.currencySymbol);
            txt_tripCost=itemView.findViewById(R.id.tripCost);
            txt_travelTime=itemView.findViewById(R.id.travelTimeValue);
            parentLayout=itemView.findViewById(R.id.parentLayout);
        }
    }
    public String Date(String milliseconds){
        long milliSeconds= Long.parseLong(milliseconds);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        String Date = calendar.getTime().toString();
        return Date;
    }
}
