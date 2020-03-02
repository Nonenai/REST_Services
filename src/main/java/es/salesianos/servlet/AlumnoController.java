package es.salesianos.servlet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.model.Alumno;
import es.salesianos.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/ALUMNO/")
// http://localhost:8080/api/v1/user/delete/equipo/
public class AlumnoController {
	List<Alumno> alumnos = new ArrayList<Alumno>();

	@GetMapping
	@RequestMapping(value = "/DELETE/", method = RequestMethod.GET)
	public ResponseEntity<Alumno> delete(@RequestParam(required = true) int id) {
		Alumno alumno = new Alumno();
		alumno = findAlumno(id, alumno);
		alumnos.remove(alumno);
		return new ResponseEntity<>(alumno, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping
	@RequestMapping(value = "/UPDATE/{id}/", method = RequestMethod.GET)
	public ResponseEntity<Alumno> update(@PathVariable int id, @RequestParam String fct) {
		Alumno alumnoUpdate = new Alumno();
		alumnoUpdate = findAlumno(id, alumnoUpdate);
		alumnoUpdate.setFct(fct);
		
		return new ResponseEntity<>(alumnoUpdate, HttpStatus.ACCEPTED);
	}


	@PostMapping
	@RequestMapping(value = "/INSERT/")
	public ResponseEntity<Alumno> create(@RequestBody Alumno alumnoReq) {
		return new ResponseEntity<>(addAlumno(alumnoReq), HttpStatus.CREATED);
	}

	private Alumno addAlumno(Alumno alumnoReq) {
		Alumno alumno = new Alumno();
		alumno.setNombre(alumnoReq.getNombre());
		alumno.setFct(alumnoReq.getFct());
		alumno.setId(4);
		alumnos.add(alumno);
		return alumno;
		
		
	}

	@GetMapping
	@RequestMapping(value = "/LIST")
	public ResponseEntity<List<Alumno>> ListWithFilter() {
		addAlumnos(alumnos);		
		return new ResponseEntity<>(alumnos, HttpStatus.OK);
	}

	private void addAlumnos(List<Alumno> alumnos) {
		Alumno alumno = new Alumno();
		
		alumno.setId(1);
		alumno.setNombre("gorka");
		alumno.setFct("SI");
		alumnos.add(alumno);
		
		Alumno alumno2 = new Alumno();
		alumno2.setId(2);
		alumno2.setNombre("juan");
		alumno2.setFct("NO");
		alumnos.add(alumno2);
		
		Alumno alumno3 = new Alumno();
		alumno3.setId(3);
		alumno3.setNombre("agustin");
		alumno3.setFct("SI");
		alumnos.add(alumno3);
	}
	private Alumno findAlumno(int id, Alumno alumnoUpdate) {
		for (int i = 0; i < alumnos.size(); i++) {
			if(alumnos.get(i).getId()==id) {
				alumnoUpdate = alumnos.get(i);
			}
		}
		return alumnoUpdate;
	}
}
