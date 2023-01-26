package com.example.quiz

import androidx.lifecycle.ViewModel
import com.example.quiz.data.QuizRepository
import com.example.quiz.data.model.Question

class QuizViewModel : ViewModel() {

   private val repository = QuizRepository()
   private val questions = repository.loadQuestions()

    private var _score = 0
    val score: Int
        get() = _score

    private var _currentQuestions = questions.random()
    val currentQuestion: Question
        get() = _currentQuestions

    fun checkAnswer(isMusician: Boolean){
        if (isMusician == currentQuestion.isMusician){
            _score ++
                getNextQuestion()
        }
    }

    private fun getNextQuestion() {
        val nextQuestion = questions.random()

        if (nextQuestion == currentQuestion) {
            getNextQuestion()
        } else {
            _currentQuestions = nextQuestion
        }

    }

    fun restartGame() {
        _score = 0
        getNextQuestion()
    }
}