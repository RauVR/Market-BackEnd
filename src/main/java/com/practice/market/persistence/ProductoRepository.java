package com.practice.market.persistence;

import com.practice.market.persistence.crud.ProductoCrudRepository;
import com.practice.market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {

  private ProductoCrudRepository productoCrudRepository;

  public List<Producto> getAll(){
    return (List<Producto>) productoCrudRepository.findAll();
  }

}
