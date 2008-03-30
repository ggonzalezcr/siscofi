package actions;

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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
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
	 * Método que encaminha para a pagina de administracao
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
	 * Método que encaminha para a pagina de administracao do Banco de dados
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
	 * Encaminha para a página de alteração das configurações do banco de dados 
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
	 * Encaminha para a página de administracao do banco de dados 
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
	 * Método que reinicia o banco de dados
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Encaminha para a mesma pagina de administração
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
	 * Altera as configuração do banco de dados
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Encaminha para a página de testa da conexão
	 * @throws Exception
	 */
	public ActionForward alteraConfig(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ConfiguracaoBDForm formulario = ((ConfiguracaoBDForm) form);
		Siscofi siscofi = Siscofi.getInstance();
		siscofi.alterarConfigBD(formulario.getConexao());
		request.setAttribute("OK", "Alterações salvas com sucesso!");
		return map.findForward("alteraConfig");
	}
	
	/**
	 * Testa a conexão que sofreu alteração
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Encaminha para a pagina de teste da conexão dando uma mensagem
	 * de êxito ou fracasso.
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
			request.setAttribute("Falha", "A conexão falhou!");
			return map.findForward("testaConexao");			
		}
		request.setAttribute("OK", "A conexão está OK!");
		return map.findForward("testaConexao");
	}
	

}
