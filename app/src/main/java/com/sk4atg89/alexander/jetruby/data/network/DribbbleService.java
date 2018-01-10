package com.sk4atg89.alexander.jetruby.data.network;


import com.sk4atg89.alexander.jetruby.data.network.dto.DribbbleDTO;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DribbbleService {

    @GET("shots")
    Single<List<DribbbleDTO>> getShots(
            @Query("access_token") String accessToken
            , @Query("page") int page
            , @Query("per_page") int perPage
    );

}
