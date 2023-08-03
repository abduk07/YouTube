package kg.varis.myyoutube.ui.playlists

import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import kg.varis.myyoutube.core.base.BaseActivity
import kg.varis.myyoutube.data.PlayList
import kg.varis.myyoutube.databinding.ActivityPlaylistBinding
import kg.varis.myyoutube.ui.playlists.adapter.PlayListAdapter
import kg.varis.myyoutube.ui.playlists.playlistviewmodel.PlaylistViewModel
import kg.varis.myyoutube.utils.ConnectionLiveData

class PlaylistActivity : BaseActivity<ActivityPlaylistBinding, PlaylistViewModel>() {

    private val adapter: PlayListAdapter by lazy { PlayListAdapter() }
    override fun inflateViewBinding(): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        binding.recyclerView.adapter = adapter
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlayList().observe(this) {
            adapter.addData(it.items as MutableList<PlayList.Item>)
            Log.e("ololo", "initViewModel: ${it}")
        }
    }

    override fun isConnection() {
        super.isConnection()
        ConnectionLiveData(application).observe(this) {
            if (it) {
                binding.notConnect.isVisible = false
                binding.internetConnection.isVisible = true
            } else {
                binding.notConnect.isVisible = true
                binding.internetConnection.isVisible = false
                initViewModel()
            }
        }
    }
}