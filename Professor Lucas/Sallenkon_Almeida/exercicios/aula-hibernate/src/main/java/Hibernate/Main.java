package Hibernate;

import Hibernate.dao.DepartamentoDao;
import Hibernate.dao.FuncionarioDao;
import Hibernate.model.Departamento;
import Hibernate.model.Funcionario;

public class Main {
    public static void main(String[] args) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        DepartamentoDao departamentoDao = new DepartamentoDao();
        Departamento departamento = new Departamento();
        Funcionario funcionario = new Funcionario();

        departamento.setNome("Engenharia");
        departamentoDao.save(departamento);
        System.out.println(departamentoDao.findAll());

         funcionario.setNome("Sallenkon");
         funcionario.setDepartamento(departamento);
        funcionarioDao.save(funcionario);
        }
    }
