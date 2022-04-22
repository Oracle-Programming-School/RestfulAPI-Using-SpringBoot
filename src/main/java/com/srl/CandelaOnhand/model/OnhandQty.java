/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srl.CandelaOnhand.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.hibernate.annotations.Subselect;

/**
 *
 * @author abdul.ahad1
 */
@Entity
@Immutable
@Subselect("select  row_number() OVER (ORDER BY variant_code) row_id,variant_code ,sum(quantity) candela_qty\n" +
"from [candelastml].[dbo].[vwShopProductInventory] \n" +
"where 1=1   \n" +
"and shop_id = 13  \n" +
" GROUP BY variant_code  ")
public class OnhandQty implements Serializable{
     private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "row_id")
    private long row_id;
    @Column(name = "variant_code", nullable = false)
    private String variantCode;
    @Column(name = "candela_qty", nullable = false)
    private int candela_qty;
    
    public OnhandQty(){}

    public long getRow_id() {
        return row_id;
    }

    public void setRow_id(long row_id) {
        this.row_id = row_id;
    }

    public String getvariantCode() {
        return variantCode;
    }

    public void setVariant_code(String variantCode) {
        this.variantCode = variantCode;
    }

    public int getCandela_qty() {
        return candela_qty;
    }

    public void setCandela_qty(int candela_qty) {
        this.candela_qty = candela_qty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OnhandQty{row_id=").append(row_id);
        sb.append(", variant_code=").append(variantCode);
        sb.append(", candela_qty=").append(candela_qty);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
