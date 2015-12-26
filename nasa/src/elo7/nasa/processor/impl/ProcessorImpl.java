package elo7.nasa.processor.impl;

import java.util.List;

import elo7.nasa.entity.Sonda;
import elo7.nasa.entity.commons.Comando;
import elo7.nasa.entity.commons.Coordenada;
import elo7.nasa.processor.Processor;

public class ProcessorImpl implements Processor {

	@Override
	public Coordenada processCommands(Sonda sonda, List<Comando> lista) {
		
		Coordenada xy = new Coordenada(10, 11);

		return xy;
	}

}