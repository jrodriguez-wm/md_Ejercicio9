package mx.com.webmaps.md_ejercicio9;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

/**
 * Created by jorge on 17/4/2018.
 */

public class SlideShowAdapter extends PagerAdapter{

    private Context context;
    LayoutInflater inflater;

    public int[] images ={
            R.drawable.basketball,
            R.drawable.basketball2,
            R.drawable.basketball3,
            R.drawable.basketball4
    };

    public SlideShowAdapter(Context context){
        this.context= context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.slideshow_layout,container,false);

        ImageView img = (ImageView) view.findViewById(R.id.imageView_id);

        //img.setImageResource(images[position]);

        Glide.with(context).load(images[position]).into(img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Image" + (position+1), Snackbar.LENGTH_LONG).show();
            }
        });

        container.addView(view);

        return  view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView( (LinearLayout)object );
    }
}
