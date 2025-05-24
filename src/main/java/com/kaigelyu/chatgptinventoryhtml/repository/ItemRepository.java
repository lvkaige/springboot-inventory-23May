package com.kaigelyu.chatgptinventoryhtml.repository; // 表示这个包属于java包

import com.kaigelyu.chatgptinventoryhtml.model.Item; // 引入定义的数据库model里的Item类
import org.springframework.data.jpa.repository.JpaRepository; // 导入spring data JPA提供的接口，里面有很多内置的操作（findAll(),save()等等）

// 定义了一个接口 called ItemRepository， which 继承了 JpaRepository
// Item 是要操作的实体类（数据库表）， Long是主键（id）的数据类型
// 这里的意思是：定义了一个ItemRepository接口，让Item这个主键为Long类型的对象可以拥有像是findAll(),save()之类的便携的数据库操作方法
public interface ItemRepository extends JpaRepository<Item, Long> {
}