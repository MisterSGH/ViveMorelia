package insostenible.edu.vivemorelia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import insostenible.edu.vivemorelia.ui.theme.ViveMoreliaTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViveMoreliaTheme {
                val windowSize = calculateWindowSizeClass(this)

                MyCityApp(
                    windowSize = windowSize.widthSizeClass
                )
            }
        }
    }
}
