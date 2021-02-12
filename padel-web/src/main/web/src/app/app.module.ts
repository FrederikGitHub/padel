import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AppCommonModule} from "@common/app-common.module";
import {StoreModule} from "@ngrx/store";
import {metaReducers, reducers} from "@app/reducers";

@NgModule({
    declarations: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        AppCommonModule,
        StoreModule.forRoot(reducers, {metaReducers, runtimeChecks: { strictStateImmutability: true, strictActionImmutability: true }}),

    ],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}
