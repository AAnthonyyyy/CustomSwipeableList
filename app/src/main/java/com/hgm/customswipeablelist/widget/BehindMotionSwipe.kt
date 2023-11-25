package com.hgm.customswipeablelist.widget


import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.hgm.customswipeablelist.common.ActionView
import com.hgm.customswipeablelist.common.DragAnchors
import com.hgm.customswipeablelist.common.SwipeItem
import kotlin.math.roundToInt

/**
 * @author：HGM
 * @created：2023/11/14 0014
 * @description：背后滑动样式的侧滑Item
 **/
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BehindMotionSwipe() {
      val density = LocalDensity.current
      val defaultActionSize = 80.dp
      val startActionSizePx = with(density) { defaultActionSize.toPx() }
      val endActionSizePx = with(density) { (defaultActionSize * 2).toPx() }

      //设置状态
      val state = remember {
            AnchoredDraggableState(
                  initialValue = DragAnchors.Default,//初始值为默认
                  anchors = DraggableAnchors {
                        //定义三个可拖动元素的锚点
                        DragAnchors.Start at -startActionSizePx
                        DragAnchors.Default at 0f
                        DragAnchors.End at endActionSizePx
                  },
                  positionalThreshold = { distance: Float -> distance * 0.5f },
                  velocityThreshold = { with(density) { 50.dp.toPx() } },//速度
                  animationSpec = tween(),//补间动画
            )
      }


      //使用该状态设置滑动容器的动画
      SwipeItem(
            state = state,
            content = {
                  Box(
                        modifier = Modifier
                              .fillMaxSize()
                              .background(Color.LightGray), contentAlignment = Alignment.Center
                  ) {
                        Text(text = "背后显示样式的侧滑Item")

                  }
            },
            startAction = {
                  Box(
                        modifier = Modifier
                              .fillMaxHeight()
                              .align(Alignment.CenterStart),
                  ) {
                        ActionView(
                              color= Color.Yellow,
                              icon = Icons.Default.Warning,
                              modifier = Modifier
                                    .width(defaultActionSize)
                                    .fillMaxHeight()
                        )
                  }
            },
            endAction = {
                  Row(
                        modifier = Modifier
                              .fillMaxHeight()
                              .align(Alignment.CenterEnd),
                  ) {
                        ActionView(
                              color= Color.Blue,
                              icon = Icons.Default.Edit,
                              modifier = Modifier
                                    .width(defaultActionSize)
                                    .fillMaxHeight()
                        )
                        ActionView(
                              color= Color.Red,
                              icon = Icons.Default.Delete,
                              modifier = Modifier
                                    .width(defaultActionSize)
                                    .fillMaxHeight()
                        )
                  }
            }
      )
}
