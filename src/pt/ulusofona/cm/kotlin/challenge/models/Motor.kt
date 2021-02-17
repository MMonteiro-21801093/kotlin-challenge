package pt.ulusofona.cm.kotlin.challenge.models


import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(var cavalos: Int, var cilindrada: Int): Ligavel {
    var ligado = false

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }

 
    override fun ligar() {
        if (this.ligado) {
            throw VeiculoLigadoException("Veiculo já se encontra ligado")
        } else {
            this.ligado= true
        }
    }

    override fun desligar() {
        if (!this.ligado) {
            throw VeiculoDesligadoException("Veiculo já se encontra desligado")
        } else {
            this.ligado = false
        }
    }

    override fun estaLigado(): Boolean {
        return this.ligado
    }

}