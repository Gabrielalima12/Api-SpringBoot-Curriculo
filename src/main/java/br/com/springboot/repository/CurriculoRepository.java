package br.com.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.com.springboot.model.Curriculo;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {

    
} 