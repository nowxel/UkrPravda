package com.nowxel.ukrpravda

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nowxel.ukrpravda.databinding.MainFragmentBinding
import com.nowxel.ukrpravda.databinding.TabItemBinding

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tabsRecycler.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.tabsRecycler.adapter = TabsAdapter()
    }

    class TabsAdapter : RecyclerView.Adapter<TabViewHolder>() {
        override fun getItemCount(): Int = AppTab.values().size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabViewHolder =
            TabViewHolder(
                TabItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

        override fun onBindViewHolder(holder: TabViewHolder, position: Int) =
            holder.bind(AppTab.values()[position])
    }

    class TabViewHolder(private val binding: TabItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tab: AppTab) {
            binding.root.apply {
                text = tab.toLocalizedString(context)
                setTextColor(
                    ContextCompat.getColor(
                        context,
                        if (tab == AppTab.MAIN) R.color.cherry else R.color.black
                    )
                )
                setOnClickListener {
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(tab.toUrl())))
                }
            }
        }
    }
}