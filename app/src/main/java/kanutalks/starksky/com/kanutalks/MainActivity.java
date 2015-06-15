package kanutalks.starksky.com.kanutalks;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;


public class MainActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv = (GridView)findViewById(R.id.gridView);
        gv.setAdapter(new HomeGridAdapter(this));
    }


}
