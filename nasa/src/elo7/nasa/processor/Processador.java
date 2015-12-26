package elo7.nasa.processor;

import java.util.List;

import elo7.nasa.entity.Sonda;
import elo7.nasa.entity.commons.Comando;
import elo7.nasa.exception.ProcessingException;

public class Processador {
	
	
	public static Sonda processarComandos(Sonda sonda, List<Comando> lista) throws ProcessingException{
		
		for (Comando comando : lista) {
			sonda.executarAcao(comando);
		}
		
		return sonda;
		
	}
}
