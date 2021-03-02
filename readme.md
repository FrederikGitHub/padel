1.Build application


2.build and run application


3.develop information


4.working and use application.


5.TODO's

server doesn't start up yet because of jpa entities that are not correct.
probably poule_tour entity.(remove some entitity java files and app will start).
Another problem is that first page of angular is not shown.see sample application tutorial-parent to fix the problem.





7.Quick start

8.resources

https://medium.com/@coderonfleek/faking-the-backend-in-angular-apps-a10c1b8823c
https://github.com/StartBootstrap/sb-admin-angular
2 ways of passing route data =https://www.thepolyglotdeveloper.com/2016/10/passing-complex-data-angular-2-router-nativescript/
https://www.digitalocean.com/community/tutorials/angular-route-resolvers
https://stackblitz.com/edit/angular-xfd5xx?file=src%2Fapp%2Flibrary-display%2Flibrary-display.component.ts
https://www.baeldung.com/jackson-serialize-enums
https://medium.com/@kastepanyan24/how-to-set-selected-option-dynamically-in-angular-6-85c99958cca5


# spring-boot-angular6-maven-project
Build and package spring boot and angular6 into a deployable war file
The corresponding article can be found at https://techshard.com/2018/08/12/building-a-web-app-using-spring-boot-angular-6-and-maven/ and https://dzone.com/articles/building-a-web-app-using-spring-boot-angular-6-and



import { Store } from '@ngrx/store';
import { Injectable } from '@angular/core';
import { Resolve } from '@angular/router';
import { Observable } from 'rxjs/Observable';

import { IAppState } from './app.state';
import * as profileActions from './profile/profile.actions'
import { IProfileData } from './profile/profile.model';
import { ApiService } from './api.service';

@Injectable()
export class ProfileResolver implements Resolve<IProfileData> {
constructor(private apiService: ApiService, private store: Store<IAppState>) { }

resolve(): Observable<IProfileData> {

    this.initProfileData();

    return this.waitForProfileDataToLoad();
}

waitForProfileDataToLoad(): Observable<IProfileData> {
return this.store.select('profile')
.map(store => store.profileData)
.filter(profileData => !!profileData)
.take(1);
}

initProfileData(): void {
this.store.take(1).subscribe(store => {
if (!store.profile.profileData) {
this.apiService.getProfileData().toPromise().then(data => {
this.store.dispatch(new profileActions.UpdateAction(data));
});
}
});
}
}







import { Component, OnInit } from '@angular/core';
import { LibraryBook } from '../models/library-book.model';
import { Library } from '../models/library.model';
import { ActivatedRoute } from '@angular/router';

@Component({
selector: 'library-display',
templateUrl: './library-display.component.html',
styleUrls: ['./library-display.component.scss']
})
export class LibraryDisplayComponent implements OnInit {

library: Library;
libraryBooks: LibraryBook[];

constructor(
private route: ActivatedRoute
) { }

ngOnInit() {
this.library = this.route.snapshot.data['libraryResolverData'][0];
this.libraryBooks = this.route.snapshot.data['libraryResolverData'][1];
}
}



import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Library } from '../models/library.model';
import { LibraryBook } from '../models/library-book.model';
import { LibraryService } from '../services/library.service';
import { Observable } from 'rxjs';
import { withLatestFrom } from 'rxjs/operators';

@Injectable()
export class LibraryDisplayResolver implements Resolve<[Library, LibraryBook[]]> {

constructor(
private _libraryService: LibraryService,
) { }

resolve (route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<[Library, LibraryBook[]]> {
const libraryId = route.params['id'];
return this._libraryService.getLibrary(libraryId).pipe(
withLatestFrom(
this._libraryService.getBooksFromLibrary(libraryId)
)
);
}
}
