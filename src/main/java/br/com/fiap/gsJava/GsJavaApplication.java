package br.com.fiap.gsJava;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.gsJava.entity.Publicacao;
import br.com.fiap.gsJava.entity.Selo;
import br.com.fiap.gsJava.entity.Usuario;
import br.com.fiap.gsJava.repository.PublicacaoRepository;
import br.com.fiap.gsJava.repository.SeloRepository;
import br.com.fiap.gsJava.repository.UsuarioRepository;

@SpringBootApplication
public class GsJavaApplication implements CommandLineRunner{

	
	@Autowired
	private SeloRepository seloRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PublicacaoRepository publicacaoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GsJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Selo s1 = new Selo(null, "comum");
		Selo s2 = new Selo(null, "confiavel");
		Selo s3 = new Selo(null, "heroi");		
		seloRepository.save(s1);
		seloRepository.save(s2);
		seloRepository.save(s3);
		
		
		Usuario u1 = new Usuario(null, "Eduardo", "edu@gmail.com", "123", "Sao Paulo", "São Paulo", "11990001234", s3);
		Usuario u2 = new Usuario(null, "Juliano", "juliano@gmail.com", "456", "Salvador", "Bahia", "11990003333", s1);
		Usuario u3 = new Usuario(null, "Abel", "abel@gmail.com", "789", "Curitiba", "Paraná", "11990004444", s2);
		usuarioRepository.save(u1);
		usuarioRepository.save(u2);
		usuarioRepository.save(u3);
		
		
		Publicacao pub1 = new Publicacao(
			    null,
			    "Alagamento na Av. Brasil",
			    "A avenida está completamente alagada. Evitem passar por lá.",
			    "https://exemplo.com/imagem1.jpg",
			    "São Paulo",
			    "SP",
			    new Date(),
			    "ativo",
			    23L,
			    2L,
			    u1
			);

			Publicacao pub2 = new Publicacao(
			    null,
			    "Deslizamento de terra no Morro Azul",
			    "Deslizamento bloqueou parte da estrada. Autoridades foram acionadas.",
			    "https://exemplo.com/imagem2.jpg",
			    "Petrópolis",
			    "RJ",
			    new Date(),
			    "ativo",
			    47L,
			    1L,
			    u2
			);

			Publicacao pub3 = new Publicacao(
			    null,
			    "Fake News sobre ponte caída",
			    "Circula nas redes uma fake news dizendo que a ponte caiu. Isso é falso.",
			    "https://exemplo.com/imagem3.jpg",
			    "Belo Horizonte",
			    "MG",
			    new Date(),
			    "ativo",
			    5L,
			    19L,
			    u3
			);
			publicacaoRepository.save(pub1);
			publicacaoRepository.save(pub2);
			publicacaoRepository.save(pub3);
	}

}
