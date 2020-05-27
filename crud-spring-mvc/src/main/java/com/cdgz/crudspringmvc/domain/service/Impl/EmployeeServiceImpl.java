package com.cdgz.crudspringmvc.domain.service.Impl;

import com.cdgz.crudspringmvc.app.controller.DTO.EmployeeDTO;
import com.cdgz.crudspringmvc.domain.model.Employee;
import com.cdgz.crudspringmvc.domain.repository.EmployeeRepository;
import com.cdgz.crudspringmvc.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void create(EmployeeDTO employeeDTO) {
        employeeRepository.save(Employee.newBuilder()
                .id(employeeDTO.getId())
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .documentNumber(employeeDTO.getDocumentNumber())
                .birthDate(employeeDTO.getBirthDate())
                .mobileNumber(employeeDTO.getMobileNumber())
                .gender(employeeDTO.getGender())
                .build());
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(this::convertToEmployeeDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(getEmployee(id));
    }

    @Override
    public EmployeeDTO getById(Long id) {
        Employee employee = employeeRepository.getOne(id);
        return convertToEmployeeDTO(employee);
    }

    private Employee getEmployee(Long id) {
        return employeeRepository.getOne(id);
    }

    private EmployeeDTO convertToEmployeeDTO(Employee employee) {
        return EmployeeDTO.newBuilder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .documentNumber(employee.getDocumentNumber())
                .birthDate(employee.getBirthDate())
                .mobileNumber(employee.getMobileNumber())
                .birthDate(employee.getBirthDate())
                .gender(employee.getGender())
                .build();
    }
}
