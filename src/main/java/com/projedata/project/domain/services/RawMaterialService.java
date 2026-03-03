package com.projedata.project.domain.services;

import com.projedata.project.domain.model.RawMaterial;
import com.projedata.project.domain.repository.RawMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RawMaterialService {


        private final RawMaterialRepository rawMaterialRepository;

        public RawMaterialService(RawMaterialRepository rawMaterialRepository){
            this.rawMaterialRepository = rawMaterialRepository;
        }

        public RawMaterial create(RawMaterial rawMaterial){
            return rawMaterialRepository.save(rawMaterial);
        }

        public List<RawMaterial> findAll(){
            return rawMaterialRepository.findAll();
        }

        public RawMaterial findById(Long id){
            return rawMaterialRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("RawMaterial Not Found"));
        }

        public RawMaterial update(Long id, RawMaterial updateRawMaterial){
            RawMaterial rawMaterial = findById(id);
            rawMaterial.setName(updateRawMaterial.getName());
            rawMaterial.setUnit(updateRawMaterial.getUnit());
            rawMaterial.setStockQuantity(updateRawMaterial.getStockQuantity());

            return rawMaterialRepository.save(rawMaterial);

        }

        public void deleteRawMaterial(Long id){
            RawMaterial rawMaterial = findById(id);
            rawMaterialRepository.delete(rawMaterial);
        }


    }


