package com.jacmobile.productlookup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jacmobile.productlookup.network.model.WalmartItem;
import com.jacmobile.productlookup.network.model.WalmartQuery;
import com.jacmobile.productlookup.network.service.WalmartService;
import com.jacmobile.productlookup.utils.Ui;
import com.jacmobile.productlookup.views.MultiStateView;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class BaseActivityFragment extends Fragment
{
    public static final String TAG = BaseActivityFragment.class.getSimpleName();

    @Inject WalmartService walmartService;

    @InjectView(R.id.input_product) EditText inputQuery;
    @InjectView(R.id.list_product_search) ListView productList;
    @InjectView(R.id.state_view_lookup) MultiStateView multiStateView;

    private ProductListAdapter productListAdapter;

    public BaseActivityFragment() {}

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ((BaseActivity) getActivity()).getApplicationComponent().inject(this);

        View root = inflater.inflate(R.layout.fragment_base, container, false);
        ButterKnife.inject(this, root);
        return root;
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        setProductLookupListener();
    }

    /**
     *
     */
    private void setProductLookupListener()
    {
        inputQuery.setOnEditorActionListener(
                new TextView.OnEditorActionListener()
                {
                    @Override public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
                    {
                        if (actionId == EditorInfo.IME_ACTION_DONE) {
                            Ui.hideSoftKeyboard(v);
                            searchWalmart(v.getText().toString());

                            return true;
                        }
                        return false;
                    }
                }
        );
    }

    /**
     *
     * @param query
     */
    private void searchWalmart(String query)
    {
        walmartService.searchWalmart(query, new Callback<WalmartQuery>()
        {
            @Override
            public void success(WalmartQuery walmartQuery, Response response)
            {
                handleWalmartSearch(walmartQuery);
            }

            @Override
            public void failure(RetrofitError error)
            {
                // something went wrong
            }
        });
    }

    private void handleWalmartSearch(WalmartQuery result)
    {
        if (productListAdapter == null) {
            productListAdapter = new ProductListAdapter(result);
        } else {
            productListAdapter.updateResults(result.getItems());
        }
        productList.setAdapter(productListAdapter);
    }

    class ProductListAdapter extends BaseAdapter
    {
        private List<WalmartItem> walmartItems;

        public ProductListAdapter(WalmartQuery searchResult)
        {
            this.walmartItems = searchResult.getItems();
        }

        public void updateResults(List<WalmartItem> walmartItems)
        {
            this.walmartItems = walmartItems;
            notifyDataSetChanged();
        }

        @Override public int getCount()
        {
            return walmartItems.size();
        }

        @Override public WalmartItem getItem(int position)
        {
            return walmartItems.get(position);
        }

        @Override public long getItemId(int position)
        {
            return walmartItems.get(position).getItemId();
        }

        @Override public View getView(int position, View convertView, ViewGroup parent)
        {
            Holder holder;

            if (convertView != null) {
                holder = (Holder) convertView.getTag();
            } else {
                holder = new Holder();
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.product_item, parent, false);
                holder.product = (ImageView) convertView.findViewById(R.id.img_product);
                holder.name = (TextView) convertView.findViewById(R.id.txt_product_name);
                holder.price = (TextView) convertView.findViewById(R.id.txt_product_price);
                convertView.setTag(holder);
            }

            WalmartItem currentItem = walmartItems.get(position);

            holder.name.setText(currentItem.getName());
            holder.price.setText("Sale Price: $"+currentItem.getSalePrice());

            Glide.with(getActivity())
                    .load(currentItem.getThumbnailImage())
                    .crossFade()
                    .into(holder.product);

            Log.wtf(
                    TAG, currentItem.toString()
            );

            return convertView;
        }
    }

    static class Holder
    {
        ImageView product;
        TextView name, price;
    }
}