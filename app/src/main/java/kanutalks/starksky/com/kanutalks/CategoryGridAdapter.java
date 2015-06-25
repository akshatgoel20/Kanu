package kanutalks.starksky.com.kanutalks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

/**
 * Created by NTQK0716 on 2015-06-25.
 */
public class CategoryGridAdapter extends BaseAdapter {

 static Integer [] mThumbids = new Integer[]{};
  static String [] imgtexts = new String[]{};

    private static LayoutInflater inflater = null;

    private Context mContext;

    public CategoryGridAdapter(Integer[] mThumbIds,String []imgtexts){
        this.mThumbids=mThumbIds ;
        this.imgtexts=imgtexts ;

    }

    // Constructor
    public CategoryGridAdapter(Context c) {
        mContext = c;
    }
    @Override
    public int getCount() {
        return mThumbids.length;
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


        holder.imageView.setImageResource(mThumbids[position]);
        holder.tv.setText(imgtexts[position]);
        return cellView;
    }



}
