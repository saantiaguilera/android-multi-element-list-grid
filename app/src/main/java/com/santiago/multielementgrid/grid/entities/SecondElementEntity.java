package com.santiago.multielementgrid.grid.entities;

import com.santiago.entity.JSONEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Mock example of an entity which should be drawed (with x design) in the gridview
 *
 * Created by santiago on 24/03/16.
 */
public class SecondElementEntity extends JSONEntity {

    public SecondElementEntity() {
        super();
    }

    public SecondElementEntity(JSONEntity JSONEntity) {
        super(JSONEntity);
    }

    public SecondElementEntity(JSONObject jsonObject) throws JSONException {
        super(jsonObject);
    }

    public SecondElementEntity(String json) throws JSONException {
        super(json);
    }

    /*---------------------------Overrides of mutables----------------------------------*/

    @Override
    public void setValuesFrom(JSONEntity JSONEntity) {
        super.setValuesFrom(JSONEntity);
    }

    @Override
    public SecondElementEntity setValuesFrom(JSONObject jsonObject) throws JSONException {
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
