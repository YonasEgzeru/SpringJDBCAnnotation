package yonas.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import yonas.spring.DAO.AppDAOImp;

@Configuration
public class AppConfig {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/project");
		dataSource.setUsername("root");
		dataSource.setPassword("Yoraelsi#5");
		return dataSource;
	}
	
	@Bean(name = "DAOBean")
	public AppDAOImp AppDAO() {		
		return new AppDAOImp(getDataSource());
	}
}
