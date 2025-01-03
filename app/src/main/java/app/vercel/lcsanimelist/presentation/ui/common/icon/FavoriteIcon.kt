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
fun FavoriteIcon(
    isFilled: Boolean,
    modifier: Modifier = Modifier,
    strokeColor: Color = MaterialTheme.colorScheme.onBackground,
    fillColor: Color = MaterialTheme.colorScheme.secondary
) {

    val favoriteIcon = remember(isFilled, strokeColor, fillColor) {
        ImageVector.Builder(
            name = "FavoriteIcon",
            defaultWidth = 26.dp,
            defaultHeight = 25.dp,
            viewportWidth = 26f,
            viewportHeight = 25f
        ).apply {
            if (isFilled) {
                path(
                    fill = SolidColor(fillColor),
                    stroke = SolidColor(fillColor),
                    strokeLineWidth = 1f
                ) {
                    moveTo(8.763f, 5.436f)
                    curveTo(10.677f, 5.01f, 12.703f, 6.833f, 13.476f, 7.799f)
                    curveTo(15.235f, 5.284f, 16.853f, 5.436f, 17.838f, 5.436f)
                    curveTo(18.823f, 5.436f, 20.862f, 6.198f, 21.355f, 8.408f)
                    curveTo(21.847f, 10.618f, 21.144f, 12.447f, 20.018f, 14.124f)
                    curveTo(19.118f, 15.465f, 15.282f, 18.595f, 13.476f, 19.992f)
                    curveTo(12.515f, 19.382f, 10.311f, 17.873f, 9.185f, 16.715f)
                    curveTo(7.778f, 15.267f, 5.738f, 12.676f, 5.527f, 10.314f)
                    curveTo(5.316f, 7.951f, 6.371f, 5.97f, 8.763f, 5.436f)
                    close()
                }
            }
            path(fill = SolidColor(strokeColor)) {
                moveTo(14.916f, 19.721f)
                curveTo(14.689f, 19.856f, 14.466f, 19.982f, 14.233f, 20.082f)
                curveTo(14.026f, 20.17f, 13.808f, 20.228f, 13.59f, 20.277f)
                curveTo(13.549f, 20.287f, 13.503f, 20.295f, 13.473f, 20.254f)
                curveTo(13.443f, 20.214f, 13.479f, 20.177f, 13.487f, 20.139f)
                curveTo(13.505f, 20.055f, 13.577f, 20.011f, 13.621f, 19.933f)
                curveTo(13.453f, 19.866f, 13.302f, 19.776f, 13.112f, 19.754f)
                curveTo(13.179f, 19.808f, 13.25f, 19.842f, 13.252f, 19.944f)
                curveTo(13.252f, 19.972f, 13.33f, 19.998f, 13.371f, 20.026f)
                curveTo(13.409f, 20.053f, 13.459f, 20.078f, 13.449f, 20.136f)
                curveTo(13.439f, 20.204f, 13.38f, 20.185f, 13.337f, 20.19f)
                curveTo(13.003f, 20.22f, 12.71f, 20.087f, 12.413f, 19.941f)
                curveTo(12.179f, 19.825f, 11.957f, 19.685f, 11.731f, 19.557f)
                curveTo(11.568f, 19.466f, 11.401f, 19.377f, 11.247f, 19.263f)
                curveTo(11.105f, 19.157f, 10.97f, 19.037f, 10.799f, 18.977f)
                curveTo(10.715f, 18.947f, 10.657f, 18.869f, 10.599f, 18.787f)
                curveTo(10.484f, 18.62f, 10.334f, 18.488f, 10.137f, 18.442f)
                curveTo(10.081f, 18.428f, 10.054f, 18.374f, 10.014f, 18.337f)
                curveTo(9.642f, 17.988f, 9.363f, 17.547f, 9.019f, 17.171f)
                curveTo(8.947f, 17.093f, 8.878f, 17.017f, 8.781f, 16.967f)
                curveTo(8.705f, 16.928f, 8.635f, 16.862f, 8.612f, 16.761f)
                curveTo(8.599f, 16.707f, 8.562f, 16.669f, 8.526f, 16.633f)
                curveTo(8.381f, 16.485f, 8.228f, 16.346f, 8.08f, 16.203f)
                curveTo(7.897f, 16.027f, 7.722f, 15.836f, 7.546f, 15.649f)
                curveTo(7.46f, 15.557f, 7.362f, 15.478f, 7.277f, 15.384f)
                curveTo(7.128f, 15.217f, 6.975f, 15.054f, 6.849f, 14.863f)
                curveTo(6.777f, 14.754f, 6.687f, 14.656f, 6.597f, 14.562f)
                curveTo(6.259f, 14.204f, 6.044f, 13.752f, 5.78f, 13.336f)
                curveTo(5.468f, 12.844f, 5.306f, 12.288f, 5.104f, 11.745f)
                curveTo(4.936f, 11.293f, 4.814f, 10.83f, 4.729f, 10.354f)
                curveTo(4.717f, 10.29f, 4.716f, 10.225f, 4.732f, 10.159f)
                curveTo(4.751f, 10.083f, 4.752f, 10.003f, 4.703f, 9.935f)
                curveTo(4.681f, 9.904f, 4.676f, 9.868f, 4.676f, 9.831f)
                curveTo(4.667f, 9.269f, 4.708f, 8.711f, 4.883f, 8.18f)
                curveTo(5.006f, 7.805f, 5.166f, 7.447f, 5.403f, 7.131f)
                curveTo(5.559f, 6.922f, 5.702f, 6.698f, 5.873f, 6.502f)
                curveTo(6.635f, 5.628f, 7.518f, 4.969f, 8.625f, 4.714f)
                curveTo(9.153f, 4.592f, 9.678f, 4.613f, 10.204f, 4.737f)
                curveTo(10.898f, 4.901f, 11.557f, 5.168f, 12.188f, 5.515f)
                curveTo(12.554f, 5.715f, 12.891f, 5.974f, 13.14f, 6.323f)
                curveTo(13.263f, 6.496f, 13.378f, 6.691f, 13.479f, 6.888f)
                curveTo(13.529f, 6.986f, 13.573f, 6.97f, 13.636f, 6.914f)
                curveTo(13.772f, 6.794f, 13.866f, 6.632f, 13.992f, 6.502f)
                curveTo(14.07f, 6.42f, 14.139f, 6.328f, 14.22f, 6.246f)
                curveTo(14.333f, 6.132f, 14.464f, 6.039f, 14.553f, 5.895f)
                curveTo(14.599f, 5.82f, 14.683f, 5.784f, 14.77f, 5.751f)
                curveTo(14.942f, 5.688f, 15.094f, 5.576f, 15.206f, 5.415f)
                curveTo(15.235f, 5.373f, 15.27f, 5.348f, 15.312f, 5.326f)
                curveTo(15.7f, 5.125f, 16.108f, 4.999f, 16.533f, 4.917f)
                curveTo(16.735f, 4.878f, 16.947f, 4.868f, 17.135f, 4.753f)
                curveTo(17.209f, 4.708f, 17.304f, 4.707f, 17.388f, 4.757f)
                curveTo(17.434f, 4.783f, 17.485f, 4.779f, 17.533f, 4.775f)
                curveTo(17.752f, 4.755f, 17.972f, 4.777f, 18.188f, 4.79f)
                curveTo(18.433f, 4.805f, 18.675f, 4.905f, 18.916f, 4.975f)
                curveTo(19.055f, 5.015f, 19.194f, 5.061f, 19.328f, 5.114f)
                curveTo(19.539f, 5.198f, 19.742f, 5.31f, 19.918f, 5.47f)
                curveTo(19.979f, 5.525f, 20.05f, 5.567f, 20.118f, 5.611f)
                curveTo(20.469f, 5.835f, 20.772f, 6.117f, 21.015f, 6.472f)
                curveTo(21.278f, 6.855f, 21.574f, 7.217f, 21.722f, 7.679f)
                curveTo(21.92f, 8.295f, 22.14f, 8.905f, 22.191f, 9.564f)
                curveTo(22.199f, 9.675f, 22.205f, 9.785f, 22.168f, 9.893f)
                curveTo(22.157f, 9.922f, 22.153f, 9.959f, 22.159f, 9.99f)
                curveTo(22.237f, 10.416f, 22.118f, 10.821f, 22.037f, 11.227f)
                curveTo(21.941f, 11.708f, 21.769f, 12.156f, 21.523f, 12.574f)
                curveTo(21.413f, 12.762f, 21.312f, 12.96f, 21.2f, 13.147f)
                curveTo(20.723f, 13.943f, 20.207f, 14.705f, 19.625f, 15.418f)
                curveTo(19.156f, 15.994f, 18.616f, 16.487f, 18.107f, 17.015f)
                curveTo(17.796f, 17.337f, 17.532f, 17.705f, 17.216f, 18.02f)
                curveTo(17.057f, 18.179f, 16.911f, 18.368f, 16.721f, 18.471f)
                curveTo(16.556f, 18.56f, 16.4f, 18.656f, 16.26f, 18.782f)
                curveTo(15.934f, 19.076f, 15.58f, 19.32f, 15.213f, 19.546f)
                curveTo(15.118f, 19.605f, 15.02f, 19.66f, 14.916f, 19.721f)
                close()
                moveTo(16.263f, 6.486f)
                curveTo(16.124f, 6.578f, 15.949f, 6.582f, 15.822f, 6.702f)
                curveTo(15.813f, 6.711f, 15.793f, 6.709f, 15.778f, 6.708f)
                curveTo(15.661f, 6.701f, 15.564f, 6.755f, 15.472f, 6.823f)
                curveTo(14.913f, 7.236f, 14.415f, 7.719f, 14.004f, 8.304f)
                curveTo(13.889f, 8.469f, 13.757f, 8.615f, 13.585f, 8.716f)
                curveTo(13.493f, 8.77f, 13.409f, 8.772f, 13.316f, 8.722f)
                curveTo(13.078f, 8.596f, 12.932f, 8.376f, 12.809f, 8.138f)
                curveTo(12.679f, 7.887f, 12.506f, 7.689f, 12.274f, 7.551f)
                curveTo(12.208f, 7.512f, 12.168f, 7.448f, 12.121f, 7.389f)
                curveTo(11.915f, 7.135f, 11.718f, 6.869f, 11.44f, 6.701f)
                curveTo(11.285f, 6.607f, 11.133f, 6.506f, 10.984f, 6.404f)
                curveTo(10.695f, 6.207f, 10.375f, 6.087f, 10.05f, 6.037f)
                curveTo(9.557f, 5.961f, 9.05f, 5.89f, 8.578f, 6.171f)
                curveTo(8.474f, 6.233f, 8.349f, 6.194f, 8.241f, 6.261f)
                curveTo(7.912f, 6.465f, 7.577f, 6.662f, 7.296f, 6.942f)
                curveTo(7.12f, 7.116f, 6.91f, 7.267f, 6.841f, 7.541f)
                curveTo(6.828f, 7.59f, 6.795f, 7.638f, 6.753f, 7.667f)
                curveTo(6.661f, 7.73f, 6.617f, 7.829f, 6.574f, 7.93f)
                curveTo(6.419f, 8.29f, 6.332f, 8.668f, 6.258f, 9.057f)
                curveTo(6.158f, 9.579f, 6.142f, 10.091f, 6.259f, 10.605f)
                curveTo(6.323f, 10.889f, 6.354f, 11.189f, 6.533f, 11.43f)
                curveTo(6.598f, 11.518f, 6.564f, 11.637f, 6.613f, 11.734f)
                curveTo(6.863f, 12.23f, 7.131f, 12.712f, 7.507f, 13.111f)
                curveTo(7.602f, 13.21f, 7.689f, 13.307f, 7.737f, 13.451f)
                curveTo(7.826f, 13.718f, 8.043f, 13.901f, 8.158f, 14.158f)
                curveTo(8.255f, 14.373f, 8.448f, 14.519f, 8.581f, 14.716f)
                curveTo(8.673f, 14.851f, 8.783f, 14.98f, 8.885f, 15.112f)
                curveTo(9.386f, 15.755f, 9.964f, 16.313f, 10.53f, 16.886f)
                curveTo(10.546f, 16.903f, 10.564f, 16.924f, 10.584f, 16.93f)
                curveTo(10.828f, 16.998f, 10.893f, 17.295f, 11.105f, 17.404f)
                curveTo(11.115f, 17.41f, 11.12f, 17.432f, 11.125f, 17.448f)
                curveTo(11.165f, 17.573f, 11.245f, 17.667f, 11.34f, 17.744f)
                curveTo(11.866f, 18.169f, 12.376f, 18.619f, 12.937f, 18.993f)
                curveTo(13.03f, 19.055f, 13.146f, 19.102f, 13.16f, 19.251f)
                curveTo(13.161f, 19.27f, 13.198f, 19.288f, 13.221f, 19.3f)
                curveTo(13.276f, 19.33f, 13.332f, 19.354f, 13.387f, 19.383f)
                curveTo(13.436f, 19.41f, 13.468f, 19.404f, 13.515f, 19.359f)
                curveTo(13.676f, 19.203f, 13.844f, 19.055f, 14.027f, 18.929f)
                curveTo(14.212f, 18.802f, 14.426f, 18.72f, 14.588f, 18.556f)
                curveTo(14.847f, 18.294f, 15.119f, 18.052f, 15.408f, 17.831f)
                curveTo(15.466f, 17.787f, 15.503f, 17.73f, 15.54f, 17.666f)
                curveTo(15.623f, 17.521f, 15.679f, 17.346f, 15.831f, 17.266f)
                curveTo(16.054f, 17.15f, 16.228f, 16.958f, 16.431f, 16.81f)
                curveTo(16.738f, 16.586f, 17.009f, 16.298f, 17.299f, 16.042f)
                curveTo(17.804f, 15.597f, 18.234f, 15.068f, 18.684f, 14.562f)
                curveTo(18.736f, 14.504f, 18.785f, 14.444f, 18.809f, 14.36f)
                curveTo(18.832f, 14.277f, 18.884f, 14.203f, 18.956f, 14.163f)
                curveTo(19.031f, 14.12f, 19.079f, 14.054f, 19.126f, 13.984f)
                curveTo(19.333f, 13.674f, 19.55f, 13.371f, 19.74f, 13.05f)
                curveTo(19.881f, 12.812f, 20.076f, 12.602f, 20.113f, 12.3f)
                curveTo(20.119f, 12.247f, 20.152f, 12.189f, 20.188f, 12.151f)
                curveTo(20.247f, 12.092f, 20.274f, 12.019f, 20.302f, 11.942f)
                curveTo(20.507f, 11.386f, 20.598f, 10.798f, 20.715f, 10.217f)
                curveTo(20.746f, 10.062f, 20.782f, 9.906f, 20.774f, 9.743f)
                curveTo(20.761f, 9.481f, 20.74f, 9.22f, 20.691f, 8.962f)
                curveTo(20.67f, 8.848f, 20.655f, 8.738f, 20.576f, 8.649f)
                curveTo(20.53f, 8.599f, 20.502f, 8.534f, 20.507f, 8.459f)
                curveTo(20.511f, 8.398f, 20.491f, 8.345f, 20.465f, 8.295f)
                curveTo(20.234f, 7.858f, 19.961f, 7.462f, 19.548f, 7.206f)
                curveTo(19.518f, 7.188f, 19.483f, 7.166f, 19.47f, 7.137f)
                curveTo(19.344f, 6.845f, 19.077f, 6.713f, 18.861f, 6.531f)
                curveTo(18.708f, 6.401f, 18.502f, 6.346f, 18.322f, 6.254f)
                curveTo(18.097f, 6.138f, 17.86f, 6.088f, 17.619f, 6.074f)
                curveTo(17.185f, 6.047f, 16.785f, 6.213f, 16.386f, 6.37f)
                curveTo(16.337f, 6.39f, 16.316f, 6.444f, 16.263f, 6.486f)
                close()
            }
            path(fill = SolidColor(strokeColor)) {
                moveTo(17.626f, 12.281f)
                curveTo(17.644f, 12.248f, 17.653f, 12.218f, 17.635f, 12.192f)
                curveTo(17.55f, 12.067f, 17.639f, 12.029f, 17.719f, 11.973f)
                curveTo(17.885f, 11.857f, 18.064f, 11.739f, 18.104f, 11.513f)
                curveTo(18.143f, 11.297f, 18.232f, 11.1f, 18.266f, 10.88f)
                curveTo(18.287f, 10.741f, 18.278f, 10.593f, 18.332f, 10.448f)
                curveTo(18.398f, 10.268f, 18.365f, 10.057f, 18.243f, 9.889f)
                curveTo(18.206f, 9.837f, 18.213f, 9.805f, 18.248f, 9.762f)
                curveTo(18.325f, 9.669f, 18.344f, 9.548f, 18.362f, 9.433f)
                curveTo(18.381f, 9.311f, 18.359f, 9.195f, 18.246f, 9.125f)
                curveTo(18.219f, 9.109f, 18.206f, 9.074f, 18.217f, 9.051f)
                curveTo(18.279f, 8.923f, 18.194f, 8.825f, 18.162f, 8.718f)
                curveTo(18.077f, 8.44f, 18.17f, 8.281f, 18.395f, 8.166f)
                curveTo(18.462f, 8.132f, 18.497f, 8.082f, 18.52f, 8.021f)
                curveTo(18.572f, 7.888f, 18.738f, 7.817f, 18.855f, 7.893f)
                curveTo(19f, 7.987f, 19.127f, 8.113f, 19.277f, 8.2f)
                curveTo(19.303f, 8.216f, 19.312f, 8.243f, 19.304f, 8.274f)
                curveTo(19.296f, 8.307f, 19.306f, 8.335f, 19.333f, 8.346f)
                curveTo(19.46f, 8.396f, 19.462f, 8.513f, 19.465f, 8.629f)
                curveTo(19.468f, 8.713f, 19.446f, 8.804f, 19.529f, 8.864f)
                curveTo(19.537f, 8.869f, 19.545f, 8.886f, 19.543f, 8.896f)
                curveTo(19.513f, 9.082f, 19.634f, 9.213f, 19.689f, 9.367f)
                curveTo(19.734f, 9.491f, 19.755f, 9.625f, 19.761f, 9.748f)
                curveTo(19.771f, 9.914f, 19.799f, 10.091f, 19.737f, 10.257f)
                curveTo(19.717f, 10.311f, 19.738f, 10.362f, 19.748f, 10.414f)
                curveTo(19.801f, 10.698f, 19.796f, 10.974f, 19.655f, 11.233f)
                curveTo(19.647f, 11.247f, 19.642f, 11.265f, 19.632f, 11.275f)
                curveTo(19.41f, 11.481f, 19.339f, 11.776f, 19.24f, 12.054f)
                curveTo(19.218f, 12.115f, 19.194f, 12.176f, 19.153f, 12.226f)
                curveTo(19.048f, 12.359f, 18.972f, 12.504f, 18.94f, 12.681f)
                curveTo(18.923f, 12.778f, 18.88f, 12.88f, 18.759f, 12.888f)
                curveTo(18.743f, 12.889f, 18.722f, 12.907f, 18.715f, 12.923f)
                curveTo(18.636f, 13.082f, 18.491f, 13.166f, 18.376f, 13.283f)
                curveTo(18.34f, 13.32f, 18.299f, 13.35f, 18.252f, 13.37f)
                curveTo(18.077f, 13.442f, 18.028f, 13.421f, 17.952f, 13.234f)
                curveTo(17.933f, 13.187f, 17.908f, 13.151f, 17.865f, 13.125f)
                curveTo(17.729f, 13.043f, 17.624f, 12.928f, 17.568f, 12.766f)
                curveTo(17.538f, 12.677f, 17.505f, 12.593f, 17.572f, 12.501f)
                curveTo(17.614f, 12.443f, 17.581f, 12.354f, 17.626f, 12.281f)
                close()
            }
            path(fill = SolidColor(strokeColor)) {
                moveTo(16.811f, 13.9f)
                curveTo(16.899f, 14.031f, 16.997f, 14.14f, 17.02f, 14.305f)
                curveTo(17.05f, 14.527f, 16.961f, 14.693f, 16.851f, 14.862f)
                curveTo(16.707f, 15.083f, 16.501f, 15.076f, 16.285f, 15.088f)
                curveTo(16.012f, 15.103f, 15.837f, 14.926f, 15.656f, 14.756f)
                curveTo(15.571f, 14.677f, 15.639f, 14.563f, 15.644f, 14.467f)
                curveTo(15.648f, 14.396f, 15.687f, 14.328f, 15.708f, 14.258f)
                curveTo(15.717f, 14.227f, 15.731f, 14.191f, 15.725f, 14.163f)
                curveTo(15.676f, 13.931f, 15.844f, 13.873f, 15.976f, 13.782f)
                curveTo(16.064f, 13.721f, 16.163f, 13.679f, 16.228f, 13.581f)
                curveTo(16.282f, 13.5f, 16.393f, 13.5f, 16.493f, 13.564f)
                curveTo(16.62f, 13.648f, 16.731f, 13.75f, 16.811f, 13.9f)
                close()
            }
        }.build()
    }

    Icon(
        modifier = modifier,
        imageVector = favoriteIcon,
        contentDescription = null,
        tint = Color.Unspecified,
    )

}
