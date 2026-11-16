package br.com.salgados.Massas.Salgados.service;

import br.com.salgados.Massas.Salgados.entity.Category;
import br.com.salgados.Massas.Salgados.entity.Filling;
import br.com.salgados.Massas.Salgados.repository.CategoryRepository;
import br.com.salgados.Massas.Salgados.repository.FillingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FillingService {

        private final FillingRepository fillingRepository;

        public List<Filling> findAll(){
            return fillingRepository.findAll();
        }

        public Filling saveFilling(Filling filling){
            return fillingRepository.save(filling);
        }
        public Optional<Filling> findyById(Long id){
            return fillingRepository.findById(id);
        }
        public void deleteFilling(Long id){
            fillingRepository.deleteById(id);
        }

}
