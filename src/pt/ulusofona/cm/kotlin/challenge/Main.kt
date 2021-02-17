package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.*
import java.time.LocalDate
import java.util.*
import java.text.SimpleDateFormat




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

   /* val p4 = Pessoa("Pedro", Date())
      p4.moverPara(5,7)
    p4.moverPara(5,7)*/

    val carro1: Veiculo = Carro("12-88-XG", Motor(75, 1200))
    val carro2: Veiculo = Carro("44-18-AF", Motor(100, 1600))
    val carro3: Carro = Carro("12-11-AA", Motor(75, 1200))
    val  bicicleta1: Veiculo = Bicicleta("1839912")
    val  bicicleta2: Veiculo = Bicicleta("1839112")
    val  bicicleta3: Veiculo = Bicicleta("1119912")
    veiculos.add(carro1)
    veiculos.add(carro2)
    veiculos.add(carro3)
    veiculos.add(bicicleta1)
    veiculos.add(bicicleta2)
    veiculos.add(bicicleta3)
    val p4 = Pessoa("Pedro", Date())
    val p5 = Pessoa("Joao", Date())
    p4.comprarVeiculo(carro1)
    p4.comprarVeiculo(carro2)
    p4.comprarVeiculo(carro3)
    p4.venderVeiculo("12-11-AA",p5)

    println(p5.pesquisarVeiculo("12-11-AA"))



    p4.desligaCarro(carro3)
    }

