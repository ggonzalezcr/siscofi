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
	
	//Mapeamento do número da pergunta objetiva para suas estatísticas
	@CollectionOfElements(fetch = FetchType.EAGER)
	@JoinTable(name="mapaEstatisticaResposta", joinColumns=@JoinColumn(name="estatisticas_resposta"))
	@Column(name="resposta")
	private Map<Integer, EstatisticaResposta> mapaEstatisticaResposta;
	
	//Chave primária
	@Id
	private Date data;
	
	//Total de avaliações analisadas. 
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
	 * Determina a contagem de avaliações analisadas na estatística.
	 * @return Total de avaliações.
	 */
	public int getContagem() {
		return contagem;
	}



	/**
	 * Altera o valor da contagem de avaliações.
	 * @param contagem novo valor da contagem.
	 */
	public void setContagem(int contagem) {
		this.contagem = contagem;
	}

	/**
	 * Determina A data da estatística.
	 * @return a data.
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Altera a data da estatística.
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
	 * Adiciona uma estatística resposta ao mapa.
	 * @param indice Número da pergunta.
	 * @param est EstatísticaResposta da pergunta.
	 */
	public void addEstatistica(int indice, EstatisticaResposta est){
		this.mapaEstatisticaResposta.put(indice, est);
	}

	/**
	 * Analisa um lista de avaliações.
	 * @param listaAvaliacao Lista de avaliações a serem analisadas.
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
	 * Contabiliza estatísticas a partir de uma lista de estatísticas.
	 * @param estatisticas Lista de estatisticas a serem contabilizadas.
	 * @return Uma estatistica contendo a informação de todas as estatisticas
	 * da lista passada como parâmetro.
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
	 * Cria um mapa que contém cinco novas EstatísticasRespostas.
	 * @param formulario Formulário que contém as perguntas as cinco perguntas correspondentes as cinco estatísticas.
	 * @return Mapa de EstatísticasRespostas.
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
