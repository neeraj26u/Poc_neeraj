package com.poc.resful.jersey.namebinder;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.poc.resful.jersey.dao.ItemDao;
import com.poc.resful.jersey.dao.UserDao;
import com.poc.resful.jersey.entities.Item;
import com.poc.resful.jersey.entities.User;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;


@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueItemId.UniqueItemIdValidator.class})
@Documented
public @interface UniqueItemId {
	
	String message() default "ItemId Already Exists";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
    
    public class UniqueItemIdValidator implements ConstraintValidator<UniqueItemId, Item>  {

    	private ItemDao itemDao = new ItemDao();
    	

		@Override
		public boolean isValid(Item value, ConstraintValidatorContext context) {
			Item item = itemDao.findByItemId(value.getItemId());
    		if(item != null)
    		    return false;
    		
    	  return true;
		}

    }
}
