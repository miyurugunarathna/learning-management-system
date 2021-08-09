import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/models/student';
import { StudentService } from 'src/app/services/student.service';
import { Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {
    imgSrc: string = '';
    imgURL: any;
    Phones: Array<string> = [];

    student: Student = new Student();
    submitted = false;

    dtTrigger: Subject<any> = new Subject<any>();
    dtOptions: any = {};
    students: Student[] = [];

    constructor(
      private studentService: StudentService,
      private router: Router) {
    }

    ngOnInit(): void {
      this.dtOptions = {
        pagingType: 'full_numbers',
        pageLength: 3,
        processing:true,
        lengthChange: false,
      };
      this.getStudents(true);
      //this.students = this.studentService.getAll();
    }

    getStudents(trigger: boolean): void {
      this.studentService.getAll()
      .subscribe(data => {
        this.students = data;

        if(trigger) {
          this.dtTrigger.next();
        }
      });
    }


    newStudent(): void {
      this.submitted = false;
      this.student = new Student();
    }
  
    onSubmit() {
      console.log(this.student);
      this.submitted = true;
      this.saveStudent();
      //return this.http.get<Student[]>('http://localhost:8083/api/stdents');
      //console.log(this.Phones.value);
      //for(let i=0; i<this.Phones.length; i++) {
      //  console.log(this.Phones.at(i).value);
      //}
  }

  saveStudent() {
    alert('Saved')
    this.studentService.create(this.student).subscribe ( data =>
      console.log(data), error => console.log(error));
      this.student = new Student();
      this.router.navigate(['/students'])
  }

  reset() {
    this.student.fname = '';
  }
}
