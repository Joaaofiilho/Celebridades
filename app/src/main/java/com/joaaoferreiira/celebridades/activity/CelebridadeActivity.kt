package com.joaaoferreiira.celebridades.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.joaaoferreiira.celebridades.R
import com.joaaoferreiira.celebridades.activity.MainActivity.Companion.EXTRA_ID_CELEBRIDADE
import com.joaaoferreiira.celebridades.database.AppDatabase
import com.joaaoferreiira.celebridades.viewmodel.CelebridadeViewModel
import com.joaaoferreiira.celebridades.viewmodel.CelebridadeViewModelFactory
import kotlinx.android.synthetic.main.activity_celebridade.*

class CelebridadeActivity : AppCompatActivity() {

    private lateinit var viewModel: CelebridadeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_celebridade)

        viewModel = ViewModelProviders.of(this, CelebridadeViewModelFactory(AppDatabase.getInstance(this))).get(
            CelebridadeViewModel::class.java)

        setupUI()
        subscribeUI()
    }

    private fun setupUI() {
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(false)

        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsingToolbarLayoutTitleColorCollapsed)
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.CollapsingToolbarLayoutTitleColorExpanded)

        botaoNovaFrase.setOnClickListener {
            viewModel.celebridade.value?.let {
                it.frases?.let { frases -> if(frases.isNotEmpty()) frase.text = frases.random().frase }
            }
        }

        val idCelebridade = intent.getIntExtra(EXTRA_ID_CELEBRIDADE, -1)
        viewModel.getCelebridade(idCelebridade)
    }

    private fun subscribeUI() {
        with(viewModel) {
            celebridade.observe(this@CelebridadeActivity, Observer {
                collapsingToolbar.title = it.celebridade?.nome
                Glide.with(this@CelebridadeActivity)
                    .load(it.celebridade?.imagem)
                    .apply(RequestOptions().dontTransform())
                    .into(imagemCelebridade)

                it.frases?.let { frases -> if(frases.isNotEmpty()) frase.text = frases.random().frase }
            })
        }
    }
}
