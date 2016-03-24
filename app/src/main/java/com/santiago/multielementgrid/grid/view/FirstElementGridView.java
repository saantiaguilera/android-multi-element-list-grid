package com.santiago.multielementgrid.grid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.santiago.multielementgrid.R;

/**
 * Using 1 view for each (although they are the same) to show that each should have their own view
 * Its reaaally bad if you merge two different entities in a same model. REALLY BAD
 * You should also do 2 xml, not reuse the same. but im lazy
 */
public class FirstElementGridView extends LinearLayout {

    private TextView textView;

    public FirstElementGridView(Context context) {
        this(context, null);
    }

    public FirstElementGridView(Context context, AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.view_generic_element, this);

        textView = (TextView) findViewById(R.id.view_generic_element_text);

        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);

    }

    public void setText(String text) {
        textView.setText(getResources().getString(R.string.view_holding_type_element, text));
    }

}
