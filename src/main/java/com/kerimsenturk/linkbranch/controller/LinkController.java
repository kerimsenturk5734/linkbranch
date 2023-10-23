package com.kerimsenturk.linkbranch.controller;

import com.kerimsenturk.linkbranch.dto.LinkDto;
import com.kerimsenturk.linkbranch.dto.request.CreateLinkRequest;
import com.kerimsenturk.linkbranch.dto.request.RemoveLinkRequest;
import com.kerimsenturk.linkbranch.dto.request.UpdateLinkRequest;
import com.kerimsenturk.linkbranch.service.ILinkService;
import com.kerimsenturk.linkbranch.service.LinkService;
import com.kerimsenturk.linkbranch.util.Result.HttpDataResult;
import com.kerimsenturk.linkbranch.util.Result.HttpResult;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAllByUsername")
    public ResponseEntity<?> findAllByUser_Username(String username) {
        HttpDataResult<List<LinkDto>> httpDataResult = linkService.findAllByUser_Username(username);
        return ResponseEntity.status(httpDataResult.getStatus()).body(httpDataResult);
    }

    @GetMapping("/getAllByUUID")
    public ResponseEntity<?> findAllByUser_Uuid(int uuid) {
        HttpDataResult<List<LinkDto>> httpDataResult = linkService.findAllByUser_Uuid(uuid);
        return ResponseEntity.status(httpDataResult.getStatus()).body(httpDataResult);
    }

    @DeleteMapping("/removeLink")
    @Transactional
    public ResponseEntity<?> removeLink(@RequestBody RemoveLinkRequest removeLinkRequest) {
        HttpResult httpResult = linkService.removeLink(removeLinkRequest);
        return ResponseEntity.status(httpResult.getStatus()).body(httpResult);
    }

    @PatchMapping("/updateLink")
    public ResponseEntity<?> updateLink(@RequestBody UpdateLinkRequest updateLinkRequest){
        HttpDataResult<LinkDto>  httpResult = linkService.updateLink(updateLinkRequest);
        return ResponseEntity.status(httpResult.getStatus()).body(httpResult);
    }
}
