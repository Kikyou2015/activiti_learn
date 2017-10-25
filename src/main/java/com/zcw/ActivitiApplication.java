package com.zcw;

import javax.sql.DataSource;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActivitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner init(final RepositoryService repositoryService, final RuntimeService runtimeService,
//			final TaskService taskService) {
//
//		return new CommandLineRunner() {
//
//			@Override
//			public void run(String... strings) throws Exception {
//				System.out.println(
//						"Number of process definitions : " + repositoryService.createProcessDefinitionQuery().count());
//				System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//				runtimeService.startProcessInstanceByKey("oneTaskProcess");
//				System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
//			}
//		};
//
//	}
//
//	@Bean
//	InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {
//
//		return new InitializingBean() {
//			public void afterPropertiesSet() throws Exception {
//
//				try {
//					// Group group = identityService.newGroup("user");
//					// group.setName("users");
//					// group.setType("security-role");
//					// identityService.saveGroup(group);
//
//					String[] users = { "a", "b", "c" };
//					for (String user : users) {
//						User admin = identityService.newUser(user);
//						admin.setPassword(user);
//						identityService.saveUser(admin);
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//			}
//		};
//	}
//
//	@Bean
//	public DataSource database() {
//		return DataSourceBuilder.create().url("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8")
//				.username("root").password("123456").driverClassName("com.mysql.jdbc.Driver").build();
//	}

}
