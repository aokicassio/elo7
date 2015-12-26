package elo7.nasa.utils;

import java.util.ArrayList;
import java.util.List;

import elo7.nasa.entity.commons.Comando;
import elo7.nasa.entity.commons.Direcao;
import elo7.nasa.exception.ConvertionException;

public class ConvertUtil {
	
	public static List<Comando> converterComandosString(String comandos){
		
		List<Comando> lista = new ArrayList<>();
		final int len = comandos.length();
		
		try {
			 for (int i = 0; i < len; i++) {

			    	switch (comandos.charAt(i)) {
					case 'L' :
						lista.add(Comando.L);
						break;
					case 'R':
						lista.add(Comando.R);
						break;
					case 'M':
						lista.add(Comando.M);
						break;
					default:
						throw new ConvertionException();
					}
			    }
		} catch (ConvertionException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public static Direcao converterDirecao(String s){

		Direcao d = null;
		try {
			switch (s) {
			case "N":
				d = Direcao.N;
				break;
			case "S":
				d = Direcao.S;
				break;
			case "W":
				d = Direcao.W;
				break;
			case "E":
				d = Direcao.E;
				break;
			default:
				throw  new ConvertionException();
			}

		} catch (ConvertionException e) {
			e.printStackTrace();
		}

		return d;
	}

}
