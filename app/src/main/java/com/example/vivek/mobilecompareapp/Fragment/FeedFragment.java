package com.example.vivek.mobilecompareapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.vivek.mobilecompareapp.Adapter.FeedAdapterClass;
import com.example.vivek.mobilecompareapp.Model.FeedModelClass;
import com.example.vivek.mobilecompareapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FeedFragment extends Fragment {
    private RecyclerView mRecycleview;
    FeedAdapterClass mAdapterclass;
    ArrayList<FeedModelClass> mArrayList;
    private RequestQueue mRequestQueue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle("FEED");

        mRecycleview = view.findViewById(R.id.Recycler_view);
        mRecycleview.setHasFixedSize(true);
        mRecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));

        mArrayList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(getActivity());
        parseJSON();


        return view;

    }

    private void parseJSON() {
        String url = "http://brainapp.in/app/v1/tourist.getForHome.inc.php?item=20";
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response", response);
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                            if (!jsonObject.getBoolean("error")) {

                                JSONArray jsonArray = jsonObject.getJSONArray("data");

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    FeedModelClass modelclass = new FeedModelClass();
                                    JSONObject hit = jsonArray.getJSONObject(i);

                                    modelclass.image = hit.getString("cover_image");
                                    mArrayList.add(modelclass);

                                }
                                mAdapterclass = new FeedAdapterClass(getActivity(), mArrayList);
                                mRecycleview.setAdapter(mAdapterclass);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.toolbar);
        item.setVisible(false);
    }
}