package com.nisheeth.ibmmq.models;

import lombok.Builder;

@Builder
public record MessageResponse(String message) {
}
