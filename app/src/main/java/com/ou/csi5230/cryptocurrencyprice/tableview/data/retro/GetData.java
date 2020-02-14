package com.ou.csi5230.cryptocurrencyprice.tableview.data.retro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {

    @GET("/crypto")
    Call<List<RetroCrypoPrice>> getCryptoData();
}
