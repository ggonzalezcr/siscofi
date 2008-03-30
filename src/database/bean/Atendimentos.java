package database.bean;

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

 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Bean que cont�m as estat�sticas sobre atendimento
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class Atendimentos {
	
	private List<Atendimento> listagem;

	
	/**
	 * 
	 * Cria um novo Atendimentos
	 */
	public Atendimentos() {
		listagem = new ArrayList<Atendimento>();
	}

	/**
	 * Adiciona um novo atendimento a lista de atendimentos.
	 * @param atendimento Atendimento a ser adicionado.
	 */
	public void addAtendimento(Atendimento atendimento){
		listagem.add(atendimento);
	}
	
	/**
	 * Remove um atendimento.
	 * @param atendimento Atendimento a ser removido.
	 */
	public void removeAtendimento(Atendimento atendimento){
		listagem.remove(atendimento);
	}
	
	/**
	 * Determina o atendimento na posi��o �ndice.
	 * @param indice o �ndice da posi��o do atendimento.
	 * @return um atendimento
	 */
	public Atendimento getAtendimento(int indice){
		return listagem.get(indice);
	}

	/**
	 * M�todo que determina uma lista com todos os atendimentos.
	 * @return uma lista de atendimentos
	 */
	public List<Atendimento> getListagem() {
		Collections.sort(listagem);
		return listagem;
	}

	/**
	 * Altera a lista de atendimentos.
	 * @param listagem um lista de atendimentos
	 */
	public void setListagem(List<Atendimento> listagem) {
		this.listagem = listagem;
	}
	
	@Override
	public String toString() {
		return listagem.toString();
	}
}
