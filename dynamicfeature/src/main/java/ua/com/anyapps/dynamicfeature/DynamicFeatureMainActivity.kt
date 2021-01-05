package ua.com.anyapps.dynamicfeature

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.play.core.splitcompat.SplitCompat

class DynamicFeatureMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_feature_main)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)

        SplitCompat.install(this)
    }
}