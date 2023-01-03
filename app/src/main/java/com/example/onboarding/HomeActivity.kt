package com.example.onboarding

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.onboarding.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent


class HomeActivity : AppCompatActivity(){
    var binding: ActivityMainBinding? = null
    private lateinit var controller: NavController
    var bottomNavigationView: BottomNavigationView? = null
    var view: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //  bottomNavigationView.setSelectedItemId(R.id.home);
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView?.setVisibility(View.VISIBLE)
        setNavigationVisibilityForKeyboard()
        setUpNavBar()

    }



    private fun setNavigationVisibilityForKeyboard() {
        KeyboardVisibilityEvent.setEventListener(
                this
        ) { isOpen ->
            Log.d(ContentValues.TAG, "onVisibilityChanged: Keyboard visibility changed")
            if (isOpen) {
                Log.d(ContentValues.TAG, "onVisibilityChanged: Keyboard is open")
//                Toast.makeText(this,"open",Toast.LENGTH_SHORT).show()
                bottomNavigationView?.setVisibility(View.GONE)
                Log.d(ContentValues.TAG, "onVisibilityChanged: NavBar got Invisible")
            } else {
                Log.d(ContentValues.TAG, "onVisibilityChanged: Keyboard is closed")
//                Toast.makeText(this,"closed",Toast.LENGTH_SHORT).show()
//                if(controller.currentDestination?.id!=R.id.loginRegisterFragment){//TODO DELETE
//                bottomNavigationView?.setVisibility(View.VISIBLE)
//                }
                Log.d(ContentValues.TAG, "onVisibilityChanged: NavBar got Visible")
            }
        }
    }

    private val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
        if(destination.id==R.id.successfulFlightBookingFragment  ){
            bottomNavigationView?.visibility = View.GONE

        }
        else{
            bottomNavigationView?.visibility = View.VISIBLE
        }


    }

    override fun onResume() {
        super.onResume()
        controller.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        controller.removeOnDestinationChangedListener(listener)
        super.onPause()
    }


    private fun setUpNavBar() {
        //val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView) //TODO DELETE
        controller = this.findNavController(R.id.nav_host_fragment)
        bottomNavigationView?.setupWithNavController(controller)
    }
}

