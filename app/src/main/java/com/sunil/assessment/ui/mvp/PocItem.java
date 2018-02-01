package com.sunil.assessment.ui.mvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sunil.assessment.R;
import com.sunil.assessment.business.model.PocDataObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 01-01-2018.
 * Recycler view holder class
 */

public class PocItem extends RecyclerView.ViewHolder {

    @BindView(R.id.content_name)
    TextView mNameTextView;
    @BindView(R.id.content_image)
    ImageView mImageView;
    @BindView(R.id.content_descpt)
    TextView mDescrptionTextView;

    private Context mContext;

    public PocItem(View itemView, Context context) {
        super(itemView);
        this.mContext = context;
        ButterKnife.bind(this, itemView);
    }

    public void bind(PocDataObject mData)
    {
        mNameTextView.setText(mData.getmName());
        mDescrptionTextView.setText(mData.getmDescription());
        if(mData.getmImage()!= null)
        {
            Picasso.with(mContext).load(mData.getmImage()).into(mImageView);
        }else
        {
            Picasso.with(mContext).load(R.mipmap.ic_launcher_round).into(mImageView);
        }

    }
}
