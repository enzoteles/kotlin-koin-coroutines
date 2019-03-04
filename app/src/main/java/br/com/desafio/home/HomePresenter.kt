package br.com.desafio.home

import android.content.Context
import br.com.desafio.service.Data
import br.com.desafio.service.RetrofitB2W
import br.com.desafio.util.HttpStatusCodes
import br.com.desafio.util.StatusCodes

/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class HomePresenter<V : OnHomeMVP.View, I : OnHomeMVP.Interactor>(val retrofit: RetrofitB2W) : OnHomeMVP.Presenter<V, I> {
    //variables
    lateinit var mView: OnHomeMVP.View
    lateinit var mInteractor: OnHomeMVP.Interactor
    lateinit var baseContext: Context

    override fun initView(mView: OnHomeMVP.View, baseContext: Context) {
        this.mView = mView
        this.baseContext = baseContext
    }

    override fun initInteractor(mInteractor: OnHomeMVP.Interactor) {
        this.mInteractor = mInteractor
        getInteractor().loadBanners(this as HomePresenter<OnHomeMVP.View, OnHomeMVP.Interactor>, retrofit)
    }

    override fun getView() = mView as V

    override fun getInteractor() = mInteractor as I

    override fun loadBanners(banners: List<Data>?) {
        if (mView.isAttached()){
            mView.loadBanners(banners)
        }
    }

    override fun error(code: Int) {
        val error = HttpStatusCodes.errorStatusCode(code)
        mView.msgError(error)
    }

}