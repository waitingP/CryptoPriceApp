package com.ou.csi5230.cryptocurrencyprice.tableview.data.retro;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServerData {
    public static void get(List<RetroCrypoPrice> dataHolder) {
        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);
        Call<List<RetroCrypoPrice>> call = service.getCryptoData();

        call.enqueue(new Callback<List<RetroCrypoPrice>>() {

            @Override
            public void onResponse(Call<List<RetroCrypoPrice>> call, Response<List<RetroCrypoPrice>> response) {
                dataHolder.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroCrypoPrice>> call, Throwable t) {
                throw new RuntimeException("Fail to get data from server", t);
            }
        });

    }
}
