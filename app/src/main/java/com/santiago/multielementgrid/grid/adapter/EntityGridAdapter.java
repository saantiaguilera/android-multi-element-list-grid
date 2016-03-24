package com.santiago.multielementgrid.grid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.santiago.multielementgrid.grid.adapter.view_holder.FirstElementEntityGridViewHolder;
import com.santiago.multielementgrid.grid.adapter.view_holder.SecondElementEntityGridViewHolder;
import com.santiago.multielementgrid.grid.entities.FirstElementEntity;
import com.santiago.multielementgrid.grid.entities.SecondElementEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * This will be the List/Grid adapter
 *
 * Created by santi on 25/01/16.
 */
public class EntityGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * I will be having 3 lists
     * 1 for each type
     * 1 for displaying the things. In case you plan using an order method, order them here. Also this list will have a generic holder of both types
     */

    private Context context;

    private List<EntityGridElement> gridElementList = new ArrayList<>();

    private final List<FirstElementEntity> firstElementList = new ArrayList<>();
    private final List<SecondElementEntity> secondElementList = new ArrayList<>();

    public EntityGridAdapter(Context context) {
        this.context = context;
    }

    public List<FirstElementEntity> getFirstElementList() {
        return firstElementList;
    }

    public List<SecondElementEntity> getSecondElementList() {
        return secondElementList;
    }

    //---------------------Recycler View-------------------//

    @Override
    public int getItemViewType(int position) {
        return gridElementList.get(position).getViewType();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //If you need to inflate them and attach, use the parent (add a param to the create for eg)
        switch (viewType){
            case EntityGridElement.ELEMENT_FIRST:
                return FirstElementEntityGridViewHolder.create(context);
            case EntityGridElement.ELEMENT_SECOND:
                return SecondElementEntityGridViewHolder.create(context);
        }
        return null;

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (getItemViewType(position)){
            case EntityGridElement.ELEMENT_FIRST:
                FirstElementEntityGridViewHolder.bind(viewHolder, (FirstElementEntity) gridElementList.get(position).getObject());
                break;
            case EntityGridElement.ELEMENT_SECOND:
                SecondElementEntityGridViewHolder.bind(viewHolder, (SecondElementEntity) gridElementList.get(position).getObject());
                break;

        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return gridElementList.size();
    }

    /**
     * Im not using the gridElementList because maybe we want to know if it has items
     * and they havent been displayed yet ?
     * @return
     */
    public boolean hasItems() { return firstElementList.size() + secondElementList.size() > 0; }

    //----------------------Lists-----------------------//

    public void clearData() {
        gridElementList.clear();
        firstElementList.clear();
        secondElementList.clear();
    }

    public void mergeLists(){
        gridElementList.clear();

        int addCount = 0;

        for(FirstElementEntity previa : firstElementList)
            gridElementList.add(new EntityGridElement<>(previa, EntityGridElement.ELEMENT_FIRST));

        for(SecondElementEntity promotion : secondElementList)
            gridElementList.add(new EntityGridElement<>(promotion, EntityGridElement.ELEMENT_SECOND));


        notifyDataSetChanged();
    }

    public void addFirstElements(List<FirstElementEntity> first) {
        this.firstElementList.addAll(first);
    }

    public void addSecondElements(List<SecondElementEntity> second) {
        this.secondElementList.addAll(second);
    }

    public void setFirstElementEntityList(List<FirstElementEntity> first){
        this.firstElementList.clear();
        this.firstElementList.addAll(first);
    }

    public void setSecondElementList(List<SecondElementEntity> secondElementList){
        this.secondElementList.clear();
        this.secondElementList.addAll(secondElementList);
    }

}
