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
import com.example.ex01_navigation_fabriciodefreitaspassamani.databinding.FragmentReprovadoBinding

class ReprovadoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentReprovadoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_reprovado, container, false)
        val args = ReprovadoFragmentArgs.fromBundle(requireArguments())
        var pontuacao = args.pontuacao

        binding.textView5.text = "Tente novamente! Você acertou ${pontuacao.toString()} das 3 perguntas."

        binding.btnConcluirRep.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_reprovadoFragment_to_startFragment)
        }

        return binding.root
    }

}