package com.hoangbui.shopping.common.controller;

import com.hoangbui.shopping.common.message.ResponseMessage;
import com.hoangbui.shopping.common.model.FileInfo;
import com.hoangbui.shopping.common.service.FileStoreService;
import com.hoangbui.shopping.exception.StorageFileNotFoundException;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/admin/file")
@CrossOrigin(origins = "*")
@Slf4j
@Api(value = "Shop", description = "Quản lý thông báo")
public class UploadFileController {
    @Autowired
    private FileStoreService fileStoreService;

    @PostMapping("/upload")
    public  ResponseEntity<ResponseMessage> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            fileStoreService.store(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = fileStoreService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(UploadFileController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files", fileStoreService.loadAll().map(path -> MvcUriComponentsBuilder.fromMethodName(
                UploadFileController.class, "serveFile", path.getFileName().toString()).build().toUri().toString()).collect(
                Collectors.toList()
        ));
        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFileName(@PathVariable String filename) {
        Resource file = fileStoreService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
                file.getFilename() + "\"").body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        return fileStoreService.store(file);
//        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " +
//                file.getOriginalFilename() + "!");
////        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}
