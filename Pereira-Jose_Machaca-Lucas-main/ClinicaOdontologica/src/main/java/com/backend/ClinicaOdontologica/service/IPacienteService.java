package com.backend.ClinicaOdontologica.service;


import com.backend.ClinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.ClinicaOdontologica.dto.salida.PacienteSalidaDto;
import com.backend.ClinicaOdontologica.exceptions.BadRequestException;
import com.backend.ClinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    List<PacienteSalidaDto> listarPacientes();

    PacienteSalidaDto buscarPacientePorId(Long id);

    void eliminarPaciente(Long id) throws ResourceNotFoundException;

    PacienteSalidaDto modificarPaciente(PacienteEntradaDto pacienteEntradaDto, Long id) throws ResourceNotFoundException;
}
