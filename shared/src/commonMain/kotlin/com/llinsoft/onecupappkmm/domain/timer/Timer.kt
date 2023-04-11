package com.llinsoft.onecupappkmm.domain.timer

import kotlinx.coroutines.*

/**
 * Pure Kotlin timer, fit for KMM
 */
class Timer {
    suspend fun startCountDown(
        durationSeconds: Int,
        onTick: (Int) -> Unit = { },
        onFinish: () -> Unit = { }
    ) {
        val scope = CoroutineScope(Dispatchers.Default)

        var currentSecond = durationSeconds

        val job = scope.launch {
            while (isActive && currentSecond > 0) {
                onTick(currentSecond)
                delay(1000L)
                currentSecond--
            }
            //callback for 0 second
            onFinish()
        }
        job.join()
    }
}