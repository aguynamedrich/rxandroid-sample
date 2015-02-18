package com.richstern.rxsample.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.richstern.rxsample.R;
import com.richstern.rxsample.adapters.SearchResultsAdapter;
import com.richstern.rxsample.app.SampleApp;
import rx.android.schedulers.AndroidSchedulers;
import rx.android.widget.OnTextChangeEvent;
import rx.android.widget.WidgetObservable;
import rx.schedulers.Schedulers;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.search_term)
    EditText searchTerm;

    @InjectView(R.id.list)
    ListView list;

    SearchResultsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        adapter = new SearchResultsAdapter(this);
        list.setAdapter(adapter);
        WidgetObservable.text(searchTerm).subscribe(onTextChangeEvent ->
            fetchResults(onTextChangeEvent));
    }

    private void fetchResults(OnTextChangeEvent onTextChangeEvent) {
        String term = onTextChangeEvent.text().toString().trim();
        SampleApp.getClient().getSearchResultService().getSearchResults(term)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(searchResults -> {
                adapter.setResults(searchResults.results);
                adapter.notifyDataSetChanged();
        });
    }
}
