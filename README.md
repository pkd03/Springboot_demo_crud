# Spring Boot CRUD - Quản lý Sản phẩm

Ứng dụng mẫu Spring Boot cung cấp các API REST để quản lý sản phẩm với đầy đủ các thao tác CRUD (Create, Read, Update, Delete).

## 📋 Giới thiệu

Đây là một ứng dụng Spring Boot đơn giản nhưng hoàn chỉnh, được thiết kế để:
- Cung cấp REST API cho quản lý thông tin sản phẩm
- Minh họa các best practices trong Spring Boot development
- Sử dụng Spring Data JPA để tương tác với cơ sở dữ liệu
- Cấu hình bảo mật cơ bản với Spring Security

## 🚀 Tính năng chính

| Chức năng | Mô tả |
|----------|-------|
| **Danh sách sản phẩm** | Lấy toàn bộ danh sách sản phẩm |
| **Chi tiết sản phẩm** | Lấy thông tin chi tiết sản phẩm theo ID |
| **Tạo sản phẩm** | Thêm sản phẩm mới vào hệ thống |
| **Cập nhật sản phẩm** | Chỉnh sửa thông tin sản phẩm hiện có |
| **Xóa sản phẩm** | Xóa sản phẩm khỏi hệ thống |

## 🛠️ Công nghệ sử dụng

- **Java 17** - Ngôn ngữ lập trình
- **Spring Boot 4** - Framework chính
- **Spring Web** - Xây dựng REST API
- **Spring Data JPA** - ORM và data access
- **H2 Database** - Cơ sở dữ liệu nhúng
- **Spring Security** - Xác thực và phân quyền
- **Maven** - Build tool

## 📁 Cấu trúc thư mục

```
src/main/java/com/example/demo/
├── CrudApplication.java          # Entry point của ứng dụng
├── config/                       # Cấu hình ứng dụng
├── controller/
│   └── ProductController.java    # REST API endpoints
├── dto/                          # Data Transfer Objects
├── model/
│   └── Product.java              # Entity JPA
├── repository/
│   └── ProductRepository.java    # Data access layer
├── service/
│   └── ProductService.java       # Business logic
├── security/
│   └── UserConfiguration.java    # Spring Security config
└── util/                         # Utility classes

src/main/resources/
└── application.properties        # Cấu hình ứng dụng
```

## 🔌 API Endpoints

**Base URL:** `http://localhost:8081/api/products`

### GET - Lấy danh sách sản phẩm
```http
GET /api/products
```
Trả về danh sách tất cả sản phẩm

**Response:**
```json
[
  {
    "id": 1,
    "name": "Sản phẩm A",
    "price": 100000,
    "description": "Mô tả sản phẩm A"
  }
]
```

### GET - Lấy sản phẩm theo ID
```http
GET /api/products/{id}
```

**Response:**
```json
{
  "id": 1,
  "name": "Sản phẩm A",
  "price": 100000,
  "description": "Mô tả sản phẩm A"
}
```

### POST - Tạo sản phẩm mới
```http
POST /api/products
Content-Type: application/json

{
  "name": "Sản phẩm B",
  "price": 200000,
  "description": "Mô tả sản phẩm B"
}
```

### PUT - Cập nhật sản phẩm
```http
PUT /api/products/{id}
Content-Type: application/json

{
  "name": "Sản phẩm A (cập nhật)",
  "price": 150000,
  "description": "Mô tả được cập nhật"
}
```

### DELETE - Xóa sản phẩm
```http
DELETE /api/products/{id}
```

## 💻 Hướng dẫn chạy ứng dụng


### Chạy ứng dụng trên Windows

**Cách 1: Chạy trực tiếp với Maven**
```powershell
mvnw.cmd spring-boot:run
```

**Cách 2: Build JAR và chạy**
```powershell
mvnw.cmd clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

### Truy cập ứng dụng

Sau khi khởi động thành công, ứng dụng sẽ chạy trên: `http://localhost:8081`

- **API Endpoint:** http://localhost:8081/api/products
- **Tài liệu API (Swagger UI):** http://localhost:8081/swagger-ui.html

## ⚙️ Cấu hình

Tệp cấu hình chính: `src/main/resources/application.properties`

```properties
spring.application.name=demo
server.port=8081
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

## 🧪 Kiểm thử
### Với Postman
1. Nhập base URL: `http://localhost:8081/api/products`
2. Sử dụng các method HTTP tương ứng (GET, POST, PUT, DELETE)
3. Gửi request để kiểm thử các endpoint

## 📝 Ghi chú

- Ứng dụng sử dụng cơ sở dữ liệu H2 nhúng (in-memory), dữ liệu sẽ bị xóa khi khởi động lại
- Để sử dụng cơ sở dữ liệu lâu dài, hãy cấu hình PostgreSQL hoặc MySQL
- Spring Security được cấu hình cơ bản, có thể mở rộng để bổ sung xác thực
