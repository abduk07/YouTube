package kg.varis.myyoutube.ui.playlists.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import kg.varis.myyoutube.data.PlayList
import kg.varis.myyoutube.databinding.ItemPlaylistBinding

class PlayListAdapter : Adapter<PlayListAdapter.PlayListViewHolder>() {

    var list = mutableListOf<PlayList.Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(lists: List<PlayList.Item>) {
        this.list = lists as MutableList<PlayList.Item>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayListViewHolder {
        return PlayListViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int =
        list.size


    inner class PlayListViewHolder(private val binding: ItemPlaylistBinding) :
        ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(item: PlayList.Item) {
            binding.ivPlaylistImage.load(item.snippet.thumbnails.default.url)
            binding.namePlaylist.text = item.snippet.title
            binding.tvAmountVideo.text = item.contentDetails.itemCount.toString() + " video series"
        }
    }
}