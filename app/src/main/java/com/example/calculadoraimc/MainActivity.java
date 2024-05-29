package com.example.calculadoraimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView resultado_imc;

    private EditText peso_imc, altura_imc;

    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        resultado_imc = findViewById(R.id.resultado_imc);
        button2 = findViewById(R.id.button2);
        peso_imc = findViewById(R.id.peso_imc);
        altura_imc = findViewById(R.id.altura_imc);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double peso = Double.parseDouble(peso_imc.getText().toString());
                double altura = Double.parseDouble(altura_imc.getText().toString());
                double IMC = peso / (altura * altura);

                if (IMC < 18.5){
                    resultado_imc.setText(IMC +"\n Você está abaixo do peso!");
                }
                else if (IMC >= 18.5 && IMC < 25) {
                    resultado_imc.setText(IMC +"\n Você está no peso ideal!");
                }
                else if (IMC >= 25 && IMC < 30) {
                    resultado_imc.setText(IMC +"\n Você está acima do peso!");
                }
                else if (IMC >= 30 && IMC < 35) {
                    resultado_imc.setText(IMC +"\n Você está com obesidade grau 1!");
                }
                else if (IMC >= 35 && IMC < 40) {
                    resultado_imc.setText(IMC +"\n Você está com obesidade grau 2!");
                }
                else if (IMC > 40) {
                    resultado_imc.setText(IMC +"\n Você está com obesidade grau 3!");
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}