package com.app.vn.controller.media;

import com.app.vn.common.model.Media;
import com.app.vn.common.utils.CoreResponse;
import com.app.vn.service.media.MediaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("private")
public class MediaCreateController {

    private MediaService mediaService;

    public MediaCreateController(MediaService mediaService){
        this.mediaService = mediaService;
    }

    final static Logger logger = Logger.getLogger(MediaCreateController.class);


    @PostMapping("media/add")
    @ApiOperation(
            value = "Thêm mới Media.",
            notes = "Dùng cho chức năng thêm mới Media."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Thêm mới Media thành công."),
            @ApiResponse(code = 400, message = "Có lỗi xảy ra khi thêm mới Media!")
    })
    public ResponseEntity<CoreResponse> add(@RequestBody @Valid Media media){
        try {
            Media result = mediaService.add(media);
            if(result != null){
                return new ResponseEntity<CoreResponse>( new CoreResponse(true, result), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<CoreResponse>( new CoreResponse(false, null, "",0), HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            logger.error("Có lỗi xảy ra tại hàm thêm mới media :",e);
            return new ResponseEntity<CoreResponse>(new CoreResponse(false),HttpStatus.NO_CONTENT);
        }
    }
}
