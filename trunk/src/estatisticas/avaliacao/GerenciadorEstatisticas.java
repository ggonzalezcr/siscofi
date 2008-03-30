package estatisticas.avaliacao;

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
 *
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 2
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe respons�vel por gera��o de estat�sticas.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.1
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.AvaliacaoDAO;
import database.EstatisticasDAO;
import database.bean.Avaliacao;
import exceptions.NotFoundInDBException;

public class GerenciadorEstatisticas {

	/**
	 * Gera estat�sticas de todas as avalia��es constantes no banco de dados e
	 * armazena as estat�sticas no banco de dados. As <b>avalia��es analisadas ser�o removidas do banco de dados</b>.
	 * 
	 */
	public void gerarEstatisticasAvaliacao() {
		AvaliacaoDAO avDAO = new AvaliacaoDAO();
		EstatisticasDAO esDAO = new EstatisticasDAO();
		Estatisticas est = new Estatisticas();

		List<Avaliacao> listaAvaliacao = new ArrayList<Avaliacao>();
		try {
			listaAvaliacao = avDAO.listaDeAvaliacoes(new Date());
			est.geraEstatistica(listaAvaliacao);
			avDAO.removeAvaliacoes(listaAvaliacao);
			esDAO.writeEstatistica(est);
		} catch (NotFoundInDBException e) {
			e.printStackTrace();
		}
	}
}
