package com.lucas.gasto_viagem

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lucas.gasto_viagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if (view != null) {
            if(view.id == R.id.button_calculate){
                calculate();
            }
        }
    }

    private fun isValid() : Boolean{
       return(binding.editDistance.text.toString() != "" &&
               binding.editPreco.text.toString() != "" &&
               binding.editAutonomy.text.toString() != "" &&
               binding.editAutonomy.text.toString().toDouble() != 0.0)
    }

    @SuppressLint("SetTextI18n")
    private fun calculate(){

        if(isValid()) {

            val distance = binding.editDistance.text.toString().toDouble();
            val price = binding.editPreco.text.toString().toDouble();
            val autonomy = binding.editAutonomy.text.toString().toDouble();

            val totalValue = (distance * price) / autonomy;
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        }else{
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }
    }
}




