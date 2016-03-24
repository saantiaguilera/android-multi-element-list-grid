package com.santiago.multielementgrid.grid.adapter.view_holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.santiago.multielementgrid.grid.entities.FirstElementEntity;
import com.santiago.multielementgrid.grid.view.FirstElementGridView;

/**
 * View holder for the first type of elements (dont use a same viewholder for two types never)
 *
 * Created by santi on 15/01/16.
 */
public class FirstElementEntityGridViewHolder extends RecyclerView.ViewHolder {

    public FirstElementEntityGridViewHolder(View itemView) {
        super(itemView);
    }

    public static FirstElementEntityGridViewHolder create(Context context){
        return new FirstElementEntityGridViewHolder(new FirstElementGridView(context));
    }

    /**
     * You should set all the things this type of view has here
     * Eg listeners or entities or wever
     * @param viewHolder
     * @param element
     */
    public static void bind(RecyclerView.ViewHolder viewHolder, FirstElementEntity element) {
        ((FirstElementGridView) viewHolder.itemView).setText(element.getClass().getSimpleName());
    }

}
