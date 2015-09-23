package kanutalks.starksky.com.kanutalks;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context;
        context = this;
        GridView gv = (GridView) findViewById(R.id.gridView);
        gv.setAdapter(new HomeGridAdapter(this));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, Category.class);
                intent.putExtra("case", i);
                startActivity(intent);


            }
        });
    }

    @Override
    public void onBackPressed() {


        toExit();

    }

    public void power(View view) {
        toExit();
    }

    void toExit() {
        AlertDialog.Builder ad1 = new AlertDialog.Builder(MainActivity.this);
        ad1.setTitle("Are you sure that you want to exit?");
        ad1.setNegativeButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);

            }
        });
        ad1.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();


            }
        });
        ad1.show();

    }
}
