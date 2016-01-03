package elo7.nasa.tests;

import org.junit.Assert;
import org.junit.Test;

import elo7.nasa.entity.commons.Direcao;
import elo7.nasa.exception.ConvertException;
import elo7.nasa.utils.ConvertUtil;

public class ConvertUtilTest {

	@Test
	public void testComandoGirarRight() throws ConvertException{
		
		Assert.assertEquals(Direcao.N, ConvertUtil.converterDirecao("N"));
		
		Assert.assertEquals(Direcao.S, ConvertUtil.converterDirecao("S"));

		Assert.assertEquals(Direcao.W, ConvertUtil.converterDirecao("W"));
		
		Assert.assertEquals(Direcao.E, ConvertUtil.converterDirecao("E"));

	}
	
}
