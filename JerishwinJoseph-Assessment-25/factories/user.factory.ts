import { faker } from '@faker-js/faker';

export interface RegisterUser {
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  password: string;
}

export function createUser(overrides?: Partial<RegisterUser>): RegisterUser {
  const firstName = overrides?.firstName ?? faker.person.firstName();
  const lastName = overrides?.lastName ?? faker.person.lastName();

  const user: RegisterUser = {
    firstName,
    lastName,
    email: faker.internet.email({ firstName, lastName, provider: 'gmail.com' }),
    phone: faker.string.numeric(10),
    password: faker.internet.password({ length: 10 }),
  };

  return { ...user, ...overrides };
}

export function createUsers(count: number, overrides?: Partial<RegisterUser>): RegisterUser[] {
  return Array.from({ length: count }, () => createUser(overrides));
}