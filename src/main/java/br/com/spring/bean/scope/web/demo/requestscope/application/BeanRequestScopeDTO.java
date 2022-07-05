package br.com.spring.bean.scope.web.demo.requestscope.application;

public class BeanRequestScopeDTO {
    private String name;
    private String oldName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }
}
