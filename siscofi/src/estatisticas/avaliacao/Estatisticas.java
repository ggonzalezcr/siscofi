package estatisticas.avaliacao;

/**
 * Este arquivo � parte do programa Siscofi
 *
 * Siscofi � um software livre; voc� pode redistribui-lo e/ou
 * modific�-lo dentro dos termos da Licen�a P�blica Geral GNU como
 * publicada pela Funda��o do Software Livre (FSF); na vers�o 3 da
 * Licen�a.
 *
 * Este programa � distribu�do na esperan�a que possa ser �til,
 * mas SEM NENHUMA GARANTIA; sem uma garantia impl�cita de ADEQUA��O a qualquer
 * MERCADO ou APLICA��O EM PARTICULAR. Veja a
 * Licen�a P�blica Geral GNU para maiores detalhes.
 *
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 2
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que armazena a contagem de respostas para cada alternativa de uma pergunta objetiva.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.1
 */

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionOfElements;

import util.DataUtil;
import database.bean.Avaliacao;
import database.bean.Formulario;

@Entity
public class Estatisticas {
	
	//Mapeamento do n�mero da pergunta objetiva para suas estat�sticas
	@CollectionOfElements(fetch = FetchType.EAGER)
	@JoinTable(name="mapaEstatisticaResposta", joinColumns=@JoinColumn(name="estatisticas_resposta"))
	@Column(name="resposta")
	private Map<Integer, EstatisticaResposta> mapaEstatisticaResposta;
	
	//Chave prim�ria
	@Id
	private Date data;
	
	//Total de avalia��es analisadas. 
	private int contagem;
	
	//Conjuntos de respostas da pergunta subjetiva 06
	@CollectionOfElements(fetch = FetchType.EAGER)
	@JoinTable(name="estatisticas_respostas06", joinColumns=@JoinColumn(name="estatisticas_data"))
	@Column(name="resposta06" , nullable = true, length = 8192)
	Set<String> respostas06 = new HashSet<String>();
	
	//Conjuntos de respostas da pergunta subjetiva 07
	@CollectionOfElements(fetch = FetchType.EAGER)
	@JoinTable(name="estatisticas_respostas07", joinColumns=@JoinColumn(name="estatisticas_data"))
	@Column(name="resposta07", nullable = true, length = 8192)
	Set<String> respostas07 = new HashSet<String>();
	
	/**
	 * 
	 * Cria uma nova Estatisticas.
	 */
	public Estatisticas(){
		data = DataUtil.getDataAtual();
		mapaEstatisticaResposta = new HashMap<Integer, EstatisticaResposta>();
	}

	
	
	/**
	 * Determina a contagem de avalia��es analisadas na estat�stica.
	 * @return Total de avalia��es.
	 */
	public int getContagem() {
		return contagem;
	}



	/**
	 * Altera o valor da contagem de avalia��es.
	 * @param contagem novo valor da contagem.
	 */
	public void setContagem(int contagem) {
		this.contagem = contagem;
	}

	/**
	 * Determina A data da estat�stica.
	 * @return a data.
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Altera a data da estat�stica.
	 * @param data nova data.
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Determina um mapa de EstatisticasResposta.
	 * @return mapa de mapaEstatisticasResposta.
	 */
	public Map<Integer, EstatisticaResposta> getMapaEstatisticaResposta() {
		return mapaEstatisticaResposta;
	}

	/**
	 * Altera o mapa de EstatisticasResposta.
	 * @param mapaEstatisticaResposta novo mapa de EstatisticasResposta.
	 */
	public void setMapaEstatisticaResposta(Map<Integer, EstatisticaResposta> listaResposta) {
		this.mapaEstatisticaResposta = listaResposta;
	}

	/**
	 * Adiciona uma estat�stica resposta ao mapa.
	 * @param indice N�mero da pergunta.
	 * @param est Estat�sticaResposta da pergunta.
	 */
	public void addEstatistica(int indice, EstatisticaResposta est){
		this.mapaEstatisticaResposta.put(indice, est);
	}

	/**
	 * Analisa um lista de avalia��es.
	 * @param listaAvaliacao Lista de avalia��es a serem analisadas.
	 */
	public void geraEstatistica(List<Avaliacao> listaAvaliacao){
		Formulario formulario = Formulario.getFormulario();
		Map<Integer, EstatisticaResposta> respostas = gerarMapaEstatisticasRespostas(formulario);
			
		int alternativa;
		for(Avaliacao av : listaAvaliacao){
			for(int i = 1; i <= 5; i++){
				EstatisticaResposta er = respostas.get(i-1);
				alternativa = Integer.parseInt(av.getResposta(i));
				er.incrementaAlternativa(alternativa);
			}
			respostas06.add(av.getResposta6());
			respostas07.add(av.getResposta7());
		}
		this.setMapaEstatisticaResposta(respostas);
		contagem = listaAvaliacao.size();

	}
	
	/**
	 * Contabiliza estat�sticas a partir de uma lista de estat�sticas.
	 * @param estatisticas Lista de estatisticas a serem contabilizadas.
	 * @return Uma estatistica contendo a informa��o de todas as estatisticas
	 * da lista passada como par�metro.
	 */
	public void contabilizaEstatisticas(List<Estatisticas> estatisticas){
		int contador = 0;
		Formulario formulario = Formulario.getFormulario();
		Map<Integer, EstatisticaResposta> respostas = gerarMapaEstatisticasRespostas(formulario);
		
		//Realiza a contagem das respostas
		Map<Integer, EstatisticaResposta> respostasdoBD = null;
		for(Estatisticas est:estatisticas){
			respostasdoBD = est.getMapaEstatisticaResposta();
			for(int i = 0; i < 5; i++){
				EstatisticaResposta er = respostas.get(i);
				for(int k = 1; k <= 5; k++){
					int valor = respostasdoBD.get(i).getValorAlternativa(k);
					er.incrementaAlternativa(k, valor);					
				}
			}
			contador += est.getContagem();
			respostas06.addAll(est.getRespostas06());
			respostas07.addAll(est.getRespostas07());
		}
		setMapaEstatisticaResposta(respostas); 
		setContagem(contador);
	}

	/**
	 * Cria um mapa que cont�m cinco novas Estat�sticasRespostas.
	 * @param formulario Formul�rio que cont�m as perguntas as cinco perguntas correspondentes as cinco estat�sticas.
	 * @return Mapa de Estat�sticasRespostas.
	 */
	private Map<Integer, EstatisticaResposta> gerarMapaEstatisticasRespostas(Formulario formulario) {
		Map<Integer, EstatisticaResposta> respostas = new HashMap<Integer, EstatisticaResposta>();
		for(int i = 1; i <= 5; i++){
			respostas.put(i - 1, new EstatisticaResposta());
			EstatisticaResposta er = respostas.get(i-1);
			er.setEstatisticas(this);
			er.setNumPergunta(i);
			er.setPergunta(formulario.getQuestao(i));
		}
		return respostas;
	}
	
	/**
	 * Determina uma string que representa o objeto.
	 * @return String que determina o objeto.
	 */
	public String toString() {
		return "Data: " + data + " Contagem: " + contagem;
	}

	/**
	 * Determina o conjunto de respostas para a pergunta 06.
	 * @return Comjunto de respostas.
	 */
	public Set<String> getRespostas06() {
		return respostas06;
	}


	/**
	 * Altera o conjunto de resposta para a pergunta 06.
	 * @param respostas06 Novo conjunto de Respostas.
	 */
	public void setRespostas06(Set<String> respostas06) {
		this.respostas06.addAll(respostas06);
	}


	/**
	 * Determina o conjunto de respostas para a pergunta 07.
	 * @return Comjunto de respostas.
	 */
	public Set<String> getRespostas07() {
		return respostas07;
	}


	/**
	 * Altera o conjunto de resposta para a pergunta 07.
	 * @param respostas06 Novo conjunto de Respostas.
	 */
	public void setRespostas07(Set<String> respostas07) {
		this.respostas07.addAll(respostas07);
	}
	
}
