package jp.ac.meijou.android.s251205047;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Optional;

import jp.ac.meijou.android.s251205047.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s251205047.databinding.ActivityMain3Binding;
import jp.ac.meijou.android.s251205047.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //明示的intentボタン
        binding.buttonA.setOnClickListener(view ->{
            var intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        });

        //暗黙的intentボタン
        binding.buttonB.setOnClickListener(view ->{
            var intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.yahoo.co.jp"));
            startActivity(intent);
        });

        //送信ボタン
        binding.buttonIntent.setOnClickListener(view ->{
            String sendText = binding.text.getText().toString();

            var intent = new Intent(this, MainActivity3.class);
            intent.putExtra("sendText", sendText);
            startActivity(intent);
        });

        //起動ボタン
        binding.buttonLaunch.setOnClickListener(view -> {
            var intent = new Intent(this, MainActivity3.class);
            getActivityResult.launch(intent);//startActivityだと、返り値を受け取れない
        });
    }

    //onCreatの外に書く
    private  final ActivityResultLauncher<Intent> getActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                switch (result.getResultCode()) {//返り値で分岐
                    case RESULT_OK:
                        Optional.ofNullable(result.getData())
                                .map(data -> data.getStringExtra("rst"))
                                .map(text ->"Result:" + text)
                                .ifPresent(text-> binding.textView.setText(text));
                        break;
                    case RESULT_CANCELED:
                        binding.textView.setText("Result:Canceled");
                        break;
                    default:
                        binding.textView.setText("Result:Unknown(" + result.getResultCode() + ")");
                        break;
                }
            }
    );

}