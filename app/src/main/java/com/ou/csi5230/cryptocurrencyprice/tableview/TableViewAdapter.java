package com.ou.csi5230.cryptocurrencyprice.tableview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evrencoskun.tableview.adapter.AbstractTableAdapter;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractSorterViewHolder;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.ou.csi5230.cryptocurrencyprice.R;
import com.ou.csi5230.cryptocurrencyprice.tableview.data.CryptoPrice;
import com.ou.csi5230.cryptocurrencyprice.tableview.holder.CellViewHolder;
import com.ou.csi5230.cryptocurrencyprice.tableview.holder.ChangeCellViewHolder;
import com.ou.csi5230.cryptocurrencyprice.tableview.holder.ColumnHeaderViewHolder;
import com.ou.csi5230.cryptocurrencyprice.tableview.holder.IconCellViewHolder;
import com.ou.csi5230.cryptocurrencyprice.tableview.holder.RowHeaderViewHolder;
import com.ou.csi5230.cryptocurrencyprice.tableview.model.Cell;
import com.ou.csi5230.cryptocurrencyprice.tableview.model.ColumnHeader;
import com.ou.csi5230.cryptocurrencyprice.tableview.model.RowHeader;

import java.util.List;

public class TableViewAdapter extends AbstractTableAdapter<ColumnHeader, RowHeader, Cell> {

    private TableViewModel tableViewModel;

    public TableViewAdapter(Context context) {
        super(context);

        this.tableViewModel = new TableViewModel();
    }


    @Override
    public AbstractViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {
        View layout;

        switch (viewType) {
            case TableViewModel.ICON_TYPE:
                layout = LayoutInflater.from(mContext).inflate(R.layout
                        .table_view_image_cell_layout, parent, false);

                return new IconCellViewHolder(layout);


            case TableViewModel.CHANGE_TYPE:
                layout = LayoutInflater.from(mContext).inflate(R.layout
                        .table_view_change_cell_layout, parent, false);

                return new ChangeCellViewHolder(layout);

            default:
                layout = LayoutInflater.from(mContext).inflate(R.layout.table_view_cell_layout,
                        parent, false);

                return new CellViewHolder(layout);
        }
    }

    @Override
    public void onBindCellViewHolder(AbstractViewHolder holder, Object object, int
            row, int col) {
        Cell cell = (Cell) object;

        if (holder instanceof CellViewHolder) {
            ((CellViewHolder) holder).setCellModel(cell, col);

        } else if (holder instanceof IconCellViewHolder) {
            ((IconCellViewHolder) holder).setCellModel(cell);
        } else if (holder instanceof ChangeCellViewHolder) {
            ((ChangeCellViewHolder) holder).setCellModel(cell);
        }

    }

    @Override
    public AbstractSorterViewHolder onCreateColumnHeaderViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(mContext).inflate(R.layout
                .table_view_column_header_layout, parent, false);

        return new ColumnHeaderViewHolder(layout, getTableView());
    }

    @Override
    public void onBindColumnHeaderViewHolder(AbstractViewHolder holder, Object object, int col) {
        ColumnHeader columnHeader = (ColumnHeader) object;

        ColumnHeaderViewHolder columnHeaderViewHolder = (ColumnHeaderViewHolder) holder;

        columnHeaderViewHolder.setColumnHeader(columnHeader);
    }

    @Override
    public AbstractViewHolder onCreateRowHeaderViewHolder(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(mContext).inflate(R.layout.table_view_row_header_layout,
                parent, false);

        return new RowHeaderViewHolder(layout);
    }

    @Override
    public void onBindRowHeaderViewHolder(AbstractViewHolder holder, Object object, int position) {

        RowHeader rowHeaderModel = (RowHeader) object;

        RowHeaderViewHolder rowHeaderViewHolder = (RowHeaderViewHolder) holder;
        rowHeaderViewHolder.rowHeaderTextView.setText(rowHeaderModel.getData());

    }

    @Override
    public View onCreateCornerView() {
        return LayoutInflater.from(mContext).inflate(R.layout.table_view_corner_layout, null, false);
    }

    @Override
    public int getColumnHeaderItemViewType(int position) {
        return 0;
    }

    @Override
    public int getRowHeaderItemViewType(int position) {
        return 0;
    }

    @Override
    public int getCellItemViewType(int position) {
        return tableViewModel.getCellItemViewType(position);
    }


    public void setCryptoPrices(List<CryptoPrice> cryptoPrices) {
        tableViewModel.generateListForTableView(cryptoPrices);

        setAllItems(
                tableViewModel.getColumeHeaderModeList(),
                tableViewModel.getRowHeaderList(),
                tableViewModel.getCellList()
        );
    }

}