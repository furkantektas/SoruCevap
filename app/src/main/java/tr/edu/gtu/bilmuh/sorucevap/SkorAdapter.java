package tr.edu.gtu.bilmuh.sorucevap;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.activeandroid.query.Select;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunum on 2/27/16.
 */
public class SkorAdapter extends BaseAdapter{
    private List<Skor> skorlar;
    private Activity activity;
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yy HH:mm");
    public SkorAdapter(Activity activity) {
        this.activity = activity;
        skorlar = new Select().from(Skor.class).orderBy("skor DESC").limit(5).execute();
    }

    @Override
    public int getCount() {
        return skorlar.size();
    }

    @Override
    public Skor getItem(int position) {
        return skorlar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater li = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.skor_item,null);
        }

        TextView skorTV = (TextView) convertView.findViewById(R.id.skor);
        TextView timeTV = (TextView) convertView.findViewById(R.id.tarih);

        Skor skor = getItem(position);
        skorTV.setText(String.valueOf(skor.getSkor()));
        timeTV.setText(dateFormatter.format(skor.getTime()));

        return convertView;
    }
}
