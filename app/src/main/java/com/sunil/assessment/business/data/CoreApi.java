package com.sunil.assessment.business.data;

import com.sunil.assessment.business.model.PocDomainModel;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by sunil on 31-01-2018.
 */



public interface CoreApi {

    /**
     * Get list of actors
     * @return {@link PocDomainModel} with all details
     */
    @GET("facts")
    Observable<Response<PocDomainModel>> getJsonContent();

}
