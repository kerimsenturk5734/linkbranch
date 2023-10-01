package com.kerimsenturk.linkbranch.dto.request;

import com.kerimsenturk.linkbranch.model.enums.LinkCategory;

public record CreateLinkRequest(int id, String url, LinkCategory linkCategory) {
}
