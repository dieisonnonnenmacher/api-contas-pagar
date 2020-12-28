package br.com.apicontaspagar.repository;

import br.com.apicontaspagar.entity.ContasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ContasRepository extends JpaRepository<ContasEntity, Long>, JpaSpecificationExecutor<ContasEntity> {
    //ContasEntity save(ContasEntity contas);
}