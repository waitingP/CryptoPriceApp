package com.ou.csi5230.cryptocurrencyprice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.evrencoskun.tableview.TableView;
import com.ou.csi5230.cryptocurrencyprice.tableview.TableViewAdapter;
import com.ou.csi5230.cryptocurrencyprice.tableview.TableViewListener;
import com.ou.csi5230.cryptocurrencyprice.tableview.data.CryptoPriceDataProvider;

public class MainFragment extends Fragment {

    private TableView mTableView;
    private TableViewAdapter tableViewAdapter;
    private CryptoPriceDataProvider dataProvider;

    public MainFragment() {
        // Required empty public constructor
    }

    public MainFragment(CryptoPriceDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mTableView = view.findViewById(R.id.my_TableView);

        initializeTableView(mTableView);


        return view;
    }


    private void initializeTableView(TableView tableView) {

        // Create TableView Adapter
        tableViewAdapter = new TableViewAdapter(getContext());
        tableViewAdapter.setTableView(tableView);
        tableViewAdapter.setCryptoPrices(dataProvider.get());
        tableView.setAdapter(tableViewAdapter);

        // Create listener
        tableView.setTableViewListener(new TableViewListener(tableView, getContext(), dataProvider));
    }
}
