package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void reajustePromocao(Funcionario funcionario, Desempenho desempenho) {
            BigDecimal porcentagem = desempenho.percentualReajuste();
           BigDecimal reajuste = funcionario.getSalario().multiply(porcentagem);
            funcionario.reajustarSalario(reajuste);
    }
}
