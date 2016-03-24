package com.santiago.multielementgrid.grid;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.santiago.multielementgrid.R;
import com.santiago.multielementgrid.grid.adapter.EntityGridAdapter;
import com.santiago.multielementgrid.grid.item_decoration.VerticalSpaceItemDecoration;

public class MultiElementGridView extends FrameLayout {

	private RecyclerView grid;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private LinearLayout noPreviasLayout;

	private HomeWithPreviaGridViewListener listener;
	
	public MultiElementGridView(Context context){
		this(context, null);
	}
	
	public MultiElementGridView(Context context, AttributeSet attrs) {
		super(context, attrs);

		inflate(context, R.layout.view_multi_element_grid, this);
		
	    grid = (RecyclerView) findViewById(R.id.view_multi_element_gridview);
        noPreviasLayout = (LinearLayout) findViewById(R.id.view_multi_element_emptyview);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.view_multi_element_swiperefreshlayout);

        mSwipeRefreshLayout.setProgressBackgroundColor(R.color.swipe_refresh_layout_background_color);

        mSwipeRefreshLayout.setColorScheme(
                R.color.swipe_refresh_layout_first_color,
                R.color.swipe_refresh_layout_second_color,
                R.color.swipe_refresh_layout_third_color,
                R.color.swipe_refresh_layout_fourth_color);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (listener != null)
                    listener.requestPage(true);
            }
        });

        mSwipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));

        grid.setHasFixedSize(true);

        grid.addItemDecoration(new VerticalSpaceItemDecoration(20));

	}

    public void setGridScrollListener(RecyclerView.OnScrollListener scrollListener) {
        grid.setOnScrollListener(scrollListener);
    }

    public void setRefreshing(boolean refreshing){
        if(mSwipeRefreshLayout!=null){
            mSwipeRefreshLayout.setRefreshing(refreshing);
        }
    }

    public void moveToTop() {
        if(grid!=null)
            grid.post(new Runnable() {
                @Override
                public void run() {
                    grid.smoothScrollToPosition(0);
                }
            });
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        grid.setLayoutManager(layoutManager);
    }

    public void setAdapter(EntityGridAdapter adapter) {
        grid.setAdapter(adapter);
    }

    public void refreshPreviasUI(boolean hasItems) {
        if(hasItems)
            hideNoPreviasUI();
        else
            showNoPreviasUI();
    }

	public void setListener(HomeWithPreviaGridViewListener listener){
		this.listener = listener;
	}

    public void showNoPreviasUI(){
        noPreviasLayout.setVisibility(View.VISIBLE);
    }

    public void hideNoPreviasUI(){
        noPreviasLayout.setVisibility(View.INVISIBLE);
    }

    public interface HomeWithPreviaGridViewListener{
        void requestPage(boolean resetPages);
	}

}