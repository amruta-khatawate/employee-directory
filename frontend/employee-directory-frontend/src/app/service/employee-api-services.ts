import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../models/employee.model';
import { environment } from '../environments/environment'; 
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EmployeeApiServices {
      private http : HttpClient = inject(HttpClient);
      private apiURL : string = environment.apiUrl;

      getEmployees() : Observable<Employee[]>{
        return this.http.get<Employee[]>(`${this.apiURL}/employees`);
      }

      getEmployee(id: number) : Observable<Employee>{
        return this.http.get<Employee>(`${this.apiURL}/employee/${id}`);
      }

      createEmployee(employee : Employee) : Observable<Employee> {
        return this.http.post<Employee>(`${this.apiURL}/employee`, employee);
      }

      updateEmployee(employee: Employee, id : number) : Observable<Employee>{
        return this.http.put<Employee>(`${this.apiURL}/employee/${id}`, employee);
      }

      deletedEmployee(id: number) : Observable<void>{
        return this.http.delete<void>(`${this.apiURL}/employee/${id}`);
      }
}
