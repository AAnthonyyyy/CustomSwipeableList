package com.hgm.customswipeablelist.common


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

/**
 * @author：HGM
 * @created：2023/11/14 0014
 * @description：封装好的通用滑动容器，滑动动画具体实现
 **/
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipeItem(
      state: AnchoredDraggableState<DragAnchors>,
      content: @Composable BoxScope.() -> Unit,
      startAction: @Composable (BoxScope.() -> Unit)? = {},
      endAction: @Composable (BoxScope.() -> Unit)? = {}
) {
      Box(
            modifier = Modifier
                  .padding(16.dp)
                  .fillMaxWidth()
                  .height(80.dp)
                  .clip(RectangleShape)
      ) {
            //左侧
            startAction?.let {
                  startAction()
            }
            endAction?.let {
                  endAction()
            }

            Box(
                  modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterStart)
                        .offset {
                              IntOffset(
                                    //水平滑动，y轴不变，只需要改变x轴的坐标
                                    x = -state.requireOffset().roundToInt(),
                                    y = 0,
                              )
                        }
                        .anchoredDraggable(
                              state = state,
                              orientation = Orientation.Horizontal,
                              reverseDirection = true
                        ),
                  content = content
            )
      }

}

