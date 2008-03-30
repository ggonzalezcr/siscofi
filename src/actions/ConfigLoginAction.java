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
import controller.TiposLogin;
import forms.ConfigLoginForm;

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
 * Classe que implementa a action configura o tipo de login do sistema.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class ConfigLoginAction extends DispatchAction{
	

	/**
	 * M�todo que encaminha para a pagina de administracao.
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de configura��o de tipo de login.
	 * @throws Exception
	 */
	public ActionForward encaminharConfig(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("tipos", TiposLogin.tiposLogin);
		request.setAttribute("tipoAtual", Siscofi.getInstance().getTipoLogin());
		return map.findForward("encaminharConfig");
	}

	/**
	 * M�todo que encaminha para a pagina de administracao do Banco de dados
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de administracao.
	 * @throws Exception
	 */
	public ActionForward voltar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltar");
	}

	/**
	 * Encaminha para a p�gina de altera��o das configura��es do tipo de login. 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de configura��o de tipo de login.
	 * @throws Exception
	 */
	public ActionForward alterarConfig(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ConfigLoginForm f = (ConfigLoginForm) form;
		Siscofi.getInstance().setTipoLogin(f.getTipoLogin());
		request.setAttribute("tipoAtual", Siscofi.getInstance().getTipoLogin());
		request.setAttribute("tipos", TiposLogin.tiposLogin);
		request.setAttribute("mensagem", "Altera��o realizada com sucesso");
		return map.findForward("alterarConfig");
	}
	
}
