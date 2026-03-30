# Demo Spring Boot CRUD

Dự án này là một ứng dụng mẫu Spring Boot cho phép quản lý thông tin sản phẩm với các thao tác CRUD cơ bản.

## Giới thiệu

- Ứng dụng chạy trên Spring Boot 4.
- Cung cấp API REST cho đối tượng `Product`.
- Sử dụng JPA với cơ sở dữ liệu H2 nhúng.
- Đã tích hợp SpringDoc OpenAPI để hiển thị tài liệu API.

## Tính năng chính

- Lấy danh sách tất cả sản phẩm
- Lấy sản phẩm theo `id`
- Tạo mới sản phẩm
- Cập nhật sản phẩm
- Xóa sản phẩm

## Công nghệ

- Java 25
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- H2 Database
- SpringDoc OpenAPI

## Cấu trúc chính

- `CrudApplication` - lớp khởi động Spring Boot
- `Product` - entity JPA cho sản phẩm
- `ProductRepository` - interface repository
- `ProductService` - service xử lý nghiệp vụ
- `ProductController` - REST API

## API endpoints

Base URL: `http://localhost:8081/api/products`

- `GET /api/products` - lấy toàn bộ sản phẩm
- `GET /api/products/{id}` - lấy sản phẩm theo `id`
- `POST /api/products` - tạo sản phẩm mới
- `PUT /api/products/{id}` - cập nhật sản phẩm
- `DELETE /api/products/{id}` - xóa sản phẩm

## Chạy ứng dụng

Trên Windows:

```powershell
mvnw.cmd spring-boot:run
```

Hoặc build và chạy jar:

```powershell
mvnw.cmd clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## Cấu hình

- `src/main/resources/application.properties`
  - `spring.application.name=demo`
  - `server.port=8081`
