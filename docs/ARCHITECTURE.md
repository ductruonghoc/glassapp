# Kiến trúc hệ thống GlassApp

## 🇻🇳 Tiếng Việt 

### Mô tả các module

#### 1. Catalog

- Quản lý sản phẩm: thêm, sửa, xóa, tìm kiếm sản phẩm.
- Cung cấp API cho client truy vấn thông tin sản phẩm.

#### 2. Cart

- Quản lý giỏ hàng: thêm/xóa sản phẩm vào giỏ, cập nhật số lượng.
- Xử lý logic liên quan đến giỏ hàng của người dùng.

#### 3. Face

- Xử lý các chức năng nhận diện khuôn mặt (nếu có).
- Tích hợp các API nhận diện, xác thực người dùng qua khuôn mặt.

#### 4. Common

- Chứa các thành phần dùng chung: cấu hình, tiện ích, exception, response, ...
- Hỗ trợ các module khác hoạt động nhất quán.

### Ngăn xếp công nghệ

- **Java 21**
- **Spring Boot 3.3**
- **H2 Database** (dùng cho môi trường phát triển/test)
- **Maven** (quản lý phụ thuộc và build project)

### Luồng cơ bản

```
Client → API (Controller) → Service → Repository → DB (H2)
```

- Client gửi request tới API.
- Controller nhận request, gọi Service xử lý nghiệp vụ.
- Service thao tác với Repository để truy xuất dữ liệu.
- Repository kết nối và thao tác với DB.

---

## 🇬🇧 English

### Module Descriptions

#### 1. Catalog

- Manages products: add, edit, delete, and search products.
- Provides an API for clients to query product information.

#### 2. Cart

- Manages the shopping cart: add/remove products, update quantities.
- Handles user-related shopping cart logic.

#### 3. Face

- Handles facial recognition functions (if any).
- Integrates APIs for facial recognition and user authentication.

#### 4. Common

- Contains shared components: configurations, utilities, exceptions, responses, etc.
- Supports other modules to ensure consistent operation.

### Technology Stack

- **Java 21**
- **Spring Boot 3.3**
- **H2 Database (used for development/testing environments)**
- **Maven (dependency management and project build)**

### Basic Flow
```
Client → API (Controller) → Service → Repository → DB (H2)
```

- The client sends a request to the API.
- The Controller receives the request and calls the Service to handle business logic.
- The Service interacts with the Repository to retrieve data.
- The Repository connects to and interacts with the DB.