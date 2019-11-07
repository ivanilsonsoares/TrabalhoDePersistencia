package br.ufc.qxd.persistencia.trabalho_02_jpa.exec;


import java.util.List;
import java.util.Scanner;

import br.ufc.qxd.persistencia.trabalho_02_jpa.controle.DepartamentoControle;
import br.ufc.qxd.persistencia.trabalho_02_jpa.controle.DependenteControle;
import br.ufc.qxd.persistencia.trabalho_02_jpa.controle.FuncionarioControle;
import br.ufc.qxd.persistencia.trabalho_02_jpa.controle.ProjetoControle;
import br.ufc.qxd.persistencia.trabalho_02_jpa.dao.LimpezaDAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.jpa.dao.LimpezaJPADAO;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Departamento;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Funcionario;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Limpeza;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Pesquisador;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Projetos;
import br.ufc.qxd.persistencia.trabalho_02_jpa.model.Secretario;


public class Principal {
	public static void menuPrincipal() {
		System.out.println("#===============> MENU PRINCIPAL <===============#");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |      [3] DEPARTAMENTOS     |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |      [2] FUNCIONARIOS      |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |      [1] PROJETOS          |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |      [0] SAIR              |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#================================================#");
	}

	public static void menuDepartamentos() {
		System.out.println("#==============> MENU DEPARTAMENTO <=============#");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |        [4] ADICIONAR       |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |        [3] REMOVER         |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |        [2] LISTAR          |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |        [1] BUSCAR          |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |        [0] SAIR            |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#================================================#");
	}

	public static void menuFuncionarios() {
		System.out.println("#==============> MENU FUNCIONARIO <==============#");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |      [5] ADICIONAR         |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |      [4] REMOVER           |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |      [3] LISTAR            |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |      [2] BUSCAR            |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |      [1] ADD DEPENDENTE    |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |      [0] SAIR              |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#================================================#");
	}

	public static void menuProjetos() {
		System.out.println("#================> MENU PROJETOS <===============#");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |        [4] ADICIONAR       |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |        [3] REMOVER         |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |        [2] LISTAR          |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |        [1] BUSCAR          |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#         |        [0] SAIR            |         #");
		System.out.println("#         +----------------------------+         #");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#                                                #");
		System.out.println("#================================================#");

	}


	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		boolean running = true;
		Scanner tcl = new Scanner(System.in);

		while (running) {
			menuPrincipal(); // menu princiapl
			int escolhaMenuPrincipal = tcl.nextInt();

			switch (escolhaMenuPrincipal) {
			case 0:
				running = false;
				System.out.println("Saindo...");
				break;

			case 1: //menu de projetos
				menuProjetos();
				int escolhaMenuProjetos = tcl.nextInt();

				switch (escolhaMenuProjetos) {
				case 0:
					System.out.println("Voltando...");
					break;
				case 1:
					System.out.println("QUAL NUMERO DO PROJETO QUE DESEJA BUSCAR? ");
					try {
						Integer numero = Integer.parseInt(tcl.nextLine());
						Projetos projeto = new ProjetoControle().buscarProjetoPorNumero(numero);
						System.out.println(projeto);
					} catch (NumberFormatException e) {
						System.out.println("O numero informado não e valido!");
					}
					break;

				case 2:
					List<Projetos> projetos = new ProjetoControle().buscarTodosOsProjetos();
					for (Projetos projeto : projetos) {
						System.out.println(projeto);
					}
					break;
				case 3:
					System.out.println("----- PROJETOS CADASTRADOS ---------");
					List<Projetos> projetos1 = new ProjetoControle().buscarTodosOsProjetos();
					for (Projetos projeto : projetos1) {
						System.out.println(projeto);
					}


					System.out.println("QUAL NUMERO DO PROJETO QUE QUER REMOVER? ");

					try {
						int numero = tcl.nextInt();
						new ProjetoControle().removerProjeto(numero);
					} catch (NumberFormatException e) {
						System.out.println("O numero informado não a valido!");
					}

					System.out.println("O projeto foi removido!");
					break;

				case 4:
					System.out.println("QUAL O NOME DO PROJETO QUE DESEJA INSERIR? ");
					String nome = tcl.nextLine();
					nome = tcl.nextLine();
					System.out.println("QUAL TEMPO DE DESENVOLVIMENTO DESTE PROJETO? ");
					int tempoDesenvolvimento = tcl.nextInt();
					System.out.println("-------- DEPARTAMENTOS CADASTRADOS -------------");

					List<Departamento> departamentos = new DepartamentoControle().buscarTodosOsDepartamentos();
					for (Departamento departamento : departamentos) {
						System.out.println(departamento);
					}

					System.out.println("QUAL ID DO DEPARTAMENTO QUE ELE FAZERÁ PARTE? ");

					int numeroDepartamento;
					try {
						numeroDepartamento = tcl.nextInt();
					} catch (NumberFormatException e) {
						System.out.println("O ID informado não é valido");
						break;
					}

					System.out.println("+-------------> SELECIONE SE QUER ADICIONAR UM PESQUISADOR <-----------------+");
					System.out.println("|                                                                            |");
					System.out.println("|                       1 - Sim         2 - Não                              |");
					System.out.println("|                                                                            |");
					System.out.println("+----------------------------------------------------------------------------+");
					int escolhaTemPesquisador = tcl.nextInt();


					if(escolhaTemPesquisador == 1) {

						List<Pesquisador> pesquisadores = new FuncionarioControle().buscarFuncionariosPesquisador();
						for (Pesquisador pesquisador : pesquisadores) {
							System.out.println(pesquisador);
						}

						System.out.println("QUAL ID DO PESQUISADOR QUE ELE FAZERÁ PARTE? ");
						int idPesquisa = tcl.nextInt();

						new ProjetoControle().adicionarProjeto(nome, tempoDesenvolvimento, numeroDepartamento, idPesquisa);



					}else if(escolhaTemPesquisador == 2) {
						new ProjetoControle().adicionarProjetoSemPesquisador(nome, tempoDesenvolvimento, numeroDepartamento);

					}else {
						System.out.println("Opcão Invalida");
					}

					System.out.println("O projeto foi inserido!");
					break;

				default:
					System.out.println("Opcão invalida");
					break;
				}

				break;

			case 2: // menu de funcionarios
				menuFuncionarios();
				int escolhaFuncionarios = tcl.nextInt();

				switch (escolhaFuncionarios) {
				case 0: // voltar
					System.out.println("Voltando...");
					break;
				case 1: // adicionar dependente
					System.out.println("QUAL O NOME DO DEPENDENTE? ");
					String nomeDependente = tcl.nextLine();
					nomeDependente = tcl.nextLine();
					System.out.println("QUAL O SEXO DO DEPENDENTE? ");
					String sexo = tcl.nextLine();
					System.out.println("QUAL A DATA DE NASCIMENTO DO DEPENDENTE? ");
					String dataNascimento= tcl.nextLine();
					System.out.println("QUAL O GRAU DE PARENTESCO COM O FUNCIONARIO QUE ELE DEPENDE? ");
					String grauDeParentesco= tcl.nextLine();

					System.out.println("---------- FUNCIONARIO CADASTRADOS -----------");

					FuncionarioControle funcionarios = new FuncionarioControle();
					List<Funcionario> fun = funcionarios.buscarFuncionarios();
					for (Funcionario funcionario : fun) {
						System.out.println(funcionario);
					}

					System.out.println("QUAL O ID DO FUNCIONARIO QUE ELE DEPENDE? ");
					int idFuncionario= tcl.nextInt();
					new DependenteControle().InserirDependente(nomeDependente, sexo, dataNascimento, grauDeParentesco, idFuncionario);

					System.out.println("A dependencia foi inserida!");

					break;
				case 2: // buscar
					System.out.println("QUAL O NUMERO DO FUNCIONARIO QUE QUER BUSCAR? ");

					try {
						int numero = tcl.nextInt();
						Funcionario funcionario = new FuncionarioControle().buscarFuncionarioPorNumero(numero);

						System.out.println(funcionario);
					} catch (NumberFormatException e) {
						System.out.println("O número informado não é valido!");
					}
					break;
				case 3: // listar

					System.out.println("+-------------------------> SELECIONE O TIPO DE FUNCIONARIO <--------------------------+");
					System.out.println("|                                                                                      |");
					System.out.println("|   1 - Pesquisador     2 - Secretario      3 -Funcionario de Limpeza      4 - Todos   |");
					System.out.println("|                                                                                      |");
					System.out.println("+--------------------------------------------------------------------------------------+");
					String tipoFuncionario = tcl.nextLine();
					tipoFuncionario = tcl.nextLine();

					if (tipoFuncionario.equals("1")) { // pesquisador
						List<Pesquisador> pesquisadores = new FuncionarioControle().buscarFuncionariosPesquisador();
						for (Pesquisador pesquisador : pesquisadores) {
							System.out.println(pesquisador);
						}
					} else if (tipoFuncionario.equals("2")) { // secretario
						List<Secretario> secretarios = new FuncionarioControle().buscarFuncionariosSecretario();
						for (Secretario secretario : secretarios) {
							System.out.println(secretario);
						}					
					} else if (tipoFuncionario.equals("3")) { //funcionario de limpeza
						List<Limpeza> limpezas = new FuncionarioControle().buscarFuncionariosLimpeza();
						for (Limpeza limpeza : limpezas) {
							System.out.println(limpeza);
						}	
					}else if (tipoFuncionario.equals("4")) { // todos
						FuncionarioControle funcionarios2 = new FuncionarioControle();
						List<Funcionario> fun1 = funcionarios2.buscarFuncionarios();
						for (Funcionario funcionario : fun1) {
							System.out.println(funcionario);
						}	
					}
					else {
						System.out.println("Opção invalida!");
					}

					break;
				case 4: // remover
					System.out.println("QUAL O NUMERO DO FUNCIONARIO QUE DESEJA REMOVER? ");

					try {
						int numero = tcl.nextInt();
						new FuncionarioControle().removerFuncionario(numero);
					} catch (NumberFormatException e) {
						System.out.println("O numero informado não a valido!");
					}

					System.out.println("O funcionario foi removido");
					break;
				case 5: // adicionar
					System.out.println("QUAL NOME DO FUNCIONARIO? ");
					String nomeFuncionario = tcl.nextLine();
					nomeFuncionario = tcl.nextLine();

					System.out.println("QUAL A RUA DO FUNCIONARIO?  ");
					String ruaFuncionario = tcl.nextLine();

					System.out.println("QUAL NUMERO DA CASA DO FUNCIONARIO: ");
					Integer numeroCasaFuncionario = 0;
					try {
						numeroCasaFuncionario = Integer.parseInt(tcl.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("O numero informado nao e valido");
						break;
					}

					System.out.println("QUAL O BAIRRO DO FUNCIONARIO? ");
					String bairroFuncionario = tcl.nextLine();

					System.out.println("QUAL A CIDADE DO FUNCIONARIO? ");
					String cidadeFuncionario = tcl.nextLine();

					System.out.println("QUAL A ESTADO DO FUNCIONARIO? ");
					String estadoFuncionario = tcl.nextLine();

					System.out.println("QUAL O SEXO DO FUNCIONARIO? ");
					String sexoFuncionario = tcl.nextLine();

					System.out.println("QUAL A DATA DE NASCIMENTO DO FUNCIONARIO? ");
					String dataAniversarioFuncionario = tcl.nextLine();

					System.out.println("QUAL O SALARIO DO FUNCIONARIO? ");
					Float salarioFuncionario;
					try {
						salarioFuncionario = Float.parseFloat(tcl.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("O salario informado não é válido");
						break;
					}

					System.out.println("-------- DEPARTAMENTOS CADASTRADOS ---------------");

					List<Departamento> departamentos = new DepartamentoControle().buscarTodosOsDepartamentos();
					for (Departamento departamento : departamentos) {
						System.out.println(departamento);
					}

					System.out.println("QUAL O ID DO DEPARTAMENTO DELE? ");
					int idDepartametoFuncionario = tcl.nextInt();

					System.out.println("+--------------------> SELECIONE O TIPO DE FUNCIONARIO <---------------------+");
					System.out.println("|                                                                            |");
					System.out.println("|    1 - Pesquisador         2 - Secretario      3 -Funcionario de Limpeza   |");
					System.out.println("|                                                                            |");
					System.out.println("+----------------------------------------------------------------------------+");
					String tipoFuncionarioInserir = tcl.nextLine();
					tipoFuncionarioInserir = tcl.nextLine();

					if (tipoFuncionarioInserir.equals("1")) { // pesquisador
						System.out.println("QUAL A AREA DE ATUAÇÃO DO PESQUISADOR? ");
						String areaAtuacaoPesquisador = tcl.nextLine();


						System.out.println("+-------------> SELECIONE SE ELE FAZ PARTE DE ALGUM PROJETO <-----------------+");
						System.out.println("|                                                                            |");
						System.out.println("|                       1 - Sim         2 - Não                              |");
						System.out.println("|                                                                            |");
						System.out.println("+----------------------------------------------------------------------------+");
						int escolhaTemProjeto = tcl.nextInt();
						if(escolhaTemProjeto == 1){
							System.out.println("QUANTAS SÃO AS HORAS TRABALHADAS (NUMERO)?");
							int horasTrabalhadasPesquisador = tcl.nextInt();

							System.out.println("------- PROJETO CADASTRADO -------------");

							List<Projetos> projetos0 = new ProjetoControle().buscarTodosOsProjetos();
							for (Projetos projeto2 : projetos0) {
								System.out.println(projeto2);
							}


							System.out.println("QUAL O PROJETO DO FUNCIONARIO (ID)? ");
							int idprojeto = tcl.nextInt();

							new FuncionarioControle().adicionarPesquisador(nomeFuncionario, ruaFuncionario,
									numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario,
									sexoFuncionario, dataAniversarioFuncionario, salarioFuncionario, idDepartametoFuncionario, areaAtuacaoPesquisador,
									idprojeto,horasTrabalhadasPesquisador);

						}
						else if(escolhaTemProjeto == 2) {

							new FuncionarioControle().adicionarPesquisadorSemProjeto(nomeFuncionario, ruaFuncionario,
									numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario,
									sexoFuncionario, dataAniversarioFuncionario, salarioFuncionario, idDepartametoFuncionario, areaAtuacaoPesquisador);
						}
						else {
							System.out.println("Opção Invalida!");
						}
						System.out.println("O pesquisador foi adicionado!");

					} else if (tipoFuncionarioInserir.equals("2")) { // secretario
						System.out.println("QUAL O GRAU DE ESCOLARIDADE DO SECRETÁRIO: ");
						String grauEscolaridadeSecretario = tcl.nextLine();

						new FuncionarioControle();
						FuncionarioControle.adicionarSecretario(nomeFuncionario, ruaFuncionario,
								numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario,
								sexoFuncionario, dataAniversarioFuncionario, salarioFuncionario, idDepartametoFuncionario,
								grauEscolaridadeSecretario);
						System.out.println("O secretário foi adicionado!");

					} else if (tipoFuncionarioInserir.equals("3")) { //funcionario de limpeza
						System.out.println("QUAL A JORNADA DE TRABALHO DESSE FUNCIONARIO DE LIMPEZA? ");
						Integer jornadaTrabalhoFuncionarioLimpeza;
						try {
							jornadaTrabalhoFuncionarioLimpeza = Integer.parseInt(tcl.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("A jornada de trabalho informada nao e valida");
							break;
						}

						System.out.println("+-----------> SELECIONE SE O FUNCIONARIO DE LIMPEZA E GERENTE <--------------+");
						System.out.println("|                                                                            |");
						System.out.println("|                       1 - Sim         2 - Não                              |");
						System.out.println("|                                                                            |");
						System.out.println("+----------------------------------------------------------------------------+");
						int escolhaLimpeza = tcl.nextInt();

						if(escolhaLimpeza == 1) {
							String cargo1 ="gerente";
							new FuncionarioControle().adicionarFuncionarioLimpeza(nomeFuncionario, ruaFuncionario,
									numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario,
									sexoFuncionario, dataAniversarioFuncionario, salarioFuncionario, idDepartametoFuncionario, cargo1,
									jornadaTrabalhoFuncionarioLimpeza);
						}else if(escolhaLimpeza == 2){
							System.out.println("QUAL O CARGO DESSE FUNCIONARIO DE LIMPEZA? ");
							String cargo;
							cargo = tcl.nextLine();
							cargo = tcl.nextLine();

							System.out.println("GERENTES CADASTRADOS ");
							LimpezaDAO cDao = new LimpezaJPADAO();
							List<Limpeza> gerente1 = cDao.findByCargo("gerente");
							cDao.close();
							for(Limpeza gerentes : gerente1) {
								System.out.println(gerentes);
							}

							System.out.println("QUAL O ID DO GERENTE?");
							int gerente = tcl.nextInt();

							new FuncionarioControle().adicionarFuncionarioLimpezaGerenciada(nomeFuncionario, ruaFuncionario,
									numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario,
									sexoFuncionario, dataAniversarioFuncionario, salarioFuncionario, idDepartametoFuncionario, cargo,
									jornadaTrabalhoFuncionarioLimpeza,gerente);
						}else {
							System.out.println("Opção Invalida!");
						}

						System.out.println("O funcionario de limpeza foi adicionado!");
					}
					break;
				default:
					System.out.println("Opcao invalida");
					break;

				}
				break;
			case 3: //menu de departamentos
				menuDepartamentos();
				int escolhaMenuDepartamentos = tcl.nextInt();

				switch (escolhaMenuDepartamentos) {
				case 0:
					System.out.println("Voltando...");
					break;
				case 1: //buscar
					System.out.println("QUAL NUMERO DO DEPARTAMENTO QUE DESEJA BUSCAR? ");
					try {

						Integer numero = Integer.parseInt(tcl.nextLine());
						Departamento departamento = new DepartamentoControle().buscarDepartamentoPorNumero(numero);
						System.out.println(departamento);
					} catch (NumberFormatException e) {
						System.out.println("O numero informado não e valido!");
					}

					break;

				case 2: //listar
					List<Departamento> departamentos = new DepartamentoControle().buscarTodosOsDepartamentos();
					for (Departamento departamento : departamentos) {
						System.out.println(departamento);
					}
					break;
				case 3: //remover
					System.out.println("QUAL NUMERO DO DEPARTAMENTO QUE QUER REMOVER? ");

					try {
						int numero = tcl.nextInt();
						new DepartamentoControle();
						DepartamentoControle.removerDepartamento(numero);
					} catch (NumberFormatException e) {
						System.out.println("O numero informado não a valido!");
					}

					System.out.println("O departamento foi removido!");
					break;

				case 4:
					System.out.println("QUAL O NOME DO DERPARTAMENTO QUE DESEJA INSERIR? ");
					String nome = tcl.nextLine();
					nome = tcl.nextLine();

					new DepartamentoControle().InserirDepartamento(nome);

					System.out.println("O departamento foi inserido!");
					break;
				default:
					System.out.println("Opcão invalida");
					break;
				}

				break;
			default:
				System.out.println("Opcao invalida");

				break;

			}

		}
		tcl.close();

	}

}
