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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText questionBox;
    RadioButton option1Button, option2Button, option3Button, option4Button,radioButton;
    Button nextButton;
    TextView currentQuestion;
    TextView score;
    RadioGroup radioGroup;

    String []questionText={"Who is pm of pakistan","Who is cm of punjab", "Who is cm of sindh"};
    String []option1={"imran khan","pervaize ilahi","Donald trump"};

    String []option2={"nawaz sharif","usman buzdar", "Murad Ali Shah"};
    String []option3={"general bajwaa","sarafaraz ahmed","John Cena"};
    String []option4={"shahbaz sharif","babar azam","UnderTaker"};
    String [] correctOption={"shahbaz sharif","pervaize ilahi","Murad Ali Shah"};
    int questionsLength=3;

    String [] userAnswers= new String[questionsLength];


    int questionNumber=0,iteration=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<questionsLength;i++)
        {
            userAnswers[i]="No";
        }

        questionNumber=generateRandomNumber();
        questionBox= findViewById(R.id.questionBox);
        option1Button = findViewById(R.id.option1);
        option2Button = findViewById(R.id.option2);
        option3Button = findViewById(R.id.option3);
        option4Button = findViewById(R.id.option4);
        nextButton= findViewById(R.id.next);
        currentQuestion= findViewById(R.id.currentQuestion);
        score=findViewById(R.id.score);



        questionBox.setText(questionText[questionNumber]);
        option1Button.setText(option1[questionNumber]);
        option2Button.setText(option2[questionNumber]);
        option3Button.setText(option3[questionNumber]);
        option4Button.setText(option4[questionNumber]);
        String c1= Integer.toString(questionNumber);
        currentQuestion.setText(Integer.toString(iteration+1));



        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                iteration++;



                if(iteration==questionsLength)
                {
                    saveAnswer();

                    System.out.println("Your answers");
                    int correctCount=0,wrongCount=0;
                    for(int i=0;i<questionsLength;i++)
                    {
                        System.out.println("Your answers"+userAnswers[i]);
                        System.out.println("Correct answers"+correctOption[i]);


                        if(userAnswers[i].endsWith(correctOption[i]) )
                            correctCount++;
                        else
                            wrongCount++;


                    }


                    score.setText("Correct Answers "+correctCount+"\nWrong Answers "+wrongCount);
                    nextButton.setText("");
                    questionBox.setText("");
                    radioGroup.removeAllViews();




                }

                else {

                    saveAnswer();
                    questionNumber=generateRandomNumber();




                    questionBox.setText(questionText[questionNumber]);
                    option1Button.setText(option1[questionNumber]);
                    option2Button.setText(option2[questionNumber]);
                    option3Button.setText(option3[questionNumber]);
                    option4Button.setText(option4[questionNumber]);
                    currentQuestion.setText(Integer.toString(iteration+1));
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
            userAnswers[questionNumber] = option1Button.getText().toString();
        } else if (selectedId == option2Button.getId()) {
            //Toast.makeText(MainActivity.this, "option2 is selected", Toast.LENGTH_SHORT).show();
            userAnswers[questionNumber] = option2Button.getText().toString();
        } else if (selectedId == option3Button.getId()) {
            userAnswers[questionNumber] = option3Button.getText().toString();
        } else if (selectedId == option4Button.getId()) {
            Toast.makeText(MainActivity.this, option4Button.getText(), Toast.LENGTH_SHORT).show();
            userAnswers[questionNumber] = option4Button.getText().toString();
        }

    }

    private int generateRandomNumber()
    {
        System.out.println("random fun called");

        Random rnd = new Random();
        int number;

        number = rnd.nextInt(questionsLength);
        while(userAnswers[number]!="No")
        {
            number = rnd.nextInt(questionsLength);

        }
        System.out.println(number);
        return number;

    }



}