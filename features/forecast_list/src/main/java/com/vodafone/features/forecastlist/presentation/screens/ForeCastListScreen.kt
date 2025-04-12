package com.vodafone.features.forecastlist.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vodafone.core.components.AnimatedPreloader
import com.vodafone.core.components.LabelDegree
import com.vodafone.core.components.LabelFormHeader
import com.vodafone.core.components.LabelNormal
import com.vodafone.core.components.LabelStatus
import com.vodafone.core.components.Section
import com.vodafone.core.util.toDegree
import com.vodafone.features.forecastlist.domain.model.LocalFutureWeatherModel
import com.vodafone.weathericonslibrary.GetIcon

@Composable
fun ForeCastListScreen(foreCastListScreenViewModel:ForeCastListScreenViewModel = hiltViewModel()){
    LaunchedEffect(true) {
        foreCastListScreenViewModel.onAction(ForeCastListScreenIntent.GetData)
    }

    val rs =foreCastListScreenViewModel._state.value

    Section {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)) {

            LabelFormHeader(caption = stringResource(com.vodafone.core.R.string.next_days), modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 8.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Column (modifier = Modifier.fillMaxWidth()) {

                if(rs.isSuccess){
                    rs.data?.let {
                        it.forEach { d->
                            NewItem(d)
                        }
                    }
                }
            }
        }


    }

}

@Composable
fun NewItem(d: LocalFutureWeatherModel) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),verticalAlignment = Alignment.CenterVertically) {

            d.let {

                LabelNormal(it.day, modifier = Modifier.weight(1f))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    LabelNormal(it.degree.toDegree())
                    Spacer(modifier = Modifier.width(4.dp))
                    LabelNormal(it.status)
                    Spacer(modifier = Modifier.width(4.dp))
                    AnimatedPreloader(icon = GetIcon(it.status), modifier = Modifier.size(32.dp))
                }


            }

        }



}