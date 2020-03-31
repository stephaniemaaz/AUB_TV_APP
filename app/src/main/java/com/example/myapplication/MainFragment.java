package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainFragment extends BrowseFragment {
    private static final String TAG = "MainFragment";

    private ArrayObjectAdapter mRowsAdapter;
    private static final int GRID_ITEM_WIDTH = 300;
    private static final int GRID_ITEM_HEIGHT = 200;

    private JSONObject metadata;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onActivityCreated(savedInstanceState);

        setupUIElements();

        setupEvenListeners();

        FetchDataFromApi();
    }

    private void setupUIElements() {
        setBadgeDrawable(getActivity().getResources().getDrawable(R.drawable.logo_white));
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(getResources().getColor(R.color.indigo_dark));
    }

    private void setupEvenListeners() {
        setOnItemViewClickedListener(new ItemViewClickedListener());
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {

        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item,
                                  RowPresenter.ViewHolder rowViewHolder, Row row) {
            Log.i("click", "Item Clicked");
            // todo: when clicking on a video
            if (item instanceof Video) {
                Video video = (Video) item;
                Log.d(TAG, "Item: " + item.toString());
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("video", video);
                getActivity().startActivity(intent);
            }
            if (item instanceof Powerpoint) {
                Powerpoint powerpoint = (Powerpoint) item;
                Log.d(TAG, "Item: " + item.toString());
                Intent intent = new Intent(getActivity(), PowerPointActivity.class);
                getActivity().startActivity(intent);
            }
            else if (item instanceof Calendar) {
                Intent intent = new Intent(getActivity(), CalendarActivity.class);
                startActivity(intent);
            }
        }
    }

    // todo: here we can add rows
    private void loadRows() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        // region calendar
        HeaderItem cardPresenterHeader_0 = new HeaderItem(0, "CALENDAR");
        CardPresenter cardPresenter_0 = new CardPresenter();
        ArrayObjectAdapter cardRowAdapter_0 = new ArrayObjectAdapter(cardPresenter_0);

        Calendar calendar = new Calendar();
        cardRowAdapter_0.add(calendar);
        mRowsAdapter.add(new ListRow(cardPresenterHeader_0, cardRowAdapter_0));
        // endregion

        // region add rows
        try {
            JSONArray categories = metadata.names();
            for(int i = 0; i < categories.length(); i++) {
                String category = categories.get(i).toString();
                HeaderItem cardPresenterHeader = new HeaderItem(i, category);
                CardPresenter cardPresenter = new CardPresenter();
                ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);

                JSONArray items = metadata.getJSONArray(category);
                for (int j = 0; j < items.length(); j++) {
                    try {
                        JSONObject item = items.optJSONObject(j);
                        Log.i("JSON:", item.toString());
                        String itemType = item.getString("type");
                        Log.i("Type:", itemType);
                        DisplayObject itemParsed = null;
                        if (itemType.toUpperCase().equals("VIDEO")) {
                            String videoTitle = item.getString("title");
                            String videoDescription = item.getString("description");
                            String videoYouTubeID = item.getString("youtubeId");
                            String cardUrl = item.getString("cardUrl");
                            itemParsed = new Video(videoTitle, videoDescription, videoYouTubeID, cardUrl);
                        }
                        if (itemParsed != null) {
                            cardRowAdapter.add(itemParsed);
                        }
                    } catch (Exception e) {
                        Log.i("ERROR", e.getMessage());
                    }
                }
                mRowsAdapter.add(new ListRow(cardPresenterHeader, cardRowAdapter));

            }
        } catch (Exception e) {
            Log.i("Error:", e.getMessage());
        }
        setAdapter(mRowsAdapter);
        // endregion
    }

    private class GridItemPresenter extends Presenter {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent) {
            TextView view = new TextView(parent.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT));
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setBackgroundColor(getResources().getColor(R.color.default_background));
            view.setTextColor(Color.WHITE);
            view.setGravity(Gravity.CENTER);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object item) {
            ((TextView) viewHolder.view).setText((String) item);
        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {

        }
    }

    private Long FetchDataFromApi() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, getResources().getString(R.string.api),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            metadata = new JSONObject(response);
                            loadRows();
                        } catch (JSONException e) {
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                            Log.i("Error", e.getMessage());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Failed to get data", Toast.LENGTH_LONG).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

        return Long.MAX_VALUE;
    }
}
