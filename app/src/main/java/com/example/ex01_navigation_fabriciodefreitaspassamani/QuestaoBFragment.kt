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
import com.example.ex01_navigation_fabriciodefreitaspassamani.databinding.FragmentQuestaoABinding
import com.example.ex01_navigation_fabriciodefreitaspassamani.databinding.FragmentQuestaoBBinding

class QuestaoBFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentQuestaoBBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_questao_b, container, false)
        val args = QuestaoBFragmentArgs.fromBundle(requireArguments())
        var pontuacao = args.pontuacao

        binding.btnConfirmarB.setOnClickListener { view : View ->
            var opcaoSelecionada = binding.radioGroup2.checkedRadioButtonId
            if (opcaoSelecionada != -1) {
                if (opcaoSelecionada == R.id.radioButton8) {
                    pontuacao += 1
                    view.findNavController().navigate(QuestaoBFragmentDirections.actionQuestaoBFragmentToQuestaoCFragment(pontuacao))
                }
                else {
                    view.findNavController().navigate(QuestaoBFragmentDirections.actionQuestaoBFragmentToQuestaoCFragment(pontuacao))
                }
            }
            else {
                Toast.makeText(context, "Por Favor, selecione uma alternativa!", Toast.LENGTH_SHORT).show()
            }
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(context, "Não é possível retornar a tela anterior", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}