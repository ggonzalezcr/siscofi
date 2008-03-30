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
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que implementa a action de avalia��o do atendimento.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class AvaliacaoAction extends DispatchAction{

	/**
	 * Encaminha para a pagina de avalia��o do atendimento
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de avalia��o do atendimento
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
			request.setAttribute("mensagem", "H� um problema com a conex�o do banco de dados!");
			return map.findForward("encaminha");
		}
		formulario.setFormulario(Formulario.getFormulario());
		request.setAttribute("formulario", Formulario.getFormulario());
		request.setAttribute("mensagem", "Avalia��o salva com sucesso!");
		return map.findForward("salva");
	}
}
