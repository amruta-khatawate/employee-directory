export interface Employee {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  department: string;
  designation: string;
  location: string;
  status: string;
  salary: number;
  joinDate: string;
  managerId : number | null;
  avatar : string;
}