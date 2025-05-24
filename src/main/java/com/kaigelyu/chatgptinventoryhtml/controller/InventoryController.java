package com.kaigelyu.chatgptinventoryhtml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.kaigelyu.chatgptinventoryhtml.model.InventoryItem;
import com.kaigelyu.chatgptinventoryhtml.repository.InventoryRepository; // 导入接口,便捷操作数据库

import java.util.List;

/**
 * 库存管理控制器，处理库存项的增删改查请求。
 */
@Controller
public class InventoryController {

    @Autowired // 让spring处理
    // 创建好接口
    private InventoryRepository inventoryRepository;

    // 显示库存列表页面
    @GetMapping("/")
    // Model model是用来与前端交互数据用的
    public String listItems(Model model) {
        // 定义一个存放InventoryItem类的列表items
        List<InventoryItem> items = inventoryRepository.findAll();
        // 传递items参数到listItems页面,model是传递参数用的
        model.addAttribute("items", items);
        return "listItems";  // 对应 templates/listItems.html
    }

    // 显示添加库存项表单
    @GetMapping("/items/new")
    public String showAddForm(Model model) {
        model.addAttribute("item", new InventoryItem());
        return "addItem";  // 对应 templates/addItem.html
    }

    // 处理添加库存项表单提交
    @PostMapping("/items")
    public String addItem(@ModelAttribute InventoryItem item) {
        inventoryRepository.save(item);
        return "redirect:/";  // 重定向到首页，显示更新后的列表
    }

    // 显示编辑库存项表单（跳转新页面）
    @GetMapping("/items/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        InventoryItem item = inventoryRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("无效的库存项ID: " + id));
        model.addAttribute("item", item);
        return "editItem";  // 对应 templates/editItem.html
    }

    // 处理编辑表单提交，保存更新后的库存项
    @PostMapping("/items/{id}")
    public String updateItem(@PathVariable("id") Long id, @ModelAttribute InventoryItem item) {
        // 为确保更新已有记录，设置 ID 后再保存
        item.setId(id);
        inventoryRepository.save(item);
        return "redirect:/";
    }

    // 删除库存项
    @GetMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        inventoryRepository.deleteById(id);
        return "redirect:/";
    }
}
