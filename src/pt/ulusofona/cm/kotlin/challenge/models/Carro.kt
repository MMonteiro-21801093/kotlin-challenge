package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro(identificador: String, var motor: Motor) : Veiculo(identificador)  {
    override fun requerCarta(): Boolean? {
        return true
    }


    @Throws(AlterarPosicaoException::class)
    override fun moverPara(x: Int, y: Int) {
        if(!motor.estaLigado()){
            motor.ligar()
        }
        posicao!!.alterarPosicaoPara(x, y)
        motor.desligar()
    }

    override fun toString(): String {
        return "Carro | ${this.identificador} | ${this.dataDeAquisicao} | Posicao | x:${this.posicao?.x} | y:${this.posicao?.y}"
    }
}

