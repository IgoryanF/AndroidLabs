package com.example.lab2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.BitmapCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    public static int REQUEST_CODE = 100;

    ImageView image;
    Button button;
    TextView textView;
    Button downloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        image = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        downloadButton = findViewById(R.id.button2);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, bs);
            intent.putExtra("image", bs.toByteArray());
            startActivityForResult(intent, REQUEST_CODE);
        });

        // неявное намерение
        downloadButton.setOnClickListener(v -> {
            Uri address = Uri.parse("https://www.hdwallpapers.in/seychelles_sea_shores-wallpapers.html");
            Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
            if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(openLinkIntent);
            } else {
                Toast.makeText(this, "Не получается обработать намерение!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // обработка результата
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Пользователь вышел из SecondActivity", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_OK) {

                if (data != null) {
                    String text = data.getStringExtra("comment");
                    if (text != null) {
                        textView.setText(text);
                    }
                }
            }
        }
    }
}
