package com.hann.projectandro2;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameInput, phoneInput;
    RadioGroup radioGroup;
    Button submitButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameInput = findViewById(R.id.Name);
        phoneInput = findViewById(R.id.Phone);
        radioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.submitbtn);

        submitButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String phone = phoneInput.getText().toString().trim();
            int selectedId = radioGroup.getCheckedRadioButtonId();
            String contacType = "";

            if (selectedId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                contacType = selectedRadioButton.getText().toString();
            }

            if (name.isEmpty()) {
                Toast.makeText(MainActivity.this, "Namamu belum diisi", Toast.LENGTH_SHORT).show();
            } else if (phone.isEmpty()) {
                Toast.makeText(MainActivity.this, "Nomor mu belum diisi", Toast.LENGTH_SHORT).show();
            } else if (contacType.isEmpty()) {
                Toast.makeText(MainActivity.this, "Pilih salah satu!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Submit Success!", Toast.LENGTH_LONG).show();
            }


        });
    }
}