package com.xw.cbm.service;

import java.util.List;

import com.xw.cbm.entity.StrFoo;

public interface StrFooService {

	List<StrFoo> findAllStrFooList();

	StrFoo findByName(String name);

	void addStrFoo(StrFoo entity);
}
