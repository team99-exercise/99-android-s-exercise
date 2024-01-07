package com.catnip.hotelier.base.core

import com.catnip.hotelier.base.exception.NoInternetConnectionException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.retry
import retrofit2.HttpException
import java.io.IOException

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

fun <T> parseException(e: Throwable): ResultWrapper<T> {
    return when (e) {
        is IOException -> ResultWrapper.Error(NoInternetConnectionException())
        is HttpException -> ResultWrapper.Error(e)
        else -> ResultWrapper.Error(e as Exception)
    }
}

fun <T> ResultWrapper<T>.proceedWhen(
    doOnSuccess: ((resource: ResultWrapper<T>) -> Unit)? = null,
    doOnError: ((resource: ResultWrapper<T>) -> Unit)? = null,
    doOnLoading: ((resource: ResultWrapper<T>) -> Unit)? = null,
    doOnEmpty: ((resource: ResultWrapper<T>) -> Unit)? = null,
    doOnIdle: ((resource: ResultWrapper<T>) -> Unit)? = null,
) {
    when (this) {
        is ResultWrapper.Success -> doOnSuccess?.invoke(this)
        is ResultWrapper.Error -> doOnError?.invoke(this)
        is ResultWrapper.Loading -> doOnLoading?.invoke(this)
        is ResultWrapper.Empty -> doOnEmpty?.invoke(this)
        is ResultWrapper.Idle -> doOnIdle?.invoke(this)
    }
}

fun <T> ResultWrapper<T>.proceed(
    doOnSuccess: ((resource: ResultWrapper<T>) -> Unit),
    doOnError: ((resource: ResultWrapper<T>) -> Unit),
    doOnLoading: ((resource: ResultWrapper<T>) -> Unit)
) = proceedWhen(doOnSuccess = doOnSuccess, doOnError = doOnError, doOnLoading = doOnLoading)

suspend fun <T> retriedNetworkCall(
    apiCall: suspend () -> T,
    retryIntervalInMillis: Long = 10000, //10 seconds
    maxRetries: Long = Long.MAX_VALUE,
): Flow<ResultWrapper<T>> =
    flow {
        try {
            emit(ResultWrapper.Success(apiCall.invoke()))
        } catch (e: Exception) {
            emit(parseException(e))
            throw e
        }
    }.retry(maxRetries) {
        delay(retryIntervalInMillis)
        it is IOException || it is HttpException
    }.catch {
        emit(parseException(it))
    }.onStart {
        emit(ResultWrapper.Loading())
    }
