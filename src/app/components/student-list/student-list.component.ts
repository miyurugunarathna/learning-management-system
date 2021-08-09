import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/models/student';
import { StudentService } from 'src/app/services/student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: Student[] = [];
  sid = '';

  page = 1;
  count = 0;
  pageSize = 5;
  pageSizes = [5,10,15];
  
  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
    this.getStudents();
  }

  private getStudents() {
    this.studentService.getAll().subscribe(data => {
      this.students = data;
    });
  }

  findById(): void {
    this.page = 1;
    this.retrieveStudents();
  }

  retrieveStudents(): void {
    const param = this.getRequestParams(this.sid, this.page, this.pageSize);
  }

  getRequestParams(searchID: string, page: number, pageSize: number): any {
    let params: any = {};

    if (searchID) {
      params['sid'] = searchID;
    }

    if (page) {
      params['page'] = page-1;
    }

    if (pageSize) {
      params['size'] = pageSize;
    }

    return params;
  }

  viewStudent(id: string) {
    this.router.navigate(['view-student', id]);
  }

  editStudent(id: string) {
    this.router.navigate(['edit-student', id]);
  }

  deleteStudent(id: string) {
    this.studentService.delete(id).subscribe(data => {
      console.log(data);
      this.getStudents();
    })
  }

}
