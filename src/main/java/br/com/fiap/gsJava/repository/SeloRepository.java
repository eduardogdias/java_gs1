package br.com.fiap.gsJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.gsJava.entity.Selo;

@Repository
public interface SeloRepository extends JpaRepository<Selo, Long>{

}
