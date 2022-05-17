package com.example.rtnconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText rn;
    Button btnConvert;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
         rn = (EditText) findViewById(R.id.editTextTextPersonName);
         btnConvert = (Button) findViewById(R.id.button2);
         result = (TextView) findViewById(R.id.textView2);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = rn.getText().toString();
                romanToDecimal(str);


            }
        });
    }

    int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    public void romanToDecimal(String str){

        {
            // Initialize result
            int res = 0;
            String ress;

            for (int i = 0; i < str.length(); i++) {
                // Getting value of symbol s[i]
                int s1 = value(str.charAt(i));

                // Getting value of symbol s[i+1]
                if (i + 1 < str.length()) {
                    int s2 = value(str.charAt(i + 1));

                    // Comparing both values
                    if (s1 >= s2) {
                        // Value of current symbol
                        // is greater or equalto
                        // the next symbol
                        res = res + s1;
                    }
                    else {
                        // Value of current symbol is
                        // less than the next symbol
                        res = res + s2 - s1;
                        i++;
                    }
                }
                else {
                    res = res + s1;


                }
            }
            ress = String.valueOf(res);

            result.setText(ress);

        }
    }
}