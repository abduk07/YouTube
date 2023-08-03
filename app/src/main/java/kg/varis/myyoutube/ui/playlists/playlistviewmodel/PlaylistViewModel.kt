package kg.varis.myyoutube.ui.playlists.playlistviewmodel

import androidx.lifecycle.LiveData
import kg.varis.myyoutube.core.base.BaseViewModel
import kg.varis.myyoutube.data.PlayList
import kg.varis.myyoutube.repository.Repository

class PlaylistViewModel : BaseViewModel() {

    val repository = Repository()

    fun getPlayList(): LiveData<PlayList> {
        return repository.getPlaylist()
    }
}