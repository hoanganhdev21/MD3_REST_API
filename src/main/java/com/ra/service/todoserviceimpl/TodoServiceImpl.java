package com.ra.service.todoserviceimpl;

import com.ra.model.entity.ToDo;
import com.ra.repository.TodoRepository;
import com.ra.service.todoservice.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<ToDo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public ToDo save(ToDo toDo) {
        return todoRepository.save(toDo);
    }

    @Override
    public ToDo finById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
// 1. Khai báo lớp:
//@Service: Chú thích này đánh dấu lớp này là một Bean dịch vụ Spring, cho biết nó cung cấp chức năng logic nghiệp vụ trong ứng dụng.
//public class TodoServiceImpl implements TodoService:
//Khai báo một lớp công khai có tên TodoServiceImpl.
//Triển khai TodoServicegiao diện, đề xuất giao diện tuân thủ hợp đồng được xác định trước cho các hoạt động liên quan đến việc cần làm.
//2. Chèn phụ thuộc:
//@Autowired private TodoRepository todoRepository;:
//Tiêm một thể hiện của TodoRepositoryvào lớp dịch vụ.
//@Autowiredtự động hóa việc quản lý phần phụ thuộc, cho phép Spring đưa vào đối tượng kho lưu trữ cần thiết.
//3. Phương pháp:
//public List<ToDo> getAll():
//Lấy danh sách tất cả ToDocác đối tượng từ kho lưu trữ.
//Ủy quyền việc truy xuất thực tế cho todoRepository.findAll()phương thức.
//public ToDo save(ToDo toDo):
//Lưu một ToDođối tượng mới vào kho lưu trữ.
//Một lần nữa, hãy dựa vào save()phương pháp của kho lưu trữ để lưu giữ dữ liệu.
//public ToDo finById(Long id):
//Tìm nạp một ToDođối tượng có ID được chỉ định.
//Sử dụng todoRepository.findById(), xử lý sự vắng mặt tiềm ẩn của một đối tượng phù hợp bằng cách trả về null.
//public void delete(Long id):
//Xóa một ToDođối tượng có ID đã cho.
//Các cuộc gọi todoRepository.deleteById()để thực hiện việc xóa.
//Những điểm chính:
//Lớp dịch vụ: Lớp này đại diện cho một thành phần lớp dịch vụ, thường xử lý logic nghiệp vụ và tương tác với các lớp truy cập dữ liệu.
//Tương tác kho lưu trữ: Nó dựa vào TodoRepository(có thể là kho lưu trữ JPA dữ liệu mùa xuân) để quản lý các tương tác với cơ sở dữ liệu cơ bản.
//Hoạt động CRUD: Nó thực hiện các hoạt động CRUD (Tạo, Đọc, Cập nhật, Xóa) cơ bản cho ToDocác thực thể.
