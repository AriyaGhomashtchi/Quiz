package com.example.quiz.data

import com.example.quiz.data.model.Question

class QuizRepository {

    fun loadQuestions(): List<Question> {
        val questionList = listOf(
            Question("Alan Shearer", false),
            Question("Ed Sheeran",true),
            Question("Craig Bellamy", false),
            Question("Craig David",true),
            Question("Alan Fornals",false),
            Question("Nigel De Jong",false),
            Question("Bruno Mars", true),
            Question("Romeo Santos", true),
            Question("Nicky Jam", true),
            Question("Douglas Luiz", false),
            Question("Bruno Guimares",false),
            Question("Bad Bunny",true),
            Question("Bukayo Saka", false),
            Question("Gabriel Martinelli",false),
            Question("Marc Antony",true),
            Question("Antony",false)
        )
        return questionList.shuffled()
    }
}