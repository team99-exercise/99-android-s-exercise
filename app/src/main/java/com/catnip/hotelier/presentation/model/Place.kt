package com.catnip.hotelier.presentation.model

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
data class Place(
    val address: Address?,
    val attributes: Attributes?,
    val category: String,
    val completedAt: String,
    val id: Int,
    val photo: String,
    val projectName: String,
    val tenure: Int
)