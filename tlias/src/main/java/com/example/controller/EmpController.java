package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {


    @Autowired
    private EmpService empService;

    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                @RequestParam(defaultValue = "10") Integer pageSize,
                String name,
                Short gender,
                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ){
        log.info("分页查询员工,参数，{}，{}，{}，{}，{}，{}", page, pageSize,name,gender,begin,end);

        PageBean pageBean = empService.list(page, pageSize, name, gender, begin, end);

        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除员工ids，{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("新增员工{}",emp.toString());
        empService.add(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        return  Result.success();
    }
}
