package tr.edu.gtu.bilmuh.sorucevap;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SkorActivity extends Activity {
    public static final String SCOR_KEY = "skor";

    @Bind(R.id.skor) TextView skor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);
        ButterKnife.bind(this);

        int skorVal = getIntent().getIntExtra(SCOR_KEY,0);
        skor.setText(String.valueOf(skorVal));
    }

}
