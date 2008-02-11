package forms;

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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import database.bean.Controle;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Classe que representa um Form para criação de novas classes de atendimento
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
	 * Método que determina o controle da classe.
	 * 
	 * @return the controle
	 */
	public Controle getControle() {
		return controle;
	}

	/**
	 * Método que redefine o controle dessa classe.
	 * 
	 * @param controle
	 *            the controle to set
	 */
	public void setControle(Controle controle) {
		this.controle = controle;
	}

	/**
	 * Método que define se uma String é vazia ou não
	 * 
	 * @param valor
	 *            String a ser analisada
	 * @return True se for vazia ou false, caso contrário
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
