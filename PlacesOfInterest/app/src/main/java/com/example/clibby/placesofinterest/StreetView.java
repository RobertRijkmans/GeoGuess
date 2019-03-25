package com.example.clibby.placesofinterest;


public class StreetView {
    private String mGeoName;
    private int mGeoImageName;
    private boolean mInEurope;

    public StreetView(String mGeoName, int mGeoImageName) {
        this.mGeoName = mGeoName;
        this.mGeoImageName = mGeoImageName;
        //Give the mInEurope boolean a value
        if(mGeoName == "denmark" || mGeoName == "kazachstan"||mGeoName == "poland"||mGeoName == "malta"){
            mInEurope = true;
        }
        else{
            mInEurope = false;
        }
    }

    public String getmGeoName() {
        return mGeoName;
    }

    public void setmGeoName(String mGeoName) {
        this.mGeoName = mGeoName;
    }

    public int getmGeoImageName() {
        return mGeoImageName;
    }

    public void setmGeoImageName(int mGeoImageName) {
        this.mGeoImageName = mGeoImageName;
    }
    public boolean getmInEurope(){
        return mInEurope;
    }

    public static final String[] PRE_DEFINED_STREET_VIEW_NAMES = {

            "denmark",
            "canada",
            "bangladesh",
            "kazachstan",
            "colombia",
            "poland",
            "malta",
            "thailand"
    };

    public static final int[] PRE_DEFINED_STREET_VIEW_IMAGE_IDS = {

            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };
}