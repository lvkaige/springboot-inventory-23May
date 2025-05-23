src/
└── main/
    └── java/
        └── com/kaigelyu/chatgptinventoryhtml/
            ├── ChatgptInventoryHtmlApplication.java     // 启动类（类似 Django 的 manage.py）
            ├── controller/InventoryController.java      // 控制器：处理网页请求（类似 views.py）
            ├── model/Item.java                          // 模型类：映射数据库表（类似 models.py）
            └── repository/ItemRepository.java           // 仓库：数据库操作接口（类似 Django ORM）


resources/
├── application.properties    // Spring Boot 配置文件（类似 settings.py）
└── templates/
    └── index.html            // Thymeleaf 模板页面（类似 Django 模板 .html 文件）
