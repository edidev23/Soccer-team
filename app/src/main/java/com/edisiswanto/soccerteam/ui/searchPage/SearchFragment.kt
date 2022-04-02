package com.edisiswanto.soccerteam.ui.searchPage

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.edisiswanto.core.ui.TeamAdapter
import com.edisiswanto.soccerteam.R
import com.edisiswanto.soccerteam.databinding.FragmentSearchBinding
import com.edisiswanto.soccerteam.ui.detailPage.DetailTeamActivity
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModel()

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val teamAdapter = TeamAdapter()
            teamAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailTeamActivity::class.java)
                intent.putExtra(DetailTeamActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            val edPlace = binding.edPlace
            edPlace.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    lifecycleScope.launch {
                        searchViewModel.queryChannel.send(s.toString())
                    }
                }
            })

            searchViewModel.searchResult.observe(viewLifecycleOwner, { teamsItem ->
                if (teamsItem.isEmpty()) {
                    binding.viewError.root.visibility = View.VISIBLE
                    binding.viewError.tvError.text = getString(R.string.nothing)
                    teamAdapter.setData(emptyList())
                } else {
                    teamAdapter.setData(teamsItem)
                }
            })

            with(binding.rvSoccerTeam) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = teamAdapter
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}