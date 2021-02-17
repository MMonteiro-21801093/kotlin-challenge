package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate

abstract class Veiculo(identificador: String?) : Movimentavel {
    var identificador: String? = null
    var posicao: Posicao? = null
    var dataDeAquisicao: LocalDate

    init {
        this.identificador = identificador
        this.posicao = Posicao(0, 0)
        this.dataDeAquisicao = LocalDate.now()
    }


    abstract fun requerCarta(): Boolean?

}