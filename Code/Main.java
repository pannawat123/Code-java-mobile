package Code;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCalculateGrade,btnCalculateVat,btnCalculateGpa,btnShowGallery,btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalculateGrade = (Button) findViewById(R.id.btnCalculateGrade);
        btnCalculateGrade.setOnClickListener(this);

        btnCalculateVat = (Button) findViewById(R.id.btnCalculateVat);
        btnCalculateVat.setOnClickListener(this);

        btnCalculateGpa = (Button) findViewById(R.id.btnCalculateGpa);
        btnCalculateGpa.setOnClickListener(this);

        btnShowGallery = (Button) findViewById(R.id.btnShowGallery);
        btnShowGallery.setOnClickListener(this);

        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);
    }





























    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnCalculateGrade) {
            Toast.makeText(this, "Welcome page Calculate Grade", Toast.LENGTH_SHORT).show();
            Intent launchFirst = new Intent( this, GradeActivity.class);
            startActivity(launchFirst);
        }
        else if (id == R.id.btnCalculateVat)
        {
            Toast.makeText(this, "Welcome page Calculate Vat", Toast.LENGTH_SHORT).show();
            Intent launchSecond = new Intent( this, VatActivity.class);
            startActivity(launchSecond);
        }
        else if (id == R.id.btnCalculateGpa)
        {
            Toast.makeText(this, "Welcome page Calculate Gpa", Toast.LENGTH_SHORT).show();
            Intent launchTree = new Intent( this, GpaActivity.class);
            startActivity(launchTree);
        }
        else if (id == R.id.btnShowGallery)
        {
            Toast.makeText(this, "Welcome page Gallery", Toast.LENGTH_SHORT).show();
            Intent launchFour = new Intent(this, GalleryActivity.class);
            startActivity(launchFour);
        }
        else if (id == R.id.btnExit);
        {
//            Toast.makeText(this, "Exit Main Program", Toast.LENGTH_SHORT).show();
              finishAffinity();

        }
    }


}