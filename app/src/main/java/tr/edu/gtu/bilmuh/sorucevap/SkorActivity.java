package tr.edu.gtu.bilmuh.sorucevap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SkorActivity extends AppCompatActivity {
    public static final String SCOR_KEY = "skor";

    @Bind(R.id.skor) TextView skorTV;
    @Bind(R.id.skor_list) ListView skorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);
        ButterKnife.bind(this);

        int skorVal = getIntent().getIntExtra(SCOR_KEY,0);
        skorTV.setText(String.valueOf(skorVal));
        Skor skor = new Skor(skorVal);
        skor.save();
        skorList.setAdapter(new SkorAdapter(this));
    }

}
