import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http'
import { Observable, throwError } from "rxjs";
import { catchError, retry } from "rxjs/Operators";
import { Student } from "../models/student";

const baseURL = 'http://localhost:8085/api/';

@Injectable({
    providedIn: 'root'
})
export class StudentService {

    constructor (private http: HttpClient) { }

    getAll(): Observable<Student[]> {
        return this.http.get<Student[]>('http://localhost:8085/api/students');
    }

    get(id: string): Observable<Object> {
        return this.http.get('http://localhost:8085/api/student/${id}');
    }

    create(student: Student): Observable<void> {
        return this.http.post<void>('http://localhost:8085/api/addstudent', student);
    }

    update(id: string, student: Student): Observable<Object> {
        return this.http.put('${baseURL}/${id}', student);
    }

    delete(id: string): Observable<Object> {
        return this.http.delete('http://localhost:8085/api/student/${id}');
    }

    deleteAll(): Observable<any> {
        return this.http.delete('${baseURL}/delete');
    }

}