package app.vercel.lcsanimelist.presentation.ui.common.icon

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun EditIcon(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
) {

    val editIcon = remember(color) {
        ImageVector.Builder(
            name = "EditIcon",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 19f,
            viewportHeight = 19f
        ).apply {
            path(fill = SolidColor(color)) {
                moveTo(4.061f, 18.243f)
                curveTo(3.443f, 18.21f, 2.838f, 18.233f, 2.243f, 18.135f)
                curveTo(1.543f, 18.02f, 1.071f, 17.449f, 1.028f, 16.74f)
                curveTo(1.005f, 16.359f, 1.004f, 15.977f, 0.999f, 15.596f)
                curveTo(0.984f, 14.45f, 0.989f, 13.304f, 0.955f, 12.16f)
                curveTo(0.923f, 11.108f, 0.949f, 10.057f, 0.92f, 9.006f)
                curveTo(0.882f, 7.649f, 0.897f, 6.292f, 0.892f, 4.935f)
                curveTo(0.888f, 4.047f, 1.543f, 3.348f, 2.428f, 3.353f)
                curveTo(3.626f, 3.36f, 4.824f, 3.411f, 6.021f, 3.445f)
                curveTo(6.389f, 3.455f, 6.757f, 3.439f, 7.124f, 3.484f)
                curveTo(7.559f, 3.537f, 7.995f, 3.58f, 8.401f, 3.762f)
                curveTo(8.444f, 3.781f, 8.486f, 3.802f, 8.526f, 3.827f)
                curveTo(8.619f, 3.884f, 8.697f, 3.96f, 8.698f, 4.076f)
                curveTo(8.699f, 4.2f, 8.599f, 4.255f, 8.502f, 4.3f)
                curveTo(8.19f, 4.445f, 7.853f, 4.495f, 7.517f, 4.527f)
                curveTo(6.691f, 4.608f, 5.861f, 4.615f, 5.032f, 4.643f)
                curveTo(4.202f, 4.672f, 3.372f, 4.665f, 2.542f, 4.699f)
                curveTo(2.339f, 4.707f, 2.268f, 4.764f, 2.255f, 4.972f)
                curveTo(2.247f, 5.106f, 2.269f, 5.241f, 2.268f, 5.376f)
                curveTo(2.258f, 7.338f, 2.251f, 9.3f, 2.234f, 11.262f)
                curveTo(2.225f, 12.302f, 2.182f, 13.341f, 2.183f, 14.38f)
                curveTo(2.184f, 15.108f, 2.214f, 15.837f, 2.215f, 16.565f)
                curveTo(2.215f, 16.775f, 2.319f, 16.877f, 2.53f, 16.879f)
                curveTo(2.875f, 16.884f, 3.22f, 16.879f, 3.565f, 16.882f)
                curveTo(5.062f, 16.896f, 6.559f, 16.908f, 8.055f, 16.928f)
                curveTo(9.201f, 16.943f, 10.347f, 16.968f, 11.492f, 16.992f)
                curveTo(12.345f, 17.011f, 13.198f, 17.039f, 14.051f, 17.057f)
                curveTo(14.406f, 17.064f, 14.561f, 16.927f, 14.586f, 16.576f)
                curveTo(14.625f, 16.044f, 14.646f, 15.51f, 14.682f, 14.978f)
                curveTo(14.737f, 14.16f, 14.819f, 13.344f, 14.943f, 12.533f)
                curveTo(15.015f, 12.058f, 15.092f, 11.584f, 15.21f, 11.119f)
                curveTo(15.24f, 11f, 15.285f, 10.884f, 15.33f, 10.77f)
                curveTo(15.358f, 10.698f, 15.404f, 10.63f, 15.494f, 10.632f)
                curveTo(15.575f, 10.634f, 15.617f, 10.697f, 15.646f, 10.762f)
                curveTo(15.749f, 10.988f, 15.825f, 11.225f, 15.825f, 11.473f)
                curveTo(15.828f, 13.2f, 15.832f, 14.928f, 15.822f, 16.655f)
                curveTo(15.817f, 17.59f, 15.06f, 18.345f, 14.127f, 18.347f)
                curveTo(12.104f, 18.351f, 10.08f, 18.35f, 8.057f, 18.338f)
                curveTo(7.023f, 18.332f, 5.988f, 18.298f, 4.954f, 18.274f)
                curveTo(4.662f, 18.267f, 4.37f, 18.254f, 4.061f, 18.243f)
                close()
            }
            path(fill = SolidColor(color)) {
                moveTo(11.58f, 3.083f)
                curveTo(12.347f, 2.334f, 13.118f, 1.604f, 13.861f, 0.847f)
                curveTo(14.289f, 0.412f, 14.764f, 0.242f, 15.352f, 0.416f)
                curveTo(16.5f, 0.756f, 17.405f, 1.392f, 17.885f, 2.533f)
                curveTo(17.978f, 2.753f, 18.047f, 2.989f, 17.974f, 3.236f)
                curveTo(17.911f, 3.452f, 17.784f, 3.505f, 17.592f, 3.385f)
                curveTo(17.392f, 3.259f, 17.237f, 3.08f, 17.074f, 2.912f)
                curveTo(16.715f, 2.539f, 16.333f, 2.193f, 15.874f, 1.947f)
                curveTo(15.643f, 1.823f, 15.41f, 1.703f, 15.145f, 1.656f)
                curveTo(14.994f, 1.629f, 14.894f, 1.661f, 14.789f, 1.771f)
                curveTo(13.463f, 3.155f, 12.127f, 4.53f, 10.762f, 5.875f)
                curveTo(9.471f, 7.145f, 8.182f, 8.417f, 6.877f, 9.672f)
                curveTo(6.604f, 9.934f, 6.453f, 10.216f, 6.388f, 10.585f)
                curveTo(6.247f, 11.386f, 6.073f, 12.181f, 5.912f, 12.979f)
                curveTo(5.898f, 13.046f, 5.881f, 13.114f, 5.9f, 13.204f)
                curveTo(6.269f, 13.133f, 6.634f, 13.064f, 6.999f, 12.992f)
                curveTo(7.622f, 12.869f, 8.244f, 12.74f, 8.868f, 12.622f)
                curveTo(8.973f, 12.602f, 9.052f, 12.56f, 9.126f, 12.488f)
                curveTo(10.769f, 10.909f, 12.41f, 9.325f, 14.059f, 7.752f)
                curveTo(15.256f, 6.611f, 16.5f, 5.524f, 17.853f, 4.57f)
                curveTo(18.078f, 4.411f, 18.204f, 4.204f, 18.195f, 3.916f)
                curveTo(18.19f, 3.741f, 18.215f, 3.565f, 18.23f, 3.39f)
                curveTo(18.237f, 3.321f, 18.246f, 3.243f, 18.324f, 3.214f)
                curveTo(18.411f, 3.182f, 18.47f, 3.238f, 18.517f, 3.3f)
                curveTo(18.99f, 3.914f, 19.073f, 4.482f, 18.427f, 5.154f)
                curveTo(17.563f, 6.054f, 16.656f, 6.914f, 15.775f, 7.798f)
                curveTo(14.542f, 9.035f, 13.318f, 10.281f, 12.086f, 11.52f)
                curveTo(11.495f, 12.114f, 10.881f, 12.686f, 10.308f, 13.297f)
                curveTo(9.907f, 13.725f, 9.439f, 13.957f, 8.867f, 14.05f)
                curveTo(7.774f, 14.229f, 6.686f, 14.442f, 5.595f, 14.638f)
                curveTo(4.876f, 14.767f, 4.31f, 14.151f, 4.489f, 13.423f)
                curveTo(4.623f, 12.877f, 4.796f, 12.34f, 4.922f, 11.792f)
                curveTo(5.068f, 11.16f, 5.187f, 10.52f, 5.306f, 9.882f)
                curveTo(5.363f, 9.573f, 5.511f, 9.325f, 5.724f, 9.106f)
                curveTo(6.855f, 7.941f, 7.984f, 6.774f, 9.115f, 5.609f)
                curveTo(9.932f, 4.769f, 10.752f, 3.931f, 11.58f, 3.083f)
                close()
            }
        }.build()
    }

    Icon(
        modifier = modifier,
        imageVector = editIcon,
        contentDescription = null,
        tint = Color.Unspecified,
    )

}