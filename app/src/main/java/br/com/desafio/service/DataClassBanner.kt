package br.com.desafio.service

import java.io.Serializable
/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

// Api Banner
data class Banner(
    val `data`: List<Data>
):Serializable

data class Data(
    val id: Int,
    val linkUrl: String,
    val urlImagem: String
):Serializable