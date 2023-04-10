package com.llinsoft.onecupappkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform