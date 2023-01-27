package com.api.produto.controler;

import com.api.produto.model.ProductModel;
import com.api.produto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductControler {
    @Autowired
    private ProductRepository actions;

    //Listar produtos
    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public @ResponseBody List<ProductModel> listAll (){
        return this.actions.findAll();
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public @ResponseBody ProductModel saveNewProduct(@RequestBody ProductModel newProduct){
        return this.actions.save(newProduct);
    };

    @RequestMapping(value = "/produtos/{code}", method = RequestMethod.GET)
    public @ResponseBody ProductModel filterProductById(@PathVariable Integer code){
        System.out.println(code);
        return this.actions.findById(code).get();
    };

    @RequestMapping(value = "/produtos", method = RequestMethod.PUT)
    public @ResponseBody ProductModel updateProduct(@RequestBody ProductModel product){
        return this.actions.save(product);
    };

    @RequestMapping(value = "/produtos/{code}", method = RequestMethod.DELETE)
    public @ResponseBody int removeProduct(@PathVariable Integer code){
        ProductModel productToRemove = filterProductById(code);
        this.actions.delete(productToRemove);
        return code;
    }
}
