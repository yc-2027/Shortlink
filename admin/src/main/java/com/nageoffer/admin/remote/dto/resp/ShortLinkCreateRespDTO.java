package com.nageoffer.admin.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短链接创建响应对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkCreateRespDTO {

    /**
     * 分组标识
     */
    private String gid;



    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 原始链接
     */
    private String originUrl;


}
