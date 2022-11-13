package com.example.exam_app;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText questionBox;
    RadioButton option1Button, option2Button, option3Button, option4Button,radioButton;
    Button nextButton;
    TextView currentQuestion,displayAnswers;
    TextView score;
    RadioGroup radioGroup;

    String []questionText={"Cobalt is a component of which of the following Vitamins?","What is the Gaussian unit of kinematic viscosity?", "Which of the following is another unit of frequency?"};
    String []option1={"VitaminA","Henry","decibel"};

    String []option2={"VitaminD ","Stokes", "cycle per second"};
    String []option3={"VitaminE","Watt","metre per second"};
    String []option4={"VitaminB12","poiseiulle","second"};
    String [] correctOption={"VitaminB12","Stokes","cycle per second"};
    int questionsLength=3;

    String [] userAnswers= new String[questionsLength];


    int questionNumber=0,iteration=0;
    int []options={0,0,0,0};
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
        displayAnswers= findViewById(R.id.displayAnswers);



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

                    currentQuestion.setText("RESULT");
                    score.setBackgroundColor(getResources().getColor(R.color.green));
                    score.setText("Correct Answers "+correctCount+"\nWrong Answers "+wrongCount);

                    nextButton.setVisibility(View.GONE);
                    questionBox.setText("");
                    radioGroup.removeAllViews();
                    String result;

                    for(int i=0;i<questionsLength;i++)
                    {
                        if(userAnswers[i].equals(correctOption[i]))
                            result="Right";
                        else
                            result="wrong";

                        displayAnswers.append(questionText[i]+"\n");

                        displayAnswers.append(userAnswers[i]+"  "+correctOption[i]+"  "+result+"\n\n");
                    }






                }

                else {

                    saveAnswer();
                    questionNumber=generateRandomNumber();




                    questionBox.setText(questionText[questionNumber]);
                    int optionNumber=generateRandomOptions();
                    setOptions(option1Button,optionNumber);


                    optionNumber=generateRandomOptions();
                    setOptions(option2Button,optionNumber);


                    optionNumber=generateRandomOptions();
                    setOptions(option3Button,optionNumber);

                    optionNumber=generateRandomOptions();
                    setOptions(option4Button,optionNumber);



                    currentQuestion.setText(Integer.toString(iteration+1));
                    for(int i=0;i<4;i++)
                    {
                        options[i]=0;
                    }
                }






            }
        });




    }

    private void setOptions(RadioButton option, int optionNumber)
    {
        if(optionNumber==0)
            option.setText(option1[questionNumber]);
        else if(optionNumber==1)
            option.setText(option2[questionNumber]);
        else if(optionNumber==2)
            option.setText(option3[questionNumber]);
        else if(optionNumber==3)
            option.setText(option4[questionNumber]);
    }


    private void saveAnswer()
    {
        radioGroup = findViewById(R.id.radioGroup);

        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == option1Button.getId()) {
            userAnswers[questionNumber] = option1Button.getText().toString();
        } else if (selectedId == option2Button.getId()) {
            userAnswers[questionNumber] = option2Button.getText().toString();
        } else if (selectedId == option3Button.getId()) {
            userAnswers[questionNumber] = option3Button.getText().toString();
        } else if (selectedId == option4Button.getId()) {
            userAnswers[questionNumber] = option4Button.getText().toString();
        }

    }

    private int generateRandomNumber()
    {

        Random rnd = new Random();
        int number;

        number = rnd.nextInt(questionsLength);
        while(userAnswers[number]!="No")
        {
            number = rnd.nextInt(questionsLength);

        }
        return number;

    }

    private int generateRandomOptions()
    {
        Random rnd= new Random();
        int number=rnd.nextInt(4);
        while(options[number]==1)
        {
            number=rnd.nextInt(4);
        }
        options[number]=1;
        return number;
    }



}