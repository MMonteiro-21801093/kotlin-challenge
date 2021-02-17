package pt.ulusofona.cm.kotlin.challenge.models

class Motor(var cavalos: Int, var cilindrada: Int) {
    var ligado = false

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }



}