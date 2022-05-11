package com.hoangbui.shopping.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {
    private String filename;
    private String fileType;
    private String fileSize;
    private byte[] file;
    private String url;

    public FileInfo(String filename, String url) {
    }
}
