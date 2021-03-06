package sebastians.challenge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import sebastians.challenge.data.Challenge;
import sebastians.challenge.views.PinnedSectionListView;

/**
 * Created by kunterbunt on 14.06.15.
 */
public abstract class ListAdapterHeader<T> extends ArrayAdapter<T> implements PinnedSectionListView.PinnedSectionListAdapter {

    private int mResource;
    private int mResourceHeader;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public ListAdapterHeader(Context context, int resource, int resourceHeader, List<T> objects) {
        super(context, resource, objects);
        mResource = resource;
        mResourceHeader = resourceHeader;
    }

    // We implement this method to return 'true' for all view types we want to pin
    @Override
    public boolean isItemViewTypePinned(int viewType) {
        //return viewType == <type to be pinned>;
        return viewType == TYPE_HEADER;
    }

    @Override
    public int getItemViewType(int position) {
        // Define a way to determine which layout to use, here it's just evens and odds.
        if (getItem(position) == null)
            return TYPE_HEADER;
        return TYPE_ITEM;
    }




    @Override
    public int getViewTypeCount() {
        return 2; // Count of different layouts
    }

    public abstract void style(View view, int position);
    public abstract void styleHeader(View view, boolean active);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate.
        if (getItemViewType(position) == TYPE_ITEM) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(mResource, parent, false);

            style(view, position);
            return view;
        } else {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(mResourceHeader, parent, false);
            if (position > 0)
                styleHeader(view, false);
            else
                styleHeader(view, true);
            return view;
        }
    }


}
