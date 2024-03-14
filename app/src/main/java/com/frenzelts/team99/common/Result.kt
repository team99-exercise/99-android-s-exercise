package com.frenzelts.team99.common

data class Result<out T>(val status: Status, val data: T?, var error: Throwable?) {
    companion object {
        fun <T> success(data: T?): Result<T> {
            return Result (
                status = Status.SUCCESS,
                data = data,
                error = null
            )
        }

        fun <T> error(error: Throwable, data: T? = null): Result<T> {
            return Result (
                status = Status.ERROR,
                data = data,
                error = error
            )
        }

        fun <T> loading(data: T? = null): Result<T> {
            return Result (
                status = Status.LOADING,
                data = data,
                error = null
            )
        }
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }
}
