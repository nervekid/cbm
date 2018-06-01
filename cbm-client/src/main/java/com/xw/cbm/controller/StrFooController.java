package com.xw.cbm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xw.cbm.entity.StrFoo;
import com.xw.cbm.service.StrFooService;

@Controller
@RequestMapping(value =  "/strfoo/")
@EntityScan(basePackages = "com.xw.cbm.entity")
public class StrFooController {

	@Autowired
    private StrFooService strFooService;

	@GetMapping("getStrFooById/{name}")
	public ResponseEntity<StrFoo> getStrFooById(@PathVariable("name") String name) {
		//测试提交
		StrFoo strFoo = this.strFooService.findByName(name);
		return new ResponseEntity<StrFoo>(strFoo, HttpStatus.OK);
	}

	@GetMapping("findStrFooList")
	public ResponseEntity<List<StrFoo>> findStrFooList() {
		List<StrFoo> list = this.strFooService.findAllStrFooList();
		return new ResponseEntity<List<StrFoo>>(list, HttpStatus.OK);
	}

	@PostMapping("article")
	public void addArticle(@RequestBody StrFoo strFoo) {
        this.strFooService.addStrFoo(strFoo);
	}
}
