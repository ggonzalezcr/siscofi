package coletaDados;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import controller.Siscofi;
import database.bean.Controle;

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

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO II
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Bean que armazena os dados monitorados de uma central de atendimento.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 * 
 */

public class DadosMonitoramento {

	private List<MonitoramentoCentral> dadosMonitoramento;
	private int totalAtendimentos;
	private int totalSenhasASeremAtendidas;
	private double totalTempoMedio;
	private int totalGuichesAtivos;
	
	/**
	 * Cria um novo objeto do tipo DadosMonitoramento
	 *
	 */
	public DadosMonitoramento(){
		dadosMonitoramento = new ArrayList<MonitoramentoCentral>();
		totalAtendimentos = 0;
		totalSenhasASeremAtendidas = 0;
		totalTempoMedio = 0.0;
		totalGuichesAtivos = 0;
	}
	
	/**
	 * Determina uma lista com dados sobre o monitoramento de cada classe de atendimento da central. 
	 * @return Listagem com dados de cada classe de atendimento.
	 */
	public List<MonitoramentoCentral> getDadosMonitoramento() {
		Siscofi siscofi = Siscofi.getInstance();
		dadosMonitoramento = new ArrayList<MonitoramentoCentral>();
		try {
			for(Controle controle: siscofi.getListaControles()){
				MonitoramentoCentral monitoramento = new MonitoramentoCentral();
				monitoramento.setAtendimentos(controle.getUltimaSenha());
				monitoramento.setSenhasASeremAtendidas( controle.getQuantidade());
				monitoramento.setClasseAtendimento(controle.getClasse());
				totalAtendimentos += controle.getUltimaSenha();
				totalSenhasASeremAtendidas += ( controle.getQuantidade()) ;
				double tempoMedio = siscofi.getTempoMedioClasse(controle.getClasse());
				int guichesAtivos = siscofi.getGuiches(controle.getClasse());
				monitoramento.setTempoMedioAtendimento(tempoMedio);
				monitoramento.setGuichesAtivos(guichesAtivos);
				totalTempoMedio += tempoMedio;
				totalGuichesAtivos += guichesAtivos;
				dadosMonitoramento.add(monitoramento);
			}
			DecimalFormat aproximador = new DecimalFormat( " 0.00 " );
			totalTempoMedio = Double.parseDouble(aproximador.format(totalTempoMedio));
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return dadosMonitoramento;
	}

	/**
	 * Altera os dados de monitoramento das classes de atendimento da central.
	 * @param dadosMonitoramento
	 */
	public void setDadosMonitoramento(List<MonitoramentoCentral> dadosMonitoramento) {
		this.dadosMonitoramento = dadosMonitoramento;
	}
	
	/**
	 * Determina o total de atendimento realizados, no momento do monitoramento.
	 * @return O total de atendimentos realizados.
	 */
	public int getTotalAtendimentos() {
		return totalAtendimentos;
	}

	/**
	 * Altera o total de atendimento realizados, no momento do monitoramento.
	 * @param totalAtendimentos O novo valor do total de atendimentos.
	 */
	public void setTotalAtendimentos(int totalAtendimentos) {
		this.totalAtendimentos = totalAtendimentos;
	}

	/**
	 * Determina o total de senhas emitidas, no momento do monitoramento.
	 * @return O total senhas atendidas.
	 */
	public int getTotalSenhasASeremAtendidas() {
		return totalSenhasASeremAtendidas;
	}

	/**
	 * Altera o total de senhas emitidas, no momento do monitoramento.
	 * @param totalSenhasASeremAtendidas Novo valor do total de senhas emitidas. 
	 */
	public void setTotalSenhasASeremAtendidas(int totalSenhasASeremAtendidas) {
		this.totalSenhasASeremAtendidas = totalSenhasASeremAtendidas;
	}

	/**
	 * Determina o total de guich�s ativos no sistema, no momento do monitoramento.
	 * @return O total de guich�s ativos.
	 */
	public int getTotalGuichesAtivos() {
		return totalGuichesAtivos;
	}

	/**
	 * Altera o total de guich�s ativos no sistema, no momento do monitoramento.
	 * @param totalGuichesAtivos Novo valor do total guich�s ativos. 
	 */
	public void setTotalGuichesAtivos(int totalGuichesAtivos) {
		this.totalGuichesAtivos = totalGuichesAtivos;
	}

	/**
	 * Determina o tempo m�dio de atendimento no sistema, at� o momento do monitoramento.
	 * @return O tempo m�dio de atendimento, em minutos.
	 */
	public double getTotalTempoMedio() {
		return totalTempoMedio;
	}

	/**
	 * Altera o tempo m�dio de atendimento no sistema.
	 * @param totalTempoMedio O novo valor do tempo m�dio de atendimento, em minutos.
	 */
	public void setTotalTempoMedio(double totalTempoMedio) {
		this.totalTempoMedio = totalTempoMedio;
	}

}
