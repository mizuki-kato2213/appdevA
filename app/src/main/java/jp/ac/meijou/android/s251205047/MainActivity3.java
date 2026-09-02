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
    private double result = 0;
    private String cal = "";
    private  boolean bitFlag = true;
    private  boolean noError = true;

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
        binding.textViewResult.setText(display_r + (int)result);

        //acボタン
        binding.buttonAc.setOnClickListener(view -> {
            result = 0;
            cal = "";
            display_r = "";
            binding.textViewResult.setText(display_r + (int)result);
            binding.textViewCal.setText(cal);
            binding.textViewCalNum.setText("");
            bitFlag = true;
            noError = true;
        });

        //数字ボタン
        binding.button0.setOnClickListener(view ->{
            if(!noError) {
                binding.buttonAc.callOnClick();
            }
            if(bitFlag){//先頭桁の時は何もさせない
                binding.textViewResult.setText("0");
            }else{
                display_r += 0;
                binding.textViewResult.setText(display_r);
            }
        });

        binding.button1.setOnClickListener(view ->{
            if(!noError) {
                binding.buttonAc.callOnClick();
            }
            if(bitFlag) {
                display_r = "1";
                binding.textViewResult.setText(display_r);
                bitFlag = false;
            }else{
                display_r += 1;
                binding.textViewResult.setText(display_r);
            }
        });

        binding.button2.setOnClickListener(view ->{
            if(!noError) {
                binding.buttonAc.callOnClick();
            }
            if(bitFlag) {
                display_r = "2";
                binding.textViewResult.setText(display_r);
                bitFlag = false;
            }else{
                display_r += 2;
                binding.textViewResult.setText(display_r);
            }
        });

        binding.button3.setOnClickListener(view ->{
            if(!noError) {
                binding.buttonAc.callOnClick();
            }
            if(bitFlag) {
                display_r = "3";
                binding.textViewResult.setText(display_r);
                bitFlag = false;
            }else{
                display_r += 3;
                binding.textViewResult.setText(display_r);
            }
        });

        binding.button4.setOnClickListener(view ->{
            if(!noError) {
                binding.buttonAc.callOnClick();
            }
            if(bitFlag) {
                display_r = "4";
                binding.textViewResult.setText(display_r);
                bitFlag = false;
            }else{
                display_r += 4;
                binding.textViewResult.setText(display_r);
            }
        });

        binding.button5.setOnClickListener(view ->{
            if(!noError) {
                binding.buttonAc.callOnClick();
            }
            if(bitFlag) {
                display_r = "5";
                binding.textViewResult.setText(display_r);
                bitFlag = false;
            }else{
                display_r += 5;
                binding.textViewResult.setText(display_r);
            }
        });

        binding.button6.setOnClickListener(view ->{
            if(!noError) {
                binding.buttonAc.callOnClick();
            }
            if(bitFlag) {
                display_r = "6";
                binding.textViewResult.setText(display_r);
                bitFlag = false;
            }else{
                display_r += 6;
                binding.textViewResult.setText(display_r);
            }
        });

        binding.button7.setOnClickListener(view ->{
            if(!noError) {
                binding.buttonAc.callOnClick();
            }
            if(bitFlag) {
                display_r = "7";
                binding.textViewResult.setText(display_r);
                bitFlag = false;
            }else{
                display_r += 7;
                binding.textViewResult.setText(display_r);
            }
        });

        binding.button8.setOnClickListener(view ->{
            if(!noError) {
                binding.buttonAc.callOnClick();
            }
            if(bitFlag) {
                display_r = "8";
                binding.textViewResult.setText(display_r);
                bitFlag = false;
            }else{
                display_r += 8;
                binding.textViewResult.setText(display_r);
            }
        });

        binding.button9.setOnClickListener(view ->{
            if(!noError) {
                binding.buttonAc.callOnClick();
            }
            if(bitFlag) {
                display_r = "9";
                binding.textViewResult.setText(display_r);
                bitFlag = false;
            }else{
                display_r += 9;
                binding.textViewResult.setText(display_r);
            }
        });

        //+ボタン
        binding.buttonPlus.setOnClickListener(view -> {
            if(noError) {
                cal = binding.textViewCal.getText().toString();
                switch (cal) {
                    case "＋":
                        result += Double.parseDouble(binding.textViewResult.getText().toString());
                        break;
                    case "－":
                        result -= Double.parseDouble(binding.textViewResult.getText().toString());
                        break;
                    case "×":
                        result *= Double.parseDouble(binding.textViewResult.getText().toString());
                        break;
                    case "÷":
                        String s = binding.textViewResult.getText().toString();
                        if (s == "0") {
                            binding.textViewResult.setText("ERROR");
                            noError = false;
                            binding.buttonEqual.callOnClick();
                        } else {
                            result /= Double.parseDouble(s);
                        }
                        break;
                    default:
                        result = Double.parseDouble(binding.textViewResult.getText().toString());
                        break;
                }
                binding.textViewCalNum.setText("" + result);
                binding.textViewCal.setText("＋");
                bitFlag = true;
            }
        });

        //-ボタン
        binding.buttonMinas.setOnClickListener(view -> {
            binding.buttonPlus.callOnClick();
            binding.textViewCal.setText("－");
        });

        //×ボタン
        binding.buttonTimes.setOnClickListener(view -> {
            binding.buttonPlus.callOnClick();
            binding.textViewCal.setText("×");
        });

        //÷ボタン
        binding.buttonDevide.setOnClickListener(view -> {
            binding.buttonPlus.callOnClick();
            binding.textViewCal.setText("÷");
        });

        //=ボタン
        binding.buttonEqual.setOnClickListener(view -> {
            if(noError) {
                cal = binding.textViewCal.getText().toString();
                switch (cal) {
                    case "＋":
                        result += Double.parseDouble(binding.textViewResult.getText().toString());
                        break;
                    case "－":
                        result -= Double.parseDouble(binding.textViewResult.getText().toString());
                        break;
                    case "×":
                        result *= Double.parseDouble(binding.textViewResult.getText().toString());
                        break;
                    case "÷":
                        String s = binding.textViewResult.getText().toString();
                        if(s == "0") {
                            binding.textViewResult.setText("ERROR");
                            noError = false;
                            binding.buttonEqual.callOnClick();
                        }else {
                            result /= Double.parseDouble(s);
                        }
                        break;
                    default:
                        result = Double.parseDouble(binding.textViewResult.getText().toString());
                        break;
                }
                if(noError) {
                    binding.textViewResult.setText("" + result);
                    binding.textViewCal.setText("");
                    binding.textViewCalNum.setText("");
                    result = 0;
                    display_r = "";
                    bitFlag = true;
                    noError = true;
                }else{
                    binding.textViewCal.setText("");
                    binding.textViewCalNum.setText("");
                }
            }
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