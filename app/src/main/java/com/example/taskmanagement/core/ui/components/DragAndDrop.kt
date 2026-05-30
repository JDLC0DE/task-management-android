package com.example.taskmanagement.core.ui.components

import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned

internal val LocalDragAndDropState = compositionLocalOf { DragAndDropState() }

class DragAndDropState {
    var isDragging: Boolean by mutableStateOf(false)
    var dragOffset by mutableStateOf(Offset.Zero)
    var draggableItem by mutableStateOf<Any?>(null)
    var dragPreview: (@Composable () -> Unit)? by mutableStateOf(null)

    private val dropTargets = mutableStateMapOf<String, Rect>()
    private var onDropCallback: ((Any, String) -> Unit)? = null

    fun addDropTarget(id: String, rect: Rect) {
        dropTargets[id] = rect
    }

    fun startDrag(item: Any, callback: (Any, String) -> Unit, preview: @Composable () -> Unit) {
        draggableItem = item
        dragPreview = preview
        isDragging = true
        onDropCallback = callback
    }

    fun stopDrag() {
        if (isDragging) {
            val targetId = dropTargets.entries.find { it.value.contains(dragOffset) }?.key
            if (targetId != null && draggableItem != null) {
                onDropCallback?.invoke(draggableItem!!, targetId)
            }
        }
        isDragging = false
        draggableItem = null
        dragPreview = null
        dragOffset = Offset.Zero
    }
}

@Composable
fun DragAndDropContainer(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    val state = remember { DragAndDropState() }
    CompositionLocalProvider(LocalDragAndDropState provides state) {
        Box(modifier = modifier.fillMaxSize()) {
            content()
            if (state.isDragging) {
                Box(modifier = Modifier
                    .graphicsLayer {
                        translationX = state.dragOffset.x - 170f // Offset para centrar un poco el drag
                        translationY = state.dragOffset.y - 120f
                        alpha = 0.8f
                        scaleX = 0.9f
                        scaleY = 0.8f
                    }
                ) {
                    state.dragPreview?.invoke()
                }
            }
        }
    }
}

@Composable
fun <T> DragTarget(
    modifier: Modifier = Modifier,
    dataToDrop: T,
    onDropped: (Any, String) -> Unit,
    content: @Composable (() -> Unit)
) {
    val state = LocalDragAndDropState.current
    var currentPosition by remember { mutableStateOf(Offset.Zero) }

    Box(modifier = modifier
        .onGloballyPositioned {
            currentPosition = it.localToWindow(Offset.Zero)
        }
        .pointerInput(Unit) {
            detectDragGesturesAfterLongPress(
                onDragStart = { offset ->
                    state.startDrag(dataToDrop as Any, onDropped) { content() }
                    state.dragOffset = currentPosition + offset
                },
                onDrag = { change, dragAmount ->
                    change.consume()
                    state.dragOffset += dragAmount
                },
                onDragEnd = { state.stopDrag() },
                onDragCancel = { state.stopDrag() }
            )
        }
    ) {
        content()
    }
}

@Composable
fun DropTarget(
    modifier: Modifier = Modifier,
    targetId: String,
    content: @Composable (BoxScope.() -> Unit)
) {
    val state = LocalDragAndDropState.current
    
    Box(modifier = modifier
        .onGloballyPositioned { layoutCoordinates ->
            state.addDropTarget(targetId, layoutCoordinates.boundsInWindow())
        }
    ) {
        content()
    }
}
