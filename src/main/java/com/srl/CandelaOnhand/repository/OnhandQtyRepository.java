/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srl.CandelaOnhand.repository;

import com.srl.CandelaOnhand.model.OnhandQty;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author abdul.ahad1
 */
public interface OnhandQtyRepository extends JpaRepository<OnhandQty, Long> {
    List<OnhandQty> findByvariantCode(String variantCode);
}
