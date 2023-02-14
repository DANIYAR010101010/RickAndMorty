package com.io.muhsin.rickandmorty.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.io.muhsin.rickandmorty.data.models.character.Character
import retrofit2.http.Query

/*
class PageSource(
    private val service: ApiService,
    private val query: String
): PagingSource<Int,Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        if (query.isEmpty()){
            return LoadResult.Page(emptyList(),prevKey = null,nextKey = null)
        }
        val page:Int = params.key?:1
        val pageSize:Int = params.loadSize
        val response = service.getAllCharacter(query,page,pageSize)
        if(response.isSuccessful){
            val characters = checkNotNull(response.body()).results?.map { it?.name }
            val nextKey = if (characters?.size!! <pageSize) null else page + 1
            val prevKey = if (page==1) null else page - 1
            return LoadResult.Page(prevKey,nextKey,characters)
        }
    }
}*/
