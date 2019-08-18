package com.caihao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.caihao.entity.CopyEmpEntity;
import com.caihao.service.CopyEmpService;
import com.github.pagehelper.PageInfo;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/8/10 15:17
 */
@RestController
@RequestMapping("/copy_emp")
public class CopyEmpController {

  @Autowired
  private CopyEmpService copyEmpService;

  @GetMapping("/test")
  public String test() {
    return copyEmpService.test();
  }

  @GetMapping("/get_list")
  public Map<String, Object> getCopyEmpList(@RequestParam(defaultValue = "1") Integer start) {
    Map<String,Object> map = new HashMap<>();
    PageInfo<CopyEmpEntity> pageInfo = copyEmpService.getCopyEmpListFY(start);
    map.put("totalCount",pageInfo.getTotal());
    map.put("pages",pageInfo.getPages());
    map.put("result",pageInfo.getList());
    return map;
  }

}
