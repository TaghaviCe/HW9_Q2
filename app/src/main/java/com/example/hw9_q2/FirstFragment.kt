package com.example.hw9_q2

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw9_q2.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
        //inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var gender: String = ""

        binding.buttonSave.setOnClickListener {
            if (binding.radioWomen.isChecked == true) {
                gender = "women"
            } else if (binding.buttonMen.isChecked == true) {
                gender = "men"
            }
                var bundle = bundleOf(
                    "name" to binding.editTextPersonName.text.toString(),
                    "username" to binding.userName.text.toString(),
                    "email" to binding.Email.text.toString(),
                    "password" to binding.password.text.toString(),
                    "gender" to gender
                )

                findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)

            
            val sharedPreferences =requireActivity().getSharedPreferences("myInformation", MODE_PRIVATE)
            val usernameValue = sharedPreferences.getString("username", "")
            val codeMelliValue=sharedPreferences.getString("codeMelli", "")
            val city=sharedPreferences.getString("city", "")
            val codePosti=sharedPreferences.getString("codePosti", "")
            val address=sharedPreferences.getString("address", "")
            val gender=sharedPreferences.getString("gender","")
            binding.editTextPersonName.setText("نام و نام خانوادگی:  "+usernameValue)
            binding.userName.setText("کد ملی:  "+codeMelliValue)
            binding.Email.setText("  شهر:  "+city)
            binding.password.setText("آدرس:  "+address)


    }
}
    }

