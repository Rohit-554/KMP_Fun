package io.jadu

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.jadu.shared.ToastManager
import kmm_masti.composeapp.generated.resources.Kodee_Assets_Digital_Kodee_jumping
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kmm_masti.composeapp.generated.resources.Res
import kmm_masti.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {
    val isToastTapped = remember { mutableStateOf(false) }
    MaterialTheme {
        KoinContext {
            val toastManager = koinInject<ToastManager>()
            Scaffold(
                Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    if(isToastTapped.value){
                        AnimatedKodee(isToastTapped)
                    }

                    CuteToastButton(toastManager, onTap = {
                        isToastTapped.value = it
                    })
                }
            }

        }
    }
}



@Composable
fun CuteToastButton(
    toastManager: ToastManager,
    onTap: (Boolean) -> Unit = {}
) {
    var isPressed by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bounceAnimation = rememberInfiniteTransition()
    val scale by bounceAnimation.animateFloat(
        initialValue = 1f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(800),
            repeatMode = RepeatMode.Reverse
        )
    )

    val heartColor by bounceAnimation.animateColor(
        initialValue = Color(0xFFFF69B4), // Pink
        targetValue = Color(0xFFFF1493), // Deep Pink
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .padding(16.dp)
            .scale(if (isPressed) 0.95f else scale)
            .background(
                color = Color(0xFFFFE4E1), // Misty Rose
                shape = RoundedCornerShape(24.dp)
            )
            .clickable {
                isPressed = true
                onTap(true)
                toastManager.showLongToast("✨ Hello from KMM! ❤️")
                scope.launch {
                    kotlinx.coroutines.delay(3000)
                    isPressed = false
                    onTap(false)
                }
            }
            .padding(16.dp)
            .animateContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Heart",
                tint = heartColor,
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = if(isPressed) "Sending love..." else "Send love",
                color = Color(0xFF4A4A4A),
                fontSize = 18.sp
            )
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Heart",
                tint = heartColor,
                modifier = Modifier
                    .size(24.dp)
                    .padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun AnimatedKodee(isToastTapped: State<Boolean>) {
    AnimatedVisibility(
        visible = isToastTapped.value,
        enter = fadeIn(
            animationSpec = tween(
                durationMillis = 1000,
                easing = EaseInOutCubic
            )
        ) + slideInVertically(
            animationSpec = tween(1000),
            initialOffsetY = { it / 2 }
        ),
        exit = fadeOut(
            animationSpec = tween(
                durationMillis = 500,
                easing = EaseInOutCubic
            )
        )
    ) {
        val infiniteTransition = rememberInfiniteTransition()
        val offsetY by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 20f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = EaseInOutQuad),
                repeatMode = RepeatMode.Reverse
            )
        )

        Image(
            painter = painterResource(Res.drawable.Kodee_Assets_Digital_Kodee_jumping),
            contentDescription = "KMM Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .graphicsLayer {
                    translationY = offsetY
                }
        )
    }
}