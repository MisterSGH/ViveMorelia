package insostenible.edu.vivemorelia.iu.utils
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

enum class MyCityNavigationType {
    BOTTOM_NAVIGATION,
    NAVIGATION_RAIL,
    PERMANENT_NAVIGATION_DRAWER
}

fun getColumnCount(windowSize: WindowWidthSizeClass): Int {
    return when (windowSize) {
        WindowWidthSizeClass.Compact -> 1
        WindowWidthSizeClass.Medium -> 2
        WindowWidthSizeClass.Expanded -> 3
        else -> 1
    }
}