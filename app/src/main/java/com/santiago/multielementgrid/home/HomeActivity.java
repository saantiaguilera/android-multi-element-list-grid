package com.santiago.multielementgrid.home;

import android.app.Activity;
import android.os.Bundle;

import com.santiago.multielementgrid.R;
import com.santiago.multielementgrid.grid.MultiElementGridController;
import com.santiago.multielementgrid.grid.MultiElementGridView;

/**
 * Created by santiago on 24/03/16.
 */
public class HomeActivity extends Activity {

    private MultiElementGridController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        controller = new MultiElementGridController(this, (MultiElementGridView) findViewById(R.id.activity_home_gridview));

        controller.requestPage(true);
    }
}
