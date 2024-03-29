package com.backend.ClinicaOdontologica.repository;

import com.backend.ClinicaOdontologica.entity.Odontologo;
import com.backend.ClinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {


}
