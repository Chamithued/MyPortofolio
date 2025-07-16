package com.self_portofolio.portofolio.Viewer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*") // Allow all origins (for testing)
@RestController
@RequestMapping("/viewers")
public class viewerController {

    private viewerService viewerservice;
    private mailService mailService;

    public viewerController(viewerService viewerservice, mailService mailService) {
        this.viewerservice = viewerservice;
        this.mailService = mailService;

    }

    @GetMapping()
    public ResponseEntity<List<Viewer>> findALl(){
        return new ResponseEntity<>(viewerservice.findALl(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createViewer(@RequestBody Viewer viewer){
        viewerservice.createViewer(viewer);
        mailService.sendViewerEmail(viewer.getName(), viewer.getEmail(), viewer.getMessage());
        return new ResponseEntity<>("viewer added successfully and mail sent successfully.",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viewer> getViewerById(@PathVariable Long id) {
        Viewer viewer = viewerservice.getViewerById(id);
        if(viewer !=null){
            return new ResponseEntity<>(viewer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
