package com.krakdev.fitzone.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakdev.fitzone.entidades.Socio;
import com.krakdev.fitzone.services.ServicioSocio;

@RestController
@RequestMapping("/socios")
public class SocioController {
	
	private final ServicioSocio service;

	public SocioController(ServicioSocio service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Socio socio) {
		try {
			Socio creado = service.crear(socio);

			return ResponseEntity.status(HttpStatus.CREATED).body(creado);

		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al crear socio");
		}
	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
		try {
			List<Socio> socios = service.listar();

			return ResponseEntity.ok(socios);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al consultar socios");
		}
	}
	
	@GetMapping("/estado")
	public ResponseEntity<?> buscarPorEstado(@RequestParam boolean activo) {
		try {
			List<Socio> socios = service.buscarPorEstado(activo);

			return ResponseEntity.ok(socios);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al consultar socios por estado");
		}
	}

}
