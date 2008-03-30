package util;

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

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import controller.Configuracao;
import estatisticas.atendimento.ResumoAtendimento;

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
 * Classe que implementa o gerador de gr�ficos com informa��es
 * dos atendimentos ralizados
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class GeradorGraficosAtendimentos {

	//Path dos gr�ficos
	private String graficosPath = Configuracao.getPath() + "/admin/images/";
	
	/**
	 * Construtor simples da classe
	 */
	public GeradorGraficosAtendimentos(){}
	
	/**
	 * Metodo respons�vel por gerar os gr�ficos
	 * @param dados os dados quem ir�o compor os gr�ficos
	 */
	public void gerarGraficos(ResumoAtendimento dados) {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		
		geraGraficoPorGuiche(dados, pieDataset);
		geraGraficoPorAtendente(dados, pieDataset);
		geraGraficoPorClasse(dados, pieDataset);
	}
	
	/*
	 * Metodo que gera o gr�fico por atendente
	 */
	private void geraGraficoPorAtendente(ResumoAtendimento dados, DefaultPieDataset pieDataset) {
		Map<String, String> atendentePercentual = dados.getAtendentePercentualAtendimento();
		
		pieDataset = createDataSetAtendente(atendentePercentual);
		geraImagemGrafico(pieDataset, graficosPath + "graficoPorAtendente.jpg", "Atendente");
	}

	/*
	 * Metodo que gera o gr�fico por Guich�
	 */
	private void geraGraficoPorGuiche(ResumoAtendimento dados, DefaultPieDataset pieDataset) {
		
		Map<Integer, String> guichePercentual = dados.getGuichePercentualAtendimento();
		
		pieDataset = createDataSetGuiche(guichePercentual);
		geraImagemGrafico(pieDataset, graficosPath + "graficoPorGuiche.jpg", "Guiche");
	}
	
	/*
	  Metodo que gera gr�ficos por classe
	 */
	private void geraGraficoPorClasse(ResumoAtendimento dados, DefaultPieDataset pieDataset) {
		Map<String, String> classePercentual = dados.getClassePercentualAtendimento();
		
		pieDataset = createDataSetClasse(classePercentual);
		geraImagemGrafico(pieDataset, graficosPath + "graficoPorClasse.jpg", "Classe");		
	}

	
	private DefaultPieDataset createDataSetClasse(Map<String, String> classePercentual) {

		DefaultPieDataset pieDataSet = new DefaultPieDataset();
		Set<String> classes = classePercentual.keySet();
		
		for(String classe : classes){
			String porcentagem_str = classePercentual.get(classe);
			String double_str = porcentagem_str.substring(0, porcentagem_str.length() - 1);
			System.out.println(double_str);
			Double porcentagem = Double.valueOf(double_str);	
			pieDataSet.setValue(classe + ": " + porcentagem_str, porcentagem);
		}
		return pieDataSet;
	}


	private DefaultPieDataset createDataSetGuiche(Map<Integer, String> guichePercentual) {
		
		
		DefaultPieDataset pieDataSet = new DefaultPieDataset();
		Set<Integer> guiches = guichePercentual.keySet();
		
		for(int guiche : guiches){
			String porcentagem_str = guichePercentual.get(guiche);
			String double_str = porcentagem_str.substring(0, porcentagem_str.length() - 1);
			System.out.println(double_str);
			Double porcentagem = Double.valueOf(double_str);	
			pieDataSet.setValue("Guiche " + guiche + ": " + porcentagem_str , porcentagem);
		}
		return pieDataSet;
	}

	private DefaultPieDataset createDataSetAtendente(Map<String, String> atendentePercentual){
		DefaultPieDataset pieDataSet = new DefaultPieDataset();
		Set<String> atendentes = atendentePercentual.keySet();
		
		for(String atendente : atendentes){
			String porcentagem_str = atendentePercentual.get(atendente);
			String double_str = porcentagem_str.substring(0, porcentagem_str.length() - 1);
			System.out.println(double_str);
			Double porcentagem = Double.valueOf(double_str);	
			pieDataSet.setValue(atendente + ": " + porcentagem_str , porcentagem);
		}
		return pieDataSet;
	}
	
	private void geraImagemGrafico(DefaultPieDataset pieDataset, String graficoPath, String tipo) {
		JFreeChart chart = ChartFactory.createPieChart3D(
	            "Atendimentos Por " + tipo,  // chart title
	            pieDataset,             // data
	            true,               // include legend
	            true,
	            false
	        );
        chart.setBorderPaint(Color.black);
		PiePlot plot = (PiePlot) chart.getPlot();
		
        plot.setSectionOutlinesVisible(false);
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 10));
        plot.setNoDataMessage("No data available");
        plot.setSimpleLabels(false);
        chart.setBackgroundPaint(Color.white);
        
        try {
			ChartUtilities.saveChartAsJPEG(new File(graficoPath), chart, 600, 375);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
