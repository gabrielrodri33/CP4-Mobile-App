package com.example.cp4_mobile


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cp4_mobile.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private  lateinit var  binging : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binging.root)
        replaceFragment(Home())

        binging.bottomNavigationView.setOnItemSelectedListener  {
            when(it.itemId){

                R.id.home -> replaceFragment(Home())
                R.id.progress -> replaceFragment(Progress())
                R.id.profile -> replaceFragment(Profile())


                else ->{

                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_layout, fragment)
        fragmentTransition.commit()
    }
}