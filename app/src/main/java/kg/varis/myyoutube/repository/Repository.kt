package kg.varis.myyoutube.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kg.varis.myyoutube.BuildConfig
import kg.varis.myyoutube.core.RetrofitClient
import kg.varis.myyoutube.data.PlayList
import kg.varis.myyoutube.data.YouTubeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val youTubeApi: YouTubeApi by lazy {
        RetrofitClient.create()
    }

    fun getPlaylist(): LiveData<PlayList> {
        val data = MutableLiveData<PlayList>()
        youTubeApi.getPlaylist(
            BuildConfig.API_KEY,
            "snippet,contentDetails", "UCdKuE7a2QZeHPhDntXVZ91w", 20
        ).enqueue(object : Callback<PlayList> {
            override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<PlayList>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}")
            }
        })
        return data
    }

}