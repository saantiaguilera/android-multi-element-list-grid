package com.santiago.multielementgrid.grid;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.santiago.controllers.BaseEventController;
import com.santiago.multielementgrid.grid.adapter.EntityGridAdapter;
import com.santiago.multielementgrid.grid.entities.FirstElementEntity;
import com.santiago.multielementgrid.grid.entities.SecondElementEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by santi on 07/01/16.
 */
public class MultiElementGridController extends BaseEventController<MultiElementGridView> implements MultiElementGridView.HomeWithPreviaGridViewListener {

    private boolean isRequestingAPageOfPrevias = false;

    private EntityGridAdapter adapter;
    private GridLayoutManager layoutManager;

    private int pastVisiblesItems, visibleItemCount, totalItemCount;
    private boolean isAlreadyInScroll = false;

    public MultiElementGridController(Context context, MultiElementGridView multiElementGridView) {
        super(context, multiElementGridView);
    }

    @Override
    protected void onViewAttached(MultiElementGridView multiElementGridView) {
        multiElementGridView.setListener(this);

        // use a grid layout manager
        layoutManager = new GridLayoutManager(getContext(), 2);
        multiElementGridView.setLayoutManager(layoutManager);

        // specify an adapter
        adapter = new EntityGridAdapter(getContext());
        multiElementGridView.setAdapter(adapter);

        // set the scroll listener
        multiElementGridView.setGridScrollListener( new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled( RecyclerView recyclerView, int dx, int dy ) {
                super.onScrolled( recyclerView, dx, dy );

                if ( dy > 0 ) //check for scroll down
                    onGridScroll();
            }
        } );
    }

    //---------------Grid-----------------//

    /**
     * Method for knowing if the user has reached bottom of the recyclerview
     */
    private void onGridScroll() {
        visibleItemCount = layoutManager.getChildCount();
        totalItemCount = layoutManager.getItemCount();
        pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();

        if (!isRequestingAPageOfPrevias) {
            if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                if (!isAlreadyInScroll) {
                    requestPage(false);
                    isAlreadyInScroll = true;
                }
            } else isAlreadyInScroll = false;
        }
    }

    public void showLoadingUI() {
        if(getView()!=null)
            getView().setRefreshing(true);
    }

    public void hideLoadingUI() {
        if (getView()!=null)
            getView().setRefreshing(false);
    }

    public void moveGridToTop() {
        if(getView()!=null)
            getView().moveToTop();
    }

    //--------------Paging & Requests---------------//

    /**
     * Use the boolean to know which request you will ask the eventmanager
     * @param resetPages
     */
    @Override
    public void requestPage(boolean resetPages) {
        if(isRequestingAPageOfPrevias)
            return;

        showLoadingUI();

        if(resetPages)
            adapter.clearData();

        requestPreviaGridPage();
    }

    private final ReentrantLock lock = new ReentrantLock(); //Only purpose is for the hardcode of #MultiElementGridController.requestPreviaGridPage();

    private void requestPreviaGridPage() {
        //Send to the event manager a request, parse it and return here on other method. I will just hardcode stuff here

        lock.lock();

        new Handler().postDelayed(new Runnable() {
            public void run() {

                List<FirstElementEntity> firstList = new ArrayList<>();
                List<SecondElementEntity> secondList = new ArrayList<>();

                int i = 0;
                while (i < 20) {
                    firstList.add(new FirstElementEntity());
                    secondList.add(new SecondElementEntity());

                    i++;
                }

                adapter.addFirstElements(firstList);
                adapter.addSecondElements(secondList);

                adapter.mergeLists();

                hideLoadingUI();

                lock.unlock();
            }
        }, 2000);
    }

}