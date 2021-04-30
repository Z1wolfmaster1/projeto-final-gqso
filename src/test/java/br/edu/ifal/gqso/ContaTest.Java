package br.edu.ifal.gqso;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifal.gqso.Conta.ParametroInvalido;
import br.edu.ifal.gqso.Conta.ValorDeTransacaoNegativo;

public class ContaTest {
  private Conta conta;

  @BeforeEach
  public void setUp() {
    this.conta = new Conta();
  }

  @Test
  public void depositoTest() {
    assertEquals(10, conta.deposito(10));
    assertEquals(27.5, conta.deposito(17.5));
    assertThrows(ValorDeTransacaoNegativo.class, conta.deposito(-100));
    assertThrows(ParametroInvalido.class, conta.deposito("7"));
  }
}
