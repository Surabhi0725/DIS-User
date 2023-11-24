package sgsits.cse.dis.user.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "file-service")
@RestController
public interface TaskAttachment {
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file);

    @RequestMapping(value = "/files", method = RequestMethod.GET)
    ResponseEntity<List<FileInfo>> getListFiles();

    @RequestMapping(value = "/files/{filename}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Resource> getFile(@PathVariable("filename") String filename);
}
