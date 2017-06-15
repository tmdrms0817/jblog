package com.jx372.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jx372.jblog.vo.UserVo;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return UserVo.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		UserVo vo = (UserVo) obj;
		String name = vo.getName();
		String id = vo.getId();
		String password = vo.getPassword();
		String path = vo.getPath();

		if (path == null || (path.trim().length() == 0)) {
			errors.rejectValue("path", "path");
		} else {

			if (path.equals("join")) {
				if (name == null || name.trim().length() == 0) {
					errors.rejectValue("name", "join.name.empty");
				} else if (name.length() < 2 || name.length() > 8) {
					errors.rejectValue("name", "join.name.length");
				}
			}

			if (id == null || (id.trim().length() == 0)) {
				errors.rejectValue("id", "NotEmpty.userVo.id");
			} else if (id.length() < 5 || id.length() > 12) {
				errors.rejectValue("id", "Length.userVo.id");
			}

			if (password == null || (password.trim().length() == 0)) {
				errors.rejectValue("password", "NotEmpty.userVo.password");
			} else if (password.length() < 8 || password.length() > 15) {
				errors.rejectValue("password", "Length.userVo.password");
			}

		}

	}

}
