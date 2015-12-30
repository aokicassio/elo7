package elo7.nasa.entity;

import elo7.nasa.entity.commons.Comando;
import elo7.nasa.entity.commons.Coordenada;
import elo7.nasa.entity.commons.Direcao;
import elo7.nasa.exception.ProcessingException;

public class Sonda {
	
	private Direcao direcao;
	
	private Coordenada coordenada;

	public Sonda(Direcao direcao, Coordenada coordenada) {
		super();
		this.direcao = direcao;
		this.coordenada = coordenada;
	}
	
	public void executarAcao(Comando comando) throws ProcessingException{
		
		if(comando == Comando.M){
			movimentar(this.direcao);
		} else 
			girar(comando);
		
	}
	
	private void movimentar(Direcao direcao) throws ProcessingException{
		switch (direcao) {
		case N:
			this.coordenada.setY(coordenada.getY()+1);
			break;
		case S:
			this.coordenada.setY(coordenada.getY()-1);
			break;
		case W:
			this.coordenada.setX(coordenada.getX()-1);
			break;
		case E:
			this.coordenada.setX(coordenada.getX()+1);
			break;
		default:
			break;
		}
		
	}
	
	private void girar(Comando comando) throws ProcessingException{
		
		switch (comando) {
		case L:
			
			switch (this.direcao) {
			case N:
				this.direcao = Direcao.W;
				break;
			case S:
				this.direcao = Direcao.E;
				break;
			case W:
				this.direcao = Direcao.S;
				break;
			case E:
				this.direcao = Direcao.N;
				break;
			default:
				throw new ProcessingException();
			}
			break;
			
		case R:
			switch (this.direcao) {
			case N:
				this.direcao = Direcao.E;
				break;
			case S:
				this.direcao = Direcao.W;
				break;
			case W:
				this.direcao = Direcao.N;
				break;
			case E:
				this.direcao = Direcao.S;
				break;
			default:
				throw new ProcessingException();
			}
			
			break;
		
		default:
			break;
		}
		
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	
}
