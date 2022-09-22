package journey.started.meditation_composecamp

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class GridProperties(
    val title: String,
    @DrawableRes val icon: Int,
    val squareColor: Color
)


