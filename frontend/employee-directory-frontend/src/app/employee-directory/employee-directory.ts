import { Component, inject, OnInit, signal } from '@angular/core';
import { Employee } from '../models/employee.model';
import { FormsModule } from '@angular/forms';
import { EmployeeApiServices } from '../service/employee-api-services';


@Component({
  selector: 'app-employee-directory',
  imports: [FormsModule],
  templateUrl: './employee-directory.html',
  styleUrl: './employee-directory.css',
})
export class EmployeeDirectory implements OnInit{

  private employeeService : EmployeeApiServices = inject(EmployeeApiServices);
  employees = signal<Employee[]>([]);
  isLoading = signal(true);

  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe({
      next:(response : Employee[]) => {
        this.employees.set(response);
        this.isLoading.set(false);
      },
      error:(error : any) => {
        console.error("Error fecthing the Employee list" + error);
        this.isLoading.set(false);
      }
      
    })
  }

  departments: string[] = ['Engineering', 'Marketing', 'Sales', 'HR', 'Finance', 'Operations'];
  locations : string[] = ['New York', 'San Francisco', 'London', 'Bangalore', 'Singapore'];
  designations : string[] = [
    'Software Engineer',
    'Senior Software Engineer',
    'Tech Lead',
    'Engineering Manager',
    'Product Manager',
    'Designer',
    'Senior Designer',
    'Marketing Specialist',
    'Marketing Manager',
    'Sales Representative',
    'Sales Manager',
    'HR Specialist',
    'HR Manager',
    'Accountant',
    'Finance Manager',
    'Operations Analyst',
    'Operations Manager'];

    statuses : string[] = ['active', 'on-leave', 'terminated'];

  
}

