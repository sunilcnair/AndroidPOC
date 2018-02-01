package com.sunil.assessment;

import com.sunil.assessment.business.data.CoreUseCase;
import com.sunil.assessment.business.model.PocDataObject;
import com.sunil.assessment.business.model.PocDomainModel;
import com.sunil.assessment.ui.mvp.POCListContract;
import com.sunil.assessment.ui.mvp.PocListPresenter;

import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PocListPresenterTest extends RXRules {

    @Mock
    private POCListContract.View mMockView;

    @Mock
    private CoreUseCase mMockCoreUsecase;

    private PocListPresenter mDataListPresenter;

    /**
     * Mockito setup
     */
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mDataListPresenter = new PocListPresenter(mMockCoreUsecase, mMockView);
    }

    /**
     * Test success response for {@link CoreUseCase#getContent()}
     */
    @Test
    public void testLoadActorsMethodIsCalledIfRequestSuccess() {
        when(mMockCoreUsecase.getContent()).thenReturn(Observable.just(getActorsResponse()));
        mDataListPresenter.getDataList();
        verify(mMockView).loadDataList(any());
    }

    /**
     * Mock data
     * @return {@link PocDomainModel}
     */
    private PocDomainModel getActorsResponse() {
        PocDomainModel dataResponse = new PocDomainModel();
        List<PocDataObject> data = new ArrayList<>();
        PocDataObject tData = new PocDataObject();
        tData.setmName("Test Content");
        tData.setmDescription("Test Description");
        tData.setmImage("Test Image Url");
        data.add(tData);
        dataResponse.setmData(data);

        return dataResponse;
    }

}