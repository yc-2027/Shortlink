package com.nageoffer.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nageoffer.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 地区访问实体
 */
@Data
@TableName("t_link_locale_stats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkLocaleStatsDO extends BaseDO {
    /**
     * id
     */
    private Long id;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 日期
     */
    private Date date;

    /**
     * 访问量
     */
    private Integer cnt;

    /**
     * 省份名称
     */
    private String regionName;

    /**
     * 市名称
     */
    private String city;

    /**
     * 城市编码
     */
    private String zip;

    /**
     * 国家标识
     */
    private String country;

    /**
     * 查询原ip
     */
    private String query;
}
