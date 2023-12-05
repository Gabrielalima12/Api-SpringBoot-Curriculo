package br.com.springboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.model.Curriculo;
import br.com.springboot.repository.CurriculoRepository;

@RestController
@RequestMapping("/curriculo")
public class CurriculoController {

    private List<Curriculo> curriculo = new ArrayList<>();

    @Autowired
    private CurriculoRepository curriculoRepository;

  @GetMapping("/{id}")
  public Curriculo curriculo(@PathVariable("id") Long id) {
    
    java.util.Optional<Curriculo> curriculoFind = this.curriculoRepository.findById(id);
    

    if (curriculoFind.isPresent()) {
      return curriculoFind.get();
    }

    return null;
  }

  @PostMapping("/")
  public Curriculo curriculo(@RequestBody Curriculo curriculo) {
   return this.curriculoRepository.save(curriculo);
    
  }

  @GetMapping("/list")
  public List<Curriculo> listCurriculo() {
    return this.curriculoRepository.findAll() ;
  }

  @DeleteMapping("/{id}")
    public void deleteCurriculo(@PathVariable("id") Long id) {
        this.curriculoRepository.deleteById(id);
    }


}
