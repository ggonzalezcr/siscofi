package database.bean;

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

 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Bean que contém as estatísticas sobre atendimento
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
	 * Determina o atendimento na posição índice.
	 * @param indice o índice da posição do atendimento.
	 * @return um atendimento
	 */
	public Atendimento getAtendimento(int indice){
		return listagem.get(indice);
	}

	/**
	 * Método que determina uma lista com todos os atendimentos.
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
