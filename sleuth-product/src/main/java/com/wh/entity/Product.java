package com.wh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author wangwenhao
 * @description Product
 * @date 2020-06-17 09:03
 */
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 6584057944868493515L;

    @Id
    @GeneratedValue
    private Long id;

    private String productName;

    private Integer status;

    private BigDecimal price;

    private String productDesc;

    private String caption;

    private Long inventory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(status, product.status) &&
                Objects.equals(price, product.price) &&
                Objects.equals(productDesc, product.productDesc) &&
                Objects.equals(caption, product.caption) &&
                Objects.equals(inventory, product.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, status, price, productDesc, caption, inventory);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", status=" + status +
                ", price=" + price +
                ", productDesc='" + productDesc + '\'' +
                ", caption='" + caption + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
