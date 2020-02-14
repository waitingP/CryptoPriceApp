package com.ou.csi5230.cryptocurrencyprice.tableview.data.retro;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetroCrypoPrice {
    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private String price;

    @SerializedName("change")
    private String change;

    @SerializedName("volume")
    private String volume;

    @SerializedName("marketCap")
    private String marketCap;
}
