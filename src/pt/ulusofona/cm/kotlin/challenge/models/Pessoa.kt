package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat

import java.time.LocalDate

import java.time.temporal.ChronoUnit
import java.util.*

class Pessoa( val nome: String, private val dataDeNascimento: Date) : Movimentavel {
    var veiculos: ArrayList<Veiculo> = ArrayList()
    var carta: Carta? = null
    var posicao: Posicao
    fun comprarVeiculo(veiculo: Veiculo) {
        veiculos.add(veiculo)
    }

    @Throws(VeiculoNaoEncontradoException::class)
    fun pesquisarVeiculo(identificador: String): Veiculo {
        for (veiculo in veiculos) {
            if (veiculo.identificador.equals(identificador) ) {
                return veiculo
            }
        }
        return throw VeiculoNaoEncontradoException("Veiculo não encontrado")
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        for (veiculo in veiculos) {
            if (veiculo.identificador.equals(identificador) ) {
                comprador.comprarVeiculo(veiculo)
                veiculos.remove(veiculo)
                break
            }
        }
    }

    @Throws(AlterarPosicaoException::class, PessoaSemCartaException::class)
    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        for (veiculo in veiculos) {
            if (veiculo.identificador.equals(identificador) ) {
                if (veiculo.requerCarta()!! && !temCarta()) {
                    throw PessoaSemCartaException("Nome da Pessoa não tem carta para conduzir o veículo indicado")
                }
                veiculo.movimentarPara(x, y)
                break
            }
        }
    }

    fun temCarta(): Boolean {
        return if (carta == null) false else true
    }

    override fun toString(): String {
        return "Pessoa | $nome | $dataDeNascimento | Posicao | x:${this.posicao.x}| y:${this.posicao.y}"
    }

    @Throws(MenorDeIdadeException::class)
    fun tirarCarta() {
        val formatter = SimpleDateFormat("dd/MM/yyyy")

        val dtNasc = formatter.format(dataDeNascimento)

        val menorDeIdade = ChronoUnit.YEARS.between(LocalDate.parse(dtNasc), LocalDate.now())
        if (menorDeIdade < 18) {
            throw MenorDeIdadeException("Não pode tirar a carta, Menor de idade")
        } else {
            carta = Carta()
        }
    }

    @Throws(AlterarPosicaoException::class)
    override fun movimentarPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }

    init {
        posicao = Posicao(0, 0)
        veiculos = ArrayList()
    }
}