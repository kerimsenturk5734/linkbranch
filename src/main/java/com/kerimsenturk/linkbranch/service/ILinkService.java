package com.kerimsenturk.linkbranch.service;

import com.kerimsenturk.linkbranch.dto.LinkDto;
import com.kerimsenturk.linkbranch.dto.request.CreateLinkRequest;
import com.kerimsenturk.linkbranch.dto.request.RemoveLinkRequest;
import com.kerimsenturk.linkbranch.util.Result.HttpDataResult;
import com.kerimsenturk.linkbranch.util.Result.HttpResult;

import java.util.List;

public interface ILinkService {
    HttpDataResult<LinkDto> addLink(CreateLinkRequest createLinkRequest);
    HttpDataResult<List<LinkDto>> findAllByUser_Username(String username);
    HttpDataResult<List<LinkDto>>  findAllByUser_Uuid(int uuid);
    HttpResult removeLink(RemoveLinkRequest removeLinkRequest);
}
