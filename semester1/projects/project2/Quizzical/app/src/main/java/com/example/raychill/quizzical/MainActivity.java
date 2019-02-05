package com.example.raychill.quizzical;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private QuestionLibrary quizQuestionLibrary = new QuestionLibrary();

    private ImageView userBackground;
    private ImageView questionBackground;
    private ImageView artTrophy;
    private ImageView scienceTrophy;
    private ImageView historyTrophy;
    private ImageView sportsTrophy;
    private TextView correctNum;
    private TextView incorrectNum;
    private Spinner category;
    private String categoryType;
    private TextView questionNumView;
    private TextView questionView;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private Button select;
    private ImageButton next;

    private int artCorrect = 0;
    private int scienceCorrect = 0;
    private int historyCorrect = 0;
    private int sportsCorrect = 0;
    private int questionNumber = 0;
    private int correct = 0;
    private int incorrect = 0;
    private String answer1Text;
    private String answer2Text;
    private String answer3Text;
    private String answer4Text;
    private String answer;
    private String text;
    private String message1;
    private String message2;
    private String yes;
    private String no;
    private Boolean art;
    private Boolean science;
    private Boolean history;
    private Boolean sports;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("corr", correct);
        outState.putInt("incorr", incorrect);
        outState.putBoolean("artbool", art);
        outState.putBoolean("sciencebool", science);
        outState.putBoolean("historybool", history);
        outState.putBoolean("sportsbool", sports);
        outState.putInt("artimageid", R.drawable.arttrophy);
        outState.putInt("scienceimageid", R.drawable.sciencetrophy);
        outState.putInt("historyimageid", R.drawable.historytrophy);
        outState.putInt("sportsimageid", R.drawable.sportstrophy);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userBackground = findViewById(R.id.userBackground);
        questionBackground = findViewById(R.id.questionBackground);
        artTrophy = findViewById(R.id.artTrophyView);
        scienceTrophy = findViewById(R.id.scienceTrophyView);
        historyTrophy = findViewById(R.id.historyTrophyView);
        sportsTrophy = findViewById(R.id.sportsTrophyView);
        correctNum = findViewById(R.id.correctNumView);
        incorrectNum = findViewById(R.id.incorrectNumView);
        category = findViewById(R.id.spinner);
        questionNumView = findViewById(R.id.questionNumView);
        questionView = findViewById(R.id.questionView);
        answer1 = findViewById(R.id.button1);
        answer2 = findViewById(R.id.button2);
        answer3 = findViewById(R.id.button3);
        answer4 = findViewById(R.id.button4);
        select = findViewById(R.id.selectButton);
        next = findViewById(R.id.nextButton);
        art = false;
        science = false;
        history = false;
        sports = false;

        if (savedInstanceState !=null){
            correct = savedInstanceState.getInt("corr");
            incorrect = savedInstanceState.getInt("incorr");
            art = savedInstanceState.getBoolean("artbool");
            science = savedInstanceState.getBoolean("sciencebool");
            history = savedInstanceState.getBoolean("historybool");
            sports = savedInstanceState.getBoolean("sportsbool");
            int artimage_id = savedInstanceState.getInt("artimageid");
            int scienceimage_id = savedInstanceState.getInt("scienceimageid");
            int historyimage_id = savedInstanceState.getInt("historyimageid");
            int sportsimage_id = savedInstanceState.getInt("sportsimageid");

            correctNum.setText(String.valueOf(correct));
            incorrectNum.setText(String.valueOf(incorrect));
            if (art)
                artTrophy.setImageResource(artimage_id);
            if (science)
                scienceTrophy.setImageResource(scienceimage_id);
            if (history)
                historyTrophy.setImageResource(historyimage_id);
            if (sports)
                sportsTrophy.setImageResource(sportsimage_id);
        }

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionNumber = 0;
                categoryType = String.valueOf(category.getSelectedItem());
                switch (categoryType) {
                    case "Art":
                        updateArtQuestion();
                        userBackground.setImageResource(R.drawable.articon);
                        questionBackground.setImageResource(R.drawable.artbackground);
                        break;
                    case "Science":
                        updateScienceQuestion();
                        userBackground.setImageResource(R.drawable.scienceicon);
                        questionBackground.setImageResource(R.drawable.sciencebackground);
                        break;
                    case "History":
                        updateHistoryQuestion();
                        userBackground.setImageResource(R.drawable.historyicon);
                        questionBackground.setImageResource(R.drawable.historybackground);
                        break;
                    case "Sports":
                        updateSportsQuestion();
                        userBackground.setImageResource(R.drawable.sportsicon);
                        questionBackground.setImageResource(R.drawable.sportsbackground);
                        break;
                    default:
                        break;
                }

                next.setClickable(false);
                next.setImageResource(R.drawable.nextdisabled);

                answer1.setVisibility(View.VISIBLE);
                answer2.setVisibility(View.VISIBLE);
                answer3.setVisibility(View.VISIBLE);
                answer4.setVisibility(View.VISIBLE);
            }
        });

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer1Text.equals(answer)) {
                    Context context = getApplicationContext();
                    CharSequence text = "Correct!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    correct++;
                    next.setClickable(true);
                    next.setImageResource(R.drawable.next);
                    answer1.setClickable(false);
                    answer2.setClickable(false);
                    answer3.setClickable(false);
                    answer4.setClickable(false);

                    switch (categoryType) {
                        case "Art":
                            artCorrect++;
                            break;
                        case "Science":
                            scienceCorrect++;
                            break;
                        case "History":
                            historyCorrect++;
                            break;
                        case "Sports":
                            sportsCorrect++;
                            break;
                        default:
                    }
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect. Please try again.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    incorrect++;
                }
                correctNum.setText(String.valueOf(correct));
                incorrectNum.setText(String.valueOf(incorrect));
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer2Text.equals(answer)) {
                    Context context = getApplicationContext();
                    CharSequence text = "Correct!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    correct++;
                    next.setClickable(true);
                    next.setImageResource(R.drawable.next);
                    answer1.setClickable(false);
                    answer2.setClickable(false);
                    answer3.setClickable(false);
                    answer4.setClickable(false);

                    switch (categoryType) {
                        case "Art":
                            artCorrect++;
                            break;
                        case "Science":
                            scienceCorrect++;
                            break;
                        case "History":
                            historyCorrect++;
                            break;
                        case "Sports":
                            sportsCorrect++;
                            break;
                        default:
                    }
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect. Please try again.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    incorrect++;
                }
                correctNum.setText(String.valueOf(correct));
                incorrectNum.setText(String.valueOf(incorrect));
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer3Text.equals(answer)) {
                    Context context = getApplicationContext();
                    CharSequence text = "Correct!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    correct++;
                    next.setClickable(true);
                    next.setImageResource(R.drawable.next);
                    answer1.setClickable(false);
                    answer2.setClickable(false);
                    answer3.setClickable(false);
                    answer4.setClickable(false);

                    switch (categoryType) {
                        case "Art":
                            artCorrect++;
                            break;
                        case "Science":
                            scienceCorrect++;
                            break;
                        case "History":
                            historyCorrect++;
                            break;
                        case "Sports":
                            sportsCorrect++;
                            break;
                        default:
                    }
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect. Please try again.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    incorrect++;
                }
                correctNum.setText(String.valueOf(correct));
                incorrectNum.setText(String.valueOf(incorrect));
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer4Text.equals(answer)) {
                    Context context = getApplicationContext();
                    CharSequence text = "Correct!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    correct++;
                    next.setClickable(true);
                    next.setImageResource(R.drawable.next);
                    answer1.setClickable(false);
                    answer2.setClickable(false);
                    answer3.setClickable(false);
                    answer4.setClickable(false);

                    switch (categoryType) {
                        case "Art":
                            artCorrect++;
                            break;
                        case "Science":
                            scienceCorrect++;
                            break;
                        case "History":
                            historyCorrect++;
                            break;
                        case "Sports":
                            sportsCorrect++;
                            break;
                        default:
                    }
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect. Please try again.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    incorrect++;
                }
                correctNum.setText(String.valueOf(correct));
                incorrectNum.setText(String.valueOf(incorrect));
            }
        });
    }

    public void nextPressed(View view) {
        questionNumber++;
        next.setClickable(false);
        next.setImageResource(R.drawable.nextdisabled);
        answer1.setClickable(true);
        answer2.setClickable(true);
        answer3.setClickable(true);
        answer4.setClickable(true);
        switch (categoryType) {
            case "Art":
                updateArtQuestion();
                break;
            case "Science":
                updateScienceQuestion();
                break;
            case "History":
                updateHistoryQuestion();
                break;
            case "Sports":
                updateSportsQuestion();
                break;
            default:
        }
    }

    public void hintPressed(View view) {
        switch (categoryType) {
            case "Art":
                Toast.makeText(getApplicationContext(), quizQuestionLibrary.getArtHint(questionNumber), Toast.LENGTH_SHORT).show();
                break;
            case "Science":
                Toast.makeText(getApplicationContext(), quizQuestionLibrary.getScienceHint(questionNumber), Toast.LENGTH_SHORT).show();
                break;
            case "History":
                Toast.makeText(getApplicationContext(), quizQuestionLibrary.getHistoryHint(questionNumber), Toast.LENGTH_SHORT).show();
                break;
            case "Sports":
                Toast.makeText(getApplicationContext(), quizQuestionLibrary.getSportsHint(questionNumber), Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }

    public void skipPressed(View view) {
        questionNumber++;
        Context context = getApplicationContext();
        CharSequence text = "Skipped to next question.";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        switch (categoryType) {
            case "Art":
                updateArtQuestion();
                break;
            case "Science":
                updateScienceQuestion();
                break;
            case "History":
                updateHistoryQuestion();
                break;
            case "Sports":
                updateSportsQuestion();
                break;
            default:
        }
    }

    private void updateArtQuestion() {
        if (questionNumber <= 4) {
            text = "Question " + (questionNumber+1);
            questionNumView.setText(text);
            questionView.setText(quizQuestionLibrary.getArtQuestion(questionNumber));
            answer1.setText(quizQuestionLibrary.getArtAnswer1(questionNumber));
            answer2.setText(quizQuestionLibrary.getArtAnswer2(questionNumber));
            answer3.setText(quizQuestionLibrary.getArtAnswer3(questionNumber));
            answer4.setText(quizQuestionLibrary.getArtAnswer4(questionNumber));
            answer1Text = quizQuestionLibrary.getArtAnswer1(questionNumber);
            answer2Text = quizQuestionLibrary.getArtAnswer2(questionNumber);
            answer3Text = quizQuestionLibrary.getArtAnswer3(questionNumber);
            answer4Text = quizQuestionLibrary.getArtAnswer4(questionNumber);
            answer = quizQuestionLibrary.getArtCorrectAnswer(questionNumber);
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Congratulations! You've completed the Art trivia category.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            if (artCorrect >= 5) {
                artTrophy.setImageResource(R.drawable.arttrophy);
                art = true;
                if (art && science && history && sports)
                    gameFinish();
            }
        }
    }

    private void updateScienceQuestion() {
        if (questionNumber <= 4) {
            text = "Question " + (questionNumber+1);
            questionNumView.setText(text);
            questionView.setText(quizQuestionLibrary.getScienceQuestion(questionNumber));
            answer1.setText(quizQuestionLibrary.getScienceAnswer1(questionNumber));
            answer2.setText(quizQuestionLibrary.getScienceAnswer2(questionNumber));
            answer3.setText(quizQuestionLibrary.getScienceAnswer3(questionNumber));
            answer4.setText(quizQuestionLibrary.getScienceAnswer4(questionNumber));
            answer1Text = quizQuestionLibrary.getScienceAnswer1(questionNumber);
            answer2Text = quizQuestionLibrary.getScienceAnswer2(questionNumber);
            answer3Text = quizQuestionLibrary.getScienceAnswer3(questionNumber);
            answer4Text = quizQuestionLibrary.getScienceAnswer4(questionNumber);
            answer = quizQuestionLibrary.getScienceCorrectAnswer(questionNumber);
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Congratulations! You've completed the Science trivia category.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            if (scienceCorrect >= 5) {
                scienceTrophy.setImageResource(R.drawable.sciencetrophy);
                science = true;
                if (art && science && history && sports)
                    gameFinish();
            }
        }
    }

    private void updateHistoryQuestion() {
        if (questionNumber <= 4) {
            text = "Question " + (questionNumber+1);
            questionNumView.setText(text);
            questionView.setText(quizQuestionLibrary.getHistoryQuestion(questionNumber));
            answer1.setText(quizQuestionLibrary.getHistoryAnswer1(questionNumber));
            answer2.setText(quizQuestionLibrary.getHistoryAnswer2(questionNumber));
            answer3.setText(quizQuestionLibrary.getHistoryAnswer3(questionNumber));
            answer4.setText(quizQuestionLibrary.getHistoryAnswer4(questionNumber));
            answer1Text = quizQuestionLibrary.getHistoryAnswer1(questionNumber);
            answer2Text = quizQuestionLibrary.getHistoryAnswer2(questionNumber);
            answer3Text = quizQuestionLibrary.getHistoryAnswer3(questionNumber);
            answer4Text = quizQuestionLibrary.getHistoryAnswer4(questionNumber);
            answer = quizQuestionLibrary.getHistoryCorrectAnswer(questionNumber);
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Congratulations! You've completed the History trivia category.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            if (historyCorrect >= 5) {
                historyTrophy.setImageResource(R.drawable.historytrophy);
                history = true;
                if (art && science && history && sports)
                    gameFinish();
            }
        }
    }

    private void updateSportsQuestion() {
        if (questionNumber <= 4) {
            text = "Question " + (questionNumber+1);
            questionNumView.setText(text);
            questionView.setText(quizQuestionLibrary.getSportsQuestion(questionNumber));
            answer1.setText(quizQuestionLibrary.getSportsAnswer1(questionNumber));
            answer2.setText(quizQuestionLibrary.getSportsAnswer2(questionNumber));
            answer3.setText(quizQuestionLibrary.getSportsAnswer3(questionNumber));
            answer4.setText(quizQuestionLibrary.getSportsAnswer4(questionNumber));
            answer1Text = quizQuestionLibrary.getSportsAnswer1(questionNumber);
            answer2Text = quizQuestionLibrary.getSportsAnswer2(questionNumber);
            answer3Text = quizQuestionLibrary.getSportsAnswer3(questionNumber);
            answer4Text = quizQuestionLibrary.getSportsAnswer4(questionNumber);
            answer = quizQuestionLibrary.getSportsCorrectAnswer(questionNumber);
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Congratulations! You've completed the Sports trivia category.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            if (sportsCorrect >= 5) {
                sportsTrophy.setImageResource(R.drawable.sportstrophy);
                sports = true;
                if (art && science && history && sports)
                    gameFinish();
            }
        }
    }

    private void gameFinish() {
        message1 = "Congratulations!";
        message2 = "You have won all the trophies and completed the game. Would you like to restart the quiz?";
        questionNumView.setText(message1);
        questionView.setText(message2);
        yes = "Yes";
        no = "No";
        answer1.setText(yes);
        answer2.setText(no);
        answer3.setVisibility(View.GONE);
        answer4.setVisibility(View.GONE);
    }

}
