package jp.ac.meijou.android.s251205047;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s251205047.databinding.ActivityMain3Binding;
import jp.ac.meijou.android.s251205047.databinding.ActivityMainBinding;

public class MainActivity3 extends AppCompatActivity {
    private ActivityMain3Binding binding;
    private  String display_r = "";
    private int result = 0;
    private  int calNum = 0;
    private  int count = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        result = 0;
        binding.textViewResult.setText(display_r + result);

        //ac
        binding.buttonAc.setOnClickListener(view -> {
            result = 0;
            calNum = 0;
            display_r = "";
            binding.textViewResult.setText(display_r + result);
        });

        //数字ボタン
        binding.button0.setOnClickListener(view ->{
            if(display_r != ""){//先頭桁の時は何もさせない
                count++;
                calNum = (int)Math.pow(10, count) * 0;
                display_r += 0;
                binding.textViewResult.setText(display_r);
            }
        });
        binding.button1.setOnClickListener(view ->{
            calNum = (int)Math.pow(10, count) * 1;
            display_r += 1;
            binding.textViewResult.setText(display_r);
        });
        binding.button2.setOnClickListener(view ->{
            calNum = (int)Math.pow(10, count) * 2;
            display_r += 2;
            binding.textViewResult.setText(display_r);
        });
        binding.button3.setOnClickListener(view ->{
            calNum = (int)Math.pow(10, count) * 3;
            display_r += 3;
            binding.textViewResult.setText(display_r);
        });
        binding.button4.setOnClickListener(view ->{
            calNum = (int)Math.pow(10, count) * 4;
            display_r += 4;
            binding.textViewResult.setText(display_r);
        });
        binding.button5.setOnClickListener(view ->{
            calNum = (int)Math.pow(10, count) * 5;
            display_r += 5;
            binding.textViewResult.setText(display_r);
        });
        binding.button6.setOnClickListener(view ->{
            calNum = (int)Math.pow(10, count) * 6;
            display_r += 6;
            binding.textViewResult.setText(display_r);
        });
        binding.button7.setOnClickListener(view ->{
            calNum = (int)Math.pow(10, count) * 7;
            display_r += 7;
            binding.textViewResult.setText(display_r);
        });
        binding.button8.setOnClickListener(view ->{
            calNum = (int)Math.pow(10, count) * 8;
            display_r += 8;
            binding.textViewResult.setText(display_r);
        });
        binding.button9.setOnClickListener(view ->{
            calNum = (int)Math.pow(10, count) * 9;
            display_r += 9;
            binding.textViewResult.setText(display_r);
        });

        //intentを取得
        //Intent intent = getIntent();
        //String sentText = getIntent().getStringExtra("sendText");//型を指定する
        //binding.textViewResult.setText(sentText);

        //OKボタン
        binding.buttonOK.setOnClickListener(view ->{
            var OK_intent = new Intent();
            OK_intent.putExtra("rst", "OK");
            setResult(RESULT_OK, OK_intent);
            finish();//finishすると、画面はスタックに残らない
        });
        //cancelボタン
        binding.buttonCancel.setOnClickListener(view ->{
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}