package application;

import model.dao.DaoFactory;
import model.dao.EixoDao;
import model.dao.EnderecoDao;
import model.dao.CnaeDao;
import model.dao.FuncionarioDao;
import model.entities.Eixo;
import model.entities.Endereco;
import model.entities.CNAE;
import model.entities.Funcionario;

import java.util.List;
import java.util.Scanner;

public class Funcoes {
// eixo
	public static void updateEixo(){
		Scanner sc = new Scanner(System.in);
		EixoDao eixoDao = DaoFactory.createEixoDao();

		System.out.println("\n=== TEST 4: update =======");
		System.out.println("informe o id que deseja atualizar");
		Eixo eixo = eixoDao.findById(sc.nextInt());
		System.out.println("digite o codigo:");
		String cod= sc.next();
		System.out.println("digite a descricao:");
		sc.nextLine();// para limpar o buffer e liberar a proxima pergunta
		String desc= sc.nextLine();
		eixo.setCod(cod);
		eixo.setDescricao(desc);
		eixoDao.update(eixo);
		System.out.println("Update completed");
		sc.close();

	}

	public static void findIdEixo(){
		Scanner sc = new Scanner(System.in);
		EixoDao eixoDao = DaoFactory.createEixoDao();

		System.out.println("=== TEST 1: findById =======");
		System.out.println("informe o id a ser exibido");
		Eixo dep = eixoDao.findById(sc.nextInt());
		System.out.println(dep);
		sc.close();

	}

	public static void findAllEixo(){
		EixoDao eixoDao = DaoFactory.createEixoDao();

		System.out.println("\n=== TEST 2: findAll =======");
		List<Eixo> list = eixoDao.findAll();
		for (Eixo d : list) {
			System.out.println(d);
		}

	}

	public static void insertEixo(){
		Scanner sc = new Scanner(System.in);

		EixoDao eixoDao = DaoFactory.createEixoDao();

		System.out.println("\n=== TEST 3: insert =======");
		System.out.println("digite o codigo");
		String cod= sc.nextLine();
		System.out.println("digite a descricao");
		String desc= sc.nextLine();
		Eixo newEixo = new Eixo(null,cod,desc);
		eixoDao.insert(newEixo);
		System.out.println("Inserted! New id: " + newEixo.getId());
		sc.close();
	}

	public static void deleteEixo(){
		Scanner sc = new Scanner(System.in);

		EixoDao eixoDao = DaoFactory.createEixoDao();

		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		eixoDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}
// fim eixo

	// inicio endereco
	public static void updateEndereco(){
		Scanner sc = new Scanner(System.in);
		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

		System.out.println("\n=== TEST 4: update =======");
		System.out.println("informe o id que deseja atualizar");
		Endereco endereco = enderecoDao.findById(sc.nextInt());
		System.out.println("digite o cep");
		sc.nextLine();
		endereco.setCep(sc.nextLine());
		System.out.println("digite a numero");
		endereco.setNumero(sc.nextInt());
		System.out.println("digite o logradouro");
		sc.nextLine();
		endereco.setLogradouro(sc.nextLine());
		System.out.println("digite o complemento");
		endereco.setComplemento(sc.nextLine());
		enderecoDao.update(endereco);
		System.out.println("Update completed");
		sc.close();

	}

	public static void findIdEndereco(){
		Scanner sc = new Scanner(System.in);

		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

		System.out.println("=== TEST 1: findById =======");
		System.out.println("informe o id a ser exibido");
		Endereco endereco = enderecoDao.findById(sc.nextInt());
		System.out.println(endereco);
		sc.close();

	}

	public static void findAllEndereco(){
		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

		System.out.println("\n=== TEST 2: findAll =======");
		List<Endereco> list = enderecoDao.findAll();
		for (Endereco endereco : list) {
			System.out.println(endereco);
		}

	}

	public static void insertEndereco(){
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

		System.out.println("\n=== TEST 3: insert =======");
		System.out.println("digite o cep");
		String cep= sc.nextLine();
		System.out.println("digite o numero");
		Integer numero= sc2.nextInt();
		System.out.println("digite o logradouro");
		sc2.nextLine();
		String logradouro= sc2.nextLine();
		System.out.println("digite o complemento");
		String complemento= sc2.nextLine();

		Endereco newEndereco = new Endereco(null,cep,numero,logradouro,complemento);
		enderecoDao.insert(newEndereco);

		System.out.println("Inserted! New id: " + newEndereco.getId());
		sc.close();
		sc2.close();
	}

	public static void deleteEndereco(){
		Scanner sc = new Scanner(System.in);

		EnderecoDao enderecoDao = DaoFactory.createEnderecoDao();

		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		enderecoDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}
// fim endereco

	// Cnae
	public static void updateCnae(){
		Scanner sc = new Scanner(System.in);
		CnaeDao CnaeDao = DaoFactory.createCnaeDao();

		System.out.println("\n=== TEST 4: update =======");
		System.out.println("informe o id que deseja atualizar");
		CNAE dep2 = CnaeDao.findById(sc.nextInt());
		System.out.println("digite o codigo");
		sc.nextLine();
		dep2.setCod(sc.nextLine());
		System.out.println("digite a descricao");

		dep2.setDescricao(sc.nextLine());
		CnaeDao.update(dep2);
		System.out.println("Update completed");
		sc.close();

	}

	public static void findIdCnae(){
		Scanner sc = new Scanner(System.in);

		CnaeDao CnaeDao = DaoFactory.createCnaeDao();

		System.out.println("=== TEST 1: findById =======");
		System.out.println("informe o id a ser exibido");
		CNAE dep = CnaeDao.findById(sc.nextInt());
		System.out.println(dep);
		sc.close();

	}

	public static void findAllCnae(){
		CnaeDao CnaeDao = DaoFactory.createCnaeDao();

		System.out.println("\n=== TEST 2: findAll =======");
		List<CNAE> list = CnaeDao.findAll();
		for (CNAE d : list) {
			System.out.println(d);
		}

	}

	public static void insertCnae(){
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		CnaeDao CnaeDao = DaoFactory.createCnaeDao();

		System.out.println("\n=== TEST 3: insert =======");
		System.out.println("digite o codigo");
		String cod= sc.nextLine();
		System.out.println("digite a descricao");
		String desc= sc2.nextLine();
		CNAE newCNAE = new CNAE(null,cod,desc);
		CnaeDao.insert(newCNAE);
		System.out.println("Inserted! New id: " + newCNAE.getId());
		sc.close();
		sc2.close();
	}

	public static void deleteCnae(){
		Scanner sc = new Scanner(System.in);

		CnaeDao CnaeDao = DaoFactory.createCnaeDao();

		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		CnaeDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}
// fim Cnae

	// inicio funcionario
	static void updateFuncionario(){
		Scanner sc = new Scanner(System.in);
		FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();

		System.out.println("\n=== TEST 4: update =======");
		System.out.println("informe o id que deseja atualizar");
		Funcionario funcionario = funcionarioDao.findById(sc.nextInt());
		System.out.println("digite o nome");
		sc.nextLine();
		funcionario.setNome(sc.nextLine());
		System.out.println("digite a numero de registro");
		funcionario.setNumeroRegistro(sc.nextInt());
		System.out.println("digite o Turno");
		sc.nextLine();
		funcionario.setTurno(sc.nextLine());
		System.out.println("digite o CPF");
		funcionario.setCPF(sc.nextLine());
		funcionarioDao.update(funcionario);
		System.out.println("Update completed");
		sc.close();

	}

	static void findIdFuncionario(){
		Scanner sc = new Scanner(System.in);

		FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();


		System.out.println("=== TEST 1: findById =======");
		System.out.println("informe o id a ser exibido");
		Funcionario funcionario = funcionarioDao.findById(sc.nextInt());
		System.out.println(funcionario);
		sc.close();

	}

	static void findAllFuncionario(){
		FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();

		System.out.println("\n=== TEST 2: findAll =======");
		List<Funcionario> list = funcionarioDao.findAll();
		for (Funcionario funcionario : list) {
			System.out.println(funcionario);
		}

	}

	static void insertFuncionario(){
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();

		System.out.println("\n=== TEST 3: insert =======");
		System.out.println("digite o nome");
		String nome= sc.nextLine();
		System.out.println("digite o número de registro");
		Integer numeroRegistro= sc2.nextInt();
		System.out.println("digite o turno");
		sc2.nextLine();
		String turno= sc2.nextLine();
		System.out.println("digite o CPF");
		String CPF= sc2.nextLine();

		Funcionario newFuncionario = new Funcionario(null,nome,numeroRegistro,turno,CPF);
		funcionarioDao.insert(newFuncionario);

		System.out.println("Inserted! New id: " + newFuncionario.getId());
		sc.close();
		sc2.close();
	}

	static void deleteFuncionario(){
		Scanner sc = new Scanner(System.in);

		FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();

		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		funcionarioDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}
// fim funcionario
}

