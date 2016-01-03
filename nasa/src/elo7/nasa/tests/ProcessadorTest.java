package elo7.nasa.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import elo7.nasa.entity.Sonda;
import elo7.nasa.entity.commons.Comando;
import elo7.nasa.entity.commons.Coordenada;
import elo7.nasa.entity.commons.Direcao;
import elo7.nasa.exception.ProcessingException;
import elo7.nasa.processor.Processador;
import elo7.nasa.utils.ConvertUtil;

public class ProcessadorTest {
	
	
	@Test
	public void testProcessarComandos() throws ProcessingException{
		
		Sonda sondaTeste = new Sonda (Direcao.E, new Coordenada(5, 1));
		
		List<Comando> lista = ConvertUtil.converterComandosString("MMMMMMLMMMRR");
		
		sondaTeste =  Processador.processarComandos(sondaTeste, lista);

		Assert.assertEquals(Direcao.S, sondaTeste.getDirecao());
		Assert.assertEquals(11, sondaTeste.getCoordenada().getX());
		Assert.assertEquals(4, sondaTeste.getCoordenada().getY());
		
	}
	
}
