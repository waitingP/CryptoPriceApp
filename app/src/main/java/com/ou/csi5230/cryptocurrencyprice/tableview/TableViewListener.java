package com.ou.csi5230.cryptocurrencyprice.tableview;

import android.content.Context;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.evrencoskun.tableview.ITableView;
import com.evrencoskun.tableview.listener.ITableViewListener;
import com.ou.csi5230.cryptocurrencyprice.R;
import com.ou.csi5230.cryptocurrencyprice.tableview.data.CryptoPriceDataProvider;
import com.ou.csi5230.cryptocurrencyprice.tableview.holder.CellViewHolder;
import com.ou.csi5230.cryptocurrencyprice.tableview.holder.ColumnHeaderViewHolder;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;
import static com.ou.csi5230.cryptocurrencyprice.tableview.TableViewModel.NAME_TYPE_INDEX;

public class TableViewListener implements ITableViewListener {

    private ITableView mTableView;
    private Context mContext;
    private CryptoPriceDataProvider dataProvider;

    public TableViewListener(ITableView pTableView, Context context, CryptoPriceDataProvider dataProvider) {
        this.mTableView = pTableView;
        this.mContext = context;
        this.dataProvider = dataProvider;
    }

    @Override
    public void onCellClicked(RecyclerView.ViewHolder cellView, int column, int row) {
        if (column == NAME_TYPE_INDEX) {
            String name = ((CellViewHolder) cellView).getText();
            View detailView = LayoutInflater.from(mContext).inflate(R.layout.activity_details, null);
            TextView graphHeader = detailView.findViewById(R.id.details_graph_title);
            ImageView graph = detailView.findViewById(R.id.details_graph);

            TextView textHeader = detailView.findViewById(R.id.details_text_title);
            TextView textDescription = detailView.findViewById(R.id.details_text_description);

            graphHeader.setText("Price History");
            graph.setImageURI(getImage(name));

            textHeader.setText("About " + name);
            textDescription.setText(getDetailText(name));
            textDescription.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);


            final PopupWindow popupWindow = new PopupWindow(detailView, WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT);

            detailView.findViewById(R.id.details_dismiss).setOnClickListener(v -> popupWindow.dismiss());

            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);

            popupWindow.getContentView().setOnClickListener(v -> popupWindow.dismiss());
            popupWindow.showAtLocation((View) mTableView, Gravity.CENTER, 0, 0);
        }
    }

    private String getDetailText(String name) {
        return dataProvider.getDetailDescription(name);
    }

    private Uri getImage(String name) {
        return dataProvider.getHistoryPriceGraphUri(name);
    }

    @Override
    public void onCellLongPressed(RecyclerView.ViewHolder cellView, int column, int row) {
    }

    @Override
    public void onColumnHeaderClicked(RecyclerView.ViewHolder columnHeaderView, int
            column) {
    }

    @Override
    public void onColumnHeaderLongPressed(RecyclerView.ViewHolder columnHeaderView, int
            column) {
        if (columnHeaderView != null && columnHeaderView instanceof ColumnHeaderViewHolder && (column == 2 || column == 3)) {

            // Create Long Press Popup
            ColumnHeaderLongPressPopup popup = new ColumnHeaderLongPressPopup(
                    (ColumnHeaderViewHolder) columnHeaderView, mTableView);

            // Show
            popup.show();
        }
    }

    @Override
    public void onRowHeaderClicked(RecyclerView.ViewHolder rowHeaderView, int row) {
    }

    @Override
    public void onRowHeaderLongPressed(RecyclerView.ViewHolder owHeaderView, int row) {
    }
}
