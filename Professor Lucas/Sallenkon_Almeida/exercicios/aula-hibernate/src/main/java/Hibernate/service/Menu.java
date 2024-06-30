package Hibernate.service;

import Hibernate.dao.DepartamentoImpl;
import Hibernate.model.Departamento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
public class Menu {
    private DepartamentoImpl departamentoDao;


    interface MenuAction{
        void execute();
    }
    private Map<Integer, MenuAction> menuOpcao;
    private Scanner sc;

    public Menu(){
        menuOpcao = new HashMap<>();
        sc = new Scanner(System.in);
        departamentoDao = new DepartamentoImpl();
        iniciaMenuOpcao();
    }

    private void iniciaMenuOpcao() {
        menuOpcao.put(1, () -> inserirDepartamento());
        menuOpcao.put(2, () -> mostrarDepartamentos());
        menuOpcao.put(3, () -> buscarDepartamento());

        menuOpcao.put(0, () -> sair());
    }

    public void run(){
        int opcao;
        do{
            mostrarMenu();
            opcao = obterOpcao();
            switch (opcao){
                case 1 -> configEntidade("Departamento");
                case 2 -> configEntidade("Funcionario");
                case 3 -> configEntidade("Projeto");
                case 4 -> {
                    System.out.println("Finalizando...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }while (opcao != 4);
        System.out.println("Programa finalizado!");
    }

    private void mostrarMenu(){
        System.out.println("\n----- Menu -----\n");
        System.out.println("1- Departamento");
        System.out.println("2- Funcionario");
        System.out.println("3- Projeto");
        System.out.println("0- Sair");
    }

    private void executarAcao(int opcao){
        MenuAction action = menuOpcao.get(opcao);
        if(action != null){
            action.execute();
        }else{
            System.out.println("Opção inválida! Tente novamente.");
        }
    }
    public int operacaoCrud(String model){
        System.out.println("\n----- Configuração -----\n");
        System.out.println("1-Inserir");
        System.out.println("2-Alterar");
        System.out.println("3-Buscar pelo Id");
        if(model.equals("Funcionario")){
            System.out.println("4-Buscar pelo Id do departamento");
            System.out.println("5-Buscar pelo Id do projeto");
            System.out.println("6-Listar");
            System.out.println("7-Deletar");
            System.out.println("8-Voltar ao menu");
            System.out.println("9-Sair");
        }
        if(model.equals("Departamento")){
            System.out.println("1-Inserir");
            System.out.println("2-Alterar");
            System.out.println("3-Buscar pelo Id");
            System.out.println("4-voltar ao menu");
            System.out.println("0-Sair");

        }if(model.equals("Projeto")){
            System.out.println("1-Inserir");
            System.out.println("2-Alterar");
            System.out.println("3-Buscar pelo Id");
            System.out.println("4-voltar ao menu");
            System.out.println("0-Sair");
        }else{
            System.out.println("4-listar");
            System.out.println("5-Deletar");
            System.out.println("6-voltar ao menu");
            System.out.println("0-Sair");
        }
        System.out.println("Insira o número do item que deseja configurar: ");
        return obterOpcao();
    }
    private int obterOpcao(){
        return sc.nextInt();
    }

    public void configEntidade(String model){
        while(true){
            int opcao = operacaoCrud(model);
            try{
                switch (opcao){
                    case 1 -> saveModel(model);
                    case 2 -> updateModel(model);
                    case 3 -> findById(model);
                    case 4 -> {
                        if(model.equals("Funcionario")){
                            findModelById();
                        }else {
                            listModels(model);
                        }
                    }
                    case 5 -> {
                        if(model.equals("Funcionario")){
                            findModelById();
                        }else {
                            deleteById(model);
                        }
                    }
                    case 6 -> {}
                }
            }
        }

    }



    public void sair(){
        System.out.println("Finalizando programa...");
    }

}

*/