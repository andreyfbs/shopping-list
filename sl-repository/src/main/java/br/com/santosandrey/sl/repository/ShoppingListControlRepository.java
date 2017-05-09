package br.com.santosandrey.sl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santosandrey.sl.model.ShoppingListControlEntity;

public interface ShoppingListControlRepository extends JpaRepository<ShoppingListControlEntity, Long> {

}
