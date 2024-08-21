package com.aksahi.patientMicroService.Controller;

import com.aksahi.patientMicroService.Service.PatientService;
import com.aksahi.patientMicroService.dto.PatientDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {
    private PatientService patientService;

    @PostMapping
    ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody  PatientDTO patientDTO){
        log.info("creating a patient");
        return ResponseEntity.ok(patientService.createPatient(patientDTO));
    }

    @GetMapping
    ResponseEntity<List<PatientDTO>> getAllPatients(){
        log.info("getting all patient records");
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    ResponseEntity<PatientDTO> getPatientById(@PathVariable(name="id") Long id){
        log.info("getting patient information by id ");
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<PatientDTO> updatePatientById(@PathVariable(name="id") Long id,
                                              @Valid @RequestBody PatientDTO patientDTO){
        log.info("updating the patient by id");
        return ResponseEntity.ok(patientService.updatePatient(id,patientDTO));
    }

    @DeleteMapping("/{id}")
    ResponseEntity deletePatientById(@PathVariable(name="id") Long id){
        log.info("deleting patient by id.");
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }
}
