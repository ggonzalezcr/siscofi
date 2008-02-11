package forms;

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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import database.bean.Controle;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Classe que representa um Form para cria��o de novas classes de atendimento
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class ClasseForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5083365856482660718L;

	private Controle controle = new Controle();
	private String classe;

	/**
	 * Retorna o valor do atributo classe
	 * @return o valor do atributo classe
	 */
	public String getClasse() {
		classe = controle.getClasse();
		return classe;
	}

	/**
	 * Altera o valor do atributo classe
	 * @param classe O novo valor do atributo classe 
	 */
	public void setClasse(String classe) {
		this.classe = classe;
		this.controle.setClasse(classe);
	}

	/**
	 * M�todo que determina o controle da classe.
	 * 
	 * @return the controle
	 */
	public Controle getControle() {
		return controle;
	}

	/**
	 * M�todo que redefine o controle dessa classe.
	 * 
	 * @param controle
	 *            the controle to set
	 */
	public void setControle(Controle controle) {
		this.controle = controle;
	}

	/**
	 * M�todo que define se uma String � vazia ou n�o
	 * 
	 * @param valor
	 *            String a ser analisada
	 * @return True se for vazia ou false, caso contr�rio
	 */
	private boolean stringVazia(String valor) {
		return valor == null || valor.trim().length() == 0;
	}

	public ActionErrors validate(ActionMapping map, HttpServletRequest req) {
		ActionErrors erros = new ActionErrors();
		// verifica o nome da classe
		if (stringVazia(controle.getClasse())) {
			erros.add("nome da classe", new ActionMessage("erro.classe"));
		}
		// verifica a cor da classe
		if (stringVazia(controle.getCor())) {
			erros.add("cor", new ActionMessage("erro.cor"));
		}
		// verifica o prefixo da classe
		if (stringVazia(controle.getPrefixo())) {
			erros.add("prefixo", new ActionMessage("erro.prefixo"));
		}
		// verifica a quantidade inicial
		if (stringVazia(controle.getQuantidadeInicial() + "")) {
			erros.add("QuantidadeInicial", new ActionMessage(
					"erro.QuantidadeInicial"));
		}
		return erros;
	}
}
