package elo7.nasa.main;

import elo7.nasa.entity.Sonda;
import elo7.nasa.entity.commons.Comando;
import elo7.nasa.entity.commons.Coordenada;
import elo7.nasa.entity.commons.Direcao;
import elo7.nasa.exception.ProcessingException;

public class Main {

	public static void main(String[] args) {
		Sonda sonda = new Sonda(Direcao.N, new Coordenada(10,5));
		
		try {
			sonda.executarAcao(Comando.M);
		} catch (ProcessingException e) {
			e.printStackTrace();
		}
		
		sonda.setDirecao(Direcao.N);
		
		System.out.print(
				sonda.getDirecao()
				+ " " + String.valueOf(sonda.getCoordenada().getX())
				+ " " + String.valueOf(sonda.getCoordenada().getY()) );
		
	}

}