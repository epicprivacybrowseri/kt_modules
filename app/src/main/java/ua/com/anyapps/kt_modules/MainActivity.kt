package ua.com.anyapps.kt_modules

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import ua.com.anyapps.kt_modules.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var splitInstallManager: SplitInstallManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        splitInstallManager = SplitInstallManagerFactory.create(this);

        binding.btnStartModule.setOnClickListener(View.OnClickListener {
            if (splitInstallManager.getInstalledModules().contains("dynamicfeature")) {
                Intent().setClassName(
                    BuildConfig.APPLICATION_ID,
                    "ua.com.anyapps.dynamicfeature.DynamicFeatureMainActivity"
                ).also {
                    startActivity(it)
                }
            }
        })

        binding.btnFluidSlider.setOnClickListener(View.OnClickListener {
            if (splitInstallManager.getInstalledModules().contains("fluidslider")) {
                Intent().setClassName(
                        BuildConfig.APPLICATION_ID,
                        "ua.com.anyapps.modules.fluidslider.MainActivity"
                ).also {
                    startActivity(it)
                }
            }
        })
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        //
        SplitCompat.install(this)
    }
}