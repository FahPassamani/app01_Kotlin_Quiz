package com.example.ex01_navigation_fabriciodefreitaspassamani

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.ex01_navigation_fabriciodefreitaspassamani.databinding.FragmentAprovadoBinding

class AprovadoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentAprovadoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_aprovado, container, false)
        val args = AprovadoFragmentArgs.fromBundle(requireArguments())
        var pontuacao = args.pontuacao

        binding.txtViewAprov.text = "Parabéns! Você acertou ${pontuacao.toString()} das 3 perguntas."

        binding.btnConcluirApro.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_aprovadoFragment_to_startFragment)
        }

        return binding.root
    }

}