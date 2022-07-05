package br.com.spring.bean.scope.web.demo.requestscope.application;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.io.Serializable;

@Component
@RequestScope
public class BeanRequestScopeService{
    private static final String DEFAULT_VALUE = "Hello World!";
    private String name;
    private String oldName;

    public BeanRequestScopeService() {
        System.out.println(this);
        this.name = DEFAULT_VALUE;
    }

    public BeanRequestScopeDTO updateName(final String newName) {
        this.oldName = this.name;
        this.name = newName;

        final BeanRequestScopeDTO beanRequestScopeDTO = new BeanRequestScopeDTO();
        beanRequestScopeDTO.setOldName(this.oldName);
        beanRequestScopeDTO.setName(this.name);

        return beanRequestScopeDTO;
    }
}
