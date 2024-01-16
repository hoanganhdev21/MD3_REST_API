package com.ra.service.todoservice;

import com.ra.model.entity.ToDo;

import java.util.List;

public interface TodoService {
    List<ToDo> getAll();
    ToDo save(ToDo todo);
    ToDo finById(Long id);
    void delete(Long id);
}
//Đây là bảng phân tích giao TodoServicediện trong Java:
//Mục đích:
//Xác định một tập hợp các phương thức để quản lý các mục việc cần làm trong hệ thống.
//Nó hoạt động như một hợp đồng cho việc triển khai cụ thể nhằm xử lý việc lưu trữ và truy xuất dữ liệu thực tế.
//Phương pháp:
//List<ToDo> getAll():
//Truy xuất danh sách tất cả các mục việc cần làm từ nguồn dữ liệu.
//Trả về danh sách trống nếu không tìm thấy mục nào.
//        ToDo save(ToDo todo):
//Lưu một mục việc cần làm mới vào nguồn dữ liệu.
//Trả về mục đã lưu, có thể có các trường được cập nhật như ID được chỉ định.
//        ToDo findById(Long id):
//Truy xuất một mục việc cần làm cụ thể dựa trên mã định danh (ID) duy nhất của nó.
//Trả về mục được tìm thấy hoặc null nếu không có mục nào có ID đã cho tồn tại.
//void delete(Long id):
//Xóa một mục việc cần làm khỏi nguồn dữ liệu dựa trên ID của nó.
//Không trả về một giá trị.