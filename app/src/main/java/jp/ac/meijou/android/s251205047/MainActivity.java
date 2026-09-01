package jp.ac.meijou.android.s251205047;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s251205047.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private PrefDataStore prefDataStore;
    private  int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        prefDataStore = PrefDataStore.getInstance(this);
        prefDataStore.getString("text")
                .ifPresent(text -> {//タグ付きで保存→ログに残せる
                    //var modText = text;
                    //Log.d("meijo",modText);
                    //binding.text.setText(modText);
                    if ("a".equals(text)){
                        binding.text.setText("aの画像");
                        binding.imageView.setImageResource(R.drawable.baseline_android_24);
                    }else if("b".equals(text)){
                        binding.text.setText("bの画像");
                        binding.imageView.setImageResource(R.drawable.outline_10k_24);
                        count++;
                    }else if("unknown".equals(text)){
                        binding.text.setText("知らない画像");
                        binding.imageView.setImageResource(R.drawable.unknown);
                        count++;
                    }
                });

        //text変更ボタン
        binding.button.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
            binding.text.setText(text);
        });
        //image変更ボタン
        binding.button2.setOnClickListener(view -> {
            count++;
            if(count % 2 == 0){
                binding.text.setText("a");
                binding.imageView.setImageResource((R.drawable.baseline_android_24));
            }else{
                binding.text.setText("b");
                binding.imageView.setImageResource(R.drawable.outline_10k_24);
            }
        });
        //textboxに入力する前/途中/後にアクションできる
        binding.editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                binding.text.setText(text);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });
        //saveボタン
        binding.SaveButton.setOnClickListener(view ->{
            var text = binding.editTextText.getText().toString();
            if ("a".equals(text)){
                binding.imageView.setImageResource(R.drawable.baseline_android_24);
            }else if("b".equals(text)){
                binding.imageView.setImageResource(R.drawable.outline_10k_24);
            }else{
                text = "unknown";
            }
            prefDataStore.setString("text", text);
        });
        //deleteボタン
        binding.deleteButton.setOnClickListener((view ->{
            binding.text.setText(" ");
            binding.imageView.setImageResource(R.drawable.unknown);
            count = 1;
        }));
    }
}