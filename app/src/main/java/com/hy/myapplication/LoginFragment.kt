package com.hy.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.hy.myapplication.databinding.FragmentLoginBinding


class LoginFragment :Fragment() {

    private var _binding : FragmentLoginBinding?= null

    private val binding get() = _binding!!

    private var syncRemote = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var str = getString(R.string.login_tips)
        var span  = SpannableStringBuilder(str)

        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                Log.d("zx","clickableSpan")
            }
        }
        span.setSpan(clickableSpan, str.length-14, str.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.loginTips.text = span
        binding.loginTips.movementMethod = LinkMovementMethod.getInstance()

        binding.loginButton.setOnClickListener {
            if (binding.username.text.isEmpty()){
                Snackbar.make(view, getString(R.string.username_can_not_null), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                return@setOnClickListener
            }

            if (binding.password.text.isEmpty()){
                Snackbar.make(view, getString(R.string.password_can_not_null), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                return@setOnClickListener
            }

            Log.d("zx","loginButton")
            var intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}