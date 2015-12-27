package elo7.nasa.jsf.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import elo7.nasa.entity.Sonda;
import elo7.nasa.entity.commons.Coordenada;
import elo7.nasa.entity.commons.Direcao;
import elo7.nasa.jsf.dto.EntradaDTO;
import elo7.nasa.jsf.dto.ResultadoDTO;
import elo7.nasa.processor.Processador;
import elo7.nasa.utils.ConvertUtil;

@ManagedBean
@SessionScoped
public class NasaManagedBean {
	
	private EntradaDTO entrada;
	private ResultadoDTO resultado;
	
	private Boolean resultadoRendered;

	
	public NasaManagedBean(){
		
	}
	
	@PostConstruct
	public void init(){
		limpar();
	}
	
	public Direcao[] getDirecoes(){
		return Direcao.values();
	}
	
	public void limpar(){
		
		entrada = new EntradaDTO();
		resultado = new ResultadoDTO();
		resultadoRendered = false;
		
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Limpeza de formulário concluída"));

	}
	
	public void executar(){
		try {
			Coordenada coord1 = new Coordenada(Long.parseLong(entrada.getCoordenada1X()), Long.parseLong(entrada.getCoordenada1Y()));
			Sonda sonda1 = new Sonda(ConvertUtil.converterDirecao(entrada.getCoordenada1D()), coord1);
			sonda1 = Processador.processarComandos(sonda1, ConvertUtil.converterComandosString(entrada.getComandos1()));

			Coordenada coord2 = new Coordenada(Long.parseLong(entrada.getCoordenada2X()), Long.parseLong(entrada.getCoordenada2Y()));
			Sonda sonda2 = new Sonda(ConvertUtil.converterDirecao(entrada.getCoordenada2D()), coord2);

			sonda2 = Processador.processarComandos(sonda2, ConvertUtil.converterComandosString(entrada.getComandos2()));
			List<Sonda> lista = new ArrayList<>();

			lista.add(sonda1);
			lista.add(sonda2);

			resultado.setResultado(retornarResultados(lista));
			resultadoRendered = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao executar processamento: ", e.toString()));
			resultadoRendered = false;
		}

	}
	
	private String retornarResultados(List<Sonda> lista){
		
		String resultado = "";
		for (Sonda sonda : lista) {
			resultado += sonda.getCoordenada().getX() + " " + sonda.getCoordenada().getY() + " " + String.valueOf(sonda.getDirecao()) + " \n";
		}
		
		return resultado;
	}
	
	public EntradaDTO getEntrada() {
		return entrada;
	}

	public void setEntrada(EntradaDTO entrada) {
		this.entrada = entrada;
	}

	public ResultadoDTO getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}

	public Boolean getResultadoRendered() {
		return resultadoRendered;
	}

	public void setResultadoRendered(Boolean resultadoRendered) {
		this.resultadoRendered = resultadoRendered;
	}
	
}
