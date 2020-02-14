package com.ou.csi5230.cryptocurrencyprice.tableview.model;

import com.evrencoskun.tableview.sort.ISortableModel;

public class Cell implements ISortableModel {

    private String mId;

    private Object mData;

    public Cell(String id, Object data) {
        this.mId = id;
        this.mData = data;
    }

    /**
     * This is necessary for sorting process.
     * See ISortableModel
     */

    @Override
    public String getId() {
        return mId;
    }

    /**
     * This is necessary for sorting process.
     * See ISortableModel
     */

    @Override
    public Object getContent() {
        String num = (String) mData;
        if (num.startsWith("$")) {
            num = num.substring(1);
        } else if (num.endsWith("%")) {
            num = num.substring(0, num.length() - 1);
        }
        num = num.replace(",", "");

        return Double.parseDouble(num);
    }


    public Object getData() {
        return mData;
    }

    public void setData(String data) {
        mData = data;
    }
}
