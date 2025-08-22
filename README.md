# GlassApp

## 🇻🇳 Tiếng Việt

### Mô tả
Backend cho ứng dụng tablet tại quầy, hỗ trợ bán hàng (POS) và thử kính AR.  
Ứng dụng chạy **offline**, không yêu cầu tích hợp thanh toán online.  
Backend được phát triển bằng **Java + Spring Boot**, đóng vai trò cung cấp API cho tablet app và xử lý dữ liệu.

#### Thành phần chính
1. **Quản lý Catalog (Product Service)**
    - Lưu trữ thông tin sản phẩm: mã, tên, thương hiệu, ảnh, chất liệu, kích thước...
    - API cho tìm kiếm, lọc theo thương hiệu, kiểu dáng, giá.

2. **Giỏ hàng & Order (Order Service)**
    - Thêm/xóa/cập nhật sản phẩm trong giỏ hàng.
    - Tự động tính tổng tiền và chiết khấu.
    - Xuất order để nhân viên xử lý tại quầy.

3. **Gợi ý sản phẩm (Recommendation Service)**
    - Nhận input dáng mặt từ client (scan từ tablet).
    - Trả về danh sách gọng kính phù hợp.

4. **Hỗ trợ AR (AR Support Service)**
    - Quản lý metadata sản phẩm (ảnh, màu, link model 3D).
    - API cho client AR overlay gọi tới (backend chỉ chuẩn bị dữ liệu).

#### Công nghệ
- **Java + Spring Boot**
- **H2 Database** (cho phát triển/test offline)
- **REST API (JSON)**
- **Swagger/OpenAPI** cho mô tả API

### Biên dịch và chạy cục bộ
``` Bash
git clone https://github.com/ductruonghoc/glassapp.git
cd glassapp
mvn clean package
java -jar target/glassapp-0.0.1-SNAPSHOT.jar
```

---

## 🇬🇧 English

### Description

Backend for an in-store tablet app supporting POS and AR eyewear try-on.  
The app works **offline**, with no need for online payment integration.  
Backend is built with **Java + Spring Boot**, providing APIs for the tablet client and handling business logic.

#### Main Components
1. **Product Catalog Service**
    - Store product data: code, name, brand, image, material, size…
    - API for search and filtering by brand, style, price.

2. **Cart & Order Service**
    - Add/remove/update items in the shopping cart.
    - Automatic pricing and discount calculation.
    - Generate order for staff to process at the counter.

3. **Recommendation Service**
    - Receive face shape input from the client (scanned via tablet).
    - Return recommended frames from the catalog.

4. **AR Support Service**
    - Manage product metadata (images, colors, 3D model links).
    - Provide API for AR overlay client (backend only manages data, no rendering).

#### Tech Stack
- **Java + Spring Boot**
- **H2 Database** (offline dev/test)
- **REST API (JSON)**
- **Swagger/OpenAPI** for API documentation

### Local compile and run
``` Bash
git clone https://github.com/ductruonghoc/glassapp.git
cd glassapp
mvn clean package
java -jar target/glassapp-0.0.1-SNAPSHOT.jar
```
