package br.edu.ifal.gqso;

public class Conta {
  public class SaldoInsuficiente extends Exception {}
  public class ParametroInvalido extends Exception {}
  public class ValorDeTransacaoNegativo extends ParametroInvalido {}

  private float saldo = 0;
}
