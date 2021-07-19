package com.example.first_task

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.first_task.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class activity_user : AppCompatActivity() {
    var imageButton5: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        imageButton5 = findViewById<View>(R.id.imageButton5) as ImageButton
        imageButton5!!.setOnClickListener {
            val `in` = Intent(this@activity_user, user_account::class.java)
            //in.putExtra("data",button.getText().toString());
            startActivity(`in`)
        }



        val homefragment = HomeFragment()
        val renewfragment = RenewFragment()
        val plusfragment = PlusFragment()
        val bookfragment = BookFragment()
        val userfragment = UserFragment()

       //makeCurrentFragment(homefragment)


        findViewById<BottomNavigationView>(R.id.bottom_nav).setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homefragment)
                R.id.ic_renew->makeCurrentFragment(renewfragment)
                R.id.ic_plus->makeCurrentFragment(plusfragment)
                R.id.ic_book->makeCurrentFragment(bookfragment)
                R.id.ic_user->makeCurrentFragment(userfragment)
            }
            true
        }


    }
    private fun makeCurrentFragment(fragment:Fragment)=
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper,fragment)
                commit()
            }
}