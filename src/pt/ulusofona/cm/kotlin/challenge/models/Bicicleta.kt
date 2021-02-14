package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

class Bicicleta(identificador: String?) : Veiculo(identificador) {
    override fun toString(): String {
        return "Bicicleta | identificador | data de aquisicao | Posicao | x:0 | y:0"
    }

    override fun requerCarta(): Boolean? {
        return false
    }

    @Throws(AlterarPosicaoException::class)
    override fun movimentarPara(x: Int, y: Int) {
        posicao!!.alterarPosicaoPara(x, y)
    }
}