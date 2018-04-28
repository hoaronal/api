package com.app.vn.controller.user;

import com.app.vn.common.model.PaggingResult;
import com.app.vn.common.model.User;
import com.app.vn.common.utils.CoreResponse;
import com.app.vn.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;

import javax.validation.Valid;

@Controller
@RequestMapping("private")
public class UserController {

    final static Logger logger = Logger.getLogger(UserController.class);

    private UserService userService;

    @Inject
    private PaggingResult result;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("infoUser")
    public String getInfoUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return "";
    }

    @GetMapping("get")
    @ApiOperation(
            value = "Danh sách người dùng(Có phân trang)",
            notes = "Dùng cho chức năng lấy danh sách người dùng."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lấy dữ liệu thành công."),
            @ApiResponse(code = 400, message = "Có lỗi xảy ra khi lấy dữ liệu người dùng!")
    })
    public ResponseEntity<PaggingResult> get(@RequestParam(required = false,defaultValue = "1") int pageNumber,
                                          @RequestParam(required = false,defaultValue = "50") int pageSize){
        Page<User> users = userService.getUsers(pageNumber,pageSize);
        result.setTotalItem(users.getTotalElements());
        result.setTotalPage(users.getTotalPages());
        result.setItemList(users.getContent());
        return new ResponseEntity<PaggingResult>(result, HttpStatus.OK);
    }

    @PostMapping("user/add")
    @ApiOperation(
            value = "Thêm mới người dùng.",
            notes = "Dùng cho chức năng đăng kí thành viên."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Thêm mới người dùng thành công."),
            @ApiResponse(code = 400, message = "Có lỗi xảy ra khi thêm mới người dùng!")
    })
    public ResponseEntity<CoreResponse> add(@RequestBody @Valid User user){
        try {
            User result = userService.add(user);
            if(result != null && result.getId() > 0){
                return new ResponseEntity<CoreResponse>( new CoreResponse(true, result), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<CoreResponse>( new CoreResponse(false, null, "",0), HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            logger.error("Có lỗi xảy ra tại hàm thêm mới người dùng :",e);
            return new ResponseEntity<CoreResponse>(new CoreResponse(false),HttpStatus.NO_CONTENT);
        }
    }
}
