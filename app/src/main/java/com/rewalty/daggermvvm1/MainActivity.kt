package com.rewalty.daggermvvm1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rewalty.daggermvvm1.databinding.ActivityMainBinding
import com.rewalty.daggermvvm1.viewmodels.MainViewModel
import com.rewalty.daggermvvm1.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        (application as MyApp).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)


        mainViewModel.productsLiveData.observe(this) {
            binding.txtProducts.text = it.joinToString { x -> x.title + "\n\n" }
        }
    }
}