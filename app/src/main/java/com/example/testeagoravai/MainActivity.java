package com.example.testeagoravai;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.testeagoravai.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private TextView result;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        result = findViewById(R.id.txt_result);
        Button buttonConverter = findViewById(R.id.btn_converter);
        buttonConverter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                converter();
            }

            private void converter() {
                RadioGroup selectedCurrency = findViewById(R.id.radio_group);
                int checked = selectedCurrency.getCheckedRadioButtonId();
                EditText txt_valor = findViewById(R.id.input_valor);
                double currency = 0.0;

                if (checked == R.id.radio_usd) {
                    double valor = Double.parseDouble(txt_valor.getText().toString());
                    currency = valor * 4.90;
                } else if (checked == R.id.radio_eur) {
                    double valor = Double.parseDouble(txt_valor.getText().toString());
                    currency = valor * 5.33;
                } else {
                    double valor = Double.parseDouble(txt_valor.getText().toString());
                    currency = valor * 0.0056;
                }

                result.setText(String.valueOf(currency));
                result.setVisibility(View.VISIBLE);
            }
        });

    }



}