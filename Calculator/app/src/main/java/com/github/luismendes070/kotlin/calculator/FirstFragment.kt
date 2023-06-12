package com.github.luismendes070.kotlin.calculator

import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.luismendes070.kotlin.calculator.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // https://medium.com/tech-takeaways/constraintlayout-from-xml-to-jetpack-compose-1aa355eabb45#id_token=eyJhbGciOiJSUzI1NiIsImtpZCI6Ijg1YmE5MzEzZmQ3YTdkNGFmYTg0ODg0YWJjYzg0MDMwMDQzNjMxODAiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJuYmYiOjE2ODY0MDI2NDAsImF1ZCI6IjIxNjI5NjAzNTgzNC1rMWs2cWUwNjBzMnRwMmEyamFtNGxqZGNtczAwc3R0Zy5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsInN1YiI6IjExODA3MzUxODM1NTIxMTMwOTUzMiIsImVtYWlsIjoibWFjaGFkb2x1aXNtZW5kZXNAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF6cCI6IjIxNjI5NjAzNTgzNC1rMWs2cWUwNjBzMnRwMmEyamFtNGxqZGNtczAwc3R0Zy5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsIm5hbWUiOiJMdWlzIE1lbmRlcyBNYWNoYWRvIiwicGljdHVyZSI6Imh0dHBzOi8vbGgzLmdvb2dsZXVzZXJjb250ZW50LmNvbS9hL0FBY0hUdGZXVXIwSUdSZFlOUDZ0ZUVlbEFyVHBVX21JLWNtbFZiUEdneXNJb3c9czk2LWMiLCJnaXZlbl9uYW1lIjoiTHVpcyIsImZhbWlseV9uYW1lIjoiTWVuZGVzIE1hY2hhZG8iLCJpYXQiOjE2ODY0MDI5NDAsImV4cCI6MTY4NjQwNjU0MCwianRpIjoiZTNiOTA4YWJhMDYwOTFjMDI2YTc0ODA2MzIxMDdkOWYwN2UwYWQ3MSJ9.AKCVaIa9G0SKwV5mqnxoGZIlRH0DGztLwxvwz__VVq3Awgxn_rpBOBwx3J7S43RlaYhos9TU66i6vuCNq3yX80pI6039P3cSq9dMlm-T04p38IwSbtNHk2JnfsbUxmIGI5lK1WiOoC3Xfnw-vaWbvCsAGDJiXfgnY4B3vUoAU2rs4-XZBwW3L7lw09n6LaKVIiqgaUdS3JPW5I5sp2TUlbjLR7MEdiL-iiavVqPurbcrgAWf9DDZSrm7dG5XIbvBlp6UhgO-kyNGRbOnmZNCBsQQZgFRRBFM5CiYzWNfwvNuVgHxORhSVI_bVSitD6zaL8O2qlcsV4tHDensxvfEzg
    @Composable
    fun CLSample() {
        ConstraintLayout(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {

        }
    }



} //end FirstFragment