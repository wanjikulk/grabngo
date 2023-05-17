package com.example.e_commerce

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView

class Home : Fragment() {

    private lateinit var D1 : CardView
    private lateinit var D2 : CardView
    private lateinit var D3 : CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var root =  inflater.inflate(R.layout.fragment_home, container, false)

        D1 = root.findViewById(R.id.d1)
        D2 = root.findViewById(R.id.d2)
        D3 = root.findViewById(R.id.d3)



        D1.setOnClickListener {
            var intent = Intent(context, BurgerActivity::class.java)
            startActivity(intent)
        }
        D2.setOnClickListener {
            var intent = Intent(context, PizzaActivity::class.java)
            startActivity(intent)
        }
        D3.setOnClickListener {
            var intent = Intent(context, OtherActivity::class.java)
            startActivity(intent)
        }

        return root

    }

    companion object {

            }
    }
