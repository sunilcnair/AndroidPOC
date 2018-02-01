package com.sunil.assessment.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sunil.assessment.R;

import com.sunil.assessment.DI.DIComponent;
import com.sunil.assessment.DI.DIModule;

import com.sunil.assessment.DI.DaggerDIComponent;

import com.sunil.assessment.business.data.CoreUseCase;
import com.sunil.assessment.business.model.PocDataObject;
import com.sunil.assessment.business.model.PocDomainModel;
import com.sunil.assessment.ui.activity.POCDetailsActivity;
import com.sunil.assessment.ui.mvp.PocListAdapter;
import com.sunil.assessment.ui.mvp.POCListContract;
import com.sunil.assessment.ui.mvp.PocListPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Sunil C - 01-02-2018.
 */
public class POCListFragment extends Fragment implements POCListContract.View{

    private static final String TAG = POCListFragment.class.getSimpleName();

    @Inject
    CoreUseCase mCoreUsecase;

    @BindView(R.id.rootView)
    ViewGroup mRootView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.content_rv)
    RecyclerView mContentRecyclerView;

    private POCListContract.Presenter mPresenter;
    private PocListAdapter mAdapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment
     * @return A new instance of fragment ActorsListFragment.
     */
    public static POCListFragment newInstance() {
        return new POCListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mRoot = inflater.inflate(R.layout.fragment_content_list, container, false);
        ButterKnife.bind(this,mRoot);
        DIComponent mActorComponent = DaggerDIComponent.builder().dIModule(new DIModule(getContext())).build();
        mActorComponent.inject(this);
        return mRoot;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mPresenter = new PocListPresenter(mCoreUsecase, this);
        mContentRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new PocListAdapter(mPresenter, getContext());
        mContentRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override

    public void onResume()
    {
        super.onResume();
        mPresenter.getDataList();
    }

    @Override
    public void loadDataList(PocDomainModel dataList) {
        hideLoading();
        mAdapter.displayData(dataList.getmData());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void openDataDetails(PocDataObject mActor) {
        startActivity(new Intent(getContext(), POCDetailsActivity.class)
                .putExtra(PocDataObject.class.getSimpleName(), mActor));
    }

    @Override
    public void displayErrorResponse(String errorMessage) {
        hideLoading();
        Toast.makeText(getContext(),errorMessage,Toast.LENGTH_SHORT).show();
        Log.e(TAG, errorMessage);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }


}
