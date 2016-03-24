package com.santiago.multielementgrid.grid.entities;

import com.santiago.entity.JSONEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * Mock of the first type of items that will be drawn with x design in the grid view
 *
 * Created by santiago on 24/03/16.
 */
public class FirstElementEntity extends JSONEntity {

    public FirstElementEntity() {
        super();
    }

    public FirstElementEntity(JSONEntity JSONEntity) {
        super(JSONEntity);
    }

    public FirstElementEntity(JSONObject jsonObject) throws JSONException {
        super(jsonObject);
    }

    public FirstElementEntity(String json) throws JSONException {
        super(json);
    }

    /*---------------------------Overrides of mutables----------------------------------*/

    @Override
    public void setValuesFrom(JSONEntity JSONEntity) {
        super.setValuesFrom(JSONEntity);
    }

    @Override
    public FirstElementEntity setValuesFrom(JSONObject jsonObject) throws JSONException {
        super.setValuesFrom(jsonObject);

        return this;
    }

    @Override
    public void setDefaultValues() {
        super.setDefaultValues();
    }

    /*---------------------------------------JSON Serializer--------------------------------------*/

    /**
     * We must override this so our json also has the particularities of this class
     * @return
     */
    @Override
    public JSONObject asJSONObject() {
        return null;
    }

}
