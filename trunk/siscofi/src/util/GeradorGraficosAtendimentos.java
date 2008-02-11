package util;

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

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import controller.Configuracao;
import estatisticas.atendimento.DadosAtendimento;
import estatisticas.atendimento.ResumoAtendimento;

public class GeradorGraficosAtendimentos {

	private String graficosPath = Configuracao.getPath() + "/admin/images/";
	
	public GeradorGraficosAtendimentos(){
		
	}
	
	public void gerarGraficos(ResumoAtendimento dados) {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		
		geraGraficoPorGuiche(dados, pieDataset);
		geraGraficoPorAtendente(dados, pieDataset);
		geraGraficoPorClasse(dados, pieDataset);
	}
	
	private void geraGraficoPorAtendente(ResumoAtendimento dados, DefaultPieDataset pieDataset) {
		Map<String, String> atendentePercentual = dados.getAtendentePercentualAtendimento();
		
		pieDataset = createDataSetAtendente(atendentePercentual);
		geraImagemGrafico(pieDataset, graficosPath + "graficoPorAtendente.jpg", "Atendente");
	}

	private void geraGraficoPorGuiche(ResumoAtendimento dados, DefaultPieDataset pieDataset) {
		
		Map<Integer, String> guichePercentual = dados.getGuichePercentualAtendimento();
		
		pieDataset = createDataSetGuiche(guichePercentual);
		geraImagemGrafico(pieDataset, graficosPath + "graficoPorGuiche.jpg", "Guiche");
	}
	
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
	
	public static void main(String[] args) {
		GeradorGraficosAtendimentos ger = new GeradorGraficosAtendimentos();
		DadosAtendimento dados = new DadosAtendimento();
		
		Map<String, Integer> atendenteXporcentagem = new HashMap<String, Integer>();
		atendenteXporcentagem.put("atendente1", 10);
		atendenteXporcentagem.put("atendente2", 10);
		dados.setTotalAtendimentos(20);
		dados.setAtendenteAtendimentos(atendenteXporcentagem);
		
		Map<String, Integer> classeXatendimentos = new HashMap<String, Integer>();
		classeXatendimentos.put("2via", 15);
		classeXatendimentos.put("especial", 5);
		dados.setClasseAtendimentos(classeXatendimentos );
		
		Map<Integer, Integer> guicheXatendimentos = new HashMap<Integer, Integer>();
		guicheXatendimentos.put(01, 5);
		guicheXatendimentos.put(02, 7);
		guicheXatendimentos.put(03, 4);
		guicheXatendimentos.put(04, 4);
		dados.setGuicheAtendimentos(guicheXatendimentos );
		
		DefaultPieDataset pieDataSet = new DefaultPieDataset();
		List<DadosAtendimento> lista = new ArrayList<DadosAtendimento>(); 
		lista.add(dados);
		ResumoAtendimento resumo = new ResumoAtendimento(DataUtil.formatarData(new Date("2007/25/01")), DataUtil.formatarData(new Date("2007/25/01")), lista );  
		ger.geraGraficoPorAtendente(resumo, pieDataSet);
		ger.geraGraficoPorClasse(resumo, pieDataSet);
		ger.geraGraficoPorGuiche(resumo, pieDataSet);
		System.out.println("Gerou com sucesso!!!");
	}

}
