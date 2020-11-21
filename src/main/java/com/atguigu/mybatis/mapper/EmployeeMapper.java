package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Employee;

import java.util.List;

/**
 * @author darren
 * @create 2020-11-21 21:51
 */
public interface EmployeeMapper {

    public void addEmployee(Employee emp);
    public void deleteEmployee(int id);
    public void updateEmployee(Employee emp);
    public List<Employee> selectEmployee();
}
