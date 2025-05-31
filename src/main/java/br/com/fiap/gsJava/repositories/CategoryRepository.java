package br.com.fiap.gsJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.gsJava.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	
}