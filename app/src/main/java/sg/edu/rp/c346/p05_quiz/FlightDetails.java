package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FlightDetails extends AppCompatActivity {

    TextView tvCost;
    TextView tvTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        tvCost = findViewById(R.id.textViewCost);
        tvTrip = findViewById(R.id.textViewTrip);
        Intent intentReceived = getIntent();
        int pax = intentReceived.getIntExtra("Pax",0);

        double oneWay = 100 * pax;
        double RoundTrip = 100 *pax * 2;

        tvTrip.setText();

    }
}
