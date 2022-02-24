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
import com.example.ex01_navigation_fabriciodefreitaspassamani.databinding.FragmentStartBinding


class QuestaoAFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentQuestaoABinding = DataBindingUtil.inflate(inflater, R.layout.fragment_questao_a, container, false)
        var pontuacao = 0

        binding.btnConfirmar.setOnClickListener { view : View ->
            var opcaoSelecionada = binding.radioGroup.checkedRadioButtonId
            if (opcaoSelecionada != -1) {
                if (opcaoSelecionada == R.id.radioButton3) {
                    pontuacao = 1
                    view.findNavController().navigate(QuestaoAFragmentDirections.actionQuestaoAFragmentToQuestaoBFragment(pontuacao))
                }
                else {
                    view.findNavController().navigate(QuestaoAFragmentDirections.actionQuestaoAFragmentToQuestaoBFragment(pontuacao))
                }
            }
            else {
                Toast.makeText(context,"Por Favor, selecione uma alternativa!", Toast.LENGTH_SHORT).show()
            }
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(context, "Não é possivel retornar a tela anterior", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}