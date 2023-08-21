package za.ac.cput.vehicledealership.service.impl;

import za.ac.cput.vehicledealership.domain.EmployeeContact;
import za.ac.cput.vehicledealership.repository.EmployeeContactRepository;
import za.ac.cput.vehicledealership.repository.impl.EmployeeContactRepositoryImpl;
import za.ac.cput.vehicledealership.service.EmployeeContactService;

import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;



/*  EmployeeContactServiceImpl.java
    ServiceImpl for employeeContact
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/

@Service
public class EmployeeContactServiceImpl implements EmployeeContactService {

    private EmployeeContactRepository employeeContactRepository;

    public EmployeeContactServiceImpl(EmployeeContactRepository employeeContactRepository) {
        this.employeeContactRepository = employeeContactRepository;
    }


    @Override
    public EmployeeContact create(EmployeeContact employeeContact) {
        return employeeContactRepository.save(employeeContact);
    }

    @Override
    public EmployeeContact read(Long employeeNumber) {
        return employeeContactRepository.findById(employeeNumber).orElse(null);
    }

    @Override
    public EmployeeContact update(EmployeeContact employeeContact) {
        if(employeeContactRepository.existsById(employeeContact.getEmployeeNumber())) {
            return this.employeeContactRepository.save(employeeContact);
        }
        return null;
    }

    @Override
    public boolean delete(Long employeeNumber) {
        if(this.employeeContactRepository.existsById(employeeNumber)) {
            this.employeeContactRepository.deleteById(employeeNumber);
            return true;
        }
        return false;
    }

    @Override
    public List<EmployeeContact> getAll() {
        return employeeContactRepository.findAll();
    }
}

