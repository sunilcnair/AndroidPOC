package com.sunil.assessment.ui.mvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunil.assessment.R;
import com.sunil.assessment.business.model.PocDataObject;

import java.util.List;

/**
 * Created by sunil on 01-02-2018.
 */

public class PocListAdapter extends RecyclerView.Adapter<PocItem>{

    private List<PocDataObject> mDataList;
    private POCListContract.Presenter mPresenter;
    private Context mContext;


    public PocListAdapter(POCListContract.Presenter actionPresenter, Context cnt )
    {
        this.mPresenter = actionPresenter;
        this.mContext = cnt;
    }

    @Override
    public PocItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_layout, parent, false);
        return new PocItem(view, mContext);
    }

    @Override
    public void onBindViewHolder(PocItem holder, int position) {
        PocDataObject mData = mDataList.get(holder.getAdapterPosition());
        holder.bind(mData);
        holder.itemView.setOnClickListener(v -> mPresenter.onDataClicked(mData));
    }

    @Override
    public int getItemCount() {
        if (mDataList != null && !mDataList.isEmpty()) {
            return mDataList.size();
        } else {
            return 0;
        }
    }

    /**
     * Load actors in recycler adapter
     * @param mList list
     */
    public void displayData(List<PocDataObject> mList) {
        this.mDataList = mList;
    }
}
