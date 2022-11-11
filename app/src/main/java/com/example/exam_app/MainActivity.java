package com.example.exam_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText questionBox;
    RadioButton option1Text,option2Text,option3Text,option4Text;
    Button nextButton;

    String []questionText={"Who is pm of pakistan","Who is cm of punjab"};
    String []option1={"imran khan","pervaize ilahi"};

    String []option2={"nawaz sharif","usman buzdar"};
    String []option3={"general bajwaa","sarafaraz ahmed"};
    String []option4={"shahbaz sharif","babar azam"};
    int [] correctOption={4,1};


    int questionNumber=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionBox= findViewById(R.id.questionBox);
        option1Text= findViewById(R.id.option1);
        option2Text= findViewById(R.id.option2);
        option3Text= findViewById(R.id.option3);
        option4Text= findViewById(R.id.option4);
        nextButton= findViewById(R.id.next);

        questionBox.setText(questionText[questionNumber]);
        option1Text.setText(option1[questionNumber]);
        option2Text.setText(option2[questionNumber]);
        option3Text.setText(option3[questionNumber]);
        option4Text.setText(option4[questionNumber]);



        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionNumber++;

                questionBox.setText(questionText[questionNumber]);
                option1Text.setText(option1[questionNumber]);
                option2Text.setText(option2[questionNumber]);
                option3Text.setText(option3[questionNumber]);
                option4Text.setText(option4[questionNumber]);

            }
        });




    }
}