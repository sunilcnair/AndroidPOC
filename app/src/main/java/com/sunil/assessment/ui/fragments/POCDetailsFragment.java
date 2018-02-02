package com.sunil.assessment.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sunil.assessment.R;
import com.sunil.assessment.business.model.PocDataObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link POCDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class POCDetailsFragment extends Fragment {

    @BindView(R.id.content_image)
    ImageView mImageView;
    @BindView(R.id.content_description)
    TextView mDescription;
    @BindView(R.id.image_title)
    TextView mTitle;

    private PocDataObject mData;

    public static POCDetailsFragment newInstance() {
        return new POCDetailsFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View mRoot = inflater.inflate(R.layout.fragment_content_details, container, false);
        ButterKnife.bind(this, mRoot);
        mData = (PocDataObject) getArguments().getSerializable(PocDataObject.class.getSimpleName());
        return mRoot;
    }
    /**
     * Lifecycle method
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(mData.getmImage()!= null)
        {
            Picasso.with(getContext()).load(mData.getmImage()).into(mImageView);
        }else
        {
            Picasso.with(getContext()).load(R.mipmap.ic_launcher_round).into(mImageView);
        }

        mTitle.setText(mData.getmName());
        mDescription.setText(mData.getmDescription());

    }

}
