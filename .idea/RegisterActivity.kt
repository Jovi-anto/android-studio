package com.example.formregister

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.formregister.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val fullName = binding.etFullName.text.toString().trim()
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()

            if (fullName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Semua field wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Password dan Confirm Password tidak cocok", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Data valid
            Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()

            // Simpan ke SharedPreferences (opsional)
            val sharedPref = getSharedPreferences("userData", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("fullName", fullName)
                putString("username", username)
                putString("password", password)
                apply()
            }
        }
    }
}
