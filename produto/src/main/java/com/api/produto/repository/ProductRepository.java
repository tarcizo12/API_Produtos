package com.api.produto.repository;

import com.api.produto.model.ProductModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository <ProductModel, Integer> {
        //Lista produtos
        List<ProductModel> findAll();

        //Pesquisar por id
        ProductModel findById(int primaryKey);

        //Remover produto
        void delete(ProductModel product);

        //Cadastrar ou alterar produto
        <ProdMod extends ProductModel> ProdMod  save(ProductModel product);
}
