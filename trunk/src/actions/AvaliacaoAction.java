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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import controller.Siscofi;
import database.bean.Avaliacao;
import util.GeradorQuestionarioPDF;
import com.lowagie.text.pdf.PdfWriter;

import database.bean.Formulario;
import forms.FormularioForm;

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
 * Classe que implementa a action de avaliação do atendimento.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class AvaliacaoAction extends DispatchAction{

	/**
	 * Encaminha para a pagina de avaliação do atendimento
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de avaliação do atendimento
	 * @throws Exception
	 */
	public ActionForward encaminha(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return map.findForward("encaminha");
	}
	
	/**
	 * Encaminha para a pagina de avaliacao do atendimento
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de avaliacao
	 * @throws Exception
	 */
	public ActionForward encaminhaAvaliacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		FormularioForm formulario = ((FormularioForm) form);
		formulario.setFormulario(Formulario.getFormulario());
		request.setAttribute("formulario", Formulario.getFormulario());
		return map.findForward("encaminhaAvaliacao");
		
	}

	/**
	 * Gera um pdf do formulario
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para o pdf
	 * @throws Exception
	 */
	public ActionForward gerarPDF(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GeradorQuestionarioPDF gerador = new GeradorQuestionarioPDF();
//		response.setContentType("application/pdf");
        PdfWriter.getInstance(gerador.geraPDF(), response.getOutputStream());
		return map.findForward("gerarPDF");
	}
	
	/**
	 * Volta para a pagina principal do SISCOFI
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina do SISCOFI
	 * @throws Exception
	 */
	public  ActionForward voltar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return map.findForward("voltar");
	}
	
	/**
	 * Metodo que salva a avaliacao de atendimento a partir do formulario
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina do formulario
	 * @throws Exception
	 */
	public  ActionForward salvaAvaliacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		FormularioForm formulario = ((FormularioForm) form);
		Formulario fBean = formulario.getFormulario();
		Avaliacao avaliacao = fBean.geraAvaliacao();
		try {
			Siscofi siscofi = Siscofi.getInstance();
			siscofi.salvaAvaliacao(avaliacao);
		} catch (ServletException e) {
			request.setAttribute("mensagem", "Há um problema com a conexão do banco de dados!");
			return map.findForward("encaminha");
		}
		formulario.setFormulario(Formulario.getFormulario());
		request.setAttribute("formulario", Formulario.getFormulario());
		request.setAttribute("mensagem", "Avaliação salva com sucesso!");
		return map.findForward("salva");
	}
}
