package com.ou.csi5230.cryptocurrencyprice.tableview.data;

import android.net.Uri;

import com.ou.csi5230.cryptocurrencyprice.tableview.data.retro.RetroCrypoPrice;
import com.ou.csi5230.cryptocurrencyprice.tableview.data.retro.ServerData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


// price data downloaded from https://coinmarketcap.com/
public class CryptoPriceDataProvider {

    private Map<String, String> detailData;


    public CryptoPriceDataProvider() {
        this.detailData = getDetailDescriptions();
    }

    public List<CryptoPrice> get() {
        List<CryptoPrice> list = new ArrayList<>();

        return getData().stream().map(d -> CryptoPrice.builder()
                .icon(d.getName().toLowerCase().replace(" ", "_"))
                .name(d.getName())
                .price(d.getPrice())
                .changeIn24h(d.getChange())
                .volumeIn24h(d.getVolume())
                .marketCap(d.getMarketCap()).build()).collect(Collectors.toList());
    }

    public String getDetailDescription(String name) {
        return detailData.getOrDefault(name, "Currently Unavailable");
    }

    public Uri getHistoryPriceGraphUri(String name) {
        String imageName = name.toLowerCase().replace(" ", "_") + "_history";
        return Uri.parse(String.format(
                "android.resource://com.ou.csi5230.cryptocurrencyprice/drawable/%s", imageName
        ));
    }


    // Currently the descriptions are hard coded for the description featur, in the long run, these information should also be
    // fetched from the internet and store them into database.
    private Map<String, String> getDetailDescriptions() {
        String[][] data =CryptoDescription.DATA;

        Map<String, String> map = new HashMap<>();
        for (String[] d : data) {
            map.put(d[0], d[1]);
        }

        return map;
    }

    private List<RetroCrypoPrice> getData() {
        List<RetroCrypoPrice> data = new ArrayList<>();

        ServerData.get(data);

        return data;
    }
}
