import { TestBed } from '@angular/core/testing';

import { SingninSignoutService } from './singnin-signout.service';

describe('SingninSignoutService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SingninSignoutService = TestBed.get(SingninSignoutService);
    expect(service).toBeTruthy();
  });
});
