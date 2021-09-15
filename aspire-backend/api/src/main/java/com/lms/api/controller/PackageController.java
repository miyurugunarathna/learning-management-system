package com.lms.api.controller;

import com.lms.api.exception.ResourceNotFoundException;
import com.lms.api.model.Package;
import com.lms.api.repository.PackageRepository;
import com.lms.api.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PackageController {

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;




    @PostMapping("/package/add")
    public ResponseEntity<Package> addPackage(@RequestBody Package package1) {


        package1.setId(sequenceGeneratorService.generateSequence(Package.SEQUENCE_NAME));
        package1.setCreatedDate(getTimeStamp());
        package1.setModifiedDate("N/A");
        Package newpackage=packageRepository.save(package1);
        return new ResponseEntity<>(newpackage, HttpStatus.CREATED);
    }

    @GetMapping("/packages")
    public List<Package> getAllPackages(){
        return packageRepository.findAll();
    }

    @GetMapping("/package/{id}")
    public ResponseEntity<Package> getPackageById(@PathVariable(value = "id")long packageId)
            throws ResourceNotFoundException {
        Package package1 = packageRepository.findById(packageId)
                .orElseThrow(() -> new ResourceNotFoundException("Package not found for this id ::" + packageId));
        return ResponseEntity.ok().body(package1);
    }




    @PutMapping("/package/update/{id}")
    public ResponseEntity<Package> updatePackage(@PathVariable(value = "id")long packageId,
                                                 @RequestBody Package packageDetails)
            throws ResourceNotFoundException {
        Package package1 = packageRepository.findById(packageId)
                .orElseThrow(() -> new ResourceNotFoundException("Package not found for this id ::" + packageId));
        package1.setPackageName(packageDetails.getPackageName());
        package1.setMaxCourse(packageDetails.getMaxCourse());
        package1.setMaxStudent(packageDetails.getMaxStudent());
        package1.setCommission(packageDetails.getCommission());
        package1.setComType(packageDetails.getComType());
        package1.setAnnualFee(packageDetails.getAnnualFee());
        package1.setMonthlyFee(packageDetails.getMonthlyFee());
        package1.setDefaultPack(packageDetails.isDefaultPack());
        package1.setCreatedDate(packageDetails.getCreatedDate());
        package1.setModifiedDate(getTimeStamp());

        final Package updatePackage=packageRepository.save(package1);

        return ResponseEntity.ok(updatePackage);
    }

    @DeleteMapping("/package/delete/{id}")
    public Map<String,Boolean> detetePackage(@PathVariable(value = "id")long packageId)
            throws ResourceNotFoundException{
        Package package1=packageRepository.findById(packageId)
                .orElseThrow(() -> new ResourceNotFoundException("Package not found for this id ::" + packageId));
        packageRepository.delete(package1);
        Map<String,Boolean> respnse= new HashMap<>();
        respnse.put("deleted",Boolean.TRUE);
        return respnse;

    }


    /* @PostMapping("/package")
     public String savePackage(@RequestBody Package package1){
         packageRepository.save(package1);
         return package1.getPackageName();
     }



     @GetMapping("/packages")
     public List<Package> getAllPackages()
     {
         return packageRepository.findAll();
     }

     @GetMapping("/package/{id}")
     public ResponseEntity<Package> getPackageById(@PathVariable(value = "id")long packageId)
         throws ResourceNotFoundException {
         Package package1 = packageRepository.findById(packageId)
                 .orElseThrow(() -> new ResourceNotFoundException("Package not found for this id ::" + packageId));
         return ResponseEntity.ok().body(package1);
     }

     @PostMapping("/package/add")
     public Package createPackage(@RequestBody Package package1){
         package1.setId(sequenceGeneratorService.generateSequence(Package.SEQUENCE_NAME));
         return packageRepository.save(package1);
     }







     @PutMapping("/package/{id}")
     public ResponseEntity<Package> updatePackage(@PathVariable(value = "id")long packageId,
             @RequestBody Package packageDetails)
             throws ResourceNotFoundException {
         Package package1 = packageRepository.findById(packageId)
                 .orElseThrow(() -> new ResourceNotFoundException("Package not found for this id ::" + packageId));
         package1.setPackageName(packageDetails.getPackageName());
         package1.setMaxCourse(packageDetails.getMaxCourse());
         package1.setMaxStudent(packageDetails.getMaxStudent());
         package1.setCommission(packageDetails.getCommission());
         package1.setComType(packageDetails.getComType());
         package1.setAnnualFee(packageDetails.getAnnualFee());
         package1.setMonthlyFee(packageDetails.getMonthlyFee());
         package1.setDefaultPack(packageDetails.isDefaultPack());
         package1.setCreatedDate(packageDetails.getCreatedDate());
         package1.setModifiedDate(packageDetails.getModifiedDate());

         final Package updatePackage=packageRepository.save(package1);

         return ResponseEntity.ok(updatePackage);
     }

     @DeleteMapping("/package/delete/{id}")
     public Map<String,Boolean> detetePackage(@PathVariable(value = "id")long packageId)
         throws ResourceNotFoundException{
         Package package1=packageRepository.findById(packageId)
                 .orElseThrow(() -> new ResourceNotFoundException("Package not found for this id ::" + packageId));
         packageRepository.delete(package1);
         Map<String,Boolean> respnse= new HashMap<>();
         respnse.put("deleted",Boolean.TRUE);
         return respnse;

     }
    */
    public String getTimeStamp() {


        LocalDateTime myDateobj = LocalDateTime.now();
        DateTimeFormatter myformatobj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String timeStamp = myDateobj.format(myformatobj);
        return timeStamp;
    }

}

