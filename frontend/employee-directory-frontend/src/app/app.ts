import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EmployeeDirectory } from './employee-directory/employee-directory';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, EmployeeDirectory],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('employee-directory-frontend');
}
