package br.com.santosandrey.sl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santosandrey.sl.model.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

}
