package com.nageoffer.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nageoffer.project.common.convention.result.Result;
import com.nageoffer.project.common.convention.result.Results;
import com.nageoffer.project.dto.req.ShortLinkBatchCreateReqDTO;
import com.nageoffer.project.dto.req.ShortLinkCreateReqDTO;
import com.nageoffer.project.dto.req.ShortLinkPageReqDTO;
import com.nageoffer.project.dto.req.ShortLinkUpdateReqDTO;
import com.nageoffer.project.dto.resp.ShortLinkBatchCreateRespDTO;
import com.nageoffer.project.dto.resp.ShortLinkCreateRespDTO;
import com.nageoffer.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.nageoffer.project.dto.resp.ShortLinkPageRespDTO;
import com.nageoffer.project.service.ShortLinkService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * 短链接控制层
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkController {
    private final ShortLinkService shortLinkService;

    /**
     * 短链接跳转原始链接
     * @param shortUri
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/{short-uri}")
    public void restoreUrl(@PathVariable("short-uri")String shortUri, ServletRequest request, ServletResponse response) throws IOException {
        shortLinkService.restoreUrl(shortUri,request,response);
    }

    /**
     *  创建短链接
     * @return
     */
    @PostMapping("/api/short-link/v1/create")
//    @SentinelResource(
//            value = "create_short-link",
//            blockHandler = "createShortLinkBlockHandlerMethod",
//            blockHandlerClass = CustomBlockHandler.class
//    )
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) throws Exception {
        return Results.success(shortLinkService.createShortLink(requestParam));
    }
    /**
     * 批量创建短链接
     */
    @PostMapping("/api/short-link/v1/create/batch")
    public Result<ShortLinkBatchCreateRespDTO> batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam) {
        return Results.success(shortLinkService.batchCreateShortLink(requestParam));
    }


    /**
     *  修改短链接
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam){
        shortLinkService.updateShortLink(requestParam);
        return Results.success();
    }

    /**
     * 分页查询短链接
     * @param requestParam 分页查询短链接请求参数
     * @return 短链接分页返回结果
     */
    @GetMapping("/api/short-link/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        return Results.success(shortLinkService.pageShortLink(requestParam));
    }

    /**
     * 查询短链接分组内的数量
     */
    @GetMapping("/api/short-link/v1/count")
    public Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(@RequestParam("requestParam") List<String> requestParam){
        return Results.success(shortLinkService.listGroupShortLinkCount(requestParam));
    }
}
