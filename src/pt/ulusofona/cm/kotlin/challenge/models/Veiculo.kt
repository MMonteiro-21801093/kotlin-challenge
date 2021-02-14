package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate

abstract class Veiculo : Movimentavel {
    var identificador: String? = null
       get()= field
       set(value) {field = value}
    protected var posicao: Posicao? = null
    protected var dataDeAquisicao: LocalDate

    constructor(identificador: String?) {
        this.identificador = identificador
        this.posicao = Posicao(0, 0)
        this.dataDeAquisicao = LocalDate.now()
    }


    abstract fun requerCarta(): Boolean?

}