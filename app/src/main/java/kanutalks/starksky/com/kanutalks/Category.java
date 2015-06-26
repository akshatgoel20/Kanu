package kanutalks.starksky.com.kanutalks;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Locale;


public class Category extends ActionBarActivity {
    ArrayList<Integer> mThumbids= new ArrayList<>() ;
  ArrayList<String> imgtexts = new ArrayList<>();
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
              Integer []  mThumbid = {R.drawable.food, R.drawable.water,
                      R.drawable.tv, R.drawable.stethescope,
                      R.drawable.aeroplane, R.drawable.carrom,
                      R.drawable.happy, R.drawable.toilet,
                      R.drawable.myroom};
                String [] imgtext = {"Food", "Drinks", "Fun"
                        , "Medical", "Travel", "Games",
                        "Emoticons", "Daily Needs", "My Room"};
            for(int i =0;i<mThumbid.length;i++){
                mThumbids.add(mThumbid[i]);
                imgtexts.add(imgtext[i]);
            }
        }
        new CategoryGridAdapter(mThumbids,imgtexts);
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
            t1.speak(imgtexts.get(i), TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }


}
