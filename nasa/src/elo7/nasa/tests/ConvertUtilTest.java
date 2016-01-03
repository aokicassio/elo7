package elo7.nasa.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import elo7.nasa.entity.commons.Comando;
import elo7.nasa.entity.commons.Direcao;
import elo7.nasa.exception.ConvertException;
import elo7.nasa.utils.ConvertUtil;

public class ConvertUtilTest {

	@Test
	public void testConverterDirecao() throws ConvertException{
		
		Assert.assertEquals(Direcao.N, ConvertUtil.converterDirecao("N"));
		
		Assert.assertEquals(Direcao.S, ConvertUtil.converterDirecao("S"));

		Assert.assertEquals(Direcao.W, ConvertUtil.converterDirecao("W"));
		
		Assert.assertEquals(Direcao.E, ConvertUtil.converterDirecao("E"));

	}
	
	@Test
	public void testConverterComandosString() throws ConvertException{
		
		List<Comando> lista = new ArrayList<>();

		
		String s = "MLR";

		lista.add(Comando.M);
		lista.add(Comando.L);
		lista.add(Comando.R);
		
		Assert.assertEquals(lista, ConvertUtil.converterComandosString(s));
		
		
		s = "";
		lista = new ArrayList<>();

		Assert.assertEquals(lista, ConvertUtil.converterComandosString(s));

	}
	
}
