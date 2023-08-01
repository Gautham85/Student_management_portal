package mongodb.testing.controller;
//hi
import mongodb.testing.models.StudentDetails;
import mongodb.testing.rep.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Flow")
public class ProFlow {

    @Autowired
    private StudentRepository studentRepository;
    @PostMapping ("/")
    public ResponseEntity<StudentDetails> addStudent(@RequestBody StudentDetails studentDetails)
    {
        StudentDetails save = this.studentRepository.save(studentDetails);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/")
    public ResponseEntity<?> getStudent()
    {
        return ResponseEntity.ok(this.studentRepository.findAll());
    }
    @DeleteMapping("/{SID}")
//Delete
    public String Del(@PathVariable int SID) {
        this.studentRepository.deleteById(SID);
        return "One record deleted";
    }
}

