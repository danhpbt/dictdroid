package com.xynotec.dictdroid.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {
    }

    @Override
    public Single<String> doTranslateApiCall(String url) {
        return Rx2AndroidNetworking.get(url)
            //.addHeaders(mApiHeader.getInfoApiHeader())
            //.addQueryParameter(request)
            .build()
            .getStringSingle();
    }
}
