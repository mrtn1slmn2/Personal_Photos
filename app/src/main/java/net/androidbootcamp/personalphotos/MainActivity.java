package net.androidbootcamp.personalphotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] funBunch = {R.drawable.family, R.drawable.friends, R.drawable.kid1, R.drawable.kid2, R.drawable.kids1,
            R.drawable.kids2, R.drawable.dance, R.drawable.dogs};
    String[] imgDescription = {"three generations of my in-laws","the Dunedin Polar Express during X-mas",
            "Bella before her dance party ","Mia abusing her iPad privileges ","sisters plotting trouble before their recital ",
            "sisters posing for Glamour magazine ","Bella and Dad before a dance party","the hairy ones of the family", };
    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView photo = (ImageView)findViewById(R.id.imgSelected);

        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Picture " + (position + 1) + " shows " + imgDescription[(position)], Toast.LENGTH_LONG).show();
                photo.setImageResource(funBunch[position]);
            }
        });
        }

    private class ImageAdapter extends BaseAdapter {
        private Context context;
        public ImageAdapter(Context con) {
            context=con;
        }

        @Override
        public int getCount() {
            return funBunch.length;
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
            photo = new ImageView(context);
            photo.setImageResource(funBunch[position]);
            photo.setScaleType(ImageView.ScaleType.FIT_XY);
            photo.setLayoutParams(new GridView.LayoutParams(360, 330));

            return photo;
        }
    }
}

