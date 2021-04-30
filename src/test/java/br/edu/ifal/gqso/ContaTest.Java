package br.edu.ifal.gqso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifal.gqso.Conta.SaldoInsuficiente;
import br.edu.ifal.gqso.Conta.ValorDeTransacaoNegativo;

public class ContaTest {
  private Conta conta;

  @BeforeEach
  public void setUp() {
    this.conta = new Conta();
  }

  @Test
  public void depositoTest() throws ValorDeTransacaoNegativo {
    assertEquals(10, conta.deposito(10));
    assertEquals(27.5, conta.deposito(17.5));
    assertThrows(ValorDeTransacaoNegativo.class, () -> conta.deposito(-100));
  }

  @Test
  public void saqueTest() throws ValorDeTransacaoNegativo, SaldoInsuficiente {
    conta.deposito(27.5);
    assertEquals(17, conta.saque(10.5));
    assertEquals(0, conta.saque(17));
    assertThrows(ValorDeTransacaoNegativo.class, () -> conta.saque(-100));
    assertThrows(SaldoInsuficiente.class, () -> conta.saque(10));
  }
}
