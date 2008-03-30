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

import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import util.LoginLDAP;
import controller.Siscofi;
import controller.TiposLogin;
import database.LoginDAO;
import database.bean.Controle;
import database.bean.Login;
import database.bean.Solicitacao;
import forms.ChamaSenhaForm;

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
 * Classe que implementa a action ChamarSenha
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class ChamarSenhaAction extends DispatchAction implements TiposLogin{

	// Constantes
	private static final String TEM_PROXIMO = "temProximo";

	private static final String ATUAL = "atual";

	private static final String CLASSES = "classes";

	private static final String MENSAGEM = "mensagem";

	private static final String GUICHE = "guiche";

	// Atributos de classe

	/**
	 * Método responsável pela lógica de chamar um próximo eleitor
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a mesma página
	 *         "solicitacao.jsp"
	 * @throws Exception
	 */
	public ActionForward proximo(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ChamaSenhaForm formulario = ((ChamaSenhaForm) form);
		Solicitacao senha = formulario.getChamaSenha();
		Siscofi siscofi = Siscofi.getInstance();
		if (siscofi.contemIP(request.getRemoteAddr())) {
			String ultimaSenha = siscofi.chamarProximaSenha(senha.getClasse(), request.getRemoteAddr());
			if (ultimaSenha != null) {
				request.setAttribute(TEM_PROXIMO, 1);
				verificarAvaliacao(request, siscofi);
				request.setAttribute(ATUAL, ultimaSenha);
			} else {
				request.setAttribute(ATUAL, request.getParameter(ATUAL));
				request.setAttribute(TEM_PROXIMO, 0);
				request.setAttribute("mensagem",
						"Não tem mais senhas desta classe!");
			}
		} else {
			request.setAttribute("mensagem", "Sessão expirou!");
			return map.findForward("erro");
		}
		ConcurrentLinkedQueue<Controle> classes = Siscofi.getInstance().getListaControles();
		request.setAttribute(CLASSES, classes);
		return map.findForward("proximo");
	}

	/**
	 * Determina se o atendente deve encaminhar para avaliação.
	 * @param request 
	 * @param siscofi
	 */
	private void verificarAvaliacao(HttpServletRequest request, Siscofi siscofi) {
		if(siscofi.encaminharAvaliacao()){
			request.setAttribute("mensagem", "Por favor, encaminhe o eleitor para avaliar o atendimento.");
		}
		
	}

	

	/**
	 * Método responsável pela lógica de chamar o ultimo eleitor que foi chamado
	 * e ainda não compareceu ao guichê.
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a mesma página
	 *         "solicitacao.jsp"
	 * @throws Exception
	 */
	public ActionForward proximoNovamente(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String atual = request.getParameter(ATUAL);
//		ControleDAO dao = new ControleDAO();
		Siscofi siscofi = Siscofi.getInstance();
//		String guiche = getCookieValue(request.getCookies(), GUICHE, "01");
		String ip = request.getRemoteAddr();
		if (siscofi.contemIP(ip)) {
			if (atual != null && !atual.equals("")) {
				ChamaSenhaForm formulario = ((ChamaSenhaForm) form);
				Solicitacao senha = formulario.getChamaSenha();
				verificarAvaliacao(request, siscofi);
				request.setAttribute(ATUAL, atual);
				siscofi.chamarNovamente(ip, senha.getClasse(), atual);
			} else
				request.setAttribute("mensagem",
						"Não há nenhuma senha a ser chamada");
		} else {
			request.setAttribute("mensagem", "Sessão expirou!");
			return map.findForward("erro");
		}
		ConcurrentLinkedQueue<Controle> classes = Siscofi.getInstance().getListaControles();
		request.setAttribute(CLASSES, classes);
		return map.findForward("proximoNovamente");
	}
	
	/**
	 * Método responsável pela lógica de alterar o controle.
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a mesma página, porém com o controle alterado
	 * @throws Exception
	 */
	public ActionForward alterarControle(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ChamaSenhaForm formulario = ((ChamaSenhaForm) form);
		Solicitacao senha = formulario.getChamaSenha();
		Siscofi siscofi = Siscofi.getInstance(); 
		siscofi.alterarControle(request.getRemoteAddr(), senha.getClasse());
		ConcurrentLinkedQueue<Controle> classes = siscofi.getListaControles();
		request.setAttribute(CLASSES, classes);
		return map.findForward("alterarControle");
	}

	/**
	 * Método responsável pela lógica de chamar um próximo eleitor digitando uma
	 * senha que já foi chamada, mas ainda não foi atendida
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a mesma página
	 *         "solicitacao.jsp"
	 * @throws Exception
	 */
	public ActionForward chamarSenha(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

//		ControleDAO dao = new ControleDAO();
		ChamaSenhaForm formulario = ((ChamaSenhaForm) form);
		Solicitacao senha = formulario.getChamaSenha();

//		Controle c = dao.readControle(senha.getClasse());
		Siscofi siscofi = Siscofi.getInstance();
		Controle c = siscofi.getControleClasse(senha.getClasse());
		String senhaASerChamada = senha.getSenhaASerChamada();
//		String guiche = getCookieValue(request.getCookies(), GUICHE, "01");
		String ip = request.getRemoteAddr();
		if (siscofi.contemIP(ip)) {
			try {
				String prefixoTemp = (senhaASerChamada.substring(0, c
						.getPrefixo().length())).toUpperCase();

				String valorTemp = senhaASerChamada.substring(c.getPrefixo()
						.length());
				int valorT = Integer.parseInt(valorTemp);

				String prefixo = c.getPrefixo();
				int valor = c.getUltimaSenha();

				if (prefixoTemp.equals(prefixo) && valor >= valorT
						&& valorT > 0) {
					request.setAttribute(ATUAL, senhaASerChamada);
					verificarAvaliacao(request, siscofi);
					siscofi.chamarSenhaEspecifica(ip, senha.getSenhaASerChamada(), senha.getClasse());
				} else {
					request.setAttribute(ATUAL, request.getParameter(ATUAL));
					request.setAttribute(MENSAGEM, "Senha Inválida!");
				}
			} catch (Exception e) {
				request.setAttribute(ATUAL, request.getParameter(ATUAL));
				request.setAttribute(MENSAGEM, "Senha Inválida!");
			}
		} else {
			request.setAttribute("mensagem", "Sessão expirou!");
			return map.findForward("erro");
		}

		ConcurrentLinkedQueue<Controle> classes = Siscofi.getInstance().getListaControles();
		request.setAttribute(CLASSES, classes);
		return map.findForward("chamaSenha");
	}

	/**
	 * Método que encaminha a ação de ir do index.jsp para a página de
	 * autenticação, atualizando no request a lista dos tipos de guichês que
	 * existem no banco
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a página de autenticação
	 * @throws Exception
	 */
	public ActionForward encaminhaLogin(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("encaminha");
	}

	public ActionForward logout(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Siscofi siscofi = Siscofi.getInstance();
//		String guiche = getCookieValue(request.getCookies(), GUICHE, "01");
		siscofi.removeGuiche(request.getRemoteAddr());
		return map.findForward("logout");
	}

	/**
	 * Método responsável pela autenticação do usuário no sistema de chamada de
	 * senha
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a página de chamar senhas
	 * @throws Exception
	 */
	public ActionForward autentica(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Siscofi siscofi = Siscofi.getInstance();
		ChamaSenhaForm formulario = ((ChamaSenhaForm) form);
		Login login = formulario.getLogin();
		String ip = request.getRemoteAddr();
		if (siscofi.isStarted()) {
			LoginDAO logDAO = new LoginDAO();
			if(siscofi.contemGuiche(login.getGuiche())){
				if(siscofi.getIp(login.getGuiche()).equals(ip)){
					return validaLogin(map, request, login, logDAO,"", ip);
				}else{
					request.setAttribute("mensagem",
						"O número do guichê já está sendo usado por outra máquina!");
					return map.findForward("erro");
				}
				
			}
			return validaLogin(map, request, login, logDAO,"", ip);
			} else {
			request
					.setAttribute("mensagem",
							"Operação de login indisponível - Sistema não Inicializado!");
		}
		return map.findForward("erro");
	}

	private ActionForward validaLogin(ActionMapping map, HttpServletRequest 
			request, Login login, LoginDAO logDAO, String mensagem, String ip)
			throws Exception {
		Siscofi siscofi = Siscofi.getInstance();
		if(realizarLogin(siscofi, logDAO, login)){
			siscofi.addGuiche(ip, login.getGuiche(), login.getLogin());
			ConcurrentLinkedQueue<Controle> classes = siscofi.getListaControles();
			request.setAttribute(CLASSES, classes);
			request.setAttribute("mensagem", mensagem);
			return map.findForward("chamaSenha");
		} else {
			request.setAttribute("mensagem", "Login ou senha inválido!");
			return map.findForward("erro");
		}
	}

	private boolean realizarLogin(Siscofi siscofi, LoginDAO logDAO, Login login) throws Exception {
		String tipo = siscofi.getTipoLogin();
		boolean loginOK = false;
		if(tipo.equalsIgnoreCase(LOGIN_LDAP)){
			LoginLDAP l = new LoginLDAP();
			loginOK = l.login(login.getLogin(), login.getPassword());
		} else{
			loginOK = logDAO.validaLogin(login);
		}
		return loginOK;
	}
}