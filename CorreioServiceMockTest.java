package aps_2;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import integracao.BancoDados;
import integracao.Pessoa;
import junit.framework.Assert;
import mock.ContaBancaria;
import mock.PessoaService;

public class CorreioServiceMockTest {

	@Test
	public void testPortoAlegre() {
		CorreioService servico = Mockito.mock(CorreioService.class);
		when(servico.buscaEndereco("9000000")).thenReturn("Porto Alegre");
		Assert.assertEquals("Porto Alegre", servico.buscaEndereco("9000000"));
	}
	
	@Test
	public void testAssisBrasil() {
		CorreioService servico = Mockito.mock(CorreioService.class);
		when(servico.buscaEndereco("8000000")).thenReturn("Av. Assis Brasil");
		Assert.assertEquals("Av. Assis Brasil", servico.buscaEndereco("8000000"));
	}
}
