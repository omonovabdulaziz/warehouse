package uz.pdp.warehousebigproject.service;


import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.warehousebigproject.entity.Attachment;
import uz.pdp.warehousebigproject.entity.AttachmentContent;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.AttachmentContentRepository;
import uz.pdp.warehousebigproject.repository.AttachmentRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    //UPLOAD
    @SneakyThrows
    public Result uploadFile(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment savedAttachment = attachmentRepository.save(attachment);


        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);
        AttachmentContent saveAttachmentContent = attachmentContentRepository.save(attachmentContent);


        return new Result("muvafaqiyatli saqlandi", true, savedAttachment.getId());


    }


    //READALL
    public List<Attachment> getAllAttachment() {
        return attachmentRepository.findAll();
    }

    //delete
    public Result deleteAttachment(Integer id) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (!optionalAttachment.isPresent())
            return new Result("bunday id li attachment topilmadi" , false);

        Attachment attachment = optionalAttachment.get();
        attachmentContentRepository.deleteById(attachment.getId());
        attachmentRepository.deleteById(id);
        return new Result("ochirildi" , true);
    }


}
