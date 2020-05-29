package yonas.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yonas.spring.DAO.AppDAOImp;
import yonas.spring.config.AppConfig;
import yonas.spring.model.Users;

@Controller
public class AppController {

	@RequestMapping("/")
	public ModelAndView homepage() {
		ModelAndView model = new ModelAndView("index");
		List<Users> users = new ArrayList<Users>();
		AnnotationConfigApplicationContext context
		= new AnnotationConfigApplicationContext(AppConfig.class);
	
		AppDAOImp DAO = context.getBean("DAOBean", AppDAOImp.class);
		
		users = DAO.listUsers();
        model.addObject("users", users);
		context.close();
		return model;
	}
}
