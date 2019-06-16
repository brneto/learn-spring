package com.example.demo.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.FileFormModel;
import com.example.demo.storage.StorageService;

@RestController
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public ModelAndView listUploadedFiles() throws IOException {
    	ModelAndView modelAndView = new ModelAndView("uploadForm");
    	modelAndView.addObject("files", storageService.loadAll().map(
            	path -> MvcUriComponentsBuilder
    			.fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
    			.build()
    			.toString()
    		).collect(Collectors.toList()));
    	
    	return modelAndView;
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
        		.ok()
        		.header(
        				HttpHeaders.CONTENT_DISPOSITION,
        				"attachment; filename=\"" + file.getFilename() + "\""
        		).body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@ModelAttribute FileFormModel model,
            RedirectAttributes redirectAttributes) {

        storageService.store(model.getFile());
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + model.getFile().getOriginalFilename() + "!");

        return "redirect:/";
    }

}
