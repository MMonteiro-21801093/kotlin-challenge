package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

import java.time.LocalDate

import java.time.temporal.ChronoUnit
import java.util.ArrayList

class Pessoa( val nome: String, private val dataDeNascimento: LocalDate) : Movimentavel {
    private val veiculos: ArrayList<Veiculo>
    private var carta: Carta? = null
    private val posicao: Posicao
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
        return "Pessoa | nome | data de nascimento | Posicao | x:0 | y:0"
    }

    @Throws(MenorDeIdadeException::class)
    fun tirarCarta() {
        val maisDe18 = ChronoUnit.YEARS.between(dataDeNascimento, LocalDate.now())
        carta = if (maisDe18 < 18) {
            throw MenorDeIdadeException("Não pode tirar a carta, Menor de idade")
        } else {
            Carta()
        }
    }

    @Throws(AlterarPosicaoException::class)
    override fun movimentarPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }

    init {
        veiculos = ArrayList()
        posicao = Posicao(0, 0)
    }
}