package ua.com.anyapps.modules.fluidslider

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.play.core.splitcompat.SplitCompat
import ua.com.anyapps.kt_modules.App
import ua.com.anyapps.modules.fluidslider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setupSlider()
    }

    private fun setupSlider() {
        binding.fluidSlider.positionListener = {
            Log.d(App.getTag(), "current position is: $it" )
            binding.tvText.text = (it*100).toString()
        }
        binding.fluidSlider.beginTrackingListener = {
            Toast.makeText(this,  "Started tracking", Toast.LENGTH_SHORT).show()
        }
        binding.fluidSlider.endTrackingListener = {
            Toast.makeText(this,  "Ended tracking", Toast.LENGTH_SHORT).show()
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.install(this)
    }
}