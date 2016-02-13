package tr.edu.gtu.bilmuh.sorucevap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Button dogruCevap;
    private Button yanlisCevap;
    private TextView skor;
    private TextView soru;

    private int currentSkor = 0;

    private List<Soru> sorular = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skor = (TextView) findViewById(R.id.skor);
        soru = (TextView) findViewById(R.id.soru);
        dogruCevap = (Button) findViewById(R.id.cevap1);
        yanlisCevap = (Button) findViewById(R.id.cevap2);

        setSkor(currentSkor);

        sorular.add(new Soru("13 x 2", "26", "36"));
        sorular.add(new Soru("9 x 5",    "45",   "40"));
        sorular.add(new Soru("120 - 30", "90",   "80"));
        sorular.add(new Soru("100 / 10", "10",   "20"));
        sorular.add(new Soru("45 x 5",   "225",  "235"));
        sorular.add(new Soru("10 x 20",  "200",  "100"));
        sorular.add(new Soru("20 x 4",   "80",   "90"));
        sorular.add(new Soru("5 - 20",   "-15",  "-20"));


        dogruCevap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSkor(currentSkor + 5);
                fillQuestion();
            }
        });

        yanlisCevap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillQuestion();
            }
        });

        fillQuestion();
    }

    private void setSkor(int skor) {
        this.currentSkor = skor;
        this.skor.setText(String.valueOf(currentSkor));
    }

    private int currentSoru = 0;

    private void fillQuestion() {
        if(currentSoru < sorular.size()) {
            Soru currSoru = sorular.get(currentSoru);
            soru.setText(currSoru.getMetin());
            dogruCevap.setText(currSoru.getDogruCevap());
            yanlisCevap.setText(currSoru.getYanlisCevap());
            ++currentSoru;
        } else {
            Toast.makeText(MainActivity.this, "Skorunuz: "+currentSkor, Toast.LENGTH_LONG).show();
        }
    }

}
