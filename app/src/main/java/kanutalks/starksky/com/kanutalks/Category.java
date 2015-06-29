package kanutalks.starksky.com.kanutalks;

import android.content.Intent;
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
        Intent in = getIntent();
        Bundle bundle = in.getExtras();
        Integer pos = bundle.getInt("case",0);
        switch (pos) {
            case 0:
                setTitle("Food");
                Integer []  mThumbidfood = {R.drawable.breakfast, R.drawable.lunch,
                        R.drawable.snacks, R.drawable.fruits,
                        R.drawable.icecream, R.drawable.custard,
                        R.drawable.sandwiches};
                String [] imgtextfood = {"BreakFast", "Lunch", "Snacks"
                        , "Fruits", "Ice Cream", "Custard",
                        "Sandwiches"};
                for(int i =0;i<mThumbidfood.length;i++){
                    mThumbids.add(mThumbidfood[i]);
                    imgtexts.add(imgtextfood[i]);

                }
            case 1:
                //add cases and fill the fields accordingly .
                setTitle("Drinks");
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
            case 2:
                setTitle("Fun");
                Integer []  mThumbidfun = {R.drawable.water, R.drawable.juice,
                        R.drawable.coffee, R.drawable.tea,
                        R.drawable.milk};
                String [] imgtextfun = {"Water", "Juice", "Coffee"
                        , "Tea", "Milk"};
                for(int i =0;i<mThumbidfun.length;i++){
                    mThumbids.add(mThumbidfun[i]);
                    imgtexts.add(imgtextfun[i]);

                }

            case 3:
                setTitle("Medical");
                Integer []  mThumbidmed = {R.drawable.toothache, R.drawable.runnynose,
                        R.drawable.earpain, R.drawable.headache,
                        R.drawable.stomachache, R.drawable.stethescope,
                        R.drawable.cold, R.drawable.hot,
                        R.drawable.fine};
                String [] imgtextmed = {"Toothache", "runnynose", "earpain"
                        , "Body Ache", "Stomach Ache", "Doctor",
                        "Feeling cold", "Feeling hot", "I am fine"};
                for(int i =0;i<mThumbidmed.length;i++) {
                    mThumbids.add(mThumbidmed[i]);
                    imgtexts.add(imgtextmed[i]);
                }
            case 4:
                setTitle("Travel");
                setTitle("Drinks");
                Integer []  mThumbidtravel = {R.drawable.aeroplane, R.drawable.train,
                        R.drawable.taxi, R.drawable.boat,
                        R.drawable.mountain, R.drawable.sea};
                String [] imgtexttravel = {"Aeroplane", "Train", "Taxi"
                        , "Boat", "Mountain", "Sea"};
                for(int i =0;i<mThumbidtravel.length;i++){
                    mThumbids.add(mThumbidtravel[i]);
                    imgtexts.add(imgtexttravel[i]);

                }
            case 5:
                setTitle("Games");
                Integer []  mThumbidgames = {R.drawable.swimming, R.drawable.carrom,
                        R.drawable.cards, R.drawable.videogame,
                        R.drawable.chess};
                String [] imgtextgames = {"Swimming", "Carrom", "Cards"
                        , "Video Game", "Chess"};
                for(int i =0;i<mThumbidgames.length;i++){
                    mThumbids.add(mThumbidgames[i]);
                    imgtexts.add(imgtextgames[i]);

                }
            case 6:
                setTitle("Emoticons");
            case 7:
                setTitle("Daily Needs");
            case 8:
                setTitle("My Room");
                Integer []  mThumbidroom = {R.drawable.fanon, R.drawable.fanoff,
                        R.drawable.onlight, R.drawable.offlight,
                        R.drawable.cleanfloor, R.drawable.dooropen,
                        R.drawable.doorclose, R.drawable.windowopen,
                        R.drawable.windowclose};
                String [] imgtextroom = {"Switch On Fan", "Switch Off Fan", "Switch On Light"
                        , "Switch Off Light", "Clean The Floor", "Open The Door",
                        "Close The Door", "Open Window", "Close Window"};
                for(int i =0;i<mThumbidroom.length;i++){
                    mThumbids.add(mThumbidroom[i]);
                    imgtexts.add(imgtextroom[i]);

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
