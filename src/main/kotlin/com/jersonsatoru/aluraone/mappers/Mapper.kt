package com.jersonsatoru.aluraone.mappers

interface Mapper<T, K> {
    fun map(t: T): K
}
