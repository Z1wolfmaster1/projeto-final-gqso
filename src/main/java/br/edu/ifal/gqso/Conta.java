package br.edu.ifal.gqso;

public class Conta {
  public class SaldoInsuficiente extends Exception {}
  public class ValorDeTransacaoNegativo extends Exception {}

  private double saldo = 0;

  public double deposito(double valor) throws ValorDeTransacaoNegativo {
    try {
    if (valor < 0) {
      throw new Exception();
    }

      saldo += valor;
    } catch (Exception e) {
      throw new ValorDeTransacaoNegativo();
    }

    return saldo;
  }
}
