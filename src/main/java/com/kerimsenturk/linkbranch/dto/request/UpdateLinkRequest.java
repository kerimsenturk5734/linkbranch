package com.kerimsenturk.linkbranch.dto.request;

import com.kerimsenturk.linkbranch.model.enums.LinkCategory;

public record UpdateLinkRequest(int linkId, String name, String url, LinkCategory linkCategory , int uuid) {
}
