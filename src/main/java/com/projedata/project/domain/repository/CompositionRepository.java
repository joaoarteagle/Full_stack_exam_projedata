package com.projedata.project.domain.repository;

import com.projedata.project.domain.model.Composition;
import com.projedata.project.domain.model.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompositionRepository extends JpaRepository<Composition, Long> {
    List<RawMaterial> findByProductId(Long id);
}
