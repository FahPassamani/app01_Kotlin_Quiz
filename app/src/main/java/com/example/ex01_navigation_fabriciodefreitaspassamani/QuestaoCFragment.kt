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
import com.example.ex01_navigation_fabriciodefreitaspassamani.databinding.FragmentQuestaoCBinding

class QuestaoCFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentQuestaoCBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_questao_c, container, false)
        val args = QuestaoCFragmentArgs.fromBundle(requireArguments())
        var pontuacao = args.pontuacao

        binding.btnConfirmarC.setOnClickListener { view: View ->
            var opcaoSelecionada = binding.radioGroup3.checkedRadioButtonId
            if (opcaoSelecionada != -1) {
                if (opcaoSelecionada == R.id.radioButton9) {
                    pontuacao += 1
                    if (pontuacao >= 2) {
                        view.findNavController().navigate(QuestaoCFragmentDirections.actionQuestaoCFragmentToAprovadoFragment(pontuacao))
                    } else {
                        view.findNavController().navigate(QuestaoCFragmentDirections.actionQuestaoCFragmentToReprovadoFragment(pontuacao))
                    }
                } else {
                    if (pontuacao >= 2) {
                        view.findNavController().navigate(QuestaoCFragmentDirections.actionQuestaoCFragmentToAprovadoFragment(pontuacao))
                    } else {
                        view.findNavController().navigate(QuestaoCFragmentDirections.actionQuestaoCFragmentToReprovadoFragment(pontuacao))
                    }

                }
            } else {
                Toast.makeText(context, "Por Favor, selecione uma alternativa!", Toast.LENGTH_SHORT).show()
            }
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(context, "Não é possível retornar a tela anterior", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}