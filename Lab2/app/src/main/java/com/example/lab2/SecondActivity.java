package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    ImageView image;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        image = findViewById(R.id.imageView1);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button2);

        if (getIntent().hasExtra("image")) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("image"), 0,
                    Objects.requireNonNull(getIntent().getByteArrayExtra("image")).length
            );
            image.setImageBitmap(bitmap);
        }

        button.setOnClickListener(v -> {
            String text = editText.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("comment", text);

            setResult(RESULT_OK, intent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        setResult(RESULT_CANCELED);
    }
}
