package com.llinsoft.onecupappkmm

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> Success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> Error(msg: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

    }
}

enum class Status {
    SUCCESS,
    ERROR
}