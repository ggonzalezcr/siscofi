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

import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import util.Cor;
import controller.Siscofi;
import database.bean.Controle;
import exceptions.NotFoundInDBException;
import forms.ClasseForm;

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
 * Classe que implementa a action Administrar classes.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class AdministrarClassesAction extends DispatchAction {


	/**
	 * M�todo respons�vel criar uma classe de atendimento
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a "adminClasses.jsp"
	 * @throws Exception
	 */
	public ActionForward criarClasse(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ClasseForm formulario = ((ClasseForm) form);
		Controle controle = formulario.getControle();
		Siscofi siscofi = Siscofi.getInstance();
		try {
			siscofi.createClasse(controle.getClasse(), controle.getPrefixo(),
					controle.getCor(), controle.getQuantidadeInicial());
		} catch (ServletException e) {
			request.setAttribute("mensagem","H� um problema com a conex�o do banco de dados!");
			return map.findForward("criarClasse");			
		}
		request.setAttribute("mensagem","Classe criada com sucesso!");
		return map.findForward("criarClasse");
	}

	/**
	 * M�todo respons�vel alterar uma classe de atendimento
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a "listagem.jsp"
	 * @throws Exception
	 */
	public ActionForward alterarClasse(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ClasseForm formulario = ((ClasseForm) form);
		Controle controle = formulario.getControle();
		Siscofi siscofi = Siscofi.getInstance();
		try {
			siscofi.alterarClasse(controle.getClasse(), controle.getPrefixo(),
					controle.getCor(), controle.getQuantidadeInicial());
		} catch (NotFoundInDBException e) {
			request
					.setAttribute("mensagem",
							"Erro: A classe n�o pode ser alterada porque n�o existe no banco de dados!");
			return map.findForward("criarClasse");			
		} catch (ServletException e) {
			request.setAttribute("mensagem","H� um problema com a conex�o do banco de dados!");
			return map.findForward("criarClasse");			
		}
		request.setAttribute("mensagem","Altera��o realizada com sucesso");
		List<String> classes = siscofi.getListaClasses();
		request.setAttribute("classes", classes);
		return map.findForward("alterarClasse");
	}
	

	/**
	 * M�todo respons�vel remover uma classe de atendimento
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a "listagem.jsp"
	 * @throws Exception
	 */
	public ActionForward removerClasse(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ClasseForm formulario = ((ClasseForm) form);
		Controle controle = formulario.getControle();
		Siscofi siscofi = Siscofi.getInstance();
		try {
			siscofi.removerClasse(controle.getClasse());
			request.setAttribute("mensagem","Exclus�o realizada com sucesso");
		} catch (NotFoundInDBException e) {
			request
					.setAttribute("mensagem",
							"Erro: A classe n�o pode ser exclu�da porque n�o existe no banco de dados!");
		}
		List<String> classes = siscofi.getListaClasses();
		request.setAttribute("classes", classes);
		return map.findForward("removerClasse");
	}

	/**
	 * M�todo respons�vel listar as classes de atendimento
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a "listagem.jsp"
	 * @throws Exception
	 */
	public ActionForward listarClasse(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		Siscofi siscofi = Siscofi.getInstance();
		List<String> classes = null;
		try{
			classes = siscofi.getListaClasses();
		}catch (Exception e) {
			request.setAttribute("mensagem","H� um problema com a conex�o do banco de dados!");
			return map.findForward("criarClasse");			
		}
		request.setAttribute("classes", classes);
		return map.findForward("listarClasses");
	}

	/**
	 * M�todo respons�vel listar as cores dispon�veis e encaminhar para a
	 * cria��o de classes de atendimento
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a "criarClasse.jsp"
	 * @throws Exception
	 */
	public ActionForward encaminhaCriacaoClasse(ActionMapping map,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Set<Cor> cores = Cor.getCoresDisponiveis();
		request.setAttribute("cores", cores);
		return map.findForward("encaminhaCriacaoClasse");
	}
	
	/**
	 * M�todo respons�vel exibir os dados da classe a ser editada.
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para "editarClasse.jsp"
	 * @throws Exception
	 */
	public ActionForward editarClasse(ActionMapping map,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ClasseForm formulario = ((ClasseForm) form);
		Controle controle = formulario.getControle();
		Siscofi siscofi = Siscofi.getInstance();
		String classe = controle.getClasse();
		Controle controleLido = siscofi.getControleClasse(classe);
		formulario.setControle(controleLido);
		Set<Cor> cores = Cor.getCoresDisponiveis();
		request.setAttribute("cores", cores);
		return map.findForward("editarClasse");
	}

	/**
	 * M�todo respons�vel cancelar uma opera��o
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para "adminClasses.jsp"
	 * @throws Exception
	 */
	public ActionForward cancelar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("cancelar");
	}
	
	/**
	 * Voltar para a p�gina de administra��o do sistema
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para "adminClasses.jsp"
	 * @throws Exception
	 */
	public ActionForward voltar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltar");
	}
	
	
	/**
	 * M�todo respons�vel por encaminhar para a administra��o de classes
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para "adminClasses.jsp"
	 * @throws Exception
	 */
	public ActionForward adminClasses(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("adminClasses");
	}
}