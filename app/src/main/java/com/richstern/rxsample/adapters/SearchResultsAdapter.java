package com.richstern.rxsample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.richstern.rxsample.R;
import com.richstern.rxsample.model.SearchResult;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by rich on 2/16/15.
 */
public class SearchResultsAdapter extends BaseAdapter {
    private Context mContext;
    private final LayoutInflater mLayoutInflater;
    List<SearchResult> mResults = Collections.emptyList();

    public SearchResultsAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setResults(List<SearchResult> results) {
        mResults = results;
    }

    @Override
    public int getCount() {
        return mResults.size();
    }

    @Override
    public Object getItem(int position) {
        return mResults.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mResults.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.row_search_result, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        SearchResult result = mResults.get(position);
        if (result != null) {
            holder.artistName.setText(result.artistName);
            holder.trackName.setText(result.trackName);
            Picasso.with(mContext).load(result.artworkUrl100).into(holder.thumbnail);
        }
        return convertView;
    }

    static class ViewHolder {

        @InjectView(R.id.artist_name)
        TextView artistName;

        @InjectView(R.id.track_name)
        TextView trackName;

        @InjectView(R.id.thumbnail)
        ImageView thumbnail;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
