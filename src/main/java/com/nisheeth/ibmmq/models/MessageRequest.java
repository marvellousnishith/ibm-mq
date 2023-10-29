package com.nisheeth.ibmmq.models;

import lombok.Builder;

@Builder
public record MessageRequest(String message) {
}
