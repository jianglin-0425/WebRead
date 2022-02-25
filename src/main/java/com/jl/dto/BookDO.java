package com.jl.dto;

import lombok.Data;

/**
 * @program: demo
 * @description:
 * @author: LIN
 * @create: 2021~05~15 21:25
 */
@Data
public class BookDO {
    private Integer sid;    //章节编号
    private Integer sno;    //章节序号
    private Integer bid;    //书籍编号
    private String sname;   //章节名
    private String authName;//作者名
    private String bname;   //书名
    private String btype;   //书籍类型
    private String img;     //书籍图片
    private String wtime;   //最新章节时间


}
