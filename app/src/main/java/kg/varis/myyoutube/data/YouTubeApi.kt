package kg.varis.myyoutube.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {
    @GET("playlists")
    fun getPlaylist(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: Int
    ): Call<PlayList>
}