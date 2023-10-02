package com.kerimsenturk.linkbranch.dto.request;

import com.kerimsenturk.linkbranch.model.enums.LinkCategory;

public record CreateLinkRequest(int id, String name, String url, LinkCategory linkCategory) {
}
