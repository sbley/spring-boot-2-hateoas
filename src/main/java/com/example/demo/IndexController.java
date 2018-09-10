package com.example.demo;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public ResponseEntity<ResourceSupport> index() {

        ResourceSupport index = new ResourceSupport();
        index.add(linkTo(methodOn(IndexController.class).index()).withSelfRel());
        return ResponseEntity.ok().body(index);
    }
}
