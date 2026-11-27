import { TestBed } from '@angular/core/testing';

import { EmployeeApiServices } from './employee-api-services';

describe('EmployeeApiServices', () => {
  let service: EmployeeApiServices;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmployeeApiServices);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
