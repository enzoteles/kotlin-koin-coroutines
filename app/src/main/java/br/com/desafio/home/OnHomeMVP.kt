package br.com.desafio.home

import br.com.desafio.util.OnGenericMVP
import br.com.desafio.service.Data
import br.com.desafio.service.RetrofitB2W

/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

interface OnHomeMVP{

    interface View: OnGenericMVP.View{
        fun loadBanners(msg: List<Data>?)
        fun msgError(s: String)
    }
    interface Presenter<V, I>: OnGenericMVP.Presenter<OnHomeMVP.View, OnHomeMVP.Interactor>{
        fun getView(): V
        fun getInteractor():I
        fun loadBanners(msg: List<Data>?)
        fun error(code: Int)
    }
    interface Interactor: OnGenericMVP.Interactor{
        fun loadBanners(
            callback: HomePresenter<View, Interactor>,
            retrofit: RetrofitB2W
        )
        fun initRetrofit(retrofit: RetrofitB2W)
    }
}