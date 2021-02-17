package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*





abstract class Veiculo(var identificador: String) : Movimentavel {
    var posicao: Posicao
    var dataDeAquisicao: Date

    init {
        this.posicao = Posicao(0, 0)
       /* val formatter = SimpleDateFormat("dd/MM/yyyy")
        var date = Date()*/
        //System.out.println(formatter.format(date));
        this.dataDeAquisicao = Date()
    }


    abstract fun requerCarta(): Boolean

}