package com.tappli.paging3

import androidx.paging.PagingSource
import kotlinx.coroutines.delay

class DataSource : PagingSource<Int, String>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        val pageNumber = params.key ?: 0
        val items = (0 until 25).map { it + pageNumber * 25 }.map { it.toString() }
        val prev: Int? = if (pageNumber > 0) pageNumber - 1 else null
        val next = if (pageNumber < 10) pageNumber + 1 else null

        delay(300)

        return LoadResult.Page(items, prev, next)
    }
}