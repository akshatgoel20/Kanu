package kanutalks.starksky.com.kanutalks;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by akshat on 15/06/15.
 */
public class HomeGridAdapter extends BaseAdapter {


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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }


    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.food, R.drawable.water,
            R.drawable.tv, R.drawable.stethescope,
            R.drawable.aeroplane, R.drawable.carrom,
            R.drawable.happy, R.drawable.toilet,
            R.drawable.myroom

    };
}
