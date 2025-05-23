package com.kaigelyu.chatgptinventoryhtml.repository;

import com.kaigelyu.chatgptinventoryhtml.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}