package com.marcoantonio95.dailypulse

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope: CoroutineScope
}