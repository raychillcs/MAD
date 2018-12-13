package com.example.raychill.quizzical;

public class QuestionLibrary {
    //Questions
    private String artQuestions[] = {
            "Which artist is credited with developing linear perspective?",
            "What note is the highest string of a violin usually tuned to?",
            "What war is taking place in the novel Lord of the Flies?",
            "Which year was the first book in the Harry Potter series published?",
            "From what language did English borrow the word zero?"
    };

    private String scienceQuestions[] = {
            "What element’s chemical symbol is the letter I?",
            "How many arms does a typical snowflake have?",
            "What colour are mosquitoes most attracted to?",
            "What is the only phase of the Moon that can produce a solar eclipse?",
            "Starfish belong to which animal phylum?"
    };

    private String historyQuestions[] = {
            "What year did Albert Einstein die?",
            "The first significant gold rush in the US occurred in what state?",
            "What nation was led by Simeon the Great?",
            "Which U.S. president appears on the far left at Mount Rushmore?",
            "Which U.S. amendment limits the president to two terms?"
    };

    private String sportsQuestions[] = {
            "Who holds the record for the most home runs in one baseball season?",
            "How many teams are in the American National Football league?",
            "What is the national sport of Japan?",
            "Which baseball team won the first World Series championship in 1903?",
            "How many super bowls have the Denver Broncos won?"
    };

    //Answers
    private String artAnswers[][] = {
            {"Donatello", "Brunelleschi", "Michelangelo", "da Vinci"},
            {"C", "D", "E", "F"},
            {"World War I", "World War II", "Vietnam War", "Cold War"},
            {"1997", "2000", "2003", "2006"},
            {"German", "Russian", "Greek", "Arabic"},
    };

    private String scienceAnswers[][] = {
            {"Iron", "Iridium", "Iodide", "Iodine"},
            {"5", "6", "7", "8"},
            {"Blue", "Red", "Yellow", "Black"},
            {"First quarter", "Last quarter", "Full moon", "New moon"},
            {"Arthropoda", "Cnidaria", "Echinoderms", "Crustacea"},
    };

    private String historyAnswers[][] = {
            {"1935", "1945", "1955", "1965"},
            {"California", "Nevada", "Colorado", "North Carolina"},
            {"Bulgaria", "Romania", "Hungary", "Austria"},
            {"Roosevelt", "Washington", "Jefferson", "Lincoln"},
            {"15th", "18th", "22nd", "26th"},
    };

    private String sportsAnswers[][] = {
            {"Babe Ruth", "Hank Aaron", "Barry Bonds", "Willie Mays"},
            {"22", "28", "32", "36"},
            {"Baseball", "Martial arts", "Ice skating", "Sumo"},
            {"Americans", "Athletics", "Tigers", "Browns"},
            {"1", "2", "3", "4"},
    };

    //Correct Answers
    private String artCorrectAnswers[] = {
            "Brunelleschi",
            "E",
            "World War II",
            "1997",
            "Arabic"
    };

    private String scienceCorrectAnswers[] = {
            "Iodine",
            "6",
            "Blue",
            "New moon",
            "Echinoderms"
    };

    private String historyCorrectAnswers[] = {
            "1955",
            "North Carolina",
            "Bulgaria",
            "Washington",
            "22nd"
    };

    private String sportsCorrectAnswers[] = {
            "Barry Bonds",
            "32",
            "Sumo",
            "Americans",
            "3"
    };

    //Hints
    private String artHints[] = {
            "Hint: He was an Italian architect.",
            "Hint: The third note of the C major scale.",
            "Hint: Took place from 1939 to 1945.",
            "Hint: Same year as the film Titanic.",
            "Hint: The language of Islam."
    };

    private String scienceHints[] = {
            "Hint: Found in the human thyroid.",
            "Hint: Same amount as a hexagon.",
            "Hint: Has a calming effect.",
            "Hint: The first lunar phase.",
            "Hint: Largest marine animal phylum."
    };

    private String historyHints[] = {
            "Hint: Same year as Vietnam War.",
            "Hint: State on the east coast.",
            "Hint: Shares a coastline with Greece.",
            "Hint: First U.S. president.",
            "Hint: Added in 1951."
    };

    private String sportsHints[] = {
            "Hint: Player from 1986 to 2007.",
            "Hint: Somewhere in the middle.",
            "Hint: A form of wrestling.",
            "Hint: Now called the Red Sox.",
            "Hint: More than 2."
    };

    //Getters
    //Getting questions
    public String getArtQuestion(int a) {
        String question = artQuestions[a];
        return question;
    }
    public String getScienceQuestion(int a) {
        String question = scienceQuestions[a];
        return question;
    }
    public String getHistoryQuestion(int a) {
        String question = historyQuestions[a];
        return question;
    }
    public String getSportsQuestion(int a) {
        String question = sportsQuestions[a];
        return question;
    }

    //Getting answers
    public String getArtAnswer1(int a) {
        String answer0 = artAnswers[a][0];
        return answer0;
    }
    public String getArtAnswer2(int a) {
        String answer1 = artAnswers[a][1];
        return answer1;
    }
    public String getArtAnswer3(int a) {
        String answer2 = artAnswers[a][2];
        return answer2;
    }
    public String getArtAnswer4(int a) {
        String answer3 = artAnswers[a][3];
        return answer3;
    }

    public String getScienceAnswer1(int a) {
        String answer0 = scienceAnswers[a][0];
        return answer0;
    }
    public String getScienceAnswer2(int a) {
        String answer1 = scienceAnswers[a][1];
        return answer1;
    }
    public String getScienceAnswer3(int a) {
        String answer2 = scienceAnswers[a][2];
        return answer2;
    }
    public String getScienceAnswer4(int a) {
        String answer3 = scienceAnswers[a][3];
        return answer3;
    }

    public String getHistoryAnswer1(int a) {
        String answer0 = historyAnswers[a][0];
        return answer0;
    }
    public String getHistoryAnswer2(int a) {
        String answer1 = historyAnswers[a][1];
        return answer1;
    }
    public String getHistoryAnswer3(int a) {
        String answer2 = historyAnswers[a][2];
        return answer2;
    }
    public String getHistoryAnswer4(int a) {
        String answer3 = historyAnswers[a][3];
        return answer3;
    }

    public String getSportsAnswer1(int a) {
        String answer0 = sportsAnswers[a][0];
        return answer0;
    }
    public String getSportsAnswer2(int a) {
        String answer1 = sportsAnswers[a][1];
        return answer1;
    }
    public String getSportsAnswer3(int a) {
        String answer2 = sportsAnswers[a][2];
        return answer2;
    }
    public String getSportsAnswer4(int a) {
        String answer3 = sportsAnswers[a][3];
        return answer3;
    }

    //Getting correct answers
    public String getArtCorrectAnswer(int a) {
        String answer = artCorrectAnswers[a];
        return answer;
    }
    public String getScienceCorrectAnswer(int a) {
        String answer = scienceCorrectAnswers[a];
        return answer;
    }
    public String getHistoryCorrectAnswer(int a) {
        String answer = historyCorrectAnswers[a];
        return answer;
    }
    public String getSportsCorrectAnswer(int a) {
        String answer = sportsCorrectAnswers[a];
        return answer;
    }

    //Getting hints
    public String getArtHint(int a) {
        String hint = artHints[a];
        return hint;
    }
    public String getScienceHint(int a) {
        String hint = scienceHints[a];
        return hint;
    }
    public String getHistoryHint(int a) {
        String hint = historyHints[a];
        return hint;
    }
    public String getSportsHint(int a) {
        String hint = sportsHints[a];
        return hint;
    }
}