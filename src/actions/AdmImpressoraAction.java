
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

import util.Impressao;
import controller.Siscofi;

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
 * Classe que implementa a action Administrar Impressora.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class AdmImpressoraAction extends DispatchAction{
	
	/**
	 * Lista todas as impressoras do sistema e coloca no request
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina da sele��o de impressoras
	 * @throws Exception
	 */
	public ActionForward listaImpressoras(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Impressao impressao = new Impressao();
		request.setAttribute("ListaDeImpressoras", impressao.listaImpressoras());
		return map.findForward("selecionaImpressora");
	}
	
	/**
	 * Pega a impressora selecionada e grava no arquivo de configura��o
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de teste da impressao
	 * @throws Exception
	 */
	public ActionForward selecionaImpressora(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String nomeImpressora = (String) request.getParameter("impressora");
		Siscofi siscofi = Siscofi.getInstance();
		siscofi.setNomeImpressora(nomeImpressora);
		request.setAttribute("impressora", nomeImpressora);
		return map.findForward("testeDeImpressao");
	}
	
	/**
	 * Imprime uma senha de teste
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a p�gina de teste novamente
	 * @throws Exception
	 */
	public ActionForward imprimeTeste(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Siscofi siscofi = Siscofi.getInstance();
		siscofi.imprimeTeste();
		request.setAttribute("mensagem", "Verifique se a senha-teste saiu leg�vel!");
		return map.findForward("impressaoTestada");
	}
	
	/**
	 * M�todo respons�vel cancelar uma opera��o
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a p�gina
	 *         "administracao.jsp"
	 * @throws Exception
	 */
	public ActionForward voltar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltar");
	}
	
}
