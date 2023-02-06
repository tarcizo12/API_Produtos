package com.api.produto.controler;

import com.api.produto.model.ProductModel;
import com.api.produto.model.ResponseModel;
import com.api.produto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductControler {
    @Autowired
    private ProductRepository actions;

    //Listar produtos
    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public @ResponseBody List<ProductModel> listAll (){
        ResponseModel response = new ResponseModel();
        try{
            return this.actions.findAll();
        }catch(Error error){
            return null;
        }
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public @ResponseBody ResponseModel saveNewProduct(@RequestBody ProductModel newProduct){
        ResponseModel response = new ResponseModel();
        try{
            ProductModel productSaved = this.actions.save(newProduct);
            response.setMessage("Sucesso ao salvar o novo produto no codigo: "+ productSaved.getCode());
            response.setProductUsed(productSaved);
        }catch(Exception erro){
            response.setMessage("Erro ao tentar salvar o novo produto de nome: "+ newProduct.getName());
            response.setError(erro);
        }
        return response;
    }

    //Realizar verificação caso o produto existe
    @RequestMapping(value = "/produtos/{code}", method = RequestMethod.GET)
    public @ResponseBody ResponseModel filterProductById(@PathVariable Integer code){
        ResponseModel response = new ResponseModel();
        try{
            ProductModel desiredProduct = new ProductModel();
            if(this.actions.findById(code).isPresent()){
                desiredProduct = this.actions.findById(code).get();
                response.setMessage("Sucesso ao achar o produto de codigo: " + code);
                response.setProductUsed(desiredProduct);
            }else{
                response.setMessage("Nao foi possui achar esse produto no sistema, de codigo: "+ code);
            }
        }catch(Exception error){
            response.setMessage("Erro ao tentar procurar o produto de codigo: " +code);
            response.setError(error);
        }
        return response;
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.PUT)
    public @ResponseBody ResponseModel updateProduct(@RequestBody ProductModel product){

        ResponseModel response = new ResponseModel();
        try{
            ProductModel productToUpdate = this.actions.save(product);
            response.setMessage("Sucesso ao atualizar o produto de codigo: "+ product.getCode());
            response.setProductUsed(productToUpdate);
        }catch (Exception error){
            response.setMessage("Erro ao tentar atualizar o produto");
            response.setError(error);
        }
        return response;
    }

    @RequestMapping(value = "/produtos/{code}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseModel removeProduct(@PathVariable Integer code){
        ResponseModel response = new ResponseModel();
        try{
            if (this.actions.findById(code).isPresent()) {
                ProductModel productToRemove = this.actions.findById(code).get();
                this.actions.delete(productToRemove);
                response.setMessage("Sucesso ao deletar o item de codigo: "+ code);
                response.setProductUsed(productToRemove);
            }else{
                response.setMessage("Nao foi possivel encontrar esse produto");
            }
        }catch (Exception error){
            response.setMessage("Erro ao deletar o item de codigo: "+ code);
            response.setError(error);
        }
        return response;
    }
}
