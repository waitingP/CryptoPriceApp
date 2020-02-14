package com.ou.csi5230.cryptocurrencyprice.tableview.holder;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.ou.csi5230.cryptocurrencyprice.R;
import com.ou.csi5230.cryptocurrencyprice.tableview.model.Cell;


public class ChangeCellViewHolder extends AbstractViewHolder {
    public final TextView cellTextView;
    public final LinearLayout cellContainer;

    public ChangeCellViewHolder(View itemView) {
        super(itemView);
        cellTextView = itemView.findViewById(R.id.change_cell);
        cellContainer = itemView.findViewById(R.id.change_cell_container);
    }

    public void setCellModel(Cell cell) {

        cellTextView.setText(String.format("%s", cell.getData()));
        cellTextView.setTextColor(((String) cell.getData()).startsWith("-") ? Color.RED : Color.rgb(0, 158, 115));
        cellContainer.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
        cellTextView.requestLayout();
    }
}
