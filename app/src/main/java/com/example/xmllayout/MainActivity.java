package com.example.xmllayout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    Button btn;
    EditText textCost;
    double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg= findViewById(R.id.tip_options);
        btn=findViewById(R.id.calculate_button);
        TextView resultcost = findViewById(R.id.tip_result);
        RadioButton rbok= findViewById(R.id.radio_okay);
        RadioButton rbgood= findViewById(R.id.radio_good);
        RadioButton rbamz= findViewById(R.id.radio_amazing);
        textCost=findViewById(R.id.cost_of_service);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double costOfService;
                Double tipPercentage=0.0;
                Double tipAmount;

                if(textCost.getText().equals("")){
                    resultcost.setError("Enter  cost of service");
                    return;
                }
                int checkedId = rg.getCheckedRadioButtonId();
                if (checkedId < 0){
                    rbok.setError("select service type");
                    return;
                }else {
                    try {
                        costOfService = Double.valueOf(textCost.getText().toString());
                    } catch (Exception ex) {
                        textCost.setError("Invalid cost of service");
                        return;
                    }
                    switch (checkedId) {
                        case R.id.radio_amazing:
                            tipPercentage = 0.20;

                            break;
                        case R.id.radio_good:
                            tipPercentage = 0.18;

                            break;
                        case R.id.radio_okay:
                            tipPercentage = 0.15;

                            break;
                    }
                }
                result= (double)tipPercentage*costOfService;
                resultcost.setText(Double.toString(result));
            }
        });


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_amazing:
                        Toast.makeText(MainActivity.this,"Amazing clicked",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_good:
                        Toast.makeText(MainActivity.this,"Good clicked",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_okay:
                        Toast.makeText(MainActivity.this,"Good clicked",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}