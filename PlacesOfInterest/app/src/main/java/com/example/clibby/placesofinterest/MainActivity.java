package com.example.clibby.placesofinterest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {
    List<StreetView> mStreetViews;
    private GestureDetector mGestureDetector;
    private StreetViewAdapter mAdapter;
    String TAG = "Tutch";

    private float x1,x2;
    static final int MIN_DISTANCE = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStreetViews = new ArrayList<>();

        for (int i = 0; i < StreetView.PRE_DEFINED_STREET_VIEW_IMAGE_IDS.length; i++){
            mStreetViews.add(new StreetView(StreetView.PRE_DEFINED_STREET_VIEW_NAMES[i], StreetView.PRE_DEFINED_STREET_VIEW_IMAGE_IDS[i]));
        }

        final RecyclerView mGeoRecyclerView = findViewById(R.id.RecyclerView);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);

        mGeoRecyclerView.setLayoutManager(mLayoutManager);

        mGeoRecyclerView.setHasFixedSize(true);

        mAdapter = new StreetViewAdapter(this, mStreetViews);

        mGeoRecyclerView.setAdapter(mAdapter);

        mGeoRecyclerView.addOnItemTouchListener(this);
        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {

            @Override

            public boolean onSingleTapUp(MotionEvent e) {

                return true;

            }

        });

    }
    @Override

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child = rv.findChildViewUnder(e.getX(), e.getY());
        int mAdapterPosition = rv.getChildAdapterPosition(child);
        boolean InEurope;

        if (child != null) {
            InEurope = mStreetViews.get(mAdapterPosition).getmInEurope();
            Log.i(TAG, ""+InEurope);
            switch (e.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x1 = e.getX();
                    break;
                case MotionEvent.ACTION_UP:
                    x2 = e.getX();
                    float deltaX = x2 - x1;
                    Log.i(TAG, "x1:" + x1 + " x2:" + x2);
                    if (Math.abs(deltaX) > MIN_DISTANCE) {

                        String feedback;
                        if (x1 > x2) { //Swiped To The Left
                            if (InEurope == true) {
                                feedback = "Correct!";
                            } else {
                                feedback = "Incorrect.";
                            }
                            Toast.makeText(this, "Your Awnser is: " + feedback, Toast.LENGTH_SHORT).show();
                        }
                        if (x1 < x2) { // Swiped To The Right
                            if (InEurope != true) {
                                feedback = "Correct!";
                            } else {
                                feedback = "Incorrect.";
                            }
                            Toast.makeText(this, "Your Awnser is: " + feedback, Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
            }
        }


        if (child != null && mGestureDetector.onTouchEvent(e)) {

            Toast.makeText(this, mStreetViews.get(mAdapterPosition).getmGeoName(), Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {



    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }


}
