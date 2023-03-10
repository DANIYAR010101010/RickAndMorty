package com.io.muhsin.rickandmorty.data.network.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.io.muhsin.rickandmorty.data.network.ApiService
import com.io.muhsin.rickandmorty.models.location.ResultX

class PagingSourceLocation(
    private val apiService: ApiService,
    private val name: String,
) : PagingSource<Int, ResultX>() {
    override fun getRefreshKey(state: PagingState<Int, ResultX>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultX> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getLocation(page = page, name)

            LoadResult.Page(
                data = response.body()?.results ?: emptyList(),
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.body()?.results?.isEmpty() == true) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}