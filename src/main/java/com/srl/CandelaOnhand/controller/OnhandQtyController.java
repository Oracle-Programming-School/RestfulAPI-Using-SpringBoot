/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srl.CandelaOnhand.controller;

import Shopify.DB.DB;
import com.srl.CandelaOnhand.model.OnhandQty;
import com.srl.CandelaOnhand.repository.OnhandQtyRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Shopify.TagsUpdate.Mutations;
import Shopify.TagsUpdate.TagsUpdate;
import Main.InventoryMainPage;

/**
 * 000002171GK4-10Y-STD
 * @author abdul.ahad1
 */
@RestController
@RequestMapping("/srl/api")
public class OnhandQtyController {
     @Autowired
     OnhandQtyRepository onhandQtyRepository;
     
      @GetMapping("/GetCandelaOnhand")
	public ResponseEntity<List<OnhandQty>> getOnhandQty(@RequestParam(required = false) String variantCode) {
		try {   
                       
			List<OnhandQty> qty = new ArrayList<OnhandQty>();

			if (variantCode == null)
				onhandQtyRepository.findAll().forEach(qty::add);
			else
				onhandQtyRepository.findByvariantCode(variantCode).forEach(qty::add);

			if (qty.isEmpty())
                        {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(qty, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
