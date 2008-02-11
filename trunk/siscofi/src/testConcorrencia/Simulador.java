package testConcorrencia;

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

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;

import controller.Siscofi;

public class Simulador extends TimerTask{
	
	
	private Timer schedule;
	
	/**
	 * Cria um novo Simulador.
	 * @param tempo Tempo em milissegundos at� que a simula��o seja encerrada.
	 */
	public Simulador(int tempo) {
		schedule = new Timer();
		schedule.schedule(this, tempo);
	}

	/**
	 * Adiciona uma tarefa que deve ser repetida a cada n milissegundos.
	 * @param tarefa Tarefa a ser repetida.
	 * @param tempo tempo em milissegundos entre cada repeti��o
	 */
	public void addTarefaRepetitiva(TimerTask tarefa, int tempo){
		schedule.schedule(tarefa, 10, tempo);
	}
	
	/**
	 * Adiciona uma tarefa que ser� executada apenas uma vez, ap�s n milissegundos do momento da adi��o.
	 * @param tarefa Tarefa a ser repetida;
	 * @param Tempo em milissegundos at� a tarefa seja executada.
	 */
	public void addTarefa(TimerTask tarefa, int tempo){
		schedule.schedule(tarefa, tempo);
	}

	@Override
	public void run() {
		schedule.cancel();
	}
	
	public static void main(String[] args) {
//		try {
//			Siscofi.getInstance().inicializaSistema();
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Simulador simulador = new Simulador(10000);
		simulador.addTarefaRepetitiva(new ProximaSenhaTask("Geral", "01", "192.168.1.1", "joao"), 10);
		simulador.addTarefaRepetitiva(new ProximaSenhaTask("Geral", "02", "192.168.1.2", "mariana"), 10);
	}

}
