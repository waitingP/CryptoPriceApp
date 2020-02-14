package com.ou.csi5230.cryptocurrencyprice.tableview.holder;

import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.ou.csi5230.cryptocurrencyprice.R;
import com.ou.csi5230.cryptocurrencyprice.tableview.model.Cell;


public class CellViewHolder extends AbstractViewHolder {

    private final TextView cellTextView;

    private final LinearLayout cellContainer;

    public CellViewHolder(View itemView) {
        super(itemView);
        cellTextView = itemView.findViewById(R.id.cell_data);
        cellContainer = itemView.findViewById(R.id.cell_container);
    }

    public void setCellModel(Cell cell, int pColumnPosition) {
        cellTextView.setText(String.valueOf(cell.getData()));
        cellTextView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);

        cellContainer.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;

        cellTextView.requestLayout();
    }

    public String getText() {
        return cellTextView.getText().toString();
    }
}