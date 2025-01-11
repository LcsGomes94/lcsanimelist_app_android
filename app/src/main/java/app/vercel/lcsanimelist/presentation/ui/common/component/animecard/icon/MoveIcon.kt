package app.vercel.lcsanimelist.presentation.ui.common.component.animecard.icon

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
fun MoveIcon(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
) {

    val moveIcon = remember(color) {
        ImageVector.Builder(
            name = "MoveIcon",
            defaultWidth = 20.dp,
            defaultHeight = 18.dp,
            viewportWidth = 20f,
            viewportHeight = 18f
        ).apply {
            path(
                fill = SolidColor(color),
                stroke = SolidColor(color),
                strokeLineWidth = 0.430389f
            ) {
                moveTo(19.607f, 7.811f)
                curveTo(19.586f, 7.113f, 19.59f, 6.416f, 19.603f, 5.715f)
                curveTo(19.612f, 5.215f, 19.586f, 4.72f, 19.465f, 4.234f)
                curveTo(19.31f, 3.606f, 18.949f, 3.175f, 18.303f, 3.003f)
                curveTo(18.006f, 2.926f, 17.705f, 2.896f, 17.399f, 2.896f)
                curveTo(16.125f, 2.891f, 14.851f, 2.891f, 13.582f, 2.891f)
                curveTo(12.928f, 2.891f, 12.269f, 2.887f, 11.615f, 2.887f)
                curveTo(11.542f, 2.887f, 11.477f, 2.896f, 11.473f, 2.788f)
                curveTo(11.469f, 2.637f, 11.434f, 2.491f, 11.4f, 2.345f)
                curveTo(11.271f, 1.772f, 10.922f, 1.411f, 10.367f, 1.239f)
                curveTo(10.001f, 1.122f, 9.618f, 1.092f, 9.239f, 1.088f)
                curveTo(8.581f, 1.084f, 7.918f, 1.084f, 7.259f, 1.084f)
                curveTo(5.848f, 1.084f, 4.432f, 1.049f, 3.024f, 1.239f)
                curveTo(2.362f, 1.329f, 1.841f, 1.643f, 1.51f, 2.241f)
                curveTo(1.221f, 2.754f, 1.118f, 3.322f, 1.079f, 3.894f)
                curveTo(1.032f, 4.699f, 1.01f, 5.504f, 1.002f, 6.309f)
                curveTo(0.984f, 7.923f, 0.997f, 9.541f, 1.04f, 11.155f)
                curveTo(1.058f, 11.719f, 1.079f, 12.278f, 1.204f, 12.825f)
                curveTo(1.303f, 13.272f, 1.462f, 13.694f, 1.763f, 14.051f)
                curveTo(2.19f, 14.559f, 2.762f, 14.783f, 3.399f, 14.792f)
                curveTo(4.664f, 14.813f, 5.93f, 14.8f, 7.191f, 14.804f)
                curveTo(7.647f, 14.804f, 8.099f, 14.809f, 8.555f, 14.804f)
                curveTo(8.663f, 14.804f, 8.71f, 14.839f, 8.714f, 14.951f)
                curveTo(8.727f, 15.269f, 8.783f, 15.579f, 8.873f, 15.885f)
                curveTo(8.968f, 16.208f, 9.123f, 16.496f, 9.442f, 16.659f)
                curveTo(9.627f, 16.754f, 9.825f, 16.81f, 10.031f, 16.831f)
                curveTo(10.991f, 16.939f, 11.951f, 16.991f, 12.915f, 17.042f)
                curveTo(13.513f, 17.073f, 14.116f, 17.077f, 14.714f, 17.081f)
                curveTo(15.497f, 17.081f, 16.28f, 17.055f, 17.064f, 16.991f)
                curveTo(17.365f, 16.965f, 17.671f, 16.944f, 17.98f, 16.892f)
                curveTo(18.084f, 16.87f, 18.178f, 16.857f, 18.269f, 16.836f)
                curveTo(18.854f, 16.702f, 19.259f, 16.375f, 19.435f, 15.786f)
                curveTo(19.556f, 15.39f, 19.586f, 14.985f, 19.594f, 14.581f)
                curveTo(19.603f, 14.163f, 19.577f, 13.75f, 19.581f, 13.333f)
                curveTo(19.586f, 12.579f, 19.599f, 11.822f, 19.607f, 11.069f)
                curveTo(19.607f, 11.051f, 19.607f, 11.034f, 19.607f, 11.017f)
                curveTo(19.638f, 9.954f, 19.642f, 8.882f, 19.607f, 7.811f)
                close()
                moveTo(8.559f, 14.34f)
                curveTo(8.525f, 14.34f, 8.49f, 14.34f, 8.456f, 14.34f)
                curveTo(6.876f, 14.34f, 5.301f, 14.34f, 3.722f, 14.34f)
                curveTo(3.408f, 14.34f, 3.098f, 14.318f, 2.796f, 14.21f)
                curveTo(2.207f, 14.004f, 1.897f, 13.556f, 1.725f, 12.984f)
                curveTo(1.57f, 12.463f, 1.535f, 11.925f, 1.51f, 11.383f)
                curveTo(1.475f, 10.608f, 1.501f, 9.829f, 1.475f, 9.054f)
                curveTo(1.449f, 8.245f, 1.449f, 7.436f, 1.462f, 6.623f)
                curveTo(1.475f, 5.762f, 1.475f, 4.901f, 1.535f, 4.04f)
                curveTo(1.574f, 3.515f, 1.639f, 2.99f, 1.893f, 2.513f)
                curveTo(2.129f, 2.065f, 2.499f, 1.807f, 3.003f, 1.734f)
                curveTo(3.739f, 1.626f, 4.475f, 1.6f, 5.219f, 1.579f)
                curveTo(6.158f, 1.548f, 7.096f, 1.561f, 8.034f, 1.561f)
                curveTo(8.538f, 1.561f, 9.046f, 1.57f, 9.549f, 1.583f)
                curveTo(9.812f, 1.591f, 10.066f, 1.639f, 10.315f, 1.734f)
                curveTo(10.672f, 1.867f, 10.858f, 2.138f, 10.935f, 2.495f)
                curveTo(10.952f, 2.564f, 10.965f, 2.637f, 10.978f, 2.71f)
                curveTo(11.008f, 2.896f, 10.991f, 2.913f, 10.806f, 2.939f)
                curveTo(10.569f, 2.969f, 10.345f, 3.033f, 10.13f, 3.137f)
                curveTo(9.652f, 3.36f, 9.39f, 3.756f, 9.239f, 4.243f)
                curveTo(9.11f, 4.656f, 9.067f, 5.078f, 9.033f, 5.508f)
                curveTo(8.977f, 6.184f, 9.059f, 6.851f, 9.059f, 7.527f)
                curveTo(9.059f, 7.712f, 9.059f, 7.712f, 8.873f, 7.707f)
                curveTo(8.176f, 7.694f, 7.475f, 7.699f, 6.777f, 7.733f)
                curveTo(6.097f, 7.763f, 5.469f, 7.931f, 4.931f, 8.37f)
                curveTo(4.324f, 8.865f, 4.23f, 9.571f, 4.69f, 10.204f)
                curveTo(5.039f, 10.681f, 5.512f, 10.952f, 6.089f, 11.06f)
                curveTo(6.515f, 11.142f, 6.945f, 11.159f, 7.38f, 11.185f)
                curveTo(7.759f, 11.193f, 8.116f, 11.206f, 8.473f, 11.211f)
                curveTo(8.568f, 11.211f, 8.602f, 11.241f, 8.602f, 11.34f)
                curveTo(8.598f, 11.495f, 8.602f, 11.65f, 8.602f, 11.805f)
                curveTo(8.602f, 12.618f, 8.62f, 13.432f, 8.645f, 14.245f)
                curveTo(8.65f, 14.314f, 8.62f, 14.34f, 8.559f, 14.34f)
                close()
                moveTo(8.542f, 10.75f)
                curveTo(7.974f, 10.733f, 7.402f, 10.72f, 6.833f, 10.681f)
                curveTo(6.381f, 10.651f, 5.925f, 10.612f, 5.525f, 10.354f)
                curveTo(5.297f, 10.208f, 5.112f, 10.019f, 4.983f, 9.782f)
                curveTo(4.785f, 9.407f, 4.875f, 9.033f, 5.232f, 8.745f)
                curveTo(5.637f, 8.422f, 6.106f, 8.258f, 6.618f, 8.228f)
                curveTo(7.234f, 8.194f, 7.849f, 8.159f, 8.469f, 8.176f)
                curveTo(9.213f, 8.198f, 9.958f, 8.228f, 10.703f, 8.297f)
                curveTo(10.875f, 8.31f, 11.025f, 8.323f, 11.176f, 8.336f)
                curveTo(11.357f, 8.349f, 11.46f, 8.254f, 11.469f, 8.073f)
                curveTo(11.482f, 7.798f, 11.383f, 7.544f, 11.352f, 7.273f)
                curveTo(11.344f, 7.199f, 11.331f, 7.126f, 11.331f, 7.057f)
                curveTo(11.331f, 6.782f, 11.533f, 6.627f, 11.8f, 6.687f)
                curveTo(11.951f, 6.722f, 12.075f, 6.803f, 12.192f, 6.902f)
                curveTo(12.459f, 7.126f, 12.652f, 7.41f, 12.863f, 7.677f)
                curveTo(13.173f, 8.069f, 13.479f, 8.456f, 13.788f, 8.848f)
                curveTo(14.215f, 9.386f, 14.253f, 9.821f, 13.84f, 10.367f)
                curveTo(13.392f, 10.957f, 12.902f, 11.516f, 12.291f, 11.951f)
                curveTo(12.153f, 12.05f, 12.007f, 12.123f, 11.839f, 12.162f)
                curveTo(11.533f, 12.226f, 11.348f, 12.063f, 11.396f, 11.757f)
                curveTo(11.426f, 11.576f, 11.464f, 11.396f, 11.477f, 11.211f)
                curveTo(11.482f, 11.172f, 11.486f, 11.133f, 11.482f, 11.094f)
                curveTo(11.464f, 10.759f, 11.352f, 10.664f, 11.017f, 10.703f)
                curveTo(10.905f, 10.716f, 10.793f, 10.711f, 10.681f, 10.716f)
                curveTo(9.975f, 10.741f, 9.261f, 10.772f, 8.542f, 10.75f)
                close()
                moveTo(19.117f, 11.783f)
                curveTo(19.104f, 12.364f, 19.104f, 12.949f, 19.1f, 13.531f)
                curveTo(19.1f, 13.995f, 19.104f, 14.43f, 19.095f, 14.869f)
                curveTo(19.091f, 15.14f, 19.056f, 15.407f, 18.966f, 15.665f)
                curveTo(18.85f, 16.005f, 18.617f, 16.225f, 18.273f, 16.332f)
                curveTo(17.933f, 16.436f, 17.584f, 16.47f, 17.236f, 16.496f)
                curveTo(16.345f, 16.569f, 15.45f, 16.612f, 14.555f, 16.603f)
                curveTo(13.672f, 16.59f, 12.79f, 16.569f, 11.908f, 16.509f)
                curveTo(11.361f, 16.47f, 10.814f, 16.427f, 10.268f, 16.388f)
                curveTo(10.109f, 16.375f, 9.954f, 16.35f, 9.803f, 16.294f)
                curveTo(9.48f, 16.173f, 9.36f, 15.898f, 9.282f, 15.592f)
                curveTo(9.201f, 15.261f, 9.179f, 14.916f, 9.153f, 14.576f)
                curveTo(9.071f, 13.582f, 9.102f, 12.592f, 9.093f, 11.598f)
                curveTo(9.093f, 11.594f, 9.093f, 11.589f, 9.093f, 11.585f)
                curveTo(9.08f, 11.215f, 9.08f, 11.215f, 9.446f, 11.211f)
                curveTo(9.893f, 11.206f, 10.337f, 11.224f, 10.784f, 11.185f)
                curveTo(10.849f, 11.181f, 10.922f, 11.168f, 10.991f, 11.193f)
                curveTo(11.021f, 11.357f, 10.961f, 11.508f, 10.931f, 11.663f)
                curveTo(10.789f, 12.429f, 11.473f, 12.764f, 11.994f, 12.614f)
                curveTo(12.368f, 12.506f, 12.674f, 12.291f, 12.958f, 12.041f)
                curveTo(13.418f, 11.632f, 13.827f, 11.176f, 14.206f, 10.694f)
                curveTo(14.469f, 10.358f, 14.632f, 9.984f, 14.611f, 9.545f)
                curveTo(14.598f, 9.244f, 14.49f, 8.973f, 14.314f, 8.74f)
                curveTo(13.827f, 8.108f, 13.337f, 7.479f, 12.837f, 6.859f)
                curveTo(12.613f, 6.584f, 12.342f, 6.365f, 12.002f, 6.24f)
                curveTo(11.482f, 6.055f, 10.771f, 6.425f, 10.862f, 7.156f)
                curveTo(10.888f, 7.372f, 10.944f, 7.582f, 10.965f, 7.815f)
                curveTo(10.819f, 7.806f, 10.681f, 7.815f, 10.543f, 7.793f)
                curveTo(10.251f, 7.75f, 9.954f, 7.755f, 9.661f, 7.729f)
                curveTo(9.579f, 7.72f, 9.549f, 7.694f, 9.549f, 7.613f)
                curveTo(9.553f, 7.01f, 9.502f, 6.403f, 9.519f, 5.801f)
                curveTo(9.532f, 5.362f, 9.562f, 4.927f, 9.674f, 4.501f)
                curveTo(9.872f, 3.761f, 10.225f, 3.451f, 11.025f, 3.395f)
                curveTo(12.243f, 3.309f, 13.466f, 3.369f, 14.688f, 3.369f)
                curveTo(15.682f, 3.365f, 16.676f, 3.382f, 17.671f, 3.395f)
                curveTo(17.869f, 3.395f, 18.062f, 3.434f, 18.252f, 3.49f)
                curveTo(18.686f, 3.614f, 18.906f, 3.933f, 19.005f, 4.355f)
                curveTo(19.087f, 4.703f, 19.134f, 5.052f, 19.13f, 5.409f)
                curveTo(19.125f, 5.848f, 19.117f, 6.283f, 19.112f, 6.722f)
                curveTo(19.108f, 7.346f, 19.151f, 7.974f, 19.151f, 8.598f)
                curveTo(19.147f, 9.661f, 19.138f, 10.724f, 19.117f, 11.783f)
                close()
            }
        }.build()
    }

    Icon(
        imageVector = moveIcon,
        contentDescription = null,
        modifier = modifier,
        tint = Color.Unspecified,
    )

}