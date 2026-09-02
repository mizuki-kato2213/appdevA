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
        display_r += result;
        binding.textViewResult.setText(display_r);

        //数字ボタン
        binding.button0.setOnClickListener(view ->{
            calNum = 0;
            if(display_r != "0"){
                display_r += calNum;
            }
            binding.textViewResult.setText(display_r);

        });
        binding.button1.setOnClickListener(view ->{
            calNum = 1;
            display_r += calNum;
            binding.textViewResult.setText(display_r);
        });
        binding.button2.setOnClickListener(view ->{
            calNum = 2;
            display_r += calNum;
            binding.textViewResult.setText(display_r);
        });
        binding.button3.setOnClickListener(view ->{
            calNum = 3;
            display_r += calNum;
            binding.textViewResult.setText(display_r);
        });
        binding.button4.setOnClickListener(view ->{
            calNum = 4;
            display_r += calNum;
            binding.textViewResult.setText(display_r);
        });
        binding.button5.setOnClickListener(view ->{
            calNum = 5;
            display_r += calNum;
            binding.textViewResult.setText(display_r);
        });
        binding.button6.setOnClickListener(view ->{
            calNum = 6;
            display_r += calNum;
            binding.textViewResult.setText(display_r);
        });
        binding.button7.setOnClickListener(view ->{
            calNum = 7;
            display_r += calNum;
            binding.textViewResult.setText(display_r);
        });
        binding.button8.setOnClickListener(view ->{
            calNum = 8;
            display_r += calNum;
            binding.textViewResult.setText(display_r);
        });
        binding.button9.setOnClickListener(view ->{
            calNum = 9;
            display_r += calNum;
            binding.textViewResult.setText(display_r);
        });

        //intentを取得
        Intent intent = getIntent();
        String sentText = getIntent().getStringExtra("sendText");//型を指定する
        binding.textViewResult.setText(sentText);
    }
}