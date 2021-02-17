package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

class Bicicleta(identificador: String?) : Veiculo(identificador) {
    override fun toString(): String {
        return "Bicicleta |$identificador | $dataDeAquisicao | Posicao | x:$posicao.x | y:$posicao.y"
    }

    override fun requerCarta(): Boolean? {
        return false
    }

    @Throws(AlterarPosicaoException::class)
    override fun movimentarPara(x: Int, y: Int) {
        posicao!!.alterarPosicaoPara(x, y)
    }
}