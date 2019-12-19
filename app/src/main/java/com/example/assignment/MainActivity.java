package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    PastTripListAdapter mAdapter;
    ArrayList<TripData> tripDataArrayList;
    ArrayList<ProfileData> profileDataArrayList;
    RecyclerView pastTrips;
    TextView txt_firstName,txt_lastName,txt_city,txt_country,txt_rides,txt_freeRide,txt_credits;
    ImageView iv_userImage;
    RequestOptions options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profileDataArrayList= new ArrayList<>();
        tripDataArrayList = new ArrayList<>();
        pastTrips=findViewById(R.id.recyclerView);
        pastTrips.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        setID();
        getData();
        setTitle("My Profile");
        options=new RequestOptions().centerCrop().placeholder(R.drawable.user).error(R.drawable.user);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();
        switch (id){
            case R.id.defaultButton:
                Toast.makeText(this, "You Selected a Menu Item!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void getData(){
        final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://gist.githubusercontent.com/iranjith4/522d5b466560e91b8ebab54743f2d0fc/raw/7b108e4aaac287c6c3fdf93c3343dd1c62d24faf/radius-mobile-intern.json",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.e("Response",response.toString());
                try {
                    JSONObject jsonObjectProfile=response.getJSONObject("data").getJSONObject("profile");
                    JSONObject jsonObjectRides=response.getJSONObject("data").getJSONObject("stats");
                    JSONObject jsonObjectCredits=response.getJSONObject("data").getJSONObject("stats").getJSONObject("credits");
                    profileDataArrayList.add(new ProfileData(jsonObjectProfile.getString("first_name"),
                            jsonObjectProfile.getString("last_name"),
                            jsonObjectProfile.getString("city"),
                            jsonObjectProfile.getString("Country"),
                            jsonObjectProfile.getString("middle_name"),
                                    jsonObjectRides.getString("rides"),
                                    jsonObjectRides.getString("free_rides"),
                                    jsonObjectCredits.getString("currency_symbol"),
                                    jsonObjectCredits.getString("value"))
                            );
                    for (int i=0;i<profileDataArrayList.size();i++){
                        //using glide we'll fetch image
                        Glide.with(MainActivity.this).load(profileDataArrayList.get(i).getUserImage()).apply(options).into(iv_userImage);
                        txt_firstName.setText(profileDataArrayList.get(i).getUserFirstName());
                        txt_lastName.setText(profileDataArrayList.get(i).getUserLastName());
                        txt_city.setText(profileDataArrayList.get(i).getUserCity()+",");
                        txt_country.setText(profileDataArrayList.get(i).getUserCountry());
                        txt_rides.setText(profileDataArrayList.get(i).getUserRides());
                        txt_freeRide.setText(profileDataArrayList.get(i).getUserFreeRides());
                        txt_credits.setText(profileDataArrayList.get(i).getCurrencyType()+profileDataArrayList.get(i).getUserCredits());
                    }

                    JSONArray jsonArray = response.getJSONObject("data").getJSONArray("trips");
                    for (int i = 0 ; i < jsonArray.length() ; i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        tripDataArrayList.add(new TripData(jsonObject.getString("from"),
                                jsonObject.getString("to"),
                                jsonObject.getString("from_time"),
                                jsonObject.getString("to_time"),
                                jsonObject.getJSONObject("cost").getString("currency_symbol"),
                                jsonObject.getJSONObject("cost").getString("value"),
                                jsonObject.getString("trip_duration_in_mins")));
                    }
                    mAdapter=new PastTripListAdapter(getApplicationContext(),tripDataArrayList);
                    pastTrips.setAdapter(mAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(jsonObjectRequest);
    }
    public void setID(){
        txt_firstName=findViewById(R.id.user_firstName);
        txt_lastName=findViewById(R.id.user_lastName);
        txt_city=findViewById(R.id.user_city);
        txt_country=findViewById(R.id.user_country);
        iv_userImage=findViewById(R.id.user_image);
        txt_rides=findViewById(R.id.user_rides);
        txt_freeRide=findViewById(R.id.free_rides);
        txt_credits=findViewById(R.id.credits);
    }
    public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src",src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }
}
