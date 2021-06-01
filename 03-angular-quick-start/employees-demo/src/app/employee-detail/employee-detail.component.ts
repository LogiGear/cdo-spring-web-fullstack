import { Component, OnInit, Input } from '@angular/core';
import { Employee } from '../model/employee.model'
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.sass']
})

export class EmployeeDetailComponent implements OnInit {
  @Input() employee?: Employee;
  constructor(
    private route: ActivatedRoute,
    private employeeService: EmployeeService,
    private location: Location) { }

  ngOnInit(): void {
    this.getEmployee();
  }

  getEmployee() {
    const username = this.route.snapshot.paramMap.get('username');
    this.employeeService.getEmloyee(username)
      .subscribe(emloyee => this.employee = emloyee);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.employeeService.updateEmployee(this.employee)
      .subscribe(() => this.goBack());
  }
}
