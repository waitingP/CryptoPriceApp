package com.ou.csi5230.cryptocurrencyprice.tableview.data;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CryptoPrice {
    private String icon;
    private String name;
    private String price;
    private String changeIn24h;
    private String volumeIn24h;
    private String marketCap;
}
