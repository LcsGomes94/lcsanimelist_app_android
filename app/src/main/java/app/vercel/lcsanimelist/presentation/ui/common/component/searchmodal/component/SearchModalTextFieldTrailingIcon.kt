package app.vercel.lcsanimelist.presentation.ui.common.component.searchmodal.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.lcsanimelist.R
import app.vercel.lcsanimelist.presentation.theme.LcsAnimeListTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchModalTextFieldTrailingIcon(
    textFieldValue: TextFieldValue,
    onTextFieldValueChange: (TextFieldValue) -> Unit,
    onSearchQueryChange: (String) -> Unit,
    onConfirmButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    val showClearButton = textFieldValue.text.isNotEmpty()

    Row(
        modifier = modifier.padding(end = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showClearButton) {
            IconButton(
                onClick = {
                    onTextFieldValueChange(TextFieldValue(""))
                    onSearchQueryChange("")
                },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "clear",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                )
            }
        }
        VerticalDivider(
            modifier = Modifier.padding(
                start = 13.dp,
                top = 8.dp,
                end = 4.dp,
                bottom = 8.dp
            ),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline
        )
        IconButton(
            onClick = onConfirmButtonClick,
            modifier = Modifier.size(50.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(
                    R.drawable.outlined_search
                ),
                contentDescription = "search",
                modifier = Modifier.size(22.dp),
                tint = MaterialTheme.colorScheme.onBackground,
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SearchModalTextFieldTrailingIconPreview() {
    LcsAnimeListTheme {
        SearchModalTextFieldTrailingIcon(
            textFieldValue = TextFieldValue("Hunter x Hunter"),
            onTextFieldValueChange = {},
            onSearchQueryChange = {},
            onConfirmButtonClick = {},
            modifier = Modifier
                .width(105.dp)
                .height(56.dp)
        )
    }
}