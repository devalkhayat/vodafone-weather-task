package com.vodafone.core.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vodafone.core.theme.colors

@Composable
fun AppButton(title:String,action:()->Unit){
    val interactionSource= remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val color=if(isPressed) Color.Gray else MaterialTheme.colors.blue
    Button(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
           , onClick = {
            action()
        } , shape = RoundedCornerShape(16.dp) , colors = ButtonDefaults.buttonColors(containerColor = color)
           , interactionSource = interactionSource) {

        LabelFormButton(caption = title)
    }
}
@Preview(showSystemUi = true)
@Composable
fun Prev()= AppButton(title = "Proceed") {

}