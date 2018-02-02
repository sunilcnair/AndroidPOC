package com.sunil.assessment.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sunil.assessment.R;
import com.sunil.assessment.business.model.PocDataObject;
import com.sunil.assessment.ui.fragments.POCListFragment;
import com.sunil.assessment.ui.fragments.POCDetailsFragment;

/**
 * Created by sunil on 31-01-2018.
 * This is the main activity for showing the list of data
 */

public class POCMainActivity extends AppCompatActivity implements POCListFragment.OnRowSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_main);
        initFragment(POCListFragment.newInstance());
    }

    /**
     * Initialize fragment
     * @param detailFragment
     */
    private void initFragment(Fragment detailFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.contentFrame, detailFragment);
        transaction.commit();
    }

    @Override
    public void onArticleSelected(PocDataObject mData) {
        Bundle args = new Bundle();
        args.putSerializable(PocDataObject.class.getSimpleName(),mData);
        //args.putInt(ArticleFragment.ARG_POSITION, position);
        Fragment mFragment = POCDetailsFragment.newInstance();
        mFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.contentFrame,mFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
