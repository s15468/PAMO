package com.example.bmicalculator;

public class Quiz {

    public String Questions[] =
    {
        "COVID-19 należy do grupy koronawirusów. Atakuje on:",
        "Zasada DDM. Co oznacz ten skrót?",
        "Jednym z najważniejszych objawów COVID-19 jest suchy kaszel. U ilu procent chorych on występuje?",
        "Osoba, która nie przestrzega ośrodków ostrożności, zaraża około:",
        "Osoba z COVID-19, zanim wystąpią u niej objawy, i tak może zarażać. Dzieje się tak nawet około:",
        "Jaki jest dystans w przestrzeni publicznej powinno zachować się od innych osób?",
        "Jak bardzo śmiertelny jest koronawirus?",
        "Ile powinno trwać dokładne mycie rąk?",
        "Co zrobić jeżeli podejrzewasz u siebie koronawirusa?",
        "Czy lekarz POZ może wystawić skierowanie na test na koronawirusa?"
    };

    private String Answers[][] =
    {
        {"Płuca i drogi oddechowe", "Płuca", "Drogi oddechowe", "Serce"},
        {"dom-dezynfekcja-maseczka", "dezynfekcja-dystans-maseczka", "dystans-dezynfekcja-mycie rąk", "dom-dystans-mycie rąk"},
        {"0%", "40%", "80%", "100%"},
        {"1", "2-3 osób", "4-5 osób", "6-10 osób"},
        {"Dwa tygodnie przed wystąpieniem objawów","Tygodnia przed wystąpieniem objawów", "24 godzin przed wystąpieniem objawów", "48-72 godzin przed wystąpieniem objawów"},
        {"Około 1m", "Około 2.5m", "Około 5m", "Około 10m"},
        {"5x mniej niż grypa", "5x bardziej niż grypa", "Tak samo jak grypa", "Nie jest śmiertelny"},
        {"Minutę", "30 sekund", "20 sekund", "Nie określone"},
        {"Kontakt z SANEPID-em", "Umówienie się na poradę z lekarzem POZ"," Pojechanie na SOR","Zabunkrować się w domu"},
        {"Tak", "Nie", "Tak, ale w wyjątkowych przypadkach", "Nie wiem"},
    };

    private String correctAnswers[] =
    {
        "Płuca i drogi oddechowe",
        "dezynfekcja-dystans-maseczka",
        "40%",
        "2-3 osób",
        "48-72 godzin przed wystąpieniem objawów",
        "Około 2.5m",
        "5x bardziej niż grypa",
        "30 sekund",
        "Umówienie się na poradę z lekarzem POZ",
        "Tak"
    };

    public String getQuestion(int a)
    {
        return Questions[a];
    }

    public String getChoice1(int a)
    {
        return Answers[a][0];
    }

    public String getChoice2(int a)
    {
        return Answers[a][1];
    }

    public String getChoice3(int a)
    {
        return Answers[a][2];
    }

    public String getChoice4(int a)
    {
        return Answers[a][3];
    }

    public String getCorrectAnswer(int a)
    {
        return correctAnswers[a];
    }
}
