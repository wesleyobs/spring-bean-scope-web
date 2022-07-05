package br.com.spring.bean.scope.web.demo.requestscope.controller;

import br.com.spring.bean.scope.web.demo.requestscope.application.BeanRequestScopeService;
import br.com.spring.bean.scope.web.demo.requestscope.application.BeanRequestScopeDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public record RequestScopeController(BeanRequestScopeService beanRequestScopeService) {

    @GetMapping(value = "/scope", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BeanRequestScopeDTO> getRequestScopeWithNoParameter() {
        final BeanRequestScopeDTO beanRequestScopeDTO = this.beanRequestScopeService.updateName("Value of attribute name was changed!");
        return ResponseEntity.ok(beanRequestScopeDTO);
    }

    @GetMapping(value = "/scope/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BeanRequestScopeDTO> getRequestScopeWithNameParameter(@PathVariable("name") final String name) {
        final BeanRequestScopeDTO beanRequestScopeDTO = this.beanRequestScopeService.updateName(name);
        return ResponseEntity.ok(beanRequestScopeDTO);
    }
}
