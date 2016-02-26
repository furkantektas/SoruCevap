package tr.edu.gtu.bilmuh.sorucevap;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.cevap1) Button cevap1;
    @Bind(R.id.cevap2) Button cevap2;
    @Bind(R.id.skor) TextView skor;
    @Bind(R.id.soru) TextView soru;

    @Bind(R.id.countdown) TextView countDown;

    @OnClick(R.id.cevap1) void onCevap1(View v) {
        onSubmit(v);
    }

    @OnClick(R.id.cevap2) void onCevap2(View v) {
        onSubmit(v);
    }

    CountDownTimer timer = new CountDownTimer(30*1000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            String countDownText = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished));
            countDown.setText(countDownText);
        }

        @Override
        public void onFinish() {
            finalizeGame();
        }
    };

    private int currentSkor = 0;
    private int nextSoru = 0;

    private List<Soru> sorular = new ArrayList<>();


    public void onSubmit(View v) {
        Button button = (Button) v;
        String buttonText = String.valueOf(button.getText());
        Soru soru = sorular.get(nextSoru - 1);

        // dogru
        if(buttonText.equals(soru.getDogruCevap())) {
            setSkor(currentSkor + 5);
        }

        fillQuestion();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSkor(currentSkor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sorucevap.firebaseio-demo.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SoruService service = retrofit.create(SoruService.class);
        service.listSorular().enqueue(new Callback<List<Soru>>() {
            @Override
            public void onResponse(Call<List<Soru>> call, Response<List<Soru>> response) {
                if (response.isSuccess()) {
                    sorular = response.body();
                    fillQuestion();
                    timer.start();
                }
            }

            @Override
            public void onFailure(Call<List<Soru>> call, Throwable t) {
                Log.i("FAIL", t.getMessage());
            }
        });
    }

    private void setSkor(int skor) {
        this.currentSkor = skor;
        this.skor.setText(String.valueOf(currentSkor));
    }


    private void fillQuestion() {
        if(nextSoru < sorular.size()) {
            Soru currSoru = sorular.get(nextSoru);
            soru.setText(currSoru.getMetin());

            Random r = new Random();
            if(r.nextBoolean()) {
                cevap1.setText(currSoru.getDogruCevap());
                cevap2.setText(currSoru.getYanlisCevap());
            } else {
                cevap1.setText(currSoru.getYanlisCevap());
                cevap2.setText(currSoru.getDogruCevap());
            }

            ++nextSoru;
        } else {
            finalizeGame();
        }
    }

    private void finalizeGame() {
        Toast.makeText(MainActivity.this, "Skorunuz: "+currentSkor, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,SkorActivity.class);
        intent.putExtra(SkorActivity.SCOR_KEY,currentSkor);
        startActivity(intent);
    }

}
