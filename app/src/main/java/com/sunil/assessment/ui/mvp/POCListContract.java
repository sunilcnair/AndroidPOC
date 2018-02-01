package com.sunil.assessment.ui.mvp;

import com.sunil.assessment.business.model.PocDataObject;
import com.sunil.assessment.business.model.PocDomainModel;

/**
 * Created by sunil on 01-02-2018.
 * This is a contract interface bwteen View (fragment) and Presenter.
 * This allows abstraction and loose coupling between view and presenter.
 */

public interface POCListContract {

    interface View extends BaseView<Presenter> {
        /**
         * Display data
         * @param dataList list
         */
        void loadDataList(PocDomainModel dataList);

        /**
         * Open data details page
         * @param mData object
         */
        void openDataDetails(PocDataObject mData);

        /**
         * Display error message
         * @param errorMessage string
         */
        void displayErrorResponse(String errorMessage);

        /**
         * Show a loading view with a progress bar indicating a loading process.
         */
        void showLoading();

        /**
         * Hide a loading view.
         */
        void hideLoading();


    }

    interface Presenter extends BasePresenter {
        /**
         * Method to get actor list
         */
        void getDataList();

        /**
         * Handle actor item click
         * @param mData object
         */
        void onDataClicked(PocDataObject mData);

    }
}

