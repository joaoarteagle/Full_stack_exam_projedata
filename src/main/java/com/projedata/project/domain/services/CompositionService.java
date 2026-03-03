package com.projedata.project.domain.services;
import com.projedata.project.domain.model.Composition;
import com.projedata.project.domain.repository.CompositionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompositionService {


        private final CompositionRepository compositionRepository;

        public CompositionService(CompositionRepository compositionRepository){
            this.compositionRepository = compositionRepository;
        }

        public Composition create(Composition composition){
            return compositionRepository.save(composition);
        }

        public List<Composition> findAll(){
            return compositionRepository.findAll();
        }

        public Composition findById(Long id){
            return compositionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("composition Not Found"));
        }

        public Composition update(Long id, Composition updatecomposition){
            Composition composition = findById(id);
            composition.setName(updatecomposition.getName());
            composition.setPrice(updatecomposition.getPrice());

            return compositionRepository.save(composition);

        }

        public void deletecomposition(Long id){
            Composition composition = findById(id);
            compositionRepository.delete(composition);
        }


    }


