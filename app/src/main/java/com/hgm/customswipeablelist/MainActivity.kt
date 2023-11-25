package com.hgm.customswipeablelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hgm.customswipeablelist.ui.theme.CustomSwipeableListTheme
import com.hgm.customswipeablelist.widget.BehindMotionSwipe
import com.hgm.customswipeablelist.widget.DrawerMotionSwipe
import com.hgm.customswipeablelist.widget.ScrollMotionSwipe

/**
 *    自定义可侧滑的Item
 **/
class MainActivity : ComponentActivity() {
      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                  CustomSwipeableListTheme {
                        Column(
                              modifier = Modifier.fillMaxSize(),
                              horizontalAlignment = Alignment.CenterHorizontally,
                              verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                              BehindMotionSwipe()
                              ScrollMotionSwipe()
                              DrawerMotionSwipe()
                        }
                  }
            }
      }
}
