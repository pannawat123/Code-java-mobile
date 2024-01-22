package Code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GradeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText scoreInput , scoreShow , gradeShow;
    private Button calculateGradeButton, backButtonMain1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        scoreInput = (EditText) findViewById(R.id.scoreInput);
        scoreShow = (EditText) findViewById(R.id.scoreShow);
        gradeShow = (EditText) findViewById(R.id.gradeShow);

        calculateGradeButton = (Button) findViewById(R.id.calculateGradeButton);
        calculateGradeButton.setOnClickListener(this);

        backButtonMain1 = (Button) findViewById(R.id.backButtonMain1);
        backButtonMain1.setOnClickListener(this);

        scoreShow.setEnabled(false);
        gradeShow.setEnabled(false);


    }

    @Override
    public void onClick(View v) {
        if (v == calculateGradeButton) {
            calcGrade();
        } else if (v == backButtonMain1) {
            Toast.makeText(this, "Back Main Program", Toast.LENGTH_SHORT).show();
            Intent launchMain1 = new Intent( this, MainActivity.class);
            startActivity(launchMain1);
        }
    }










    
    
    public void calcGrade() {
// Get the score from the scoreInput EditText
        String scoreStr = scoreInput.getText().toString();

        if (!scoreStr.isEmpty()) {
// Check if the input contains only one dot (.) and remove it
            if (scoreStr.equals(".") || scoreStr.startsWith(".") || scoreStr.endsWith(".") || scoreStr.indexOf(".") != scoreStr.lastIndexOf(".")) {
// Handle case when input contains more than one dot (.) or starts/ends with dot
                scoreShow.setText("Please enter a valid score");
                gradeShow.setText("Please enter a valid score"); // Clear the grade display
            } else {
// Parse the input score to a numeric value
                double score = Double.parseDouble(scoreStr);

                scoreShow.setText("" + score);

// Perform your grading logic here
                String grade;
                if (score >= 80) {
                    grade = "A" ;
                } else if (score >= 75) {
                    grade = "B+";
                } else if (score >= 70) {
                    grade = "B";
                } else if (score >= 65) {
                    grade = "C+";
                } else if (score >= 60) {
                    grade = "C";
                } else if (score >= 55) {
                    grade = "D+";
                } else if (score >= 50) {
                    grade = "D";
                } else {
                    grade = "F";
                }

// Display the grade in the gradeShow EditText
                gradeShow.setText("" + grade);
            }
        } else {
            // Handle case when input is empty
            scoreShow.setText("Please enter a score");
            gradeShow.setText(""); // Clear the grade display
        }
    }


}