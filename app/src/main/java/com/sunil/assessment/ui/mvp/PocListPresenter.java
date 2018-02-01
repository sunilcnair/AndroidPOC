package com.sunil.assessment.ui.mvp;

import com.sunil.assessment.business.data.CoreUseCase;
import com.sunil.assessment.business.model.PocDataObject;
import com.sunil.assessment.business.model.PocDomainModel;

import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/**
 * Created by sunil on 01-02-2018.
 * Presenter class as part of MVP pattern
 */

public class PocListPresenter implements POCListContract.Presenter{

    private POCListContract.View mView;
    private CoreUseCase mCoreUsecase;

    public PocListPresenter(final CoreUseCase coreUseCase , final POCListContract.View conView)
    {
        mCoreUsecase = coreUseCase;
        mView = conView;
    }

    @Override
    public void getDataList() {
        mCoreUsecase.getContent()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> mView.loadDataList(response),
                        error -> mView.displayErrorResponse(error.getMessage())
                );
    }

    @Override
    public void onDataClicked(PocDataObject mActor) {
        mView.openDataDetails(mActor);
    }
}
