package com.example.quiz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.quiz.QuizViewModel
import com.example.quiz.databinding.FragmentQuizBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class QuizFragment : Fragment() {

    private lateinit var binding : FragmentQuizBinding

    private val viewModel: QuizViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        updateUi()

        binding.scoreText.text = viewModel.score.toString()
        binding.questionText.text = viewModel.currentQuestion.name

        binding.musicianButton.setOnClickListener {
            viewModel.checkAnswer(true)
            updateUi()
        }
        binding.footballButton.setOnClickListener {
            viewModel.checkAnswer(false)
            updateUi()
        }
    }
    private fun updateUi() {
        binding.scoreText.text = viewModel.score.toString()
        binding.questionText.text = viewModel.currentQuestion.name

        if (viewModel.score == 10) {
            showEndDialog()
        }
    }

    private fun showEndDialog() {
    MaterialAlertDialogBuilder(requireContext())
        .setTitle("Du bist ein Experte!")
        .setMessage("Du bist gut!")
        .setCancelable(false)
        .setNegativeButton("verlassen") { _,_ ->
            activity?.finish()
        }
        .setPositiveButton("nochmal") { _,_->
            viewModel.restartGame()
            updateUi()
        }
        .show()
    }
}