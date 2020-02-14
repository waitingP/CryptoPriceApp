package com.ou.csi5230.cryptocurrencyprice.tableview;

import android.view.Gravity;

import com.ou.csi5230.cryptocurrencyprice.tableview.data.CryptoPrice;
import com.ou.csi5230.cryptocurrencyprice.tableview.model.Cell;
import com.ou.csi5230.cryptocurrencyprice.tableview.model.ColumnHeader;
import com.ou.csi5230.cryptocurrencyprice.tableview.model.RowHeader;

import java.util.ArrayList;
import java.util.List;


public class TableViewModel {

    public static final int ICON_TYPE = 1;
    public static final int CHANGE_TYPE = 2;

    public static final int ICON_TYPE_INDEX = 0;
    public static final int NAME_TYPE_INDEX = 1;
    public static final int CHANGE_TYPE_INDEX = 3;

    private List<ColumnHeader> mColumnHeaderList;
    private List<RowHeader> mRowHeaderList;
    private List<List<Cell>> mCellList;

    public int getCellItemViewType(int column) {
        switch (column) {
            case ICON_TYPE_INDEX:
                return ICON_TYPE;
            case CHANGE_TYPE_INDEX:
                return CHANGE_TYPE;
            default:
                return 0;
        }
    }

    public static int getColumnTextAlign(int column) {
        switch (column) {
            case 0:
                return Gravity.CENTER;
            default:
                return Gravity.LEFT;
        }

    }

    private List<ColumnHeader> createColumnHeaderList() {
        List<ColumnHeader> list = new ArrayList<>();

        // Create Column Headers
        list.add(new ColumnHeader("Icon"));
        list.add(new ColumnHeader("Name"));
        list.add(new ColumnHeader("Price"));
        list.add(new ColumnHeader("Change (24h)"));
        list.add(new ColumnHeader("Volume (24h)"));
        list.add(new ColumnHeader("Market Cap"));

        return list;
    }

    private List<List<Cell>> createCellList(List<CryptoPrice> cryptoPrices) {
        List<List<Cell>> lists = new ArrayList<>();

        for (int i = 0; i < cryptoPrices.size(); i++) {
            CryptoPrice cryptoPrice = cryptoPrices.get(i);

            List<Cell> list = new ArrayList<>();

            list.add(new Cell("1-" + i, cryptoPrice.getIcon()));
            list.add(new Cell("2-" + i, cryptoPrice.getName()));
            list.add(new Cell("3-" + i, cryptoPrice.getPrice()));
            list.add(new Cell("4-" + i, cryptoPrice.getChangeIn24h()));
            list.add(new Cell("5-" + i, cryptoPrice.getVolumeIn24h()));
            list.add(new Cell("6-" + i, cryptoPrice.getMarketCap()));

            lists.add(list);
        }

        return lists;
    }

    private List<RowHeader> createRowHeaderList(int size) {
        List<RowHeader> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new RowHeader(String.valueOf(i + 1)));
        }
        return list;
    }


    public List<ColumnHeader> getColumeHeaderModeList() {
        return mColumnHeaderList;
    }

    public List<RowHeader> getRowHeaderList() {
        return mRowHeaderList;
    }

    public List<List<Cell>> getCellList() {
        return mCellList;
    }


    public void generateListForTableView(List<CryptoPrice> cryptoPrices) {
        mColumnHeaderList = createColumnHeaderList();
        mCellList = createCellList(cryptoPrices);
        mRowHeaderList = createRowHeaderList(cryptoPrices.size());
    }
}



