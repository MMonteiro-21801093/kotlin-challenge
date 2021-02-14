package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro(identificador: String?, var motor: Motor) : Veiculo(identificador), Ligavel {
    override fun requerCarta(): Boolean? {
        return true
    }

    override fun ligar() {
        if (motor.ligado) {
            try {
                throw VeiculoLigadoException("Veiculo já se encontra ligado")
            } catch (e: VeiculoLigadoException) {
                e.printStackTrace()
            }
        } else {
            motor.ligado= true
        }
    }

    override fun desligar() {
        if (!motor.ligado) {
            try {
                throw VeiculoDesligadoException("Veiculo já se encontra desligado")
            } catch (e: VeiculoDesligadoException) {
                e.printStackTrace()
            }
        } else {
            motor.ligado = false
        }
    }

    override fun estaLigado(): Boolean {
        return motor.ligado
    }

    @Throws(AlterarPosicaoException::class)
    override fun movimentarPara(x: Int, y: Int) {
        posicao!!.alterarPosicaoPara(x, y)
        motor.ligado = false
    }

    override fun toString(): String {
        return "Carro | identificador | data de aquisicao | Posicao | x:0 | y:0"
    }
}

