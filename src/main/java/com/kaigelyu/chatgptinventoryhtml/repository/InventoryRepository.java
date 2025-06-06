package com.kaigelyu.chatgptinventoryhtml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kaigelyu.chatgptinventoryhtml.model.InventoryItem;

/**
 * 库存项数据访问接口，提供 CRUD 等数据库操作方法。
 */
@Repository
// 定义InventoryRepository接口，让主键为long类型的InventoryItem类可以拥有数据库的便捷操作方法
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    // JpaRepository 提供 save, findAll, findById, deleteById 等方法:contentReference[oaicite:12]{index=12}:contentReference[oaicite:13]{index=13}
}
