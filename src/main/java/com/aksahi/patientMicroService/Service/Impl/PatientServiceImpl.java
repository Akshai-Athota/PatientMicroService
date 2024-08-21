package com.aksahi.patientMicroService.Service.Impl;

import com.aksahi.patientMicroService.Entities.Patient;
import com.aksahi.patientMicroService.Exception.PatientNotFoundException;
import com.aksahi.patientMicroService.Mappers.PatientMapper;
import com.aksahi.patientMicroService.Repository.PatientRepository;
import com.aksahi.patientMicroService.Service.PatientService;
import com.aksahi.patientMicroService.dto.PatientDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
    private PatientMapper patientMapper;
    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patientMapper::patientToPatientDto).collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        return patientRepository.findById(id).map(patientMapper::patientToPatientDto)
                .orElseThrow(()->new PatientNotFoundException("no patient find with given id"));
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient=patientRepository.save(patientMapper.patientDTOToPatient(patientDTO));
        return patientMapper.patientToPatientDto(patient);
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Patient patient=patientRepository.findById(id)
                .orElseThrow(()->new PatientNotFoundException("no patient find with given id"));
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setEmail(patientDTO.getEmail());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setPhoneNumber(patientDTO.getPhoneNumber());
        patient.setGender(patientDTO.getGender());
        patient.setAddress(patientDTO.getAddress());
        patient=patientRepository.save(patient);
        return patientMapper.patientToPatientDto(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
