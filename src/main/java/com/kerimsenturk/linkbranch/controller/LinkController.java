package com.kerimsenturk.linkbranch.controller;

import com.kerimsenturk.linkbranch.dto.LinkDto;
import com.kerimsenturk.linkbranch.dto.request.CreateLinkRequest;
import com.kerimsenturk.linkbranch.service.ILinkService;
import com.kerimsenturk.linkbranch.service.LinkService;
import com.kerimsenturk.linkbranch.util.Result.HttpDataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/links")
public class LinkController {
    private final ILinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CreateLinkRequest createLinkRequest){
        HttpDataResult<LinkDto> httpDataResult = linkService.addLink(createLinkRequest);
        return ResponseEntity.status(httpDataResult.getStatus()).body(httpDataResult);
    }
    public ResponseEntity<?> findAllByUser_Username(String username) {
        return null;
    }

    public ResponseEntity<?> findAllByUser_Uuid(int uuid) {
        return null;
    }

    public ResponseEntity<?> removeLinkById(int id) {
        return null;
    }
}
