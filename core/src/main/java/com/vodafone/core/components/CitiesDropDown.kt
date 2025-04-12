package com.vodafone.core.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vodafone.core.R
import com.vodafone.core.theme.colors


@Composable
fun CitiesDropDown(modifier: Modifier=Modifier,action:(selected:City)->Unit){

    val list= listOf(City.Cairo,City.NewCairo,City.Giza,City.Alexandria)
    val isExpandend = remember {
        mutableStateOf(false)
    }
    val currentValue = remember {
        mutableStateOf(list[0])
    }

    Row(modifier = modifier.border(width = 1.dp,color= Color.White, shape = MaterialTheme.shapes.medium).fillMaxWidth().padding(8.dp).clickable { isExpandend.value = !isExpandend.value } , verticalAlignment = Alignment.CenterVertically) {

        LabelFormDropDown(caption = currentValue.value.name, modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(8.dp))
        Icon(painter = painterResource(id = R.drawable.ic_current_location) , contentDescription = "drop" , tint = MaterialTheme.colors.white )
        Spacer(modifier = Modifier.width(8.dp))

        DropdownMenu(
            expanded = isExpandend.value,
            onDismissRequest = { isExpandend.value = false }) {

            list.forEach { DropdownMenuItem(
                text = { LabelFormDropDownList(caption = it.name)  } ,
                onClick = {
                    currentValue.value = it
                    isExpandend.value = false
                    action(it)
                }
            ) }


        }
    }
}

//reference https://www.latlong.net/category/cities-66-15.html
sealed class City(val name:String, val latitude:String,val longitude:String){
    data object Cairo:City(name="Cairo", latitude = "30.033333",longitude="31.233334")
    data object Giza:City(name="Giza", latitude = "30.013056",longitude="31.208853")
    data object Alexandria:City(name="Alexandria", latitude = "31.205753",longitude="29.924526")
    data object NewCairo:City(name="NewCairo", latitude = "30.005493",longitude="31.477898")
}