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
import controller.TiposLogin;
import forms.ConfigLoginForm;

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
	 * Método que encaminha para a pagina de administracao.
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de configuração de tipo de login.
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
	 * Método que encaminha para a pagina de administracao do Banco de dados
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
	 * Encaminha para a página de alteração das configurações do tipo de login. 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de configuração de tipo de login.
	 * @throws Exception
	 */
	public ActionForward alterarConfig(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ConfigLoginForm f = (ConfigLoginForm) form;
		Siscofi.getInstance().setTipoLogin(f.getTipoLogin());
		request.setAttribute("tipoAtual", Siscofi.getInstance().getTipoLogin());
		request.setAttribute("tipos", TiposLogin.tiposLogin);
		request.setAttribute("mensagem", "Alteração realizada com sucesso");
		return map.findForward("alterarConfig");
	}
	
}
