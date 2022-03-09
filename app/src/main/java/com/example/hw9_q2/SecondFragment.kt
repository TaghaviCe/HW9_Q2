package com.example.hw9_q2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.hw9_q2.databinding.FragmentFirstBinding
import com.example.hw9_q2.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
        //inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var name = requireArguments().getString("name")
        var username = requireArguments().getString("username")
        var email= requireArguments().getString("email")
        var password = requireArguments().getString("password")
        var gender=requireArguments().getString("gender")
        binding.viewName.setText(name)
        binding.viewUserName.setText(username)
        binding.viewEmail.setText(email)
        binding.viewpassword.setText(password)
        binding.viewgender.setText(gender)
        val sharedPreferences: SharedPreferences =
            this.requireActivity().getSharedPreferences("myInformation", Context.MODE_PRIVATE)
        binding.save.setOnClickListener {
           var name1=binding.viewName.text.toString()
           var username1= binding.viewUserName.text.toString()
           var email1= binding.viewEmail.text.toString()
           var password1= binding.viewpassword.text.toString()
            var gender=binding.viewgender.text.toString()
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("name", name1)
            editor.putString("username", username1)
            editor.putString("email", email1)
            editor.putString("password", password1)
            editor.putString("gender", gender)
            editor.apply()
            editor.commit()
            Toast.makeText(activity, "your information was saved!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)

        }
    }
}

