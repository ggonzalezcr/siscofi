package controleChamada;

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
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;

import controller.Configuracao;
import controller.Siscofi;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Implementa��o de uma pilha de tarefas de aviso. Os objetos desta classe s�o
 * respons�vel pelo controle de aviso.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 * 
 */

@Deprecated
public class PilhaAviso extends TimerTask {

	private static final int TempoCadaRepeticao = 4000;
 
	/**
	 * Tempo que o aviso ser� mantido
	 */
	private int tempo;

	/**
	 * Lista com os pr�ximos avisos
	 */
	private List<Aviso> avisos;

	/**
	 * Indica se o primeiro aviso da lista foi realizado.
	 */
	private boolean jaAvisou;

	/**
	 * Cria uma nova pilha de avisos.
	 * 
	 */
	public PilhaAviso() {
		avisos = new ArrayList<Aviso>();
		tempo = TempoCadaRepeticao * Configuracao.getRepeat()+1000;
		int refreshTime = Configuracao.getRefreshTime();
		jaAvisou = false;
		Timer timer = new Timer();
		timer.schedule(this, refreshTime, refreshTime);
	}

	@Override
	public void run() {
	/*	// Verifico se tem avisos
		if (avisos.size() > 0) {
			if (jaAvisou) {
				Aviso aviso = avisos.get(0);
				Date dataSistema = new Date();
				// Se tiver passado o tempo do aviso
				if (aviso.diferencaMilissegundos(dataSistema) >= tempo) {
					// Pego o pr�ximo aviso ou paro o aviso atual
					if (avisos.size() > 1) {
						avisos.remove(0);
						aviso = avisos.get(0);
						aviso.setTime(new Date());
						aviso.setAvisar(Aviso.AVISAR);
						gerarXml(aviso);
						jaAvisou = true;
					} else {
						aviso.setAvisar(Aviso.NAO_AVISAR);
						gerarXml(aviso);
						avisos.remove(0);
						jaAvisou = false;
					}
				}
			} else {
				Aviso aviso = avisos.get(0);
				aviso.setTime(new Date());
				aviso.setAvisar(Aviso.AVISAR);
				gerarXml(aviso);
				jaAvisou = true;
			}
		}*/
	}

//	/**
//	 * Gera��o de um arquivo com o aviso do topo da pilha.
//	 * 
//	 * @param aviso
//	 *            Aviso a ser colocado na pilha.
//	 */
//	private void gerarXml(Aviso aviso) {
//		Siscofi siscofi = Siscofi.getInstance();
//		siscofi.gerarXMLFlash(aviso);
//	}

//	/**
//	 * Adiciona um novo aviso para a pilha.
//	 * 
//	 * @param guiche
//	 *            informa��o do guiche.
//	 * @param senha
//	 *            Senha a ser chamada.
//	 */
//	public void addAviso(String guiche, String senha, String cor) {
//		Aviso aviso1 = new Aviso();
//		aviso1.setGuiche(guiche);
//		aviso1.setSenha(senha);
//		aviso1.setAvisar(Aviso.AVISAR);
//		aviso1.setCor(cor);
//		avisos.add(aviso1);
//	}

//	/**
//	 * Metodo que verifica se a PilhaAviso est� vazio.
//	 * 
//	 * @return true caso verdadeiro e false caso contrario.
//	 */
//	public boolean isEmpty() {
//		return avisos.isEmpty();
//	}

	/**
	 * Determina o total de avisos que est�o no momento.
	 * 
	 * @return O total de avisos no sistema.
	 */
	public int getTotalAvisos() {
		return avisos.size();
	}

	public static void main(String[] args) throws ServletException {
		Siscofi siscofi = Siscofi.getInstance();
		siscofi.addAviso("abc", "abc 132", "000000");
		siscofi.addAviso("abc", "abc 133", "000000");

	}

}