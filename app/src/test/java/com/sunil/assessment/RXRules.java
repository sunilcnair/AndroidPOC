package com.sunil.assessment;

import org.junit.After;
import org.junit.Before;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sunil on 01-02-2018.
 */

public class RXRules {
    @Before
    public void rxSetup() {
        setAllRxThreadsToMainThread();
    }

    private void setAllRxThreadsToMainThread() {
        RxAndroidPlugins.reset();
        RxJavaPlugins.reset();

        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setComputationSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setNewThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxAndroidPlugins.setMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @After
    public void tearDown() throws Exception {
        RxAndroidPlugins.reset();
        RxJavaPlugins.reset();
    }
}
