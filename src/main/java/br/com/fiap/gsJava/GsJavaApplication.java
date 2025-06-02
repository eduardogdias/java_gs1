package br.com.fiap.gsJava;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.gsJava.entities.Category;
import br.com.fiap.gsJava.entities.Product;
import br.com.fiap.gsJava.entities.Selo;
import br.com.fiap.gsJava.entities.Usuario;
import br.com.fiap.gsJava.repositories.CategoryRepository;
import br.com.fiap.gsJava.repositories.ProductRepository;
import br.com.fiap.gsJava.repositories.SeloRepository;
import br.com.fiap.gsJava.repositories.UsuarioRepository;

@SpringBootApplication
public class GsJavaApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SeloRepository seloRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GsJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");

		Product p1 = new Product(null, "TV", 2200.00, cat1);
		Product p2 = new Product(null, "Domain Driven Design", 120.00, cat2);
		Product p3 = new Product(null, "PS5", 2800.00, cat1);
		Product p4 = new Product(null, "Docker", 100.00, cat2);

		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
		
		Selo s1 = new Selo(null, "comum");
		Selo s2 = new Selo(null, "confiavel");
		Selo s3 = new Selo(null, "heroi");		
		seloRepository.save(s1);
		seloRepository.save(s2);
		seloRepository.save(s3);
		
		
		Usuario u1 = new Usuario(null, "Eduardo", "edu@gmail.com", "123", "Sao Paulo", "São Paulo", "11990001234", s3);
		Usuario u2 = new Usuario(null, "Juliano", "juliano@gmail.com", "456", "Salvado", "Bahia", "11990003333", s1);
		Usuario u3 = new Usuario(null, "Abel", "abel@gmail.com", "789", "Curitiba", "Paraná", "11990004444", s2);
		usuarioRepository.save(u1);
		usuarioRepository.save(u2);
		usuarioRepository.save(u3);
	}

}
