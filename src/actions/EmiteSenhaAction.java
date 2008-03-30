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
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

//Classe que implementa a action EmiteSenha
/**
 * Action respos�vel pela emiss�o de uma senha.
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
	 * M�todo respons�vel pela l�gica da emiss�o de senha
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a mesma p�gina "emitirSenha.jsp"
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
	 * M�todo que encaminha a a��o de ir do index.jsp para emitirSenha.jsp,
	 * atualizando no request a lista dos tipos de guich�s que existem no banco
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
	 * M�todo respons�vel pela autenti��o do usu�rio no sistema
	 * de emiss�o de senha
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a p�gina de chamar senhas
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
				request.setAttribute("mensagem", "Login ou senha inv�lido!");
				return map.findForward("erro");
			}
		}
		request.setAttribute("mensagem", "Opera��o de login indispon�vel - Sistema n�o Inicializado!");
		return map.findForward("erro");
	}

	/**
	 * Realiza o login de acordo com o tipo configurado no sistema.
	 * @param siscofi Inst�ncia do sistema
	 * @param login Login recebido pelo sistema a ser realizado.
	 * @return  TRUE se o login for realizado com sucesso e FALSE em caso contr�rio.
	 * @throws Exception Lan�ada se o login ou senha possu�rem caracteres inv�lidos.
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

