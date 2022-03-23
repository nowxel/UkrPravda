package com.nowxel.ukrpravda

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nowxel.ukrpravda.databinding.MenuFragmentBinding
import com.nowxel.ukrpravda.databinding.MenuTabItemBinding

class MenuFragment : Fragment() {

    private lateinit var binding: MenuFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MenuFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ukrButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pravda.com.ua/")))
        }
        binding.rusButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pravda.com.ua/rus/")))
        }
        binding.engButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pravda.com.ua/eng/")))
        }

        binding.searchButton.setOnClickListener {
            val query = binding.searchField.text
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.pravda.com.ua/search/?search=$query")
                )
            )
        }

        binding.upShopButton.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/ukrpravda/shop/?ref_code=mini_shop_page_card_cta")
                )
            )
        }

        binding.sectionsRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TabsAdapter()
        }
    }

    class TabsAdapter : RecyclerView.Adapter<TabViewHolder>() {
        override fun getItemCount(): Int = AppTab.values().size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabViewHolder =
            TabViewHolder(
                MenuTabItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

        override fun onBindViewHolder(holder: TabViewHolder, position: Int) =
            holder.bind(AppTab.values()[position])
    }

    class TabViewHolder(private val binding: MenuTabItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tab: AppTab) {
            binding.root.apply {
                text = tab.toLocalizedString(context)
                setOnClickListener {
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(tab.toUrl())))
                }
            }
        }
    }
}