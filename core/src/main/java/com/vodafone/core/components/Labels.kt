package com.vodafone.core.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vodafone.core.theme.labels

@Composable
fun LabelDegree(caption:String,modifier: Modifier = Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.degree)
}

@Composable
fun LabelStatus(caption:String,modifier: Modifier = Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.status)
}

@Composable
fun LabelCity(caption:String,modifier: Modifier = Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.city)
}

@Composable
fun LabelNormal(caption:String,modifier: Modifier = Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.normal)
}

@Composable
fun LabelHeader(caption:String,modifier: Modifier = Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.header)
}

@Composable
fun LabelFormHeader(caption:String,modifier: Modifier = Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.formHeader)
}


@Composable
fun LabelFormDropDown(caption:String,modifier: Modifier = Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.formDropDown)
}
@Composable
fun LabelFormDropDownList(caption:String,modifier: Modifier = Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.formDropDownList)
}

@Composable
fun LabelFormButton(caption:String,modifier: Modifier = Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.formButtonNormal)
}