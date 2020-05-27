package com.cdgz.crudspringmvc.domain.service;

import com.cdgz.crudspringmvc.app.controller.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    void create(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAll();

    void delete(Long id);

    EmployeeDTO getById(Long id);
}
