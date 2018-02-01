package com.sunil.assessment.business.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sunil on 31-01-2018.
 */

public class PocDomainModel {

    @SerializedName("rows")
    private List<PocDataObject> mData;

    public List<PocDataObject> getmData() {
        return mData;
    }

    public void setmData(List<PocDataObject> mData) {
        this.mData = mData;
    }
}
