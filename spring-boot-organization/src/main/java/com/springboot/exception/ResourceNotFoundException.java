package com.springboot.exception;

import com.springboot.entity.ProductCategory;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message){
    	super(message);
    }

    public ResourceNotFoundException(Class<ProductCategory> productCategoryClass, SingularAttribute<AbstractPersistable, Serializable> id) {
    }

    public ResourceNotFoundException() {

    }
}
