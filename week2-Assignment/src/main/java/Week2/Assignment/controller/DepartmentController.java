package Week2.Assignment.controller;

import Week2.Assignment.DTO.DepartmentDTO;
import Week2.Assignment.exception.ResourceNotFoundException;
import Week2.Assignment.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

//    @GetMapping(path = "/{departmentId}")
//    public DepartmentDTO getDepartmentById(@PathVariable Long departmentId){
//        DepartmentDTO getDepartment = departmentService.getDepartmentById(departmentId);
//        return
//    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment() {
        List<DepartmentDTO> department = departmentService.getAllDepartment();

        return ResponseEntity.ok(department);
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable @Valid Long departmentId) {
        Optional<DepartmentDTO> departmentDTO = departmentService.getDepartmentById(departmentId);

        return departmentDTO
                .map(departmentDTO1 -> ResponseEntity.ok(departmentDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Department Not found with id : " + departmentId));
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO departmentDTO){
        DepartmentDTO newDepartment = departmentService.createNewDepartment(departmentDTO);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentDTO, departmentId));
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId){
        boolean gotDeleted = departmentService.deleteDepartmentById(departmentId);
        if (gotDeleted) return ResponseEntity.ok(true);

        return ResponseEntity.notFound().build();
    }

}
