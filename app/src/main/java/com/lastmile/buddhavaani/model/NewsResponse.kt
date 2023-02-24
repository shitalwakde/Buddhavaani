package com.lastmile.buddhavaani.model

data class NewsResponse(
    val articles: List<News>,
    val status: String,
    val totalResults: Int
)