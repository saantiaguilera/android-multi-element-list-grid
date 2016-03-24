package com.santiago.multielementgrid.grid.adapter.view_holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.santiago.multielementgrid.grid.entities.SecondElementEntity;
import com.santiago.multielementgrid.grid.view.SecondElementGridView;

/**
 * View holder for the second type of elements (dont use a same viewholder for two types never)
 *
 * Created by santi on 15/01/16.
 */
public class SecondElementEntityGridViewHolder extends RecyclerView.ViewHolder {

    public SecondElementEntityGridViewHolder(View itemView) {
        super(itemView);
    }

    public static SecondElementEntityGridViewHolder create(Context context){
        return new SecondElementEntityGridViewHolder(new SecondElementGridView(context));
    }

    /**
     * You should set all the things this type of view has here
     * Eg listeners or entities or wever
     * @param viewHolder
     * @param element
     */
    public static void bind(RecyclerView.ViewHolder viewHolder, SecondElementEntity element) {
        ((SecondElementGridView) viewHolder.itemView).setText(element.getClass().getSimpleName());
    }

}