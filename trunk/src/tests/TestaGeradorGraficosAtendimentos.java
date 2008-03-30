package tests;

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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.jfree.data.general.DefaultPieDataset;

import util.DataUtil;
import util.GeradorGraficosAtendimentos;
import estatisticas.atendimento.DadosAtendimento;
import estatisticas.atendimento.ResumoAtendimento;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE CCT - CENTRO DE CI�NCIA E
 * TECNOLOGIA DSC - DEPARTAMENTO DE SISTEMAS E COMPUTACAO DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS ALUNOS: CARLOS TRAJANO DE
 * OLIVEIRA HAMON BARROS HENRIQUES RODRIGO LOPES
 */

/**
 * Classe que testa a classe GeradorGraficosAtendimento
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaGeradorGraficosAtendimentos extends TestCase {

	private GeradorGraficosAtendimentos gerador;

	public TestaGeradorGraficosAtendimentos(String name) {
		super(name);
	}

	protected void setUp() {
		gerador = new GeradorGraficosAtendimentos();
	}

	/**
	 * Metodo que retorna uma suite de teste para a classe
	 * TestaGeradorGraficosAtendimentos
	 * 
	 * @return uma suite de teste.
	 */
	public static Test suite() {
		return new TestSuite(TestaGeradorGraficosAtendimentos.class);
	}

	public void testGerarGraficos() {
		try {
			DadosAtendimento dados = new DadosAtendimento();

			Map<String, Integer> atendenteXporcentagem = new HashMap<String, Integer>();
			atendenteXporcentagem.put("atendente1", 10);
			atendenteXporcentagem.put("atendente2", 10);
			dados.setTotalAtendimentos(20);
			dados.setAtendenteAtendimentos(atendenteXporcentagem);

			Map<String, Integer> classeXatendimentos = new HashMap<String, Integer>();
			classeXatendimentos.put("2via", 15);
			classeXatendimentos.put("especial", 5);
			dados.setClasseAtendimentos(classeXatendimentos);

			Map<Integer, Integer> guicheXatendimentos = new HashMap<Integer, Integer>();
			guicheXatendimentos.put(01, 5);
			guicheXatendimentos.put(02, 7);
			guicheXatendimentos.put(03, 4);
			guicheXatendimentos.put(04, 4);
			dados.setGuicheAtendimentos(guicheXatendimentos);

			DefaultPieDataset pieDataSet = new DefaultPieDataset();
			List<DadosAtendimento> lista = new ArrayList<DadosAtendimento>();
			lista.add(dados);
			ResumoAtendimento resumo = new ResumoAtendimento(DataUtil
					.formatarData(new Date("2007/25/01")), DataUtil
					.formatarData(new Date("2007/25/01")), lista);
			gerador.gerarGraficos(resumo);
		} catch (Exception e) {
			fail("N�o foi possivel gerar os gr�ficos");
		}
	}
}
