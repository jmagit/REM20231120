package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.transaction.Transactional;

@EnableDiscoveryClient
@EnableFeignClients("com.example.application.proxies")
@SpringBootApplication
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Autowired
//	ActorRepository dao;
//	@Autowired
//	ActorService srv;

	@Bean 
	RestTemplate srvRT(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean 
	@LoadBalanced
	RestTemplate srvRTLB(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("Aplicacion arracada");

//		var a = new Actor(0, "Pepito", "Grillo");
//		dao.save(a);
//		var item = dao.findById(202);
//		if (item.isPresent()) {
//			var a = item.get();
//			a.setFirstName(a.getFirstName().toUpperCase());
//			dao.save(a);
//		} else {
//			System.err.println("No encontrado");
//		}
//		dao.deleteById(202);
//		dao.findAll().forEach(System.out::println);
//		dao.findTop5ByFirstNameStartingWithOrderByLastNameDesc("P").forEach(System.out::println);
//		dao.findTop5ByFirstNameStartingWith("P", Sort.by("firstName", "actorId").ascending()).forEach(System.out::println);
//		dao.findByActorIdGreaterThanEqual(200).forEach(System.out::println);
//		dao.findByNovedadesJPQL(200).forEach(System.out::println);
//		dao.findByNovedadesSQL(200).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("actorId"), 200)).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.lessThanOrEqualTo(root.get("actorId"), 5)).forEach(System.out::println);
//		var item = dao.findById(1);
//		if (item.isPresent()) {
//			var a = item.get();
//			System.out.println(a);
////			a.getFilmActors().forEach(f-> System.out.println(f.getFilm().getTitle()));
//		} else {
//			System.err.println("No encontrado");
//		}
//		var a = new Actor(0, null, "12345678z");
////		if(a.isInvalid())
////			System.err.println(a.getErrorsMessage());
////		else
//			dao.save(a);
//		dao.findByActorIdGreaterThanEqual(200).forEach(f-> System.out.println(ActorDTO.from(f)));
//		dao.readByActorIdGreaterThanEqual(200).forEach(System.out::println);
//		dao.queryByActorIdGreaterThanEqual(200).forEach(f -> System.out.println(f.getId() + " " + f.getNombre()));
//		dao.searchByActorIdGreaterThanEqual(200, ActorDTO.class).forEach(System.out::println);
//		dao.searchByActorIdGreaterThanEqual(200, ActorShort.class).forEach(f -> System.out.println(f.getId() + " " + f.getNombre()));
//		srv.getAll().forEach(System.out::println);
//		srv.add(new Actor(1, "PP", "12345678z"));
	}
//	
//	@Transactional
//	void transaccion() {
//		//...
//	}

}
