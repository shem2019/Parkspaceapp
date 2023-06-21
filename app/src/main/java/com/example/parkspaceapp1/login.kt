package com.example.parkspaceapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.parkspaceapp1.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


            firebaseAuth= FirebaseAuth.getInstance()
            binding.btnlogin.setOnClickListener{
                val email =binding.edemaillogin.text.toString()
                val pass=binding.edpasswordlogin.text.toString()



                if (email.isNotEmpty() && pass.isNotEmpty() ){

                        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                            if(it.isSuccessful){
                                val intent = Intent(this,loggedinactivity::class.java)
                                startActivity(intent)

                            }else{
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                            }
                        }


                }else{

                    Toast.makeText(this, "Fill Empty Fields ", Toast.LENGTH_SHORT).show()

                }
        }




    }
}