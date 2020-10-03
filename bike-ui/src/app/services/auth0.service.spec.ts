import { TestBed } from '@angular/core/testing';

import { AuthService0 } from './auth0.service';

describe('Auth0Service', () => {
  let service: AuthService0;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthService0);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
