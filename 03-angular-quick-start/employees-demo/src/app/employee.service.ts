import { Injectable } from '@angular/core';
import { Employee } from './model/employee.model';
import { Observable} from 'rxjs';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(
    private readonly apiService: ApiService) { }

  getEmployees() : Observable<Employee[]> {
    return this.apiService.get(`/v1/employees`);
  }

  getEmloyee(username: any): Observable<Employee> {
    return this.apiService.get(`/v1/employees/${username}`);
  }

  updateEmployee(employee: any): Observable<any> {
    return this.apiService.patch(`/v1/employees/${employee.username}`, employee);
  }
}
