package com.heyday7.movieapp.ui.core.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomTopBar(
    color: Color = Color.Transparent,
    headContent: @Composable (() -> Unit)? = null,
    titleContent: @Composable () -> Unit,
    actionContent: @Composable (() -> Unit)? = null
) {
   Surface(color = color) {
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 12.dp)
               .requiredHeight(56.dp),
           verticalAlignment = Alignment.CenterVertically
       ) {
           if (headContent != null) {
               headContent()
               Spacer(modifier = Modifier.requiredWidth(12.dp))
           }
           Box(
               modifier = Modifier.weight(1f),
               contentAlignment = Alignment.CenterStart
           ) {
               titleContent()
           }
           if (actionContent != null) {
               Spacer(modifier = Modifier.requiredWidth(12.dp))
               actionContent()
           }
       }
   }
}