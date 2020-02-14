package com.ou.csi5230.cryptocurrencyprice.tableview.holder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.evrencoskun.tableview.ITableView;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractSorterViewHolder;
import com.evrencoskun.tableview.sort.SortState;
import com.ou.csi5230.cryptocurrencyprice.R;
import com.ou.csi5230.cryptocurrencyprice.tableview.model.ColumnHeader;

public class ColumnHeaderViewHolder extends AbstractSorterViewHolder {


    private final LinearLayout columnHeaderContainer;

    private final TextView columnHeaderTextView;

    private final ImageButton columnHeaderSortButton;
    private final ITableView tableView;
    private View.OnClickListener mSortButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (getSortState() == SortState.ASCENDING) {
                tableView.sortColumn(getAdapterPosition(), SortState.DESCENDING);
            } else if (getSortState() == SortState.DESCENDING) {
                tableView.sortColumn(getAdapterPosition(), SortState.ASCENDING);
            } else {
                tableView.sortColumn(getAdapterPosition(), SortState.DESCENDING);
            }

        }
    };

    public ColumnHeaderViewHolder(View itemView, ITableView tableView) {
        super(itemView);
        this.tableView = tableView;
        columnHeaderTextView = itemView.findViewById(R.id.column_header_textView);
        columnHeaderContainer = itemView.findViewById(R.id.column_header_container);
        columnHeaderSortButton = itemView.findViewById(R.id.column_header_sort_imageButton);

        // Set click listener to the sort button
        columnHeaderSortButton.setOnClickListener(mSortButtonClickListener);
    }

    public void setColumnHeader(ColumnHeader columnHeader) {
        columnHeaderTextView.setText(String.valueOf(columnHeader.getData()));

        columnHeaderContainer.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
        columnHeaderTextView.requestLayout();
    }

    @Override
    public void onSortingStatusChanged(SortState sortState) {
        super.onSortingStatusChanged(sortState);

        columnHeaderContainer.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;

        controlSortState(sortState);

        columnHeaderTextView.requestLayout();
        columnHeaderSortButton.requestLayout();
        columnHeaderContainer.requestLayout();
        itemView.requestLayout();
    }

    private void controlSortState(SortState sortState) {
        if (sortState == SortState.ASCENDING) {
            columnHeaderSortButton.setVisibility(View.VISIBLE);
            columnHeaderSortButton.setImageResource(R.drawable.ic_down);

        } else if (sortState == SortState.DESCENDING) {
            columnHeaderSortButton.setVisibility(View.VISIBLE);
            columnHeaderSortButton.setImageResource(R.drawable.ic_up);
        } else {
            columnHeaderSortButton.setVisibility(View.INVISIBLE);
        }
    }
}
