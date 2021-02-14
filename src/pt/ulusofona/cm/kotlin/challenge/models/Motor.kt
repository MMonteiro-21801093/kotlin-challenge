package pt.ulusofona.cm.kotlin.challenge.models

class Motor(var cavalos: Int, var cilindrada: Int) {
    var ligado = false
    get()= field
    set(value) {
        field = value
    }
    override fun toString(): String {
        return "Motor | cavalos | cilindrada"
    }



}