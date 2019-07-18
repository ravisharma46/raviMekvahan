package com.naruto.mekvahandelivery.OngoingOrders;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.customer_pickup.OnGoingBookingVendorDrop;
import com.naruto.mekvahandelivery.vendor_pickup.OngoingBookingCustomerDrop;

import java.util.ArrayList;


public class OngoingAdapter_1 extends RecyclerView.Adapter<OngoingAdapter_1.ViewHolder> {

    private Context context;
    private ArrayList<MyListDataOngoingBooking> dataArrayList;


    public OngoingAdapter_1(ArrayList<MyListDataOngoingBooking> dataArrayList) {
        this.dataArrayList = dataArrayList;

    }

    @NonNull
    @Override
    public OngoingAdapter_1.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_item, viewGroup, false);
        return new OngoingAdapter_1.ViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull OngoingAdapter_1.ViewHolder viewHolder, int i) {

       final MyListDataOngoingBooking data = dataArrayList.get(i);

       viewHolder.textViewstatus.setText(data.getDescription());


//        viewHolder.textViewname.setText(listitem.getName());
//        viewHolder.textViewrent.setText(listitem.getRent_from());
//        viewHolder.textViewdeposite.setText(listitem.getSecurity_deposit_from());
//        viewHolder.textViewaccomd.setText(listitem.getAccomodation_allowed_str());
//        viewHolder.textViewbed.setText(listitem.getAvailable_bed_count()+" Beds");
//
//        String state_city= listitem.getCity()+","+listitem.getState();
//        viewHolder.textViewcity.setText(state_city);


        //viewHolder.textViewRupee.setText("\u20B9" + " 99");

        String status=data.getDescription();


        if (status.contains("Awaiting customer drop off")) {
            viewHolder.textVieworderid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), OngoingBookingCustomerDrop.class);
                    view.getContext().startActivity(i);

                }
            });

        }

        if (status.contains("Awaiting vendor drop off")) {
            viewHolder.textVieworderid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), OnGoingBookingVendorDrop.class);
                    view.getContext().startActivity(i);

                }
            });

        }





    }

    @Override
    public int getItemCount() {
        if (dataArrayList != null) {
            return dataArrayList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textVieworderid, textViewstatus, textViewstate, textViewrent, textViewdeposite, textViewaccomd, textViewbed;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textVieworderid = itemView.findViewById(R.id.order_id_2);
            textViewstatus= itemView.findViewById(R.id.status);

//            textViewcity= (TextView) itemView.findViewById(R.id.city_tv);
//            textViewrent= (TextView) itemView.findViewById(R.id.rent_tv);
//            textViewdeposite= (TextView) itemView.findViewById(R.id.deposite_tv);
//            textViewaccomd= (TextView) itemView.findViewById(R.id.accomd_tv);
//            textViewbed= (TextView)itemView.findViewById(R.id.bed_tv);
//
//            imageView =(ImageView) itemView.findViewById(R.id.image_View);
//            linearLayout=(LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}