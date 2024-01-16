package com.ra.repository;

import com.ra.model.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<ToDo, Long> {
}
// 1. Khai báo giao diện:
//public interface TodoRepository: Dòng này khai báo một giao diện công cộng có tên TodoRepository. Các giao diện đóng vai trò là bản thiết kế cho các lớp, xác định một tập hợp các phương thức mà các lớp triển khai phải cung cấp.
//2. Mở rộng JpaRepository:
//extends JpaRepository<ToDo, Long>: Phần này biểu thị là TodoRepositorykế thừa từ JpaRepositorygiao diện, do Spring Data JPA cung cấp. Kế thừa này cung cấp TodoRepositorymột tập hợp phong phú các phương thức để làm việc với ToDocác thực thể trong cơ sở dữ liệu bằng cách sử dụng JPA (API liên tục Java).
//3. Thông số loại:
//<ToDo, Long>: Các tham số loại này chỉ định:
//ToDo: Loại thực thể mà kho lưu trữ quản lý.
//Long: Loại khóa chính (ID) của thực thể.
//4. Những điểm chính:
//Không triển khai phương thức: Giao diện không chứa nội dung phương thức. Các lớp thực hiện cung cấp những thứ đó.
//Spring Data JPA Magic: Nó tự động tạo ra một triển khai TodoRepositorytrong thời gian chạy, dựa trên các quy ước.
//Các phương thức có sẵn: Bằng cách mở rộng JpaRepository, bạn sẽ có được một loạt các phương thức sẵn có:
//save(): Lưu một ToDothực thể vào cơ sở dữ liệu.
//findById(Long id): Truy xuất một ToDothực thể theo ID của nó.
//findAll(): Tìm nạp tất cả ToDocác thực thể.
//deleteById(Long id): Xóa một ToDothực thể theo ID của nó.
//Và nhiều hơn nữa, tuân theo các quy ước JPA.
//5. Truy vấn tùy chỉnh:
//Bạn có thể xác định các phương thức truy vấn tùy chỉnh bằng cách TodoRepositorysử dụng các chú thích như @Queryđể truy xuất dữ liệu phức tạp hơn.
//Về bản chất, TodoRepositorycung cấp một cách thuận tiện để tương tác với ToDocác thực thể trong cơ sở dữ liệu bằng JPA mà không cần phải viết mã truy cập dữ liệu soạn sẵn.
