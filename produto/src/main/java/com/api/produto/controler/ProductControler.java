package com.api.produto.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductControler {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody String inicio (){
        return "Testando api de produtos";
    }

    @RequestMapping(value = "/sobre", method = RequestMethod.GET)
    public @ResponseBody String sobre (){
        return "Falando sobre o produto";
    }

    @RequestMapping(value = "/contato", method = RequestMethod.GET)
    public @ResponseBody String contato (){
        return "Contato do fornecedor";
    }
}
