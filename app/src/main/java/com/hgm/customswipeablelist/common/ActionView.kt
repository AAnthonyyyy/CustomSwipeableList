package com.hgm.customswipeablelist.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @author：HGM
 * @created：2023/11/14 0014
 * @description：隐藏的按钮
 **/
@Composable
fun ActionView(
      color: Color,
      icon: ImageVector,
      modifier: Modifier = Modifier
) {
      Box(
            modifier = modifier.background(color),
            contentAlignment = Alignment.Center,
      ) {
            IconButton(onClick = { /*TODO*/ }) {
                  Icon(imageVector = icon, contentDescription = null)
            }
      }
}