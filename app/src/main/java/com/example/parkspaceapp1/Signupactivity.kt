package com.example.parkspaceapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.parkspaceapp1.databinding.ActivitySignupactivityBinding
import com.google.firebase.auth.FirebaseAuth

class Signupactivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignupactivityBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth= FirebaseAuth.getInstance()
        binding.btnsignup.setOnClickListener{
            val email =binding.edemail.text.toString()
            val phone=binding.edphone.text.toString()
            val username=binding.edusername.text.toString()
            val pass=binding.edpassword.text.toString()
            val passwordconfirm=binding.edpassword2.text.toString()
            
            
            if (email.isNotEmpty() && phone.isNotEmpty() && username.isNotEmpty() && pass.isNotEmpty() && passwordconfirm.isNotEmpty()){
                if(pass==passwordconfirm){

                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                       if(it.isSuccessful){
                         val intent =Intent(this,login::class.java)
                         startActivity(intent)
                       }else{
                           Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                       }
                   }

                }
                else {
                    Toast.makeText(this, "Password do not match", Toast.LENGTH_SHORT).show()
                }
            }
            else{

                Toast.makeText(this, "Fill Empty Fields ", Toast.LENGTH_SHORT).show()
                
            }



        }






    }
}