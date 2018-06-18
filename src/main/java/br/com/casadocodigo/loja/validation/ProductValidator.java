package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Product;

public class ProductValidator implements Validator {

	/*recebe a classe do objeto que está querendo ser validado e
	retorna se o validador consegue lidar com ele */
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"title", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"description", "field.required");
		Product product = (Product) target;
		
		if(product.getPages() == 0){
			errors.rejectValue("pages", "field.required");
		}
		
	}

}
