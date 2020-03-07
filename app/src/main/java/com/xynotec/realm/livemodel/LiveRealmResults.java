package com.xynotec.realm.livemodel;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import java.util.List;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmModel;
import io.realm.RealmResults;

public class LiveRealmResults<T extends RealmModel> extends LiveData<List<T>> {
    private final RealmResults<T> results;

    // The listener will notify the observers whenever a change occurs.
    // The results are modified in change. This could be expanded to also return the change set in a pair.
    private OrderedRealmCollectionChangeListener<RealmResults<T>> listener = new OrderedRealmCollectionChangeListener<RealmResults<T>>() {
        @Override
        public void onChange(@NonNull RealmResults<T> results, @Nullable OrderedCollectionChangeSet changeSet) {
            LiveRealmResults.this.setValue(results);
        }
    };

    @MainThread
    public LiveRealmResults(@NonNull RealmResults<T> results) {
        //noinspection ConstantConditions
        if (results == null) {
            throw new IllegalArgumentException("Results cannot be null!");
        }
        if (!results.isValid()) {
            throw new IllegalArgumentException("The provided RealmResults is no longer valid, the Realm instance it belongs to is closed. It can no longer be observed for changes.");
        }
        this.results = results;
        if (results.isLoaded()) {
            // we should not notify observers when results aren't ready yet (async query).
            // however, synchronous query should be set explicitly.
            setValue(results);
        }
    }

    // We should start observing and stop observing, depending on whether we have observers.

    /**
     * Starts observing the RealmResults, if it is still valid.
     */
    @Override
    protected void onActive() {
        super.onActive();
        if (results.isValid()) { // invalidated results can no longer be observed.
            results.addChangeListener(listener);
        }
    }

    /**
     * Stops observing the RealmResults.
     */
    @Override
    protected void onInactive() {
        super.onInactive();
        if (results.isValid()) {
            results.removeChangeListener(listener);
        }
    }
}
