package com.marcoantonio95.dailypulse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform