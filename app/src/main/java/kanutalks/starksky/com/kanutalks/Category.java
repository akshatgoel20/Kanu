package kanutalks.starksky.com.kanutalks;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.Locale;


public class Category extends ActionBarActivity {
    static Integer [] mThumbids = new Integer[]{};
    static String [] imgtexts = new String[]{};
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Bundle bundle = new Bundle();
        Integer pos = bundle.getInt("case",0);
        switch (pos) {
            case 1:
                //add cases and fill the fields accordingly .
              mThumbids={}  ;
                imgtexts= {} ;
        }
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        GridView gv = (GridView)findViewById(R.id.gridView);
        gv.setAdapter(new CategoryGridAdapter(this));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            t1.speak(imgtexts[i], TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }


}
