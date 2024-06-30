package Hibernate;

import Hibernate.dao.DepartamentoImpl;
import Hibernate.dao.FuncionarioImpl;
import Hibernate.dao.ProjetoImpl;
import Hibernate.interfacesDao.DepartamentoDao;
import Hibernate.interfacesDao.FuncionarioDao;
import Hibernate.interfacesDao.ProjetoDao;
import Hibernate.service.MenuOp;

public class Main {
    public static void main(String[] args) {

        DepartamentoDao departamentoDao = new DepartamentoImpl();
        FuncionarioDao funcionarioDao = new FuncionarioImpl();
        ProjetoDao projetoDao = new ProjetoImpl();
        
        MenuOp menu = new MenuOp(departamentoDao, funcionarioDao, projetoDao);

        menu.mostrarMenu();
    }
    }
