package br.com.provacast.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.provacast.domains.ZipCode;

@FeignClient(name = "ZipCode", url = "http://viacep.com.br/ws")
public interface ZipCodesEndPointImp {
    
    @RequestMapping(value = "/{zipcode}/json/", method = RequestMethod.GET)
    ZipCode getZipCode(@PathVariable("zipcode") String code);
}