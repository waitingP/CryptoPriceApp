package com.ou.csi5230.cryptocurrencyprice.tableview.holder;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.ou.csi5230.cryptocurrencyprice.R;
import com.ou.csi5230.cryptocurrencyprice.tableview.model.Cell;

public class IconCellViewHolder extends AbstractViewHolder {

    private final ImageView cellImageView;

    public IconCellViewHolder(View itemView) {
        super(itemView);
        cellImageView =  itemView.findViewById(R.id.image_cell);
    }

    public void setCellModel(Cell cell) {
        String imageName = String.valueOf(cell.getData());

        cellImageView.setImageURI(Uri.parse(String.format(
                "android.resource://com.ou.csi5230.cryptocurrencyprice/drawable/%s", imageName
        )));
    }

}
