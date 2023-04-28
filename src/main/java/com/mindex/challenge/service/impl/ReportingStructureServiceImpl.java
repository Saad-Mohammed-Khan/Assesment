package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.dto.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {
    @Autowired
    private EmployeeRepository employeeRepository;
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Override
    public ReportingStructure getReportingStructure(String employeeId) {
        ReportingStructure empStructure = new ReportingStructure();
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if(employee != null){
            empStructure.setEmployee(employee);
            empStructure.setNumberOfReports(getReportingNumber(employeeId,0) - 1 );
            return empStructure;
        }
        else
            throw new RuntimeException("Invalid employeeId: " + employeeId);
    }

    public int getReportingNumber(String empId, int total){
        Employee employee = employeeRepository.findByEmployeeId(empId);
        if(employee.getDirectReports() == null || employee.getDirectReports().size() == 0 ){
            return ++total;
        }
        for(Employee reportee : employee.getDirectReports()){
            total = getReportingNumber(reportee.getEmployeeId(),total);
        }
        total++;
        return total;
    }

}
