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

import util.Impressao;
import util.LoginLDAP;
import controller.Siscofi;
import controller.TiposLogin;
import database.LoginDAO;
import database.bean.Controle;
import database.bean.Emissao;
import database.bean.Login;
import forms.EmissaoForm;

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

//Classe que implementa a action EmiteSenha
/**
 * Action resposável pela emissão de uma senha.
 *
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
		
public class EmiteSenhaAction extends DispatchAction implements TiposLogin {

	private static final String CLASSES = "classes";


	/**
	 * Método responsável pela lógica da emissão de senha
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a mesma página "emitirSenha.jsp"
	 * @throws Exception
	 */
	public ActionForward emiteSenha(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmissaoForm formulario = ((EmissaoForm) form);
		Emissao emissao = null;
		try{
			emissao = formulario.getEmissao();
			if(emissao.getTotal() < 1 || emissao.getTotal() > 500){
				return map.findForward("erroEmissao");
			}
		}catch(Exception e){
			return map.findForward("erroEmissao");
		}
		Siscofi siscofi = Siscofi.getInstance();
		Controle controle = siscofi.getControleClasse(emissao.getClasse());
		Impressao impressao = new Impressao();
		controle = impressao.setPrint(emissao.getTotal(), emissao.getClasse(), controle);
		siscofi.emiteSenha(controle);
		formulario.reset();
		formulario.setEmissao(emissao);
		ConcurrentLinkedQueue<Controle> classes = siscofi.getListaControles();
		request.setAttribute(CLASSES, classes);
		return map.findForward("emiteSenha");
	}
	
	
	/**
	 * Método que encaminha a ação de ir do index.jsp para emitirSenha.jsp,
	 * atualizando no request a lista dos tipos de guichês que existem no banco
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado o index.jsp para emitirSenha.jsp
	 * @throws Exception
	 */
	public ActionForward listaClasses(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Siscofi siscofi = Siscofi.getInstance(); 
		ConcurrentLinkedQueue<Controle> classes = siscofi.getListaControles();
		request.setAttribute(CLASSES, classes);
		return map.findForward("listaClasses");
	}

	/**
	 * Método responsável pela autentição do usuário no sistema
	 * de emissão de senha
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
		if(siscofi.isStarted()){
			EmissaoForm formulario = ((EmissaoForm) form);
			Login login = formulario.getLogin();
			if(realizarLogin(siscofi,login)){
				ConcurrentLinkedQueue<Controle> classes = siscofi.getListaControles();
				request.setAttribute(CLASSES, classes);		
				return map.findForward("emiteSenha");			
			}else{
				request.setAttribute("mensagem", "Login ou senha inválido!");
				return map.findForward("erro");
			}
		}
		request.setAttribute("mensagem", "Operação de login indisponível - Sistema não Inicializado!");
		return map.findForward("erro");
	}

	/**
	 * Realiza o login de acordo com o tipo configurado no sistema.
	 * @param siscofi Instância do sistema
	 * @param login Login recebido pelo sistema a ser realizado.
	 * @return  TRUE se o login for realizado com sucesso e FALSE em caso contrário.
	 * @throws Exception Lançada se o login ou senha possuírem caracteres inválidos.
	 */
	private boolean realizarLogin(Siscofi siscofi, Login login) throws Exception {
		String tipo = siscofi.getTipoLogin();
		boolean loginOK = false;
		if(tipo.equalsIgnoreCase(LOGIN_LDAP)){
			LoginLDAP l = new LoginLDAP();
			loginOK = l.login(login.getLogin(), login.getPassword());
		} else{
			LoginDAO logDAO = new LoginDAO();
			loginOK = logDAO.validaLogin(login);
		}
		return loginOK;
	}

}

