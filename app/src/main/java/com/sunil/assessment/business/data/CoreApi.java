package com.sunil.assessment.business.data;

import com.sunil.assessment.business.model.PocDomainModel;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by sunil on 31-01-2018.
 * This class provides API for Retrofit calls. Can use <GET>, <POST> , <CALL> methods for Requests
 */



public interface CoreApi {

    /**
     * Get list of content from the JSON URL
     * @return {@link PocDomainModel} with all details
     */
    @GET("facts")
    Observable<Response<PocDomainModel>> getJsonContent();

}
