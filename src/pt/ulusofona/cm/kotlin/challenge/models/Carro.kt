package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import java.text.SimpleDateFormat

class Carro(identificador: String, var motor: Motor) : Veiculo(identificador)  {
    override fun requerCarta(): Boolean {
        return true
    }


    @Throws(AlterarPosicaoException::class)
    override fun moverPara(x: Int, y: Int) {
        if(!motor.estaLigado()){
            motor.ligar()
        }
        posicao.alterarPosicaoPara(x, y)
        motor.desligar()
    }
    override fun toString(): String {
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        val dtAqs = formatter.format(dataDeAquisicao)
        return "Carro | ${this.identificador} | $dtAqs | Posicao | x:${this.posicao.x} | y:${this.posicao.y}"
    }
}

