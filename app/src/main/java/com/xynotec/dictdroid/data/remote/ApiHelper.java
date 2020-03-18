package com.xynotec.dictdroid.data.remote;

import io.reactivex.Single;

public interface ApiHelper {
    Single<String> doTranslateApiCall(String url);
}
