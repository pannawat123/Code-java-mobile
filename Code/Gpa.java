package Code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class GpaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText grade1Input,grade2Input,grade3Input,grade4Input,pointShow,creditShow,gpaShow;
    private Button calculateGpaButton,backButtonMain3,btnResetButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);

        grade1Input = (EditText) findViewById(R.id.grade1Input);
        grade2Input = (EditText) findViewById(R.id.grade2Input);
        grade3Input = (EditText) findViewById(R.id.grade3Input);
        grade4Input = (EditText) findViewById(R.id.grade4Input);

        pointShow = (EditText) findViewById(R.id.pointShow);
        creditShow = (EditText) findViewById(R.id.creditShow);
        gpaShow = (EditText) findViewById(R.id.gpaShow);

        calculateGpaButton = (Button) findViewById(R.id.calculateGpaButton);
        calculateGpaButton.setOnClickListener(this);

        backButtonMain3 = (Button) findViewById(R.id.backButtonMain3);
        backButtonMain3.setOnClickListener(this);

        btnResetButton3 = (Button) findViewById(R.id.btnResetButton3);
        btnResetButton3.setOnClickListener(this);

        pointShow.setEnabled(false);
        creditShow.setEnabled(false);
        gpaShow.setEnabled(false);
    }














    @Override
    public void onClick(View v) {
        if (v == calculateGpaButton) {
            calculateGpa();
        } else if (v == backButtonMain3) {
            Toast.makeText(this, "Back Main Program", Toast.LENGTH_SHORT).show();
            Intent launchMain3 = new Intent( this, MainActivity.class);
            startActivity(launchMain3);
        } else if (v == btnResetButton3) {
            grade1Input.setText("");
            grade2Input.setText("");
            grade3Input.setText("");
            grade4Input.setText("");
            pointShow.setText("");
            creditShow.setText("");
            gpaShow.setText("");
        }

    }

    private void calculateGpa() {
        // Get grades from EditText fields
        String grade1 = grade1Input.getText().toString().toUpperCase();
        String grade2 = grade2Input.getText().toString().toUpperCase();
        String grade3 = grade3Input.getText().toString().toUpperCase();
        String grade4 = grade4Input.getText().toString().toUpperCase();

        // Check if any grade field is empty
        if (grade1.isEmpty() || grade2.isEmpty() || grade3.isEmpty() || grade4.isEmpty()) {
            pointShow.setText("Enter Grade");
            creditShow.setText("Enter Grade");
            gpaShow.setText("Enter Grade");
            return;
        }

        int creditsPerCourse = 3; // Assuming each course has 3 credits

        // Calculate total grade points
        float totalGradePoints = getGradePoints(grade1) * creditsPerCourse
                + getGradePoints(grade2) * creditsPerCourse
                + getGradePoints(grade3) * creditsPerCourse
                + getGradePoints(grade4) * creditsPerCourse;

        // Calculate total credits
        int totalCredits = 4 * creditsPerCourse; // Assuming 4 courses

        // Calculate GPA
        float gpa = totalGradePoints / totalCredits;

        // Create a DecimalFormat with two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        // Format the GPA with two decimal places
        String formattedPoints = decimalFormat.format(totalGradePoints);
        String formattedCredits = decimalFormat.format(totalCredits);
        String formattedGpa = decimalFormat.format(gpa);



        // Display total points, total credits, and GPA result
        pointShow.setText("" + formattedPoints);
        creditShow.setText("" + formattedCredits);
        gpaShow.setText("" + formattedGpa);
}





    private float getGradePoints(String grade) {
        switch (grade) {
            case "A":
                return 4.0f;
            case "B+":
                return 3.5f;
            case "B":
                return 3.0f;
            case "C+":
                return 2.5f;
            case "C":
                return 2.0f;
            case "D+":
                return 1.5f;
            case "D":
                return 1.0f;
            case "F":
                return 0.0f; // Handle invalid grades
            default:
                return 0.0f;
        }
    }

}