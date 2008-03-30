package actions;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import controller.Siscofi;
import database.bean.Conexao;
import forms.ConfiguracaoBDForm;

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
 * Classe que implementa a action para gerenciar o banco de dados.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class AdminBDAction extends DispatchAction{
	

	/**
	 * M�todo que encaminha para a pagina de administracao
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de administracao
	 * @throws Exception
	 */
	public ActionForward voltarAdmin(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltarAdmin");
	}

	/**
	 * M�todo que encaminha para a pagina de administracao do Banco de dados
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de administracao do Banco de dados
	 * @throws Exception
	 */
	public ActionForward voltar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltar");
	}

	/**
	 * Encaminha para a p�gina de altera��o das configura��es do banco de dados 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward encaminhaConfig(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ConfiguracaoBDForm formulario = ((ConfiguracaoBDForm) form);
		formulario.setConexao(Conexao.getConexao());
		return map.findForward("encaminhaConfig");
	}
	
	/**
	 * Encaminha para a p�gina de administracao do banco de dados 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward encaminhaAdmin(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("encaminhaAdmin");
	}
	
	/**
	 * M�todo que reinicia o banco de dados
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Encaminha para a mesma pagina de administra��o
	 * @throws Exception
	 */
	public ActionForward resetDB(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Siscofi siscofi = Siscofi.getInstance();
		siscofi.resetBD();
		request.setAttribute("OK", "O banco de dados foi reiniciado!");
		return map.findForward("reset");
	}

	/**
	 * Altera as configura��o do banco de dados
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Encaminha para a p�gina de testa da conex�o
	 * @throws Exception
	 */
	public ActionForward alteraConfig(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ConfiguracaoBDForm formulario = ((ConfiguracaoBDForm) form);
		Siscofi siscofi = Siscofi.getInstance();
		siscofi.alterarConfigBD(formulario.getConexao());
		request.setAttribute("OK", "Altera��es salvas com sucesso!");
		return map.findForward("alteraConfig");
	}
	
	/**
	 * Testa a conex�o que sofreu altera��o
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Encaminha para a pagina de teste da conex�o dando uma mensagem
	 * de �xito ou fracasso.
	 * @throws Exception
	 */
	public ActionForward testaConexao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Siscofi siscofi = Siscofi.getInstance();
		ConfiguracaoBDForm formulario = ((ConfiguracaoBDForm) form);
		formulario.setConexao(Conexao.getConexao());
		try{
			siscofi.testaConexaoBD();
		}catch (Exception e) {
			request.setAttribute("Falha", "A conex�o falhou!");
			return map.findForward("testaConexao");			
		}
		request.setAttribute("OK", "A conex�o est� OK!");
		return map.findForward("testaConexao");
	}
	

}
