package com.santiago.multielementgrid.grid.adapter;

import com.santiago.multielementgrid.grid.entities.FirstElementEntity;
import com.santiago.multielementgrid.grid.entities.SecondElementEntity;

/**
 * This is just a holder of more types of views (dont know if its the best approach)
 * Set the ones you will be able to use in the grid adapter
 * And create a viewholder for each
 *
 * Created by santi on 15/01/16.
 */
public class EntityGridElement<T> {

    public static final int ELEMENT_FIRST = 0;
    public static final int ELEMENT_SECOND = 1;

    private T object;
    private int viewType;

    public EntityGridElement(T object, int viewType) {
        this.object = object;
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public T getObject() {
        return object;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof FirstElementEntity && object instanceof FirstElementEntity) {
            return ((FirstElementEntity) o).getId() == ((FirstElementEntity) object).getId();
        }

        if(o instanceof SecondElementEntity && object instanceof SecondElementEntity) {
            return ((SecondElementEntity) o).getId() == ((SecondElementEntity) object).getId();
        }

        return super.equals(o);
    }
}
