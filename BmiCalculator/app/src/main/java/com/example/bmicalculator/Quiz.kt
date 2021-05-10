package com.example.bmicalculator

class Quiz {
    var Questions = arrayOf(
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
    )
    private val Answers = arrayOf(arrayOf("Płuca i drogi oddechowe", "Płuca", "Drogi oddechowe", "Serce"), arrayOf("dom-dezynfekcja-maseczka", "dezynfekcja-dystans-maseczka", "dystans-dezynfekcja-mycie rąk", "dom-dystans-mycie rąk"), arrayOf("0%", "40%", "80%", "100%"), arrayOf("1", "2-3 osób", "4-5 osób", "6-10 osób"), arrayOf("Dwa tygodnie przed wystąpieniem objawów", "Tygodnia przed wystąpieniem objawów", "24 godzin przed wystąpieniem objawów", "48-72 godzin przed wystąpieniem objawów"), arrayOf("Około 1m", "Około 2.5m", "Około 5m", "Około 10m"), arrayOf("5x mniej niż grypa", "5x bardziej niż grypa", "Tak samo jak grypa", "Nie jest śmiertelny"), arrayOf("Minutę", "30 sekund", "20 sekund", "Nie określone"), arrayOf("Kontakt z SANEPID-em", "Umówienie się na poradę z lekarzem POZ", " Pojechanie na SOR", "Zabunkrować się w domu"), arrayOf("Tak", "Nie", "Tak, ale w wyjątkowych przypadkach", "Nie wiem"))
    private val correctAnswers = arrayOf(
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
    )

    fun getQuestion(a: Int): String {
        return Questions[a]
    }

    fun getChoice1(a: Int): String {
        return Answers[a][0]
    }

    fun getChoice2(a: Int): String {
        return Answers[a][1]
    }

    fun getChoice3(a: Int): String {
        return Answers[a][2]
    }

    fun getChoice4(a: Int): String {
        return Answers[a][3]
    }

    fun getCorrectAnswer(a: Int): String {
        return correctAnswers[a]
    }
}