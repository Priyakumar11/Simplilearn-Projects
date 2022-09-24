import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  addEmpURL : string;
  getEmpURL : string;
  updateEmpUrl : string;
  deleteEmpUrl : string;

  constructor(private http : HttpClient) {

    this.addEmpURL = 'http://localhost:3000/Employee';
    this.getEmpURL = 'http://localhost:3000/Employee';
    this.updateEmpUrl = 'http://localhost:3000/Employee';
    this.deleteEmpUrl = 'http://localhost:3000/Employee';

   }

   addEmployee(emp : Employee): Observable<Employee> {
     return this.http.post<Employee>(this.addEmpURL,emp);
   }

   getAllEmployee(): Observable<Employee[]>{
     return this.http.get<Employee[]>(this.getEmpURL);
   }

   updateEmployee(emp :Employee) : Observable<Employee>{
      console.log(emp);
     return this.http.put<Employee>(this.updateEmpUrl+"/"+emp.id,emp);
   }

   deleteEmployee(emp : Employee) : Observable<Employee> {
     return this.http.delete<Employee>(this.deleteEmpUrl+'/'+emp.id);
   }
  

}
