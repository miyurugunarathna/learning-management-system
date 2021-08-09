import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './components/student-list/student-list.component';
import { AddStudentComponent } from './components/add-student/add-student.component';

@NgModule({
  imports: [
    FormsModule,
    RouterModule.forRoot( [
      {path: 'students', component: StudentListComponent},
      {path: 'add-student', component: AddStudentComponent},
    ]),
    AppRoutingModule,
    BrowserModule,
    HttpClientModule
  ],
  declarations: [
    AppComponent,
    StudentListComponent,
    AddStudentComponent,
  ],
  bootstrap: [ AppComponent ],
  providers: [],
})
export class AppModule { 
  constructor() {}
 }
