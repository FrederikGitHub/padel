import {HttpClientModule} from '@angular/common/http';
import {LOCALE_ID, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AppCommonModule} from "@common/app-common.module";
import {StoreModule} from "@ngrx/store";
import {metaReducers, reducers} from "@app/reducers";
import {EffectsModule} from "@ngrx/effects";
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NgBootstrapFormValidationModule} from "ng-bootstrap-form-validation";
import {MaterialModule} from "@modules/material/material.module";
import {FlexLayoutModule} from "@angular/flex-layout";

@NgModule({
    declarations: [AppComponent],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        AppRoutingModule,
        MaterialModule,
        HttpClientModule,
        AppCommonModule,
        ToastrModule.forRoot(),
        NgBootstrapFormValidationModule.forRoot(),
        FlexLayoutModule,
        StoreModule.forRoot(reducers, {metaReducers, runtimeChecks: { strictStateImmutability: true, strictActionImmutability: true }}),
        EffectsModule.forRoot([]),
    ],
    providers: [{ provide: LOCALE_ID, useValue: 'nl-BE' }],
    bootstrap: [AppComponent],
})
export class AppModule {}
