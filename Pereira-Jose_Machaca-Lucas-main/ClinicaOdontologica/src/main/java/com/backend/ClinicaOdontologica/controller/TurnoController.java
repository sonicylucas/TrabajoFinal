package com.backend.ClinicaOdontologica.controller;

import com.backend.ClinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.ClinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.ClinicaOdontologica.dto.entrada.TurnoEntradaDto;
import com.backend.ClinicaOdontologica.dto.salida.PacienteSalidaDto;
import com.backend.ClinicaOdontologica.dto.salida.TurnoSalidaDto;
import com.backend.ClinicaOdontologica.exceptions.BadRequestException;
import com.backend.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.backend.ClinicaOdontologica.service.IOdontologoService;
import com.backend.ClinicaOdontologica.service.IPacienteService;
import com.backend.ClinicaOdontologica.service.ITurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private ITurnoService turnoService;


    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    //GET
    @GetMapping()
    public ResponseEntity<List<TurnoSalidaDto>> listarturnos() {
        return new ResponseEntity<>(turnoService.listarTurnos(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TurnoSalidaDto> buscarTurnoPorId(@PathVariable Long id)throws  ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.buscarTurnoPorId(id), HttpStatus.OK);
    }

    //POST
    @PostMapping("/registrar")
    public ResponseEntity<TurnoSalidaDto> registrarTurno(@RequestBody @Valid TurnoEntradaDto turnoEntradaDto) throws BadRequestException {
        return new ResponseEntity<>(turnoService.registrarTurno(turnoEntradaDto), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<TurnoSalidaDto> actualizarTurno(@RequestBody @Valid TurnoEntradaDto turno, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.modificarTurno(turno, id), HttpStatus.OK);
    }


    //DELETE
    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarTurno(@RequestParam Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return new ResponseEntity<>("turno eliminado correctamente", HttpStatus.NO_CONTENT);


    }
}
