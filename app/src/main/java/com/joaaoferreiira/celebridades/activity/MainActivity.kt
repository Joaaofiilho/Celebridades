package com.joaaoferreiira.celebridades.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.transition.AutoTransition
import androidx.transition.Explode
import androidx.transition.Fade
import com.joaaoferreiira.celebridades.R
import com.joaaoferreiira.celebridades.adapter.CelebridadesAdapter
import com.joaaoferreiira.celebridades.database.AppDatabase
import com.joaaoferreiira.celebridades.util.CelebridadesUtil
import com.joaaoferreiira.celebridades.viewmodel.MainActivityViewModel
import com.joaaoferreiira.celebridades.viewmodel.MainActivityViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.holder_celebridade.view.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID_CELEBRIDADE = "idCelebridade"
    }

    private val database by lazy { AppDatabase.getInstance(applicationContext) }
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var celebridadesAdapter: CelebridadesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, MainActivityViewModelFactory(database)).get(MainActivityViewModel::class.java)

        setupUI()
        subscribeUI()
    }

    private fun setupUI() {

        celebridadesAdapter = CelebridadesAdapter(
            this,
            onItemClicked = { itemView, id ->
                val intent = Intent(this@MainActivity, CelebridadeActivity::class.java)

                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                    Pair(itemView.container, itemView.container.transitionName),
                    Pair(itemView.container, itemView.container.transitionName),
                    Pair(itemView.nomeCelebridade, itemView.nomeCelebridade.transitionName)
                )
                intent.putExtra(EXTRA_ID_CELEBRIDADE, id)
                startActivity(intent, options.toBundle())
            }
        )

        recyclerViewCelebridades.adapter = celebridadesAdapter

        viewModel.carregarCelebridadesFromDB()
    }

    private fun subscribeUI() {
        with(viewModel) {
            onCelebridadesCarregadas.observe(this@MainActivity, Observer {
                if(it.isEmpty()) {
                    //Se tiver vazio, popula o db
                    viewModel.gerarCelebridadesForDB()
                } else {
                    //Se não, popula a tela
                    celebridadesAdapter.atualizar(it)
                }
            })
        }
    }
}
