package br.com.baseapp.controllers.api.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.baseapp.domains.ZipCode;
import br.com.baseapp.services.zipcodes.ZipCodesImp;
import br.com.baseapp.services.zipcodes.ZipCodesService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/zip-codes")
@AllArgsConstructor
public class ZipCodesController {

    private ZipCodesService zipCodesService;
    private ZipCodesImp zipCodesImp;

    @GetMapping("/{code}")
    public ResponseEntity<ZipCode> findByCode(@PathVariable("code") String code) {
        // return ResponseEntity.ok(zipCodesService.findByCode(code));
        return ResponseEntity.ok(zipCodesImp.getZipCode());
    }
    
}
