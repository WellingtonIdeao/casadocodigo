package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.UpdateProductForm;

//Validator específico UpdateProductForm

public class UpdateProductFormValidator implements Validator {

	/*recebe a classe do objeto que está querendo ser validado e
	retorna se o validador consegue lidar com ele */
	@Override
	public boolean supports(Class<?> clazz) {
		return UpdateProductForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

	}

}
