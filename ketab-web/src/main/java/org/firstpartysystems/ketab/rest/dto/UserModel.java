package org.firstpartysystems.ketab.rest.dto;

import java.io.Serializable;

public interface UserModel<T extends Serializable> extends Serializable{
	T getId();
	void setId(T id);
}
