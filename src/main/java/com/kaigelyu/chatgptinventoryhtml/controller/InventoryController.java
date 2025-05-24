package com.kaigelyu.chatgptinventoryhtml.controller; // 这个文件类似于views.py，编写时候把urls.py与views.py结合了

import com.kaigelyu.chatgptinventoryhtml.model.Item; // 导入在model文件夹里定义的模型文件 item
import com.kaigelyu.chatgptinventoryhtml.repository.ItemRepository; // 导入类似Django的ORM文件
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller//这是一个控制器类，类似django的视图函数
public class InventoryController {

    @Autowired
    private ItemRepository itemRepository; // 把接口给弄进来

    // Mapping前面的Get是指，这是一个Get请求
    @GetMapping("/")
    public String index(Model model) {
        // 学习一下这里的语法，与django不同
        // 这里需要传输数据，用到了itemRepository里的接口（ORM）
        model.addAttribute("items", itemRepository.findAll());
        return "index";
        // items = Items.objects.all()
        // return render(request, 'index.html',{"items".items})
    }

    // 这是一个Post请求，网址后缀是 /add
    // @RequestParam 是指获取表单中名为name字段的内容
    // name = request.POST.get('name')
    @PostMapping("/add")
    public String addItem(@RequestParam String name, @RequestParam Integer quantity) {
        Item item = new Item(); // 利用Item类新建一个item对象
        item.setName(name); // 调用item对象里的方法
        item.setQuantity(quantity);
        itemRepository.save(item); // item.save()
        return "redirect:/"; // 重定向url到 “/”
    }
}