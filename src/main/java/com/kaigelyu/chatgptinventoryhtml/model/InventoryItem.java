package com.kaigelyu.chatgptinventoryhtml.model;

import jakarta.persistence.*;

/**
 * 库存项实体类，对应数据库表 inventory_item。
 */
@Entity
@Table(name = "item")  // 指定数据表名
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 主键自增
    private Long id;

    @Column(name = "name", nullable = false)  // 列名为 name（可有可无），不能为空
    private String name;

    @Column(name = "quantity")
    private Integer quantity;


    // 构造方法、getter 和 setter 省略

    // 无参构造函数（JPA 需要）
    public InventoryItem() {}

    // 带参构造函数
    public InventoryItem(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
