package com.xw.cbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xw.cbm.entity.StrFoo;
import com.xw.cbm.repo.StrFooRepo;

@Service
public class StrFooServiceImpl implements StrFooService {

	@Autowired StrFooRepo strFooRepo;

	@Override
	public List<StrFoo> findAllStrFooList() {
		return this.strFooRepo.findAll();
	}

	@Override
	public StrFoo findByName(String name) {
		return this.strFooRepo.findUserByName(name);
	}

	@Override
	public void addStrFoo(StrFoo entity) {
		if (this.strFooRepo.strFooExit(entity.getName())) {
			return ;
		}
		this.strFooRepo.save(entity);
	}

}
