# 1. General Info

This padel application is used for making an automatic planning each week for padel members.

# 2. Build and run application

## 2.1 in development with angular frontend server and backend server

### 2.1.1 start frontend server

go to atlantis3-app and run the following command 'npm start' to start the front end server.
Open your browser and got to http://localhost:4200/atlantis3/login.

### 2.1.2 start backend server

Start backend server by making a run configuration for spring boot(main class=com.realdolmen.padel.PadelApplication)

## 2.2 in production as systemd service.

When you want to run the application as a full spring boot application(frontend and backend to)
in production as a systemd service you have to execute clean


# 3.technical information

## 3.1 frontend

### 3.1.1 angular 9.0

The latest angular version(at this time of writing) is used as frontend framework

### 3.1.2 bootstrap

Bootstrap stylesheet is used to style your html.
When developing this app you can make use of http://bootstrap-live-customizer.com.On this website you
can change the look and feel of your tables,forms,buttons,menus and how they will look in your app.

### 3.1.3 unit testing

karma and jasmine is used to test frontend angular code.All your angular components,services,directives,pipes,...can be tested be executing the following command 'npm test'

## 3.2 backend

### 3.2.1 spring and rest



# 4.functional information.



## 4.1 scenarios



# 5.references

https://www.typescriptlang.org/play/
angular-io:https://angular.io/
https://rxjs-dev.firebaseapp.com/api
https://www.learnrxjs.io/
https://ngrx.io/
https://github.com/ngrx/platform/
https://blog.mgechev.com/2017/04/23/angular-tooling-codelyzer-angular-cli-ngrev/
https://robferguson.org/blog/2017/09/09/a-simple-logging-service-for-angular-4/
https://material.angular.io/
https://plnkr.co/edit/XGWR616adDzK2lreusN6?p=preview(dynamic radio buttons)
https://stackoverflow.com/questions/48251876/formgroup-containing-radio-buttons-with-an-angular-formarray
https://github.com/crazedVic/angularnestedformarrays/blob/master/src/app/component/sampleform/sampleform.component.ts
https://stackblitz.com/edit/angular-dffny7?file=app/app.component.html
https://blog.angular-university.io
https://blog.fullstacktraining.com/caching-http-requests-with-angular/
https://christianlydemann.com/four-ways-to-create-loading-spinners-in-an-angular-app/
https://indepth.dev/everything-you-need-to-know-about-the-expressionchangedafterithasbeencheckederror-error/
https://www.ag-grid.com/javascript-grid-value-setters/
https://ng-bootstrap.github.io/#/home
https://startbootstrap.com/previews/sb-admin-angular/
https://github.com/third774/ng-bootstrap-form-validation#readme

testing

https://www.amadousall.com/unit-testing-angular-stubs-vs-spies-vs-mocks/

# 6.TODO's

you cannot filter gammas after a refresh of the main page.The gammas are loaded into the ngrx-store,
but filtering is not done after keyup in gamma-cell editor

test dnr
--------
FQDHMXF(mix dossier,NVS+EPA,THA)
PKXSSFH(NRB met 1 adult and child)
HFLVFRS(ligplaats)

# 7.WORKING









1.build and run application




3.develop information


4.working and use application.


5.TODO's

server doesn't start up yet because of jpa entities that are not correct.
probably poule_tour entity.(remove some entitity java files and app will start).
Another problem is that first page of angular is not shown.see sample application tutorial-parent to fix the problem.
https://docs.spring.io/spring-boot/docs/current/reference/html/deployment.html#deployment-systemd-service
https://www.auroria.io/spring-boot-as-systemd-service/




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
