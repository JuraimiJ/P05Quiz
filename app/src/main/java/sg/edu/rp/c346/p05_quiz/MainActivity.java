package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbOne;
    CheckBox cbRound;

    Button btnPlus;
    Button btnMinus;
    Button btnSubmit;

    EditText etInput;

    TextView tvInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbOne = findViewById(R.id.checkBoxOneWay);
        cbRound = findViewById(R.id.checkBoxRound);
        btnPlus = findViewById(R.id.buttonPlus);
        btnMinus = findViewById(R.id.buttonMinus);
        btnSubmit = findViewById(R.id.buttonSubmit);
        etInput = findViewById(R.id.editTextInput);


        if (cbRound.isChecked() && cbOne.isChecked()) {
            CharSequence text = "Invalid input in PAX, Number cannot be 0";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(MainActivity.this, text, duration);
            toast.show();
        }


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etInput.setText(etInput + 1);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etInput < 1) {
                    CharSequence text = "Invalid input in PAX, Number cannot be 0";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(MainActivity.this, text, duration);
                    toast.show();
                }
                else {
                    etInput.setText(etInput - 1);
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FlightDetails.class);

                if (cbRound.isChecked()) {
                    intent.putExtra("RoundType", "Round Trip");
                }
                else if (cbOne.isChecked()) {
                    intent.putExtra("One Way", "One  Way Trip");
                }
               startActivity(intent);


                Intent pax = new Intent (MainActivity.this, FlightDetails.class);
                pax.putExtra("Pax", etInput.getText());
                startActivity(pax);
            }
        });





    }


}
