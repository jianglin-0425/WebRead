package com.jl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: demo
 * @description:
 * @author: LIN
 * @create: 2021~05~28 11:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformationVO {
    Integer iId;
    String iType;
    String content;
    String vid;
    String publishTime;
    String vname;
}
