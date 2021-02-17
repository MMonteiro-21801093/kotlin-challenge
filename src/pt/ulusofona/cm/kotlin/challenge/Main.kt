package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.*
import java.time.LocalDate
import java.util.ArrayList
val veiculos: ArrayList<Veiculo> = ArrayList()
val pessoas: ArrayList<Pessoa> = ArrayList()
fun main() {


   /* val p1 = Pessoa("Luis", LocalDate.of(1999, 8, 21))
    val p2 = Pessoa("João", LocalDate.of(2015, 5, 25))
    val p3 = Pessoa("Maria", LocalDate.of(1980, 1, 1))
    val p4 = Pessoa("Pedro", LocalDate.of(1972, 2, 1))
    pessoas.add(p1)
    pessoas.add(p2)
    pessoas.add(p3)
    pessoas.add(p4)
    val carro1: Veiculo = Carro("12-88-XG", Motor(75, 1200))
    val carro2: Veiculo = Carro("44-18-AF", Motor(100, 1600))
    val carro3: Veiculo = Carro("12-11-AA", Motor(75, 1200))
    val  bicicleta1: Veiculo = Bicicleta("1839912")
    val  bicicleta2: Veiculo = Bicicleta("1839112")
    val  bicicleta3: Veiculo = Bicicleta("1119912")
    veiculos.add(carro1)
    veiculos.add(carro2)
    veiculos.add(carro3)
    veiculos.add(bicicleta1)
    veiculos.add(bicicleta2)
    veiculos.add(bicicleta3)*/




    var opcaoSelecionada :String ? = null
    mostraMenu()
    opcaoSelecionada = readLine()!!.toString()
    do {
       when(opcaoSelecionada){
           "0"-> mostraMenu()
           "1"-> pesquisarVeiculo()
           "2"-> venderVeiculo()
           "3"-> moverVeiculo()
           "4"-> verificaSeTemCarta()
           "5"-> tirarCarta()
           "6"-> movimentaPessoa()
           else-> println("opção inválida")
           }
    } while (opcaoSelecionada!="99")


    }

fun movimentaPessoa() {

}

fun tirarCarta() {

}

fun verificaSeTemCarta() {

}

fun moverVeiculo() {

}

fun venderVeiculo() {

}

fun pesquisarVeiculo() {
    println("Introduza o nome da pessoa")
    val nomePessoa :String = readLine().toString()
    for(pessoa in pessoas ){
        if(pessoa.nome.equals(nomePessoa)){
            println("Introduza o identificador do veiculo")
            val idVeiculo :String = readLine().toString()
            println(pessoa.pesquisarVeiculo(idVeiculo))
        }
    }
}

fun mostraMenu() {
    println("MENU")
    println("0 - Menu inicial")
    println("1 - Pesquisar veiculo")
    println("2 - vender veiculo")
    println("3 - Mover veiculo")
    println("4 - Verifica se tem carta")
    println("5 - Tirar a carta")
    println("6 - Movimenta pessoa")
    println("99 - Sair")
}
