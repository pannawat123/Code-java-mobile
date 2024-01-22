package Code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class VatActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText priceInput, priceShow, vatShow, totalShow;
    private Button calculateVatButton, backButtonMain2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vat);

        priceInput = (EditText) findViewById(R.id.priceInput);
        priceShow = (EditText) findViewById(R.id.priceShow);
        vatShow = (EditText) findViewById(R.id.vatShow);
        totalShow = (EditText) findViewById(R.id.totalShow);

        calculateVatButton = (Button) findViewById(R.id.calculateVatButton);
        calculateVatButton.setOnClickListener(this);

        backButtonMain2 = (Button) findViewById(R.id.backButtonMain2);
        backButtonMain2.setOnClickListener(this);

        priceShow.setEnabled(false);
        vatShow.setEnabled(false);
        totalShow.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        if (v == calculateVatButton) {
            calcVat();
        } else if (v == backButtonMain2) {
            Toast.makeText(this, "Back Main Program", Toast.LENGTH_SHORT).show();
            Intent launchMain2 = new Intent( this, MainActivity.class);
            startActivity(launchMain2);
        }
    }











    public void calcVat() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        String priceStr = priceInput.getText().toString();

        if (!priceStr.isEmpty()) {
            float price = Float.parseFloat(priceStr);

            // Calculate VAT (7% of the price)
            float vat = (price * 7) / 100;

            // Calculate total price including VAT
            float totalPrice = price + vat;

            // Format the results with two decimal places
            String formattedPrice = decimalFormat.format(price);
            String formattedVat = decimalFormat.format(vat);
            String formattedTotalPrice = decimalFormat.format(totalPrice);

            // Display the formatted results in the respective EditText fields
            priceShow.setText(formattedPrice);
            vatShow.setText(formattedVat);
            totalShow.setText(formattedTotalPrice);
        } else {
            // Handle case when input is empty
            priceShow.setText("Please enter a price");
            vatShow.setText("Please enter a price");
            totalShow.setText("Please enter a price");
        }
    }
}
