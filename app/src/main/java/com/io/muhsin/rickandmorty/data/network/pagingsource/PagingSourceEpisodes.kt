package com.io.muhsin.rickandmorty.data.network.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.io.muhsin.rickandmorty.data.network.ApiService
import com.io.muhsin.rickandmorty.models.episode.ResultZ

class PagingSourceEpisodes(
    private val apiService: ApiService,
    private val name: String,
) : PagingSource<Int, ResultZ>() {
    override fun getRefreshKey(state: PagingState<Int, ResultZ>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultZ> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getEpisode(page = page, name)

            LoadResult.Page(
                data = response.body()?.results as List<ResultZ>? ?: emptyList(),
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.body()?.results?.isEmpty() == true) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}