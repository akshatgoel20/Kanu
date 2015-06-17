package kanutalks.starksky.com.kanutalks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by akshat on 15/06/15.
 */
public class HomeGridAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;

    private Context mContext;

    // Constructor
    public HomeGridAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class Holder {
        TextView tv;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();

        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View cellView;

        cellView = inflater.inflate(R.layout.layout_home_cell, null);

        holder.imageView = (ImageView) cellView.findViewById(R.id.imageView1);
        holder.tv = (TextView) cellView.findViewById(R.id.textView1);


      /*  holder.imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.imageView.setPadding(8, 8, 8, 8);*/


        holder.imageView.setImageResource(mThumbIds[position]);
        holder.tv.setText(imgtexts[position]);
        return cellView;
    }


    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.food, R.drawable.water,
            R.drawable.tv, R.drawable.stethescope,
            R.drawable.aeroplane, R.drawable.carrom,
            R.drawable.happy, R.drawable.toilet,
            R.drawable.myroom

    };

    public String[] imgtexts = {"Food", "Drinks", "Fun"
            , "Medical", "Travel", "Games",
            "Emoticons", "Daily Needs", "My Room"

    };
}
