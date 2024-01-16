package com.ra.controller;

import com.ra.model.entity.ToDo;
import com.ra.service.todoservice.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // Defines an Controller
@RequestMapping("/todos") // Hiển thị cấu trúc thư mục như URI
@CrossOrigin("*") // Cấu hình để API truy cập được đến tất cả mọi nơi
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("") // Ví dụ như khi chúng ta localhost:8888/todos
    public ResponseEntity<List<ToDo>> getAll() {
        List<ToDo> todos = todoService.getAll(); // Khai báo một list để hứng về
        return new ResponseEntity<>(todos, HttpStatus.OK);

        // 1. Chú thích:
        //@GetMapping(""):
        //Chú thích này cho biết getAll()phương thức sẽ xử lý các yêu cầu HTTP GET.
        //Chuỗi trống ""trong chú thích có nghĩa là nó sẽ ánh xạ tới đường dẫn gốc của bộ điều khiển, thường có localhost:8888/todostrong ví dụ của bạn.
        //2. Khai báo phương thức:
        //public ResponseEntity<List<ToDo>> getAll():
        //Điều này khai báo một phương thức có tên getAll()trả về một ResponseEntity<List<ToDo>>đối tượng.
        //ResponseEntitylà một lớp Spring gói gọn một phản hồi, bao gồm mã trạng thái, tiêu đề và nội dung.
        //List<ToDo>chỉ ra rằng nội dung của phản hồi sẽ chứa danh sách ToDocác đối tượng.
        //3. Thân phương pháp:
        //List<ToDo> todos = todoService.getAll();:
        //Dòng này gọi một phương thức có tên getAll()trên lớp dịch vụ có tên todoService.
        //Giả định rằng lớp dịch vụ này xử lý các tương tác với nguồn dữ liệu (ví dụ: cơ sở dữ liệu) để truy xuất ToDocác đối tượng.
        //Các đối tượng được truy xuất ToDođược lưu trữ trong danh sách có tên todos.
        //return new ResponseEntity<>(todos, HttpStatus.OK); Dòng này tạo một ResponseEntity đối tượng mới với:Danh todos sách là nội dung của phản hồi.
        //Mã trạng thái HTTP HttpStatus.OK(200), cho biết việc truy xuất dữ liệu thành công.
        //Đối tượng này ResponseEntitysau đó được trả về dưới dạng phản hồi cho yêu cầu GET.
    }

    // Thêm mới
    @PostMapping("")
    public ResponseEntity<ToDo> save(@RequestBody ToDo todo) {
        ToDo todoNew = todoService.save(todo);
        return new ResponseEntity<>(todoNew, HttpStatus.CREATED);
        // Chú thích:
        //@PostMapping(""): Chú thích này cho biết rằng phương thức xử lý các yêu cầu HTTP POST được gửi đến đường dẫn gốc của bộ điều khiển (ví dụ: /todos). Đó là một lối tắt cho @RequestMapping(method = RequestMethod.POST).
        //Chữ ký phương thức:
        //ResponseEntity<ToDo> công khai được lưu(@RequestBody ToDo all):
        //public: Phương thức này có thể được truy cập từ bên ngoài lớp.
        //ResponseEntity<ToDo>: Phương thức trả về một ResponseEntityđối tượng, đóng gói mã trạng thái phản hồi và đối tượng ToDo đã lưu.
        //save: Tên của phương thức, cho biết mục đích của nó.
        //@RequestBody ToDo todo: Chú thích này yêu cầu Spring trích xuất đối tượng ToDo từ phần thân yêu cầu và liên kết nó với todotham số.
        //Nội dung phương thức:
        //ToDo todoNew = todoService.save(todo);:
        //Gọi savephương thức của todoService(có lẽ là thành phần lớp dịch vụ) để duy trì todođối tượng trong cơ sở dữ liệu.
        //Lưu trữ đối tượng ToDo được trả về (đã lưu) trong todoNewbiến.
        //trả về ResponseEntity mới<>(todoNew, HttpStatus.CREATED);:
        //Xây dựng một ResponseEntityđối tượng với:
        //Nội dung: Đối tượng đã lưu todoNew.
        //Mã trạng thái: HttpStatus.CREATED (201), cho biết việc tạo tài nguyên thành công.
        //Trả về đối tượng này ResponseEntitylàm phản hồi cho yêu cầu POST.
    }

    // Search API theo ID
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getById(@PathVariable Long id) {
        ToDo todo = todoService.finById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
        // 1. Chú thích:
        //@GetMapping("/{id}"): Chú thích này ánh xạ yêu cầu GET HTTP tới phương thức này. Nó chỉ định rằng phương thức này sẽ xử lý các yêu cầu được gửi đến mẫu URL kết thúc bằng ID, chẳng hạn như /todos/123.
        //2. Chữ ký phương thức:
        //public ResponseEntity<ToDo> getById(@PathVariable Long id):
        //public: Phương thức này có thể được truy cập từ bên ngoài lớp.
        //ResponseEntity<ToDo>: Phương thức trả về một ResponseEntityđối tượng chứa một ToDođối tượng làm tải trọng của nó. Điều này cho phép linh hoạt trong việc xử lý các phản hồi HTTP khác nhau.
        //getById: Tên của phương thức, cho biết mục đích truy xuất Công việc bằng ID của nó.
        //@PathVariable Long id: Chú thích này trích xuất giá trị ID từ đường dẫn URL và gán nó cho idtham số.
        //3. Thân phương pháp:
        //ToDo todo = todoService.finById(id);:
        //Gọi todoService.finById(id)phương thức để truy xuất một ToDođối tượng có ID được chỉ định từ nguồn dữ liệu (ví dụ: cơ sở dữ liệu).
        //return new ResponseEntity<>(todo, HttpStatus.OK);:
        //Tạo một ResponseEntityđối tượng chứa todođối tượng được truy xuất.
        //Đặt mã trạng thái HTTP thành HttpStatus.OK(200), cho biết truy xuất thành công.
        //Trả về ResponseEntityđối tượng, đối tượng này sẽ được gửi lại dưới dạng phản hồi cho khách hàng.
    }

    // Update API theo ID
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> update(@RequestBody ToDo todo) {
        ToDo todoUpdate = todoService.save(todo);
        return new ResponseEntity<>(todoUpdate, HttpStatus.OK);
        // 1. Chú thích:
        //@PutMapping("/{id}"):
        //Chỉ định rằng phương thức này xử lý các yêu cầu HTTP PUT được gửi tới một URL có idbiến đường dẫn động (ví dụ: /todos/123).
        //Yêu cầu PUT thường được sử dụng để cập nhật các tài nguyên hiện có.
        //2. Chữ ký phương thức:
        //cập nhật ResponseEntity<ToDo> công khai(@RequestBody ToDo all):
        //Khai báo một phương thức có tên updatechấp nhận một ToDođối tượng làm đầu vào và trả về một ResponseEntity<ToDo>đối tượng.
        //@RequestBodychú thích: Ánh xạ nội dung yêu cầu JSON đến todođối tượng.
        //3. Logic:
        //Cập nhật việc cần làm:
        //todoService.save(todo)gọi một phương thức dịch vụ (có thể từ một lớp dịch vụ riêng biệt) để cập nhật todođối tượng được cung cấp trong nguồn dữ liệu (ví dụ: cơ sở dữ liệu).
        //Đối tượng cập nhật ToDođược trả về và lưu trữ trong todoUpdatebiến.
        //Tạo một thực thể phản hồi:
        //new ResponseEntity<>(todoUpdate, HttpStatus.OK)xây dựng một đối tượng phản hồi với hai phần:
        //Đối tượng được cập nhật todoUpdatelàm nội dung phản hồi.
        //Mã trạng thái HTTP 200 (OK)để cho biết cập nhật thành công.
        //4. Trả lời phản hồi:
        //Đối ResponseEntitytượng được trả về, chứa đối tượng ToDo đã cập nhật và mã trạng thái thành công. Phản hồi này sẽ được gửi lại cho khách hàng.
    }

    // Delete API theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // 1. Chú thích:
        //@DeleteMapping("/{id}"): Chú thích này phục vụ hai mục đích chính:
        //Nó ánh xạ phương thức để xử lý các yêu cầu HTTP DELETE.
        //Nó chỉ định mẫu URL cho ánh xạ này, bao gồm phần giữ chỗ cho giá trị ID ( {id}).
        //2. Chữ ký phương thức:
        //public ResponseEntity<?> delete(@PathVariable Long id):
        //Phương thức này được khai báo để publiclàm cho nó có thể truy cập được từ bên ngoài lớp.
        //Nó trả về một ResponseEntity<?>, là loại Spring để biểu thị các phản hồi HTTP, bao gồm mã trạng thái, tiêu đề và nội dung nội dung (nếu có).
        //Nó nhận một đối số duy nhất, @PathVariable Long id, lấy giá trị ID từ đường dẫn URL và làm cho nó có sẵn trong phương thức.
        //3. Thân phương pháp:
        //todoService.delete(id):
        //Dòng này gọi một phương thức có tên deletetrên một đối tượng có tên là todoService. Có khả năng đây todoServicelà lớp dịch vụ chịu trách nhiệm xử lý các hoạt động liên quan đến việc cần làm, chẳng hạn như xóa một mục việc cần làm.
        //Nó chuyển giá trị ID đã nhận ( id) cho deletephương thức, có lẽ là để xác định mục việc cần làm cụ thể cần xóa.
        //trả về ResponseEntity mới<>(HttpStatus.NO_CONTENT):
        //Dòng này xây dựng và trả về một ResponseEntityđối tượng có mã trạng thái HttpStatus.NO_CONTENT.
        //HttpStatus.NO_CONTENT(204) là mã trạng thái HTTP tiêu chuẩn cho biết rằng yêu cầu đã thành công nhưng không có nội dung nào để trả về trong nội dung phản hồi. Đây là quy ước chung cho các thao tác DELETE thành công.
    }
}

// 1. Định nghĩa lớp:
//@Controller: Chú thích này đánh dấu lớp này là bộ điều khiển Spring MVC, cho biết rằng nó xử lý các yêu cầu HTTP đến và tạo ra các phản hồi thích hợp.
//@RequestMapping("/todos"): Chú thích này ánh xạ các yêu cầu đến với đường dẫn "/todos" tới bộ điều khiển này. Vì vậy, mọi yêu cầu bắt đầu bằng "/todos" sẽ được lớp này xử lý.
//@CrossOrigin("*"): Chú thích này cho phép chia sẻ tài nguyên nhiều nguồn gốc (CORS), cho phép các yêu cầu từ bất kỳ nguồn gốc (miền) nào truy cập API này.

//2. Chèn phụ thuộc:
//@Autowired: Chú thích này tự động đưa một thể hiện của TodoService lớp vào todoService trường, làm cho nó có sẵn để sử dụng trong các phương thức của bộ điều khiển.

//3. Điểm cuối:
//@GetMapping(""): Chú thích này ánh xạ các yêu cầu GET tới đường dẫn gốc "/todos". Nó truy xuất danh sách tất cả các việc cần làm bằng todoService.getAll()phương thức này và trả về chúng dưới dạng phản hồi JSON với mã trạng thái là 200 (OK).
//@PostMapping(""): Chú thích này ánh xạ các yêu cầu POST tới đường dẫn gốc "/todos". Nó chấp nhận một đối tượng việc cần làm mới trong phần thân yêu cầu, lưu nó bằng phương todoService.save()thức và trả về đối tượng việc cần làm đã lưu dưới dạng phản hồi JSON với mã trạng thái là 201 (Đã tạo).
//@GetMapping("/{id}"): Chú thích này ánh xạ các yêu cầu GET với biến đường dẫn "id" (ví dụ: "/todos/123") để truy xuất một việc cần làm cụ thể theo ID của nó. Nó gọi todoService.finById()phương thức để tìm việc cần làm và trả về dưới dạng phản hồi JSON với mã trạng thái là 200 (OK).
//@PutMapping("/{id}"): Chú thích này ánh xạ các yêu cầu PUT với biến đường dẫn "id" để cập nhật việc cần làm hiện có. Nó chấp nhận đối tượng việc cần làm đã cập nhật trong phần thân yêu cầu, gọi todoService.save()phương thức để lưu các thay đổi và trả về đối tượng việc cần làm đã cập nhật dưới dạng phản hồi JSON với mã trạng thái là 200 (OK).
//@DeleteMapping("/{id}"): Chú thích này ánh xạ các yêu cầu XÓA với biến đường dẫn "id" để xóa việc cần làm theo ID của nó. Nó gọi todoService.delete()phương thức xóa việc cần làm và trả về phản hồi trống với mã trạng thái là 204 (Không có nội dung), cho biết việc xóa thành công.

//4. Xử lý phản hồi:
//ResponseEntity: Lớp này được sử dụng để tạo phản hồi HTTP với mã trạng thái và nội dung phù hợp. Nó cho phép kiểm soát nhiều hơn phản hồi hơn là chỉ trả lại trực tiếp các đối tượng.

