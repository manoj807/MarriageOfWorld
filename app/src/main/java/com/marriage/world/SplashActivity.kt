package com.marriage.world

import android.animation.ObjectAnimator
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Handle the splash screen transition.
        val splashScreen = installSplashScreen()

       setContentView(R.layout.activity_splash)
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            // Create your custom animation.
            val slideUp = ObjectAnimator.ofFloat(
                splashScreenView,
                View.TRANSLATION_Y,
                 0f,
                -splashScreenView.view.height.toFloat()
            )
            slideUp.interpolator  =  AnticipateInterpolator()
            slideUp.duration  =  200L

            // Call SplashScreenView.remove at the end of your custom animation.
            slideUp.doOnEnd { splashScreenView.remove() }

            // Run your animation.
            slideUp.start()
        }


    }
}