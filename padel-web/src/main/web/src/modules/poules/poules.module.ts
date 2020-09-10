/* tslint:disable: ordered-imports*/
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

/* Modules */
import {AppCommonModule} from '@common/app-common.module';
import {NavigationModule} from '@modules/navigation/navigation.module';

/* Components */
import * as pouleComponents from './components';

import * as pouleContainers from './containers';

@NgModule({
    imports: [
        CommonModule,
        RouterModule,
        ReactiveFormsModule,
        FormsModule,
        AppCommonModule,
        NavigationModule,
    ],

    declarations: [...pouleComponents.components,...pouleContainers.containers],
    exports: [ ...pouleComponents.components,...pouleContainers.containers],
})
export class PoulesModule {}
