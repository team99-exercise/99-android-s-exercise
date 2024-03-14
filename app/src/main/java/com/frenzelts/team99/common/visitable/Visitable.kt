package com.frenzelts.team99.common.visitable

interface Visitable<T> {
    val id: Long
    fun type(typeFactory: T): Int
    fun areContentsTheSame(newItem: BaseVisitable): Boolean
}

typealias BaseVisitable = Visitable<*>
