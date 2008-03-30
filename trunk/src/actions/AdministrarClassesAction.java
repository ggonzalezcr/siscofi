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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
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
	 * Método responsável criar uma classe de atendimento
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
			request.setAttribute("mensagem","Há um problema com a conexão do banco de dados!");
			return map.findForward("criarClasse");			
		}
		request.setAttribute("mensagem","Classe criada com sucesso!");
		return map.findForward("criarClasse");
	}

	/**
	 * Método responsável alterar uma classe de atendimento
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
							"Erro: A classe não pode ser alterada porque não existe no banco de dados!");
			return map.findForward("criarClasse");			
		} catch (ServletException e) {
			request.setAttribute("mensagem","Há um problema com a conexão do banco de dados!");
			return map.findForward("criarClasse");			
		}
		request.setAttribute("mensagem","Alteração realizada com sucesso");
		List<String> classes = siscofi.getListaClasses();
		request.setAttribute("classes", classes);
		return map.findForward("alterarClasse");
	}
	

	/**
	 * Método responsável remover uma classe de atendimento
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
			request.setAttribute("mensagem","Exclusão realizada com sucesso");
		} catch (NotFoundInDBException e) {
			request
					.setAttribute("mensagem",
							"Erro: A classe não pode ser excluída porque não existe no banco de dados!");
		}
		List<String> classes = siscofi.getListaClasses();
		request.setAttribute("classes", classes);
		return map.findForward("removerClasse");
	}

	/**
	 * Método responsável listar as classes de atendimento
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
			request.setAttribute("mensagem","Há um problema com a conexão do banco de dados!");
			return map.findForward("criarClasse");			
		}
		request.setAttribute("classes", classes);
		return map.findForward("listarClasses");
	}

	/**
	 * Método responsável listar as cores disponíveis e encaminhar para a
	 * criação de classes de atendimento
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
	 * Método responsável exibir os dados da classe a ser editada.
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
	 * Método responsável cancelar uma operação
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
	 * Voltar para a página de administração do sistema
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
	 * Método responsável por encaminhar para a administração de classes
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