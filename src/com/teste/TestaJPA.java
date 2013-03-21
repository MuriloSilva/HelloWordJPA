package com.teste;

import com.bean.User;
import com.dao.UserDAO;

public class TestaJPA {
	public static void main(String ...args){
		User user = new User(); 
		user.setName("Murilo");
		user.setPassword("PingaComMeleLimaO");
		
	
		//Insere Usuario
		UserDAO userDAO = new UserDAO();
		userDAO.insere(user);
		System.out.println(user);
		
		//Busca Usuário
		System.out.println(userDAO.busca(8));
	}	
}
