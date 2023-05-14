package com.example.giuaky.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
//import androidx.privacysandbox.tools.core.model.Method;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.giuaky.R;
import com.example.giuaky.adapter.TourAdapter;
import com.example.giuaky.adapter.TourNoiBatAdapter;
import com.example.giuaky.model.Tour;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;




public class HomeFragment extends Fragment {


    private List<Tour> toursOutStanding ;
    private List<Tour> toursComming ;
    private TourAdapter tourAdapter;
    private TourNoiBatAdapter tourNoiBatAdapter;

    RequestQueue requestQueue;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestQueue = Volley.newRequestQueue(getContext());

        toursOutStanding = new ArrayList<>();
        toursComming = new ArrayList<>();
        tourAdapter = new TourAdapter(getContext(), toursOutStanding);
        tourNoiBatAdapter = new TourNoiBatAdapter(getContext(), toursComming);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));



//        List<Tour> items = new ArrayList<>();
//        items.add(new Tour(R.drawable.bien1, "Biển Ngọc"));
//        items.add(new Tour(R.drawable.bien2, "Biển Lý Sơn"));
//        items.add(new Tour(R.drawable.bien3, "Biển Khánh Hòa"));
//        items.add(new Tour(R.drawable.bien4, "Biển Vũng Tàu"));

        recyclerView.setAdapter(tourAdapter);


        RecyclerView recyclerView2 = view.findViewById(R.id.my_recycler_view2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        List<Tour> items2 = new ArrayList<>();
//        items2.add(new Tour(R.drawable.bien1, "Biển Ngọc"));
//        items2.add(new Tour(R.drawable.bien2, "Biển Lý Sơn"));
//        items2.add(new Tour(R.drawable.bien3, "Biển Khánh Hòa"));
//        items2.add(new Tour(R.drawable.bien4, "Biển Vũng Tàu"));

        recyclerView2.setAdapter(tourNoiBatAdapter);

        getTours("http://192.168.1.22:3000/tour/list?paging=1&key=featured&status=1", toursOutStanding);
        getTours("http://192.168.1.22:3000/tour/list?paging=1&status=1", toursComming);

        return view;
    }

    private List<Tour> getTours(String url, final List<Tour> tours) {
//        String url  = "http://192.168.1.22:3000/tour/list?paging=1";
//        List<Tour> tours = new ArrayList<>();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray jsonArray = null;
                try {
                    jsonArray = (JSONArray) response.getJSONArray("data");


                    for (int i = 0; i <jsonArray.length() ; i++) {
                        try {
                            JSONObject object = (JSONObject) jsonArray.get(i);
                            Tour tour = new Tour();
                            tour.setName(object.getString("name"));
                            String startDateString = object.getString("startDate");
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            try {

                                tour.setStartDate((Date) dateFormat.parse(startDateString));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            tour.setTotalDay(object.getInt("totalDay"));
                            tour.setTourDestination(object.getString("tourDestination"));
                            tour.setPrice(object.getInt("price"));

                            String stringImgs = object.getString("imageUrl");
                            int find = stringImgs.indexOf(',');
                            stringImgs = stringImgs.substring(1, stringImgs.length() - 2).replace("\"", "");
                            if(find==-1){
                                tour.setUrlImage(stringImgs);
                            }
                            else{

                                String[] listImages = stringImgs.split(",");
//                                Toast.makeText(getContext(), "listImages: "+listImages[0], Toast.LENGTH_LONG).show();
//                                Log.e("listImages", listImages[0]);

                                tour.setUrlImage(listImages[0]);
                            }



                            tours.add(tour);

                            tourAdapter.notifyDataSetChanged();
                            tourNoiBatAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error: "+error.toString(), Toast.LENGTH_SHORT).show();
                Log.e("error", error.toString());
            }
        });
        requestQueue.add(request);
        return tours;
    }
}