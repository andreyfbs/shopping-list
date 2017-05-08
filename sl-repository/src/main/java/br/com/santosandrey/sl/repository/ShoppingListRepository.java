package br.com.santosandrey.sl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santosandrey.sl.model.ShoppingListEntity;

public interface ShoppingListRepository extends JpaRepository<ShoppingListEntity, Long> {

}
