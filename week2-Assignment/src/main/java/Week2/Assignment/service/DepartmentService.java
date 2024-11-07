package Week2.Assignment.service;

import Week2.Assignment.DTO.DepartmentDTO;
import Week2.Assignment.Entity.DepartmentEntity;
import Week2.Assignment.Repository.DepartmentRepository;
import Week2.Assignment.config.MapperConfig;
import Week2.Assignment.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, MapperConfig mapperConfig, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<DepartmentDTO> getDepartmentById(Long departmentId) {

//        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
//        return departmentEntity.map(departmentEntity1 -> modelMapper.map(departmentEntity, DepartmentDTO.class));

        return departmentRepository.findById(departmentId)
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class));
    }

    public DepartmentDTO createNewDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity savedDepartment = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    public void isExistByDepartmentId(Long departmentId){
        boolean exist = departmentRepository.existsById(departmentId);
        if (!exist) throw new ResourceNotFoundException(" Department Not found with id : " + departmentId);
    }

    public DepartmentDTO updateDepartmentById(DepartmentDTO departmentDTO, Long departmentId) {
        isExistByDepartmentId(departmentId);
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity savedDepartment = departmentRepository.save(departmentEntity);

        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    public Boolean deleteDepartmentById(Long departmentId) {
        isExistByDepartmentId(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }

    public List<DepartmentDTO> getAllDepartment() {
        List<DepartmentEntity> departmentEntity = departmentRepository.findAll();

        return departmentEntity.stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }
}
