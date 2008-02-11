package controleChamada;

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
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Implementação de uma pilha de tarefas de aviso. Os objetos desta classe são
 * responsável pelo controle de aviso.
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
	 * Tempo que o aviso será mantido
	 */
	private int tempo;

	/**
	 * Lista com os próximos avisos
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
					// Pego o próximo aviso ou paro o aviso atual
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
//	 * Geração de um arquivo com o aviso do topo da pilha.
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
//	 *            informação do guiche.
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
//	 * Metodo que verifica se a PilhaAviso está vazio.
//	 * 
//	 * @return true caso verdadeiro e false caso contrario.
//	 */
//	public boolean isEmpty() {
//		return avisos.isEmpty();
//	}

	/**
	 * Determina o total de avisos que estão no momento.
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