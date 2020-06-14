package com.tappli.paging3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val adapter = SampleDataAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.adapter = adapter
        lifecycleScope.launch {
            getStream().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun getStream(): Flow<PagingData<String>> {
        // 実際はRepositoryがFlowにして返す？
        // https://codelabs.developers.google.com/codelabs/android-paging/#5
        return Pager(config = PagingConfig(pageSize = 10), initialKey = 0) { DataSource() }.flow
    }
}