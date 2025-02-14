package org.example.test_multi

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform