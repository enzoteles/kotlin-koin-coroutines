package br.com.desafio.home

import android.os.Bundle
import br.com.desafio.R
import br.com.desafio.base.BaseActivity
import br.com.desafio.service.Data
import br.com.desafio.util.WrapperLog
import org.koin.android.ext.android.inject

/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class HomeActivity : BaseActivity(), OnHomeMVP.View {

    val mPresenter: HomePresenter<OnHomeMVP.View, OnHomeMVP.Interactor> by inject()
    val mInteractor: HomeInteractor by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initInjection()
        initDate()
    }

    override fun loadBanners(banners: List<Data>?) {
        banners!!.forEach {
            WrapperLog.info("${it.linkUrl}")
        }
    }

    override fun initView() {
        mPresenter.initView(this, baseContext)
    }

    override fun initInjection() {
        //módulo do dagger2
    }

    override fun initDate() {
        mPresenter.initInteractor(mInteractor)
    }

    override fun isAttached(): Boolean {
        return !isFinishing
    }

    override fun msgError(error: String) {
        error(error)
    }

}
