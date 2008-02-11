package estatisticas.avaliacao;

/**
 * Este arquivo é parte do programa Siscofi
 *
 * Siscofi é um software livre; você pode redistribui-lo e/ou
 * modificá-lo dentro dos termos da Licença Pública Geral GNU como
 * publicada pela Fundação do Software Livre (FSF); na versão 3 da
 * Licença.
 *
 * Este programa é distribuído na esperança que possa ser útil,
 * mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÂO a qualquer
 * MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
 * Licença Pública Geral GNU para maiores detalhes.
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
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


import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CollectionOfElements;

@Entity
public class EstatisticaResposta {

	//ìndice da pergunta
	private int numPergunta;
	//Texto da pergunta
	private String pergunta = new String();
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Estatisticas estatisticas;
	
	//Mapeamento da alternativa para a quantidade de vezes que a mesma foi respondida
	@CollectionOfElements(fetch=FetchType.EAGER)
	@JoinTable(name="contagemAlternativas", joinColumns=@JoinColumn(name="id_resposta"))
	@Column(name="contagemAlternativa")
	private Map<Integer, Integer> contagemAlternativa = new HashMap<Integer, Integer>();
	
	@Id @GeneratedValue
	private int id;
	
	//inicializa o mapa com o valor inicial zero para cada contagem 
	public EstatisticaResposta(){
		for(int i =1 ; i<=5 ;i++){
			contagemAlternativa.put(i, 0);
		}
	}
	
	/**
	 * Incrementa em uma unidade a contagem de uma alternativa
	 * @param alternativa O número da alternativa a ser incrementada.
	 */
	public void incrementaAlternativa(int alternativa) {
		int contagem = contagemAlternativa.get(alternativa) + 1;
		contagemAlternativa.put(alternativa, contagem);
	}
	
	/**
	 * Atualiza o valor da alternativa que eh passada como parametro
	 * @param alternativa A alternativa a ser atualizada
	 * @param valor O valor a ser incrementado na alternativa
	 */
	public void incrementaAlternativa(int alternativa, int valor){
		int contagem = contagemAlternativa.get(alternativa) + valor;
		contagemAlternativa.put(alternativa, contagem);		
	}
	
	/**
	 * Recupera o valor da contagem da alternativa passada como parametro 
	 * @param alternativa O alternativa a ser pesquisada
	 * @return O valor da contagem da alternativa passada como parametro
	 */
	public int getValorAlternativa(int alternativa){
		return contagemAlternativa.get(alternativa);
	}

	/**
	 * Determina um mapa que mapea a alternativa para a contagem de vez que a alternativa foi respondida.
	 * @return um mapa com a contagem das alternativas.
	 */
	public Map<Integer, Integer> getContagemAlternativa() {
		return contagemAlternativa;
	}

	/**
	 * Altera o valor de contagem das alternativas.
	 * @param contagemAlternativa Um novo mapa com a contagem.
	 */
	public void setContagemAlternativa(Map<Integer, Integer> contagemAlternativa) {
		this.contagemAlternativa = contagemAlternativa;
	}

	/**
	 * Determina a qual estatistica esta resposta esta associada.
	 * @return o valor de estatisticas.
	 */
	public Estatisticas getEstatisticas() {
		return estatisticas;
	}

	/**
	 * Altera a estatistica a qual esta resposta está associada.
	 * @param estatisticas nova estatisticas.
	 */
	public void setEstatisticas(Estatisticas estatisticas) {
		this.estatisticas = estatisticas;
	}

	/**
	 * Determina o id que é chave primária deste objeto no banco de dados.
	 * @return o valor de id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Altera o valor do id do objeto.
	 * @param id novo valor do id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Determina o número da pergunta.
	 * @return o número da pergunta.
	 */
	public int getNumPergunta() {
		return numPergunta;
	}

	/**
	 * Altera o número da pergunta.
	 * @param numPergunta novo valor do número da pergunta.
	 */
	public void setNumPergunta(int numPergunta) {
		this.numPergunta = numPergunta;
	}

	/**
	 * Determina o texto da pergunta.
	 * @return o texto da pergunta.
	 */
	public String getPergunta() {
		return pergunta;
	}

	/**
	 * Altera texto da pergunta.
	 * @param pergunta novo texto da pergunta.
	 */
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
}
