package com.sunil.assessment.business.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sunil on 31-01-2018.
 * Pojo class for Retrofit JSON parsed response.
 * Each tag is added with getter setter methods.
 */

public class PocDataObject implements Serializable {

    @SerializedName("title")
    private String mName;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("imageHref")
    private String mImage;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }
}
