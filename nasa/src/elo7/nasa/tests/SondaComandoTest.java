package elo7.nasa.tests;

import org.junit.Test;

import elo7.nasa.entity.Sonda;
import elo7.nasa.entity.commons.Comando;
import elo7.nasa.entity.commons.Coordenada;
import elo7.nasa.entity.commons.Direcao;
import elo7.nasa.exception.ProcessingException;

import org.junit.Assert;

public class SondaComandoTest {
	
	@Test
	public void testAcaoGirarRight() throws ProcessingException{
		
		Sonda sonda = new Sonda(Direcao.N, new Coordenada(0,0));
		sonda.executarAcao(Comando.R);
		Assert.assertEquals(Direcao.E, sonda.getDirecao());
		
		sonda.setDirecao(Direcao.E);
		sonda.executarAcao(Comando.R);
		Assert.assertEquals(Direcao.S, sonda.getDirecao());
		
		sonda.setDirecao(Direcao.S);
		sonda.executarAcao(Comando.R);
		Assert.assertEquals(Direcao.W, sonda.getDirecao());
		
		sonda.setDirecao(Direcao.W);
		sonda.executarAcao(Comando.R);
		Assert.assertEquals(Direcao.N, sonda.getDirecao());

	}
	
	@Test
	public void testAcaoGirarLeft() throws ProcessingException{
		
		Sonda sonda = new Sonda(Direcao.N, new Coordenada(0, 0));
		sonda.executarAcao(Comando.L);
		Assert.assertEquals(Direcao.W, sonda.getDirecao());
		
		sonda.setDirecao(Direcao.W);
		sonda.executarAcao(Comando.L);
		Assert.assertEquals(Direcao.S, sonda.getDirecao());
		
		sonda.setDirecao(Direcao.S);
		sonda.executarAcao(Comando.L);
		Assert.assertEquals(Direcao.E, sonda.getDirecao());
		
		sonda.setDirecao(Direcao.E);
		sonda.executarAcao(Comando.L);
		Assert.assertEquals(Direcao.N, sonda.getDirecao());
		
	}
	
	@Test
	public void testAcaoMovimentar() throws ProcessingException{
		
		Sonda sonda = new Sonda(Direcao.E, new Coordenada(0, 0));
		sonda.executarAcao(Comando.M);
		Assert.assertEquals(1, sonda.getCoordenada().getX());
		
		sonda.setDirecao(Direcao.W);
		sonda.setCoordenada(new Coordenada(0, 0));
		sonda.executarAcao(Comando.M);
		Assert.assertEquals(-1, sonda.getCoordenada().getX());
		
		sonda.setDirecao(Direcao.N);
		sonda.setCoordenada(new Coordenada(0, 0));
		sonda.executarAcao(Comando.M);
		Assert.assertEquals(1, sonda.getCoordenada().getY());
		
		sonda.setDirecao(Direcao.S);
		sonda.setCoordenada(new Coordenada(0, 0));
		sonda.executarAcao(Comando.M);
		Assert.assertEquals(-1, sonda.getCoordenada().getY());

	}
	
}
