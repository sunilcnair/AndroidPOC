package com.sunil.assessment.business.data;

import com.sunil.assessment.business.model.PocDomainModel;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by sunil on 31-01-2018.
 */

public class CoreUseCase {

    private static final String TAG = CoreUseCase.class.getSimpleName();

    private CoreApi mCoreApi;

    public CoreUseCase(CoreApi actApi) {
        if(actApi != null)
        {
            mCoreApi = actApi;
        }

    }

    /**
     * Retrieves the list of data from the server using Rxjava observable and
     * the result is published.
     * @return {@link PocDomainModel}
     */
    public Observable<PocDomainModel> getContent() {
        return Observable.defer(() -> {
            return mCoreApi.getJsonContent();
        })
                .subscribeOn(Schedulers.io())
                .map(Response::body);
    }
}
