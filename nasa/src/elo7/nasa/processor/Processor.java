package elo7.nasa.processor;

import java.util.List;

import elo7.nasa.entity.Sonda;
import elo7.nasa.entity.commons.Comando;
import elo7.nasa.entity.commons.Coordenada;

public interface Processor {
	

	public Coordenada processCommands(Sonda sonda, List<Comando> lista);
	
}
