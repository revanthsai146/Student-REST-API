package com.example.demo.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentServiceImpl;
import static io.swagger.v3.oas.annotations.enums.ParameterIn.HEADER;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@Tag(name="Student API")
@CrossOrigin
@RequestMapping("v1/api")
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentServiceImpl studentService;
    
//    @RequestMapping("/v1")
   @Operation(
      summary = "Sample Health-Check",
      description = "Health-Check API")
      @ApiResponses(
        value = {
        @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                //mediaType = APPLICATION_JSON_VALUE,
               // schema = @Schema(implementation = Student.class)
               )
               ),
    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
        })
    @GetMapping("/health-check")
    public String HelloWorld(@RequestHeader(value = "X-API-KEY")
          @Parameter(
              name = "X-API-KEY",
              in = HEADER,
              description = "The api key received while registering for student service.")
          String apiKey) {
            
    return "Hello World";

    }
    
    @Operation(
      summary = "Add/Save a Student",
      description = "Adding student details")
    @ApiResponses(
        value = {
        @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
               // mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = Student.class))),
    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
        })  
    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestHeader(value = "X-API-KEY")
          @Parameter(
              name = "X-API-KEY",
              in = HEADER,
              description = "The api key received while registering for student service.")
          String apiKey,@Valid@RequestBody Student student) {
        Student savedStudent = studentService.save(student);
        return ResponseEntity.ok(savedStudent);
    }

    @Operation(
      summary = "Get Students",
      description = "Return all students")
    @ApiResponses(
        value = {
        @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
               // mediaType = APPLICATION_JSON_VALUE,
                //schema = @Schema(implementation = Student.class)
                )),
    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
        })  
    @GetMapping("/get")
    public ResponseEntity<List<Student>> getAllStudents(@RequestHeader(value = "X-API-KEY")
          @Parameter(
              name = "X-API-KEY",
              in = HEADER,
              description = "The api key received while registering for student service.")
          String apiKey) {
    	logger.info("Getting all students");
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    
    // @GetMapping("/{id}")
    // public ResponseEntity<Student> getStudentById(@PathVariable int id) {
    // 	logger.info("Getting student with id: {}", id);
    //     Optional<Student> student = studentService.getStudentById(id);
        
    //     if(student.isPresent()) {
    //         return ResponseEntity.ok(student.get());
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }
    @Operation(
      summary = "Get Student By ID",
      description = "Return a student by ID")
    @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "OK",
            content =
                @Content(
                    //mediaType = APPLICATION_JSON_VALUE,
                   // schema = @Schema(implementation = Student.class)
                   )),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
      })
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@RequestHeader(value = "X-API-KEY")
          @Parameter(
              name = "X-API-KEY",
              in = HEADER,
              description = "The api key received while registering for student service.")
          String apiKey ,@PathVariable int id) {
    	logger.info("Getting student with id: {}", id);
        Student student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
    }
    // @PutMapping("/{id}")
    // public ResponseEntity<Student> updateStudentById(@RequestBody Student updateStudent,@PathVariable int id) {
    // 	logger.info("Getting student with id: {}", id);
    //     Optional<Student> student = studentService.getStudentById(id);
    //     if(student.isPresent()) {
    //     	Student existStudent=student.get();
    //     	existStudent.setDepartment(updateStudent.getDepartment());
    //     	existStudent.setName(updateStudent.getName());
    //     	studentService.save(existStudent);
    //         return ResponseEntity.ok(existStudent);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    @Operation(
      summary = "Update Student",
      description = "Update a student by ID")
    @ApiResponses(
        value = {
        @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                //mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = Student.class))),
    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
        })
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@RequestHeader(value = "X-API-KEY")
          @Parameter(
              name = "X-API-KEY",
              in = HEADER,
              description = "The api key received while registering for student service.")
          String apiKey,@RequestBody Student updateStudent,@PathVariable int id) {
    	logger.info("Getting student with id: {}", id);
        Student student = studentService.updateStudentById(updateStudent,id);
            return ResponseEntity.ok(student);
    }
    @Operation(
      summary = "Delete Student",
      description = "Delete a student by ID")
    @ApiResponses(
        value = {
        @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                //mediaType = APPLICATION_JSON_VALUE,
                //schema = @Schema(implementation = Student.class)
                )),
    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
        })  
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@RequestHeader(value = "X-API-KEY")
          @Parameter(
              name = "X-API-KEY",
              in = HEADER,
              description = "The api key received while registering for student service.")
          String apiKey,@PathVariable int id) {
    	logger.info("Deleting student with id: {}", id);
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Deleted sucessfully");
    }
}

	


