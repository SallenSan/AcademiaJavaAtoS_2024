package Hibernate.service;

import Hibernate.interfacesDao.DepartamentoDao;
import Hibernate.interfacesDao.FuncionarioDao;
import Hibernate.interfacesDao.ProjetoDao;
import Hibernate.model.Departamento;
import Hibernate.model.Funcionario;
import Hibernate.model.Projeto;

import java.util.List;
import java.util.Scanner;

public class MenuOp {
    private final Scanner sc = new Scanner(System.in);
    private final DepartamentoDao departamentoDao;
    private final FuncionarioDao funcionarioDao;
    private final ProjetoDao projetoDao;

    public MenuOp(DepartamentoDao departamentoDao, FuncionarioDao funcionarioDao, ProjetoDao projetoDao) {
        this.departamentoDao = departamentoDao;
        this.funcionarioDao = funcionarioDao;
        this.projetoDao = projetoDao;
    }

    public void mostrarMenu() {
        int opcao = 1;
        while (opcao != 0) {
            opcao = obterOpcaoMenu();
            if (opcao != 0) {
                executarAcao(opcao);
            }
        }
    }

    public int obterOpcaoMenu() {
        boolean flag = false;
        int opcao = 4;
        while (!flag) {
            System.out.println("|------------MENU------------|");
            System.out.println("|--Selecione o item que deseja configurar--|");
            System.out.println("0 para voltar ao menu principal");
            System.out.println("1- Departamento");
            System.out.println("2- Funcionario");
            System.out.println("3- Projeto");
            System.out.println("4- Sair");
            System.out.println("|----------------------------|");

            try {
                String entrada = sc.nextLine();
                opcao = Integer.parseInt(entrada);

                if (opcao >= 0 && opcao <= 4) {
                    flag = true;
                } else {
                    throw new Exception("Entrada inválida");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite novamente.\n" + e.getMessage());
            }
        }
        return opcao;
    }

    public void executarAcao(int opcao) {
        String model = null;
        switch (opcao) {
            case 1 -> model = "Departamento";
            case 2 -> model = "Funcionario";
            case 3 -> model = "Projeto";
            case 4 -> {
                System.out.println("Saindo...");
                System.exit(0);
            }
        }

        if (model != null) {
            int opcaoModel = 1;
            while (opcaoModel != 0) {
                opcaoModel = obterOpcaoModel(model);
                switch (opcaoModel) {
                    case 1 -> saveModel(model);
                    case 2 -> updateModel(model);
                    case 3 -> findModelById(model);
                    case 4 -> deleteModelById(model);
                    case 5 -> listModels(model);
                }
            }
        }
    }

    public int obterOpcaoModel(String model) {
        boolean flag = false;
        int opcao = 5;
        while (!flag) {
            System.out.println("|------------MENU " + model.toUpperCase() + "------------|");
            System.out.println("0 para voltar ao menu anterior");
            System.out.println("1- Salvar");
            System.out.println("2- Atualizar");
            System.out.println("3- Encontrar por ID");
            System.out.println("4- Deletar");
            System.out.println("5- Listar todos");
            System.out.println("|----------------------------|");

            try {
                String entrada = sc.nextLine();
                opcao = Integer.parseInt(entrada);

                if (opcao >= 0 && opcao <= 5) {
                    flag = true;
                } else {
                    throw new Exception("Entrada inválida");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite novamente.\n" + e.getMessage());
            }
        }
        return opcao;
    }

    // método que irá inserir
    public void saveModel(String model) {
        try {
            switch (model) {
                case "Departamento" -> {
                    System.out.println("Nome do departamento: ");
                    String nome = sc.nextLine();
                    Departamento departamento = Departamento.builder().nome(nome).build();
                    departamentoDao.save(departamento);
                    System.out.println("Departamento cadastrado com sucesso!");
                }
                case "Funcionario" -> {
                    System.out.println("Nome do funcionário: ");
                    String nome = sc.nextLine();
                    System.out.println("Cargo do funcionário: ");
                    String cargo = sc.nextLine();
                    System.out.println("Insira o Id do departamento: ");
                    int departamentoId = Integer.parseInt(sc.nextLine());
                    System.out.println("Insira o Id do projeto: ");
                    int projetoId = Integer.parseInt(sc.nextLine());

                    Departamento departamento = departamentoDao.findById(departamentoId);
                    Projeto projeto = projetoDao.findById(projetoId);

                    if (departamento != null && projeto != null) {
                        Funcionario funcionario = Funcionario.builder().nome(nome).departamento(departamento).projeto(projeto).build();
                        funcionarioDao.save(funcionario);
                        System.out.println("Funcionario cadastrado com sucesso!");
                    } else {
                        System.out.println("Departamento ou projeto não encontrado!");
                    }
                }
                case "Projeto" -> {
                    System.out.println("Nome do projeto: ");
                    String nome = sc.nextLine();
                    Projeto projeto = Projeto.builder().nome(nome).build();
                    projetoDao.save(projeto);
                    System.out.println("Projeto cadastrado com sucesso!");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro na inserção " + model + ": " + e.getMessage());
        }
    }

    // método de update
    public void updateModel(String model) {
        System.out.println("Insira o Id: ");
        int id = Integer.parseInt(sc.nextLine());
        try {
            switch (model) {
                case "Departamento" -> {
                    Departamento departamento = departamentoDao.findById(id);
                    if (departamento != null) {
                        System.out.println("Insira o novo nome do departamento: ");
                        departamento.setNome(sc.nextLine());
                        departamentoDao.update(departamento);
                        System.out.println("Departamento atualizado com sucesso!");
                    }
                }
                case "Funcionario" -> {
                    Funcionario funcionario = funcionarioDao.findById(id);
                    if (funcionario != null) {
                        System.out.println("Insira o novo nome do funcionario: ");
                        funcionario.setNome(sc.nextLine());
                        System.out.println("Insira o novo cargo: ");
                        funcionario.setCargo(sc.nextLine());
                        System.out.println("Id do departamento: ");
                        int departamentoId = Integer.parseInt(sc.nextLine());
                        System.out.println("Id do projeto: ");
                        int projetoId = Integer.parseInt(sc.nextLine());

                        Departamento departamento = departamentoDao.findById(departamentoId);
                        Projeto projeto = projetoDao.findById(projetoId);

                        if (departamento != null && projeto != null) {
                            funcionario.setDepartamento(departamento);
                            funcionario.setProjeto(projeto);
                            funcionarioDao.update(funcionario);
                            System.out.println("Funcionario atualizado com êxito!!");
                        } else {
                            System.out.println("Projeto ou Departamento não encontrado!");
                        }
                    } else {
                        System.out.println("Funcionario não encontrado! ");
                    }
                }
                case "Projeto" -> {
                    Projeto projeto = projetoDao.findById(id);
                    if (projeto != null) {
                        System.out.println("Insira o nome do projeto: ");
                        projeto.setNome(sc.nextLine());
                        projetoDao.update(projeto);
                        System.out.println("Projeto salvo com sucesso!");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erro na atualização " + model + ":" + e.getMessage());
        }
    }

    public void findModelById(String model) {
        try {
            System.out.println("Digite o id: " + model);
            int id = Integer.parseInt(sc.nextLine());

            switch (model) {
                case "Departamento" -> {
                    Departamento departamento = departamentoDao.findById(id);
                    System.out.println(departamento != null ? departamento : "Departamento não encontrado!");
                }
                case "Funcionario" -> {
                    Funcionario funcionario = funcionarioDao.findById(id);
                    System.out.println(funcionario != null ? funcionario : "Funcionario não encontrado!");
                }
                case "Projeto" -> {
                    Projeto projeto = projetoDao.findById(id);
                    System.out.println(projeto != null ? projeto : "Projeto não encontrado!");
                }
            }
        } catch (Exception e) {
            System.out.println("Não foi possível buscar " + model + ": " + e.getMessage());
        }
    }

    private void listModels(String model) {
        try {
            switch (model) {
                case "Departamento" -> {
                    List<Departamento> departamentos = departamentoDao.findAll();
                    departamentos.forEach(System.out::println);
                }
                case "Funcionario" -> {
                    List<Funcionario> funcionarios = funcionarioDao.findAll();
                    funcionarios.forEach(System.out::println);
                }
                case "Projeto" -> {
                    List<Projeto> projetos = projetoDao.findAll();
                    projetos.forEach(System.out::println);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar " + model + ": " + e.getMessage());
        }
    }

    private void deleteModelById(String model) {
        try {
            System.out.println("Id do " + model + " a ser deletado:");
            int id = Integer.parseInt(sc.nextLine());
            switch (model) {
                case "Departamento" -> {
                    Departamento departamento = departamentoDao.findById(id);
                    if (departamento != null) {
                        departamentoDao.delete(departamento);
                        System.out.println("Departamento deletado com sucesso!");
                    } else {
                        System.out.println("Departamento não encontrado!");
                    }
                }
                case "Funcionario" -> {
                    Funcionario funcionario = funcionarioDao.findById(id);
                    if (funcionario != null) {
                        funcionarioDao.delete(funcionario);
                        System.out.println("Funcionario deletado com sucesso!");
                    } else {
                        System.out.println("Funcionario não encontrado!");
                    }
                }
                case "Projeto" -> {
                    Projeto projeto = projetoDao.findById(id);
                    if (projeto != null) {
                        projetoDao.delete(projeto);
                        System.out.println("Projeto deletado com sucesso!");
                    } else {
                        System.out.println("Projeto não encontrado!");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar " + model + ": " + e.getMessage());
        }
    }
}
