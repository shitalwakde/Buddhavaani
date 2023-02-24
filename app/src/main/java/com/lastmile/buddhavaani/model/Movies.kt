package com.lastmile.buddhavaani.model

data class Movies(
    val page: Int,
    val results: List<Result>,
    val projectList: List<Result>,
    val usersList: List<Result>,
    val total_pages: Int,
    val total_results: Int,

    //======== user ===========

    val name: String?,
    val city: String?
)