package com.ou.csi5230.cryptocurrencyprice.tableview.holder;

import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.ou.csi5230.cryptocurrencyprice.R;

public class RowHeaderViewHolder extends AbstractViewHolder {
    public final TextView rowHeaderTextView;

    public RowHeaderViewHolder(View view) {
        super(view);
        rowHeaderTextView = view.findViewById(R.id.row_header_textview);
    }

    @Override
    public void setSelected(SelectionState p_nSelectionState) {
        super.setSelected(p_nSelectionState);

        int nBackgroundColorId;
        int nForegroundColorId;

        if (p_nSelectionState == SelectionState.SELECTED) {
            nBackgroundColorId = R.color.selected_background_color;
            nForegroundColorId = R.color.selected_text_color;

        } else if (p_nSelectionState == SelectionState.UNSELECTED) {
            nBackgroundColorId = R.color.unselected_header_background_color;
            nForegroundColorId = R.color.unselected_text_color;

        } else { // SelectionState.SHADOWED

            nBackgroundColorId = R.color.shadow_background_color;
            nForegroundColorId = R.color.unselected_text_color;
        }

        itemView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(),
                nBackgroundColorId));
        rowHeaderTextView.setTextColor(ContextCompat.getColor(rowHeaderTextView.getContext(),
                nForegroundColorId));
    }
}
