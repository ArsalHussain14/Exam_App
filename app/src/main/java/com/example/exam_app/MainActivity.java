package com.example.exam_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText questionBox;
    RadioButton option1Button, option2Button, option3Button, option4Button,radioButton;
    Button nextButton;
    TextView currentQuestion;
    RadioGroup radioGroup;

    String []questionText={"Who is pm of pakistan","Who is cm of punjab"};
    String []option1={"imran khan","pervaize ilahi"};

    String []option2={"nawaz sharif","usman buzdar"};
    String []option3={"general bajwaa","sarafaraz ahmed"};
    String []option4={"shahbaz sharif","babar azam"};
    String [] correctOption={"shahbaz sharif","pervaize ilahi"};
    String [] userAnswers= new String[2];
    int questionNumber=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionBox= findViewById(R.id.questionBox);
        option1Button = findViewById(R.id.option1);
        option2Button = findViewById(R.id.option2);
        option3Button = findViewById(R.id.option3);
        option4Button = findViewById(R.id.option4);
        nextButton= findViewById(R.id.next);
        currentQuestion= findViewById(R.id.currentQuestion);


        questionBox.setText(questionText[questionNumber]);
        option1Button.setText(option1[questionNumber]);
        option2Button.setText(option2[questionNumber]);
        option3Button.setText(option3[questionNumber]);
        option4Button.setText(option4[questionNumber]);
        String c1= Integer.toString(questionNumber);
        currentQuestion.setText(Integer.toString(questionNumber+1));



        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                questionNumber++;



                if(questionNumber>=2)
                {
                    saveAnswer();

                    System.out.println("Your answers");
                    int correctCount=0,wrongCount=0;
                    for(int i=0;i<2;i++)
                    {
                        System.out.println("Your answers"+userAnswers[i]);
                        System.out.println("Correct answers"+correctOption[i]);


                        if(userAnswers[i].endsWith(correctOption[i]) )
                            correctCount++;
                        else
                            wrongCount++;


                    }

                    System.out.println("correct answers"+correctCount);

                    System.out.println("Wrong answers"+wrongCount);



                }
                else {

                    saveAnswer();




                    questionBox.setText(questionText[questionNumber]);
                    option1Button.setText(option1[questionNumber]);
                    option2Button.setText(option2[questionNumber]);
                    option3Button.setText(option3[questionNumber]);
                    option4Button.setText(option4[questionNumber]);
                    currentQuestion.setText(Integer.toString(questionNumber+1));
                }






            }
        });




    }

    private void saveAnswer()
    {
        radioGroup = findViewById(R.id.radioGroup);

        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == option1Button.getId()) {
            //Toast.makeText(MainActivity.this, "option1 is selected", Toast.LENGTH_SHORT).show();
            userAnswers[questionNumber-1] = option1Button.getText().toString();
        } else if (selectedId == option2Button.getId()) {
            //Toast.makeText(MainActivity.this, "option2 is selected", Toast.LENGTH_SHORT).show();
            userAnswers[questionNumber-1] = option2Button.getText().toString();
        } else if (selectedId == option3Button.getId()) {
            Toast.makeText(MainActivity.this, "option3 is selected", Toast.LENGTH_SHORT).show();
            userAnswers[questionNumber-1] = option3Button.getText().toString();
        } else if (selectedId == option4Button.getId()) {
            Toast.makeText(MainActivity.this, option4Button.getText(), Toast.LENGTH_SHORT).show();
            userAnswers[questionNumber-1] = option4Button.getText().toString();
        }

    }


}