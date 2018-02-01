package com.sunil.assessment.DI;

import com.sunil.assessment.ui.fragments.POCListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sunil on 31-01-2018.\
 * This class acts as a bridge between the Dependency module and the fragment class
 */



@Singleton
@Component(modules = DIModule.class)
public interface DIComponent {
    void inject(POCListFragment content);

}
