package uz.pdp.warehousebigproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.warehousebigproject.entity.Attachment;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.service.AttachmentService;

import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;


    //CREATE
    @PostMapping("/upload")
    public Result uploadPhoto(MultipartHttpServletRequest request) {
        return attachmentService.uploadFile(request);
    }

    //READ
    @GetMapping
    public List<Attachment> getAttachmentAll() {
        return attachmentService.getAllAttachment();
    }


    //DELETE
    @DeleteMapping("/byId/{id}")
    public Result deleteAttachment(@PathVariable Integer id) {
        return attachmentService.deleteAttachment(id);
    }

}
