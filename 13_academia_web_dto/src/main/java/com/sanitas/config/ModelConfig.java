package com.sanitas.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@PropertySource("classpath:com/sanitas/config/application.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.sanitas.service","com.sanitas.converters"})
@EnableJpaRepositories(basePackages = {"com.sanitas.dao"}, 
						entityManagerFactoryRef = "factory",
						transactionManagerRef = "txManager")
@Configuration
public class ModelConfig {

	@Value("${datasourceRef}")
	String datasourceRef;
	/*@Bean
	public DataSource dataSource() {
		DriverManagerDataSource data=new DriverManagerDataSource();
		data.setDriverClassName(driver);
		data.setUrl(url);
		data.setUsername(user);
		data.setPassword(pwd);
		return data;
	}*/
	@Bean
	public DataSource dataSourceServer() {
		JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource(datasourceRef);
	}
	//adaptador de Hibernate
		@Bean
		public HibernateJpaVendorAdapter adapter() {
			HibernateJpaVendorAdapter adp=new HibernateJpaVendorAdapter();
			adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
			return adp;
		}
		//factoria EntityManager: Objeto para acceder a capa de persistencia con JPA
		@Bean
		public LocalContainerEntityManagerFactoryBean factory(@Qualifier("dataSourceServer") DataSource dataSource, HibernateJpaVendorAdapter adapter) {
			LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
			factory.setPersistenceUnitName("academiaPU");
			factory.setDataSource(dataSource);
			factory.setPackagesToScan("com.sanitas.entities");
			factory.setJpaVendorAdapter(adapter);
			return factory;
		}
		
		//gestor de transacción
		@Bean
		public JpaTransactionManager txManager(LocalContainerEntityManagerFactoryBean factory) {
			JpaTransactionManager manager=new JpaTransactionManager();
			manager.setEntityManagerFactory(factory.getObject());
			return manager;
		}
}
