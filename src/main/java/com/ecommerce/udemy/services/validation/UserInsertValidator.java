package com.ecommerce.udemy.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ecommerce.udemy.Dtos.UserInsertDto;
import com.ecommerce.udemy.controllers.exceptions.FieldMessage;
import com.ecommerce.udemy.entities.User;
import com.ecommerce.udemy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDto> {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(UserInsertValid ann) {
	}

	@Override
	public boolean isValid(UserInsertDto dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		User user = repository.findByEmail(dto.getEmail());
		if (user != null) {
			list.add(new FieldMessage("email", "Email já existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
