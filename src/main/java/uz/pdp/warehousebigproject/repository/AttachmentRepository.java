package uz.pdp.warehousebigproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehousebigproject.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment , Integer> {
}
