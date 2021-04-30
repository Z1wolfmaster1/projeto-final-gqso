package br.edu.ifal.gqso;

public class Conta {
  public class SaldoInsuficiente extends Exception {}

  public class ValorDeTransacaoNegativo extends Exception {}

  private double saldo = 0;

  public double deposito(double valor) throws ValorDeTransacaoNegativo {
    try {
      if (valor < 0) {
        throw new ValorDeTransacaoNegativo();
      }

      saldo += valor;
    } catch (ValorDeTransacaoNegativo e) {
      throw new ValorDeTransacaoNegativo();
    }

    return saldo;
  }

  public double saque(double valor) throws ValorDeTransacaoNegativo, SaldoInsuficiente {
    try {
      if (valor < 0) {
        throw new ValorDeTransacaoNegativo();
      }

      if (saldo - valor < 0) {
        throw new SaldoInsuficiente();
      }

      saldo -= valor;
    } catch (ValorDeTransacaoNegativo v) {
        throw new ValorDeTransacaoNegativo();
    } catch (SaldoInsuficiente s) {
        throw new SaldoInsuficiente();
    }

    return saldo;
  }

  public double saldo() {
    return saldo;
  }
}
