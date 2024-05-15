package cadastroDeAlunos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

class ComparadorPorIdade implements Comparator<Aluno> {
	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		return Integer.compare(aluno1.getIdade(), aluno2.getIdade());
	}
}

class ComparadorPorNota implements Comparator<Aluno> {
	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		return Double.compare(aluno1.getNota(), aluno2.getNota());
	}
}

class Aluno {

	private String nome;
	private int idade;
	private double nota;

	public Aluno(String nome, int idade, double nota) {

		this.nome = nome;
		this.idade = idade;
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public double getNota() {
		return nota;
	}

	public void setNome(String nome1) {
		nome = nome1;
	}

	public void setIdade(int idade1) {
		idade = idade1;
	}

	public void setNota(double nota1) {
		nota = nota1;
	}

	@Override

	public String toString() {

		return "Aluno -" + "nome = '" + nome + '\'' + ", idade =" + idade + ", nota =" + nota + "}";
	}

}

public class CadastroAlunos {

	public static void main(String[] args) {

		ArrayList<Aluno> alunos = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("Menu:");
			System.out.println("1. Cadastrar aluno");
			System.out.println("2. Exibir os alunos cadastrados, ordenados por ordem de registro");
			System.out.println("3. Exibir os alunos cadastrados, ordenados por idade, do menor ao maior");
			System.out.println("4. Exibir os alunos cadastrados, ordenados por nota, da menor à maior");
			System.out.println("5. Editar um cadastro");
			System.out.println("6. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = sc.nextInt();

			if (opcao == 1) {

				System.out.print("Digite o nome do aluno: ");
				String nome = sc.next();

				System.out.print("Digite a idade do aluno: ");
				int idade = sc.nextInt();

				System.out.print("Digite a nota do aluno: ");
				double nota = sc.nextDouble();

				Aluno aluno = new Aluno(nome, idade, nota);

				alunos.add(aluno);

				System.out.println("Aluno cadastrado com sucesso!");

			} else if (opcao == 2) {
				System.out.println("Alunos em ordem de registro:");
				for (Aluno aluno : alunos) {
					System.out.println(aluno);
				}

			} else if (opcao == 3) {
				Collections.sort(alunos, new ComparadorPorIdade());
				System.out.println("Alunos em ordem de idade: (Menor ao maior)");
				for (Aluno aluno : alunos) {
					System.out.println(aluno);
				}
			} else if (opcao == 4) {
				Collections.sort(alunos, new ComparadorPorNota());
				System.out.println("Alunos em ordem de nota: (Menor ao maior)");
				for (Aluno aluno : alunos) {
					System.out.println(aluno);
				}
			} else if (opcao == 5) {
				System.out.println("Digite o nome do aluno que deseja editar");
				String nomeAlunoEditavel = sc.next();
				Aluno alunoParaEditar = new Aluno(nomeAlunoEditavel, 2, 3);
				for (Aluno aluno : alunos) {
					if (aluno.getNome().equals(nomeAlunoEditavel)) {
						alunoParaEditar = aluno;
					} else {
						System.out.println("Não temos nenhum aluno com esse nome!");
						break;
					}
					System.out.println("E o quê você deseja editar?");
					System.out.println("1. Editar nome");
					System.out.println("2. Editar idade");
					System.out.println("3. Editar nota");
					System.out.println("4. Voltar ao menu");
					int opcaoEditar = sc.nextInt();
					if (opcaoEditar == 1) {
						System.out.println("Digite o novo nome do aluno escolhido");
						alunoParaEditar.setNome(sc.next());
						aluno = alunoParaEditar;
						System.out.println("Aluno editado com sucesso!");
					} else if (opcaoEditar == 2) {
						System.out.println("Digite a nova idade do aluno escolhido");
						alunoParaEditar.setIdade(sc.nextInt());
						aluno = alunoParaEditar;
						System.out.println("Aluno editado com sucesso!");
					} else if (opcaoEditar == 3) {
						System.out.println("Digite a nova nota do aluno escolhido");
						alunoParaEditar.setNota(sc.nextFloat());
						aluno = alunoParaEditar;
						System.out.println("Aluno editado com sucesso!");
					} else if (opcaoEditar == 4) {
						break;

					} else {
						System.out.println("Opção inválida. Tente novamente.");
					}
				}
			} else if (opcao == 6) {
				System.out.println("Saindo...");
				break;
			} else {

				System.out.println("Opção inválida. Tente novamente.");

			}
		}
		sc.close();
	}
}
